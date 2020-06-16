package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class LookCommand extends Command {
    public LookCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        lookaround();
    }

    @Override
    void printDescription() {
        System.out.println("Command to look around the area.");
        System.out.println("Format: look");
    }

    void lookaround() {
        System.out.println(game.getCurrentArea().getDescription());
        System.out.println(game.getCurrentArea().getAreaInfo());
    }
}
