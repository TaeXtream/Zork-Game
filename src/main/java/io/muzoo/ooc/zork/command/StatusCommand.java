package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class StatusCommand extends Command {

    public StatusCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        game.getPlayer().printPlayerStatus();
    }

    @Override
    void printDescription() {
        System.out.println("Display player status and inventory.");
        System.out.println("Format: status");
    }

}
