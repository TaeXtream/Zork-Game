package io.muzoo.ooc.zork.Map;

import io.muzoo.ooc.zork.Item.Item;
import io.muzoo.ooc.zork.Monster.Monster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Area {
    String name;
    String description;
    HashMap<String, Area> neighbor;
    List<Monster> monsters = new ArrayList<>();
    List<Item> items = new ArrayList<>();
    String temperature;

    public Area(String name) {
        this.name = name;
        neighbor = new HashMap<>();
    }

    public Area(String name, String description){
        this.name = name;
        this.description = description;
        neighbor = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    void printNeighborList(){
        StringBuilder neighborList = new StringBuilder();
        neighborList.append("{ ");
        for(String string : neighbor.keySet()){
            neighborList.append(string);
            neighborList.append("=");
            neighborList.append(neighbor.get(string).name).append(" ");
        }
        neighborList.append("}");
        System.out.println(neighborList);
    }

    public void setExit(String direction, Area neighbor) {
        this.neighbor.put(direction, neighbor);
    }

    public Area getExit(String direction) {
        return neighbor.get(direction);
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

    public void setItems(Collection<Item> items){
        for (Item item : items)
            setItem(item);
    }

    public String getRoomItem(){
        String ritem = "Nothing";
        for (Item item : items) {
            ritem = item.getName() + " ";
        }
        return ritem;
    }

    public void addMonster(Monster monster){
        monsters.add(monster);
    }

    public void removeMonster(Monster monster){
        monsters.remove(monster);
    }


}
