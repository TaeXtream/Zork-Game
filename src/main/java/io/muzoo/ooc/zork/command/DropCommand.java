package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;
import io.muzoo.ooc.zork.gameitem.Item;

public class DropCommand extends Command {

    public DropCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String argv) {
        dropItem(argv);
    }

    private void dropItem(String argv) {
        if (argv.isEmpty()) {
            System.out.println("Drop what?");
            return;
        }
        Item dItem = null;
        int index = 0;
        for (int i = 0; i < game.getPlayer().getInventory().size(); i++) {
            if (game.getPlayer().getInventory().get(i).getName().equals(argv)) {
                dItem = game.getPlayer().getInventory().get(i);
                index = i;
            }
        }
        if (dItem == null) {
            System.out.println("That item is not in your inventory");
        } else {
            game.getPlayer().getInventory().remove(index);
            game.getCurrentArea().addItem(dItem);
            System.out.println("Drop " + argv);
        }
    }
}
