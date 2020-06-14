package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class AttackCommand extends Command {
    public AttackCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        System.out.println("Attack " + arg);
    }
}
