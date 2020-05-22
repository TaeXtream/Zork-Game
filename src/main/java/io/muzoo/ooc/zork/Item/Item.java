package io.muzoo.ooc.zork.Item;

public class Item {
    private final String name;

    public Item(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }
}
