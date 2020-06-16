package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;
import io.muzoo.ooc.zork.gamemap.GameLibrary;

public class StudyCommand extends Command {
    GameLibrary gameLibrary;

    public StudyCommand(Game game) {
        super(game);
        gameLibrary = game.getGameLibrary();
    }

    @Override
    public void execute(String arg) {
        if (arg == null) {
            System.out.println("Study What!");
            return;
        }
        study(arg);
    }

    @Override
    void printDescription() {
        System.out.println("This command is use to study a detain of a monster.");
        System.out.println("Format: study ..arg..");
    }

    void study(String arg) {

        if (gameLibrary.getSmallMonstersBook().containsKey(arg)) {
            String data = gameLibrary.getSmallMonstersBook().get(arg).getKey();
            String drop = gameLibrary.getSmallMonstersBook().get(arg).getValue();
            printMonsterData(arg, data, drop);
        } else if (gameLibrary.getBigMonstersBook().containsKey(arg)) {
            String data = gameLibrary.getBigMonstersBook().get(arg).getKey();
            String drop = gameLibrary.getBigMonstersBook().get(arg).getValue();
            printMonsterData(arg, data, drop);
        } else if (gameLibrary.getDragonBook().containsKey(arg)) {
            String data = gameLibrary.getDragonBook().get(arg).getKey();
            String drop = gameLibrary.getDragonBook().get(arg).getValue();
            printMonsterData(arg, data, drop);
        }
    }

    void printMonsterData(String name, String data, String drop) {
        System.out.println("This monster name is " + name + ".");
        System.out.println(data);
        System.out.println("This monster drop " + drop + ".");
    }


}
