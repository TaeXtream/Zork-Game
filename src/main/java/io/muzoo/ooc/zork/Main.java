package io.muzoo.ooc.zork;

import io.muzoo.ooc.zork.gamemap.GameMap;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.start();
        GameMap gameMap = new GameMap(new File("RuinPinnacleData.txt"));

    }
}
