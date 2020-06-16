package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;
import io.muzoo.ooc.zork.gameitem.Item;

public class TakeCommand extends Command {
    public TakeCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        pickItem(arg);
    }

    @Override
    void printDescription() {
        System.out.println("Command to pickup item from a area.");
        System.out.println("Format: take ..arg..");
    }

    void pickItem(String item) {
        Item getItem = game.getCurrentArea().getItem(item);

        if (getItem == null) {
            System.out.println("That item is not here!");
        } else {
            game.getPlayer().getInventory().add(getItem);
            game.getCurrentArea().removeItem(item);
            System.out.println("Pick up " + item);
        }
    }
}
