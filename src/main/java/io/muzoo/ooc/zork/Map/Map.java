package io.muzoo.ooc.zork.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Map {
    String name;
    String description;
    List<Area> areas = new ArrayList<>();
    File base;

    public Map(String path){
        File file = new File(path);
        try {
            this.base = file;
            Scanner scanner = new Scanner(base);
            this.name = stringCutter(scanner.nextLine(), ":");
            this.description = stringCutter(scanner.nextLine(), ":");
            this.generateArea();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map(File base){
        try {
            this.base = base;
            Scanner scanner = new Scanner(base);
            this.name = stringCutter(scanner.nextLine(), ":");
            this.description = stringCutter(scanner.nextLine(), ":");
            this.generateArea();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String stringCutter(String url, String target){
        return url.substring(url.indexOf(target)+1);
    }

    void setName(String name){
        this.name = name;
    }

    void setDescription(String description){
        this.description = description;
    }

    public void printIntro(){
        System.out.println(this.description.replaceAll("\\.", ".\n"));
    }

    void generateArea(){
        List<String[]> allNeighbors = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(this.base);
            while (scanner.hasNext()){
                String current = scanner.next();
                if(current.matches("Camp")){
                    Area camp = new Area("Camp");
                    areas.add(camp);
                    current = scanner.next("exit.*");
                    current = current.substring(current.indexOf("{")+1,current.indexOf("}"));
                    String[] arr = current.split(",");
                    allNeighbors.add(arr);
                }
                else if(current.matches("Area.*\\d.*")){
                    Area area = new Area(current);
                    areas.add(area);
                    current = scanner.next("exit.*");
                    current = current.substring(current.indexOf("{")+1,current.indexOf("}"));
                    String[] arr = current.split(",");
                    allNeighbors.add(arr);
                }
            }
            generateNeigbor(areas, allNeighbors);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void generateNeigbor(List<Area> areas, List<String[] > allNeighbor){
        printAreas();
        assert areas.size() == allNeighbor.size();
        for (int i=0; i < areas.size() ; i++){
            String[] exits = allNeighbor.get(i);
            for(String string : exits){
                String exit = string.substring(0, string.indexOf("="));
                String wayout = string.substring(string.indexOf("=")+1);
                if(wayout.equals("Camp")){
                    areas.get(i).neighbor.put(exit, areas.get(0));
                }
                else{
                    Scanner scanner = new Scanner(wayout).useDelimiter("[^0-9]+");
                    areas.get(i).neighbor.put(exit, areas.get(scanner.nextInt()));
                }
            }
            areas.get(i).printNeighborList();
        }
    }

    void generateMonster(){

    }

    public void printAreas(){
        StringBuilder allAreas = new StringBuilder();
        allAreas.append("{ ");
        for (Area area : areas){
            allAreas.append(area.getName());
            allAreas.append(" ");
        }
        allAreas.append("}");
        System.out.println(allAreas.toString());

    }

    public void printMap(){

    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }


}
