package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class mapCommand extends Command {
    public mapCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        game.getGameMap().printMap();
    }

    @Override
    void printDescription() {
        System.out.println("Command that print map in 2D art.");
    }
}
