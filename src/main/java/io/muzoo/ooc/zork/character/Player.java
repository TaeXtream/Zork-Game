package io.muzoo.ooc.zork.character;

import io.muzoo.ooc.zork.gameitem.Item;
import io.muzoo.ooc.zork.gameitem.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    private final List<Item> inventory = new ArrayList<>();
    public Weapon weapon;

    public Player(Weapon weapon){
        this.weapon = weapon;
    }

    public int getDamage(){
        return this.weapon.getDamage();
    }

    private void printInventory() {
        if (inventory.size() == 0) {
            System.out.println("You are not carry anything");
        } else {
            StringBuilder inv = new StringBuilder();
            for (Item item : inventory) {
                inv.append(item.getName()).append(" ");
            }
            System.out.println("You are carrying:");
            System.out.println(inv);
        }
    }


}
