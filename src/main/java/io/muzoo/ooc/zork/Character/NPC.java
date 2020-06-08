package io.muzoo.ooc.zork.Character;

import io.muzoo.ooc.zork.Item.Item;

import java.util.LinkedList;
import java.util.List;

public class NPC extends Entity {
    String dialog;
    List<Item> inventory;

    public NPC(String name, String dialog){
        this.setName(name);
        this.dialog = dialog;
        this.inventory = new LinkedList<>();
        this.setHealthMax(10);
    }

    public void setDialog(String dialog){
        this.dialog = dialog;
    }

    public void speak(){
        System.out.println(this.dialog);
    }
}
