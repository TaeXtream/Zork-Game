package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class QuitCommand extends Command {

    public QuitCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        game.finished();

    }
}
