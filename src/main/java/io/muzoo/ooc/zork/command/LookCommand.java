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

    void lookaround() {
        System.out.println(game.getCurrentArea().getAreaInfo());
    }
}
