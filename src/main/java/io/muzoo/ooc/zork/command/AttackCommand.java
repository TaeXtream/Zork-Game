package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class AttackCommand extends Command {
    public AttackCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        if (game.getTarget() == null) {
            return;
        }
        attacking();
    }

    void attacking() {
        System.out.println("Attack " + game.getTarget().getName());
        game.getTarget().setHealth(game.getTarget().getHealth() - game.getPlayer().getDamage());
    }
}
