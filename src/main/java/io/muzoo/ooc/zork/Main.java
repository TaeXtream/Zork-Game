package io.muzoo.ooc.zork;

import io.muzoo.ooc.zork.Map.Map;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.start();
        Map map = new Map(new File("RuinPinnacleData.txt"));
        System.out.println(map.getName());
        map.printIntro();

    }
}
