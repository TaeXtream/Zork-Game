package io.muzoo.ooc.zork.gamemap;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class GameLibrary {
    Map<String, Pair<String, String>> smallMonstersBook = new HashMap<>();
    Map<String, Pair<String, String>> bigMonstersBook = new HashMap<>();
    Map<String, Pair<String, String>> dragonBook = new HashMap<>();
    Map<String, Integer> healItemBook = new HashMap<>();
    List<String> maxHealItemBook = new ArrayList<>();
    List<String> smallHealthItemBook = new ArrayList<>();
    List<String> largeHealthItemBook = new ArrayList<>();
    List<String> smallAttackItemBook = new ArrayList<>();
    List<String> largeAttackItemBook = new ArrayList<>();
    List<String> victoryItem = new ArrayList<>();
    File monsterData = new File("mapdata\\MonsterLibrary.txt");
    File itemsData = new File("mapdata\\ItemLibrary.txt");

    public GameLibrary() {
        writeAllMonsterBook();
        writeAllItemBook();
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

    public Map<String, Integer> getHealItemBook() {
        return healItemBook;
    }

    public List<String> getMaxHealItemBook() {
        return maxHealItemBook;
    }

    public List<String> getSmallHealthItemBook() {
        return smallHealthItemBook;
    }

    public List<String> getLargeHealthItemBook() {
        return largeHealthItemBook;
    }

    public List<String> getSmallAttackItemBook() {
        return smallAttackItemBook;
    }

    public List<String> getLargeAttackItemBook() {
        return largeAttackItemBook;
    }

    public List<String> getVictoryItem() {
        return victoryItem;
    }

    public void listBookEntry(List<String> book) {
        System.out.println(book.toString());
    }

    public void listBookEntry(Map<String, ?> book) {
        System.out.println(book.keySet().toString());
    }


    void writeAllMonsterBook() {
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

    void writeAllItemBook() {
        try {
            Scanner scanner = new Scanner(itemsData);
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (current.contains("Heal:")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        String heal = scanner.next();
                        if (heal.contains("max")) {
                            maxHealItemBook.add(name);
                        } else {
                            int healnum = Integer.parseInt(heal.replaceAll("[\\D]", ""));
                            healItemBook.put(name, healnum);
                        }
                    }
                } else if (current.contains("SmallHealth:")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        smallHealthItemBook.add(name);
                    }
                } else if (current.contains("LargeHealth:")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        largeHealthItemBook.add(name);
                    }
                } else if (current.contains("SmallAttack")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        smallAttackItemBook.add(name);
                    }
                } else if (current.contains("LargeAttack")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        largeAttackItemBook.add(name);
                    }
                } else if (current.contains("Victory")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        victoryItem.add(name);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
