package io.muzoo.ooc.zork.Item;

public abstract class Item {
    private final String name;
    private String info;


    public Item(String newName, String info) {
        name = newName;
        info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
