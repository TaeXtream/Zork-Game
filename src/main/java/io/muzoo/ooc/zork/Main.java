package io.muzoo.ooc.zork;

import io.muzoo.ooc.zork.command.Command;
import io.muzoo.ooc.zork.command.CommandFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
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
}
