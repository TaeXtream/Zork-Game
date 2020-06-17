package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;
import io.muzoo.ooc.zork.gameitem.Item;

public class UseCommand extends Command {
    public UseCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        useItem(arg);
    }

    @Override
    void printDescription() {
        System.out.println("Command to use an item from your inventory.");
        System.out.println("Format: use ..arg..");
    }

    void useItem(String item) {
        if (!game.getGameLibrary().getHealItemBook().containsKey(item) && !game.getGameLibrary().getMaxHealItemBook().contains(item)) {
            System.out.println("This Item is not exist.");
            return;
        }
        for (Item playerItem : game.getPlayer().getInventory()) {
            if (playerItem.getName().equals(item)) {
                playerItem.itemEffect(game.getPlayer());
                game.getPlayer().getInventory().remove(playerItem);
                System.out.println("Use " + playerItem.getName());
                playerItem.printEffect();
                game.getPlayer().printPlayerStatus();
                return;
            }
        }
        System.out.println("You don't have this item.");
    }

}
