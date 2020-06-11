package io.muzoo.ooc.zork.gamemap;

import io.muzoo.ooc.zork.gameitem.ItemFactory;
import io.muzoo.ooc.zork.gameitem.ItemType;
import io.muzoo.ooc.zork.monster.MonsterFactory;
import io.muzoo.ooc.zork.monster.MonsterType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameMap {
    String name;
    String intro;
    String description;
    List<Area> areas = new ArrayList<>();
    File base;
    GameLibrary gameLibrary = new GameLibrary();

    public GameMap(String path) {
        File file = new File(path);
        try {
            this.base = file;
            Scanner scanner = new Scanner(base);
            this.name = stringCutter(scanner.nextLine(), ":");
            this.intro = stringCutter(scanner.nextLine(), ":");
            this.description = stringCutter(scanner.nextLine(), ":");
            this.generateMap();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public GameMap(File base){
        try {
            this.base = base;
            Scanner scanner = new Scanner(base);
            this.name = stringCutter(scanner.nextLine(), ":");
            this.intro = stringCutter(scanner.nextLine(), ":");
            this.description = stringCutter(scanner.nextLine(), ":");
            this.generateMap();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String stringCutter(String s, String target) {
        return s.substring(s.indexOf(target) + 1);
    }

    void setDescription(String description) {
        this.description = description;
    }

    public void printIntro() {
        System.out.println(this.intro.replaceAll("\\.", ".\n"));
    }

    public void printDescription() {
        System.out.println(this.description.replaceAll("\\.", ".\n"));
    }

    void generateMap() {
        List<String[]> allNeighbors = new ArrayList<>();
        List<String[]> allMonster = new ArrayList<>();
        List<String[]> allItem = new ArrayList<>();
        String[] arr;
        try {
            Scanner scanner = new Scanner(this.base);
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (current.contains("Camp")) {
                    Area camp = new Area("Camp");
                    areas.add(camp);
                    current = scanner.next("exit.*");
                    arr = stringtoArray(current);
                    allNeighbors.add(arr);
                } else if (current.matches("Area.*\\d.*")) {
                    Area area = new Area(current);
                    areas.add(area);
                    current = scanner.next("exit.*");
                    arr = stringtoArray(current);
                    allNeighbors.add(arr);
                    current = scanner.next();
                    arr = stringtoArray(current);
                    allMonster.add(arr);
                    current = scanner.next();
                    arr = stringtoArray(current);
                    allItem.add(arr);
                }
            }
            generateAreaPath(allNeighbors);
            generateMonster(allMonster);
            genarateItem(allItem);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void generateAreaPath(List<String[] > allNeighbor){
        for (int i=0; i < areas.size() ; i++){
            String[] exits = allNeighbor.get(i);
            for(String string : exits){
                String exit = string.substring(0, string.indexOf("="));
                String wayout = string.substring(string.indexOf("=")+1);
                if(wayout.equals("Camp")){
                    areas.get(i).neighbor.put(exit, areas.get(0));
                } else {
                    Scanner scanner = new Scanner(wayout).useDelimiter("[^0-9]+");
                    areas.get(i).neighbor.put(exit, areas.get(scanner.nextInt()));
                }
            }
        }
    }

    void generateMonster(List<String[]> allMonster) {
        int i = 1;
        MonsterFactory monsterFactory = new MonsterFactory();
        for (String[] monsters : allMonster) {
            for (String monster : monsters) {
                String name = monster.substring(0, monster.indexOf("="));
                int amount = Integer.parseInt(monster.replaceAll("[\\D]", ""));
                for (int j = 0; j < amount; j++) {
                    if (gameLibrary.smallMonstersBook.containsKey(name)) {
                        areas.get(i).addMonster(monsterFactory.createMonster(MonsterType.SmallMonster, name));
                    } else if (gameLibrary.bigMonstersBook.containsKey(name)) {
                        areas.get(i).addMonster(monsterFactory.createMonster(MonsterType.BigMonster, name));
                    } else if (gameLibrary.dragonBook.containsKey(name)) {
                        areas.get(i).addMonster(monsterFactory.createMonster(MonsterType.Dragon, name));
                    }
                }
            }
            i++;
        }
    }

    void genarateItem(List<String[]> allItem) {
        int i = 1;
        ItemFactory itemFactory = new ItemFactory();
        for (String[] items : allItem) {
            for (String item : items) {
                String name = item.substring(0, item.indexOf("="));
                int amount = Integer.parseInt(item.replaceAll("[\\D]", ""));
                if (gameLibrary.healItemBook.containsKey(name)) {
                    areas.get(i).addItems(itemFactory.createItem(ItemType.HealItem, name), amount);
                } else if (gameLibrary.maxHealItemBook.contains(name)) {
                    areas.get(i).addItems(itemFactory.createItem(ItemType.MaxHealItem, name), amount);
                } else if (gameLibrary.smallHealthItemBook.contains(name)) {
                    areas.get(i).addItems(itemFactory.createItem(ItemType.SmallHealthItem, name), amount);
                } else if (gameLibrary.largeHealthItemBook.contains(name)) {
                    areas.get(i).addItems(itemFactory.createItem(ItemType.LargeHealthItem, name), amount);
                } else if (gameLibrary.smallAttackItemBook.contains(name)) {
                    areas.get(i).addItems(itemFactory.createItem(ItemType.SmallAttackItem, name), amount);
                } else if (gameLibrary.largeAttackItemBook.contains(name)) {
                    areas.get(i).addItems(itemFactory.createItem(ItemType.LargeAttackItem, name), amount);
                } else if (gameLibrary.victoryItem.contains(name)) {
                    areas.get(i).addItems(itemFactory.createItem(ItemType.VictoryItem, name), amount);
                }
            }
            i++;
        }
    }


    public void printAreas() {
        StringBuilder allAreas = new StringBuilder();
        allAreas.append("{ ");
        for (Area area : areas) {
            allAreas.append(area.getName());
            allAreas.append(" ");
        }
        allAreas.append("}");
        System.out.println(allAreas.toString());

    }

    public void printMap(){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description.replaceAll("\\.", ".\n");
    }

    String[] stringtoArray(String s) {
        s = s.substring(s.indexOf("{") + 1, s.indexOf("}"));
        return s.split(",");
    }


}
