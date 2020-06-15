package io.muzoo.ooc.zork;


import io.muzoo.ooc.zork.monster.Dragon;
import io.muzoo.ooc.zork.monster.Monster;

public class Main {

    public static void main(String[] args) {

        Game game = new Game("GameMapdata\\RuinPinnacleData.txt");
        game.play();
//        gameMap.printIntro();
//        gameMap.printDescription();
//        GameLibrary gameLibrary = new GameLibrary();
//        gameLibrary.listBookEntry(gameLibrary.getDragonBook());
//        gameLibrary.listBookEntry(gameLibrary.getVictoryItem());

    }
}
