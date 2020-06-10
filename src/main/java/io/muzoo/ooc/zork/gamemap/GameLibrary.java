package io.muzoo.ooc.zork.gamemap;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class GameLibrary {
    Map<String, Pair<String, String>> smallMonstersBook = new HashMap<>();
    Map<String, Pair<String, String>> bigMonstersBook = new HashMap<>();
    Map<String, Pair<String, String>> dragonBook = new HashMap<>();
    Map<String, Pair<String, String>> itemBook = new HashMap<>();
    File monsterData = new File("mapdata\\MonsterLibrary.txt");
    File itemsData;

    public GameLibrary() {
        writeMonsterBook();

    }

    public Map<String, Pair<String, String>> getSmallMonstersBook() {
        return smallMonstersBook;
    }

    public Map<String, Pair<String, String>> getBigMonstersBook() {
        return bigMonstersBook;
    }

    public Map<String, Pair<String, String>> getDragonBook() {
        return dragonBook;
    }

    public void listBookEntry(Map<String, Pair<String, String>> book) {
        System.out.println(book.keySet().toString());
    }

    void writeMonsterBook() {
        try {
            Scanner scanner = new Scanner(monsterData);
            while (scanner.hasNextLine()) {
                String current = scanner.nextLine();
                if (current.contains("SmallMonster:")) {
                    writeMonsterBook(current, scanner, smallMonstersBook);
                } else if (current.contains("BigMonster:")) {
                    writeMonsterBook(current, scanner, bigMonstersBook);
                } else if (current.contains("Dragon:")) {
                    writeMonsterBook(current, scanner, dragonBook);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeMonsterBook(String current, Scanner scanner, Map<String, Pair<String, String>> monstersBook) {
        String name;
        String info;
        String drop;
        int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
        for (int i = 0; i < amount; i++) {
            current = scanner.nextLine();
            name = current.substring(current.indexOf(":") + 1);
            current = scanner.nextLine();
            info = current.substring(current.indexOf(":") + 1).replaceAll("\\.", ".\n");
            current = scanner.nextLine();
            drop = current.substring(current.indexOf("=") + 1);
            monstersBook.put(name, new Pair<>(info, drop));
        }
    }


}
