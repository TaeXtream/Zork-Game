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

    void useItem(String item) {
        if (!game.getGameLibrary().getHealItemBook().containsKey(item)) {
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
