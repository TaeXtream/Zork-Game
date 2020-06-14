package io.muzoo.ooc.zork;

import io.muzoo.ooc.zork.character.Player;
import io.muzoo.ooc.zork.command.CommandLine;
import io.muzoo.ooc.zork.command.Parser;
import io.muzoo.ooc.zork.gameitem.Weapon;
import io.muzoo.ooc.zork.gamemap.Area;
import io.muzoo.ooc.zork.gamemap.GameLibrary;
import io.muzoo.ooc.zork.gamemap.GameMap;
import io.muzoo.ooc.zork.command.Command;
import io.muzoo.ooc.zork.command.CommandFactory;
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

    void initialize(String mapPath) {
        player = new Player(new Weapon(10));
        gameMap = new GameMap(mapPath);
        currentArea = gameMap.getArea("Camp");
        commandFactory = new CommandFactory(this);
        parser = new Parser(commandFactory);

    }

    String inputMap() {
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
            System.out.print("> ");
        } catch (InterruptedException ignored) {
        }

    }

    public void play() {
        gameMap.printIntro();
        while (!finished) {
            CommandLine commandLine = parser.getCommandLine();
            Command command = commandFactory.getCommand(commandLine.getCommandWord());
            command.execute(commandLine.getSecondWord());
            if (!player.isAlive()) {
                finished = true;
            } else if (Collections.disjoint(player.getInventory(), gameLibrary.getVictoryItem())) {
                finished = true;
            }

        }
        System.out.println("Thank You For Playing");

    }

    void combat(Player player, Monster monster) {
        while (player.isAlive() || monster.isAlive()) {

        }
    }


    public void titleScreen() {
        String title =
                "===============================\n" +
                        "       Monster Hunter\n" +
                        "            Zork\n" +
                        "===============================\n";
        System.out.println(title);
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Monster Hunter Zork!");
        System.out.println("In this game you will fight monster.");
        System.out.println("And explore a map.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("Please Input your Map.");
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


}
