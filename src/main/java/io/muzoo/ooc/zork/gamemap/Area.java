package io.muzoo.ooc.zork.gamemap;

import io.muzoo.ooc.zork.gameitem.Item;
import io.muzoo.ooc.zork.monster.Monster;

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
        for (String string : neighbor.keySet()) {
            neighborList.append(string);
            neighborList.append("=");
            neighborList.append(neighbor.get(string).name).append(" ");
        }
        neighborList.append("}");
        System.out.println(neighborList);
    }

    void printMonsterList() {
        StringBuilder monsterList = new StringBuilder();
        monsterList.append("{ ");
        for (Monster monster : monsters) {
            monsterList.append(monster.getName()).append(" ");
        }
        monsterList.append("}");
        System.out.println(monsterList);
    }

    void printItemList() {
        StringBuilder itemList = new StringBuilder();
        itemList.append("{ ");
        for (Item item : items) {
            itemList.append(item.getName()).append(" ");
        }
        itemList.append("}");
        System.out.println(itemList);
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
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(itemname)) {
                items.remove(i);
                break;
            }
        }
    }

    public void addItem(Item newitem) {
        items.add(newitem);
    }

    public void addItems(Item item, int amount) {
        for (int i = 0; i < amount; i++)
            addItem(item);
    }

    public void addItems(Collection<Item> items) {
        for (Item item : items)
            addItem(item);
    }

    public String getRoomItem() {
        String ritem = "Nothing";
        for (Item item : items) {
            ritem = item.getName() + " ";
        }
        return ritem;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }

    public void removeDeathMonster() {
        monsters.removeIf(monster -> !monster.isAlive());
    }

    public String printAreaInfo() {

        StringBuilder info = new StringBuilder();
        info.append("You are in ").append(this.getName());
        info.append('\n');
        info.append("Exits: ");
        if (this.getExit("north") != null) {
            info.append("north ");
        }
        if (this.getExit("east") != null) {
            info.append("east ");
        }
        if (this.getExit("south") != null) {
            info.append("south ");
        }
        if (this.getExit("west") != null) {
            info.append("west ");
        }
        if (!this.getName().equals("Camp")) {
            info.append('\n');
            info.append("This Area have:" + " ");
            info.append(this.getRoomItem()).append(" ");
        }
        return info.toString();
    }


}
