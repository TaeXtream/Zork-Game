package io.muzoo.ooc.zork;

import io.muzoo.ooc.zork.gamemap.GameMap;
import io.muzoo.ooc.zork.command.Command;
import io.muzoo.ooc.zork.command.CommandFactory;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    List<GameMap> allGameMap;

    public Game(){
    }

    public void start() {
        try{
            titleScreen();
            TimeUnit.SECONDS.sleep(2);
            printWelcome();
        }
        catch (InterruptedException ignored){
        }

    }

    public void play(GameMap gameMap){

    }

    public void process(){
        Scanner scanner = new Scanner(System.in);
        String cmd;
        while (true){
            System.out.print("> ");
            cmd = scanner.next();
            String[] words = cmd.split(" ");
            Command command = CommandFactory.getCommand(words[0]);
            if (command != null){
                command.execute(words.length == 1 ? null : words[1]);
            }
        }
    }



    public void titleScreen(){
        String title =
                "===============================\n" +
                        "       Monster Hunter\n" +
                        "            Zork\n" +
                "===============================\n";
        System.out.println(title);
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Monster Hunter Zork!");
        System.out.println("In this game you will fight monster.");
        System.out.println("And explore a map.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("Please Choose your Map.\n");
    }
    
}
