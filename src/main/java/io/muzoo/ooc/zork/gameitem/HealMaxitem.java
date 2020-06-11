package io.muzoo.ooc.zork.gameitem;

import io.muzoo.ooc.zork.character.Player;

public class HealMaxitem extends Healitem {
    public HealMaxitem(String newName) {
        super(newName);
    }

    @Override
    public void itemEffect(Player player) {
        player.setHealth(player.getHealthMax());
    }

    public void printEffect() {
        System.out.println("Heal to full health");
    }
}
