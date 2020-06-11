package io.muzoo.ooc.zork.gameitem;

import io.muzoo.ooc.zork.character.Player;

public class Healitem extends Item {
    int health;


    public Healitem(String newName, int health) {
        super(newName);
        this.health = health;
    }

    public Healitem(String newName) {
        super(newName);
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public void printEffect() {
        System.out.printf("Heal %d health when use\n", health);
    }

    @Override
    public void itemEffect(Player player) {
        player.setHealth(player.getHealth() + health);
    }
}
