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

    @Override
    void printDescription() {
        System.out.println("Coomand that use to combat with a monster.");
        System.out.println("Format: attack ..arg.. to begin combat with target monster.");
        System.out.println("        attack during a combat.");
    }

    void attacking() {
        System.out.println("Attack " + game.getTarget().getName());
        game.getTarget().setHealth(game.getTarget().getHealth() - game.getPlayer().getDamage());
    }
}
