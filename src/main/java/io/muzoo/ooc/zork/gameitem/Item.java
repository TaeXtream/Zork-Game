package io.muzoo.ooc.zork.gameitem;

import io.muzoo.ooc.zork.character.Player;

public abstract class Item {
    private String name;
    private String info;

    public Item(String newName) {
        this.name = newName;
    }

    public Item(String newName, String info) {
        this.name = newName;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public abstract void itemEffect(Player player);
}
