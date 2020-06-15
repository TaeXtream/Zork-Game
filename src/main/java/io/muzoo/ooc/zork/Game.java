package io.muzoo.ooc.zork;

import io.muzoo.ooc.zork.character.Player;
import io.muzoo.ooc.zork.command.CommandLine;
import io.muzoo.ooc.zork.command.Parser;
import io.muzoo.ooc.zork.gameitem.Healitem;
import io.muzoo.ooc.zork.gameitem.HealthUpgradeItem;
import io.muzoo.ooc.zork.gameitem.VictoryItem;
import io.muzoo.ooc.zork.gameitem.Weapon;
import io.muzoo.ooc.zork.gamemap.Area;
import io.muzoo.ooc.zork.gamemap.GameLibrary;
import io.muzoo.ooc.zork.gamemap.GameMap;
import io.muzoo.ooc.zork.command.Command;
import io.muzoo.ooc.zork.command.CommandFactory;
import io.muzoo.ooc.zork.monster.Dragon;
import io.muzoo.ooc.zork.monster.Monster;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class Game {
    GameMap gameMap;
    Player player;
    Monster target;
    Area currentArea;
    CommandFactory commandFactory;
    Parser parser;
    boolean finished = false;
    GameLibrary gameLibrary = new GameLibrary();
    List<String> mapFiles = new ArrayList<>();
    {
        mapFiles.add("GameMapdata\\RuinPinnacleData.txt");
    }

    Game() {
        start();
        try {
            String input = inputMap();
            initialize(input);
        } catch (InputMismatchException i) {
            System.out.println("Unknown Map Name");
            i.printStackTrace();
        }
    }

    Game(String path) {
        start();
        initialize(path);
    }

    void initialize(String mapPath) {
        player = new Player(new Weapon(10));
        gameMap = new GameMap(mapPath);
        currentArea = gameMap.getArea("Camp");
        commandFactory = new CommandFactory(this);
        parser = new Parser(this.commandFactory);

    }

    String inputMap() {
        System.out.println("Please Input your Map.");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String map = scanner.nextLine();
        for (String mappath : mapFiles) {
            if (mappath.contains(map))
                return mappath;
        }
        throw new InputMismatchException();
    }

    public void start() {
        try {
            titleScreen();
            TimeUnit.SECONDS.sleep(2);
            printWelcome();
        } catch (InterruptedException ignored) {
        }

    }

    public void play() {
        gameMap.printIntro();
        System.out.println();
        gameMap.printDescription();
        System.out.println();
        System.out.println(this.currentArea.getAreaInfo());
        while (!finished) {
            CommandLine commandLine = parser.getCommandLine();
            if (commandLine.isUnknown()) {
                System.out.println("Unknown Command input!");
                continue;
            }
            if (commandLine.getCommandWord().equals("attack") && target == null) {
                String targetname = commandLine.getSecondWord();
                this.target = currentArea.getMonster(targetname);
                Command command = commandFactory.getCommand(commandLine.getCommandWord());
                command.execute(commandLine.getSecondWord());
                if (this.target.getClass().equals(Dragon.class)) {
                    dragonCombat(this.player, (Dragon) this.target);
                } else {
                    monsterCombat(this.player, this.target);
                }
                currentArea.removeDeathMonster();
            }
            if (!player.isAlive()) {
                printQuestFail();
                finished = true;
            } else if (player.getInventory().stream().anyMatch(o -> o.getClass().equals(VictoryItem.class))) {
                printQuestClear();
                finished = true;
            } else {
                Command command = commandFactory.getCommand(commandLine.getCommandWord());
                command.execute(commandLine.getSecondWord());
            }

        }
        System.out.println("Thank You For Playing");

    }

    void monsterCombat(Player player, Monster monster) {
        while (player.isAlive() || monster.isAlive()) {
            CommandLine commandLine = parser.getCommandLine();
            if (commandLine.getCommandWord().equals("go")) {
                System.out.println("Run Away from Monster.");
                Command command = commandFactory.getCommand(commandLine.getCommandWord());
                command.execute(commandLine.getSecondWord());
                this.target = null;
                break;
            }
            Command command = commandFactory.getCommand(commandLine.getCommandWord());
            command.execute(commandLine.getSecondWord());
            player.setHealth(player.getHealth() - monster.getAttack());
            if (player.getHealth() <= 0) {
                player.dead();
            } else if (monster.getHealth() <= 0) {
                System.out.println(monster.getName() + " has been kill!");
                monster.dead();
                if (!monster.getDrop().getClass().equals(Healitem.class)) {
                    System.out.println("You obtain " + monster.getDrop().getName() + "from killing " + monster.getName());
                    monster.getDrop().printEffect();
                    monster.getDrop().itemEffect(this.player);
                } else {
                    player.getInventory().add(monster.getDrop());
                }
            }

        }
    }

    void dragonCombat(Player player, Dragon dragon) {
        Random random = new Random();
        while (player.isAlive() && dragon.isAlive()) {
            CommandLine commandLine = parser.getCommandLine();
            if (commandLine.getCommandWord().equals("go")) {
                System.out.println("Cannot run away from the Dragon!!!!.");
                continue;
            }
            Command command = commandFactory.getCommand(commandLine.getCommandWord());
            command.execute(commandLine.getSecondWord());
            if (random.nextInt(4) == 3) {
                System.out.println("Dragon is using super attack!");
                player.setHealth(player.getHealth() - dragon.getSuperAttack());
            }
            player.setHealth(player.getHealth() - dragon.getAttack());
            if (player.getHealth() <= 0) {
                player.dead();
            } else if (dragon.getHealth() <= 0) {
                System.out.println(dragon.getName() + " has been slay!");
                dragon.dead();
                player.getInventory().add(dragon.getDrop());
            }

        }
    }


    public void titleScreen() {
        System.out.println("===============================");
        System.out.println("O                             O");
        System.out.println("O     Monster Hunter Zork     O");
        System.out.println("O                             O");
        System.out.println("===============================");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Monster Hunter Zork!");
        System.out.println("In this game you will fight monster.");
        System.out.println("And explore a map.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }


    public Area getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void finished() {
        this.finished = true;
    }

    public Player getPlayer() {
        return player;
    }

    public CommandFactory getCommandFactory() {
        return commandFactory;
    }

    public Monster getTarget() {
        return target;
    }

    public void setTarget(Monster target) {
        this.target = target;
    }

    public GameLibrary getGameLibrary() {
        return gameLibrary;
    }

    void printQuestClear() {
        try {
            System.out.println("You slay the dragon!!!!");
            TimeUnit.SECONDS.sleep(2);
            System.out.println();
            System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            System.out.println("O                             O");
            System.out.println("O        Quest Clear!         O");
            System.out.println("O                             O");
            System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    void printQuestFail() {
        try {
            System.out.println("You been kill by the monster!");
            TimeUnit.SECONDS.sleep(2);
            System.out.println();
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("X                             X");
            System.out.println("X        Quest Fail!          X");
            System.out.println("X                             X");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
