package io.muzoo.ooc.zork.gamemap;

import io.muzoo.ooc.zork.monster.MonsterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameMap {
    String name;
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
            this.description = stringCutter(scanner.nextLine(), ":");
            this.generateMap();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String stringCutter(String s, String target) {
        return s.substring(s.indexOf(target) + 1);
    }

    void setName(String name) {
        this.name = name;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public void printIntro(){
        System.out.println(this.description.replaceAll("\\.", ".\n"));
    }

    void generateMap(){
        List<String[]> allNeighbors = new ArrayList<>();
        List<String[]> allMonster = new ArrayList<>();
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
                }
            }
            generateAreaPath(allNeighbors);
            printAreas();
            generateMonster(allMonster);
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
                String info;
                int amount = Integer.parseInt(monster.replaceAll("[\\D]", ""));
                for (int j = 0; j < amount; j++) {
                    if (gameLibrary.smallMonstersBook.containsKey(name)) {
                        info = gameLibrary.smallMonstersBook.get(name).getKey();
                        areas.get(i).addMonster(monsterFactory.createMonster(MonsterFactory.MonsterType.SmallMonster, name, info));
                    } else if (gameLibrary.bigMonstersBook.containsKey(name)) {
                        info = gameLibrary.bigMonstersBook.get(name).getKey();
                        areas.get(i).addMonster(monsterFactory.createMonster(MonsterFactory.MonsterType.BigMonster, name, info));
                    } else if (gameLibrary.dragonBook.containsKey(name)) {
                        info = gameLibrary.dragonBook.get(name).getKey();
                        areas.get(i).addMonster(monsterFactory.createMonster(MonsterFactory.MonsterType.Dragon, name, info));
                    }
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
