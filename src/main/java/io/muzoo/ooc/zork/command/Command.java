package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public abstract class Command {
    Game game;

    public Command(Game game) {
        this.game = game;
    }

    public abstract void execute(String arg);

    abstract void printDescription();
}
