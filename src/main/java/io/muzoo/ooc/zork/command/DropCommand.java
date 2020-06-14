package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class DropCommand extends Command {

    public DropCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        System.out.println("Drop " + arg);
    }
}
