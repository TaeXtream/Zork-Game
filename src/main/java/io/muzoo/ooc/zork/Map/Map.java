package io.muzoo.ooc.zork.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Map {
    String name;
    String description;
    Set<Area> areas = new HashSet<>();
    Dictionary<String, String> smallMonsterDict = new Hashtable<>();
    Dictionary<String, String> bigMonsterDict = new Hashtable<>();
    Dictionary<String, String> dragonDict = new Hashtable<>();
    Dictionary<String, String> itemDict = new Hashtable<>();
    File base;

    public Map(File base){
        try {
            this.base = base;
            Scanner scanner = new Scanner(base);
            this.name = stringCutter(scanner.nextLine(), ":");
            this.description = stringCutter(scanner.nextLine(), ":");
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
        try {
            Scanner scanner = new Scanner(this.base);
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void generateMonster(){
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
