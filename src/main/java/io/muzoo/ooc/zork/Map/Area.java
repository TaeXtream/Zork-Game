package io.muzoo.ooc.zork.Map;

import io.muzoo.ooc.zork.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Area {
    public String description;
    private final List<Item> items = new ArrayList<>();
    private HashMap<String, Area> TheArea;

    public Area(String description){
        this.description = description;
        TheArea = new HashMap<>();
    }

    public void setExit(String direction, Area neighbor) {
        TheArea.put(direction, neighbor);
    }

    public Area getExit(String direction) {
        return TheArea.get(direction);
    }

    public String getDescription() {
        return description;
    }

    public Item getItem(int index){
        return items.get(index);
    }

    public Item getItem(String itemName){
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(String itemname){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getName().equals(itemname)){
                items.remove(i);
                break;
            }
        }
    }

    public void setItem(Item newitem){ items.add(newitem); }

    public String getRoomItem(){
        String ritem = "Nothing";
        for (Item item : items) {
            ritem = item.getName() + " ";
        }
        return ritem;
    }

}
