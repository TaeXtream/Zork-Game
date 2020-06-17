package io.muzoo.ooc.zork.gamemap;

import io.muzoo.ooc.zork.gameitem.ItemFactory;
import io.muzoo.ooc.zork.monster.MonsterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMap implements Serializable {
    String name;
    String intro;
    String description;
    List<Area> areas = new ArrayList<>();
    File base;
    File map2D;

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
            while (scanner.hasNextLine()) {
                String current = scanner.nextLine();
                if (current.contains("Camp")) {
                    Area camp = new Area("Camp");
                    areas.add(camp);
                    current = scanner.nextLine();
                    arr = stringtoArray(current);
                    allNeighbors.add(arr);
                } else if (current.matches("Area.*\\d.*")) {
                    String areaInfo = stringCutter(scanner.nextLine(), ":");
                    areaInfo = areaInfo.replaceAll("\\.", ".\n");
                    Area area = new Area(current, areaInfo);
                    areas.add(area);
                    current = scanner.nextLine();
                    arr = stringtoArray(current);
                    allNeighbors.add(arr);
                    current = scanner.nextLine();
                    arr = stringtoArray(current);
                    allMonster.add(arr);
                    current = scanner.nextLine();
                    arr = stringtoArray(current);
                    allItem.add(arr);
                }
            }
            generateAreaPath(allNeighbors);
            generateMonster(allMonster);
            generateItem(allItem);
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
                    areas.get(i).addMonster(monsterFactory.createMonsterByName(name));
                }
            }
            i++;
        }
    }

    void generateItem(List<String[]> allItem) {
        int i = 1;
        ItemFactory itemFactory = new ItemFactory();
        for (String[] items : allItem) {
            for (String item : items) {
                String name = item.substring(0, item.indexOf("="));
                if (!name.equals("None")) {
                    int amount = Integer.parseInt(item.replaceAll("[\\D]", ""));
                    areas.get(i).addItems(itemFactory.createItem(name), amount);
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

    public void printMap() {
        System.out.println("Areas in this map: ");
        printAreas();
        try {
            Scanner scanner = new Scanner(map2D);
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }


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

    public Area getArea(String argv) {
        for (Area area : areas) {
            if (area.getName().equals(argv))
                return area;
        }
        return null;
    }

    public void setMapFile(String map) {
        this.map2D = new File(map);
    }

    public void setMapFile(File map) {
        this.map2D = map;
    }
}
