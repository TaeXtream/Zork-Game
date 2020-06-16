package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand extends Command {
    public HelpCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        if (arg == null) {
            printHelp();
            return;
        }
        printHelpCommand(arg);
    }

    @Override
    void printDescription() {
        System.out.println("You can also use help ..arg..");
        System.out.println("To get a detail of how to use that command.");
    }

    void printHelp() {
        System.out.println("Your objective is to hunt down the dragon.");
        System.out.println("You can fight other monster to gain an upgrade.");
        System.out.println("There are useful item you can take from the map.");
        System.out.println();
        System.out.println("This is the list of command that you can use.");
        System.out.println(getCommandList().toString());
        printDescription();
    }

    List<String> getCommandList() {
        List<String> commandList = new ArrayList<>();
        for (String string : game.getCommandFactory().getCommandMap().keySet()) {
            if (!string.equals("cheat")) {
                commandList.add(string);
            }

        }
        return commandList;
    }

    void printHelpCommand(String arg) {
        game.getCommandFactory().getCommand(arg).printDescription();
    }


}
