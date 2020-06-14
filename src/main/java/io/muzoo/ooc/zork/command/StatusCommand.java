package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class StatusCommand extends Command {

    public StatusCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        printStatus();
    }

    void printStatus() {
        game.getPlayer().printHealth();
        game.getPlayer().printDamage();
        game.getPlayer().printInventory();
    }
}
