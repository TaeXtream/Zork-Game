package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

import java.util.Set;

public class HelpCommand extends Command {
    public HelpCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        printHelp();
    }

    void printHelp() {
        System.out.println("Your objective is to hunt down the dragon.");
        System.out.println("You can fight other monster to gain an upgrade.");
        System.out.println("There are useful item you can take from the map.");
        System.out.println();
        System.out.println("This is the list of command that you can use.");
        System.out.println(getCommandList().toString());
    }

    Set<String> getCommandList() {
        Set<String> stringSet = game.getCommandFactory().getCommandMap().keySet();
        stringSet.remove("cheat");
        return stringSet;
    }


}
