package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

public class HelpCommand extends Command {
    public HelpCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        printHelp();
    }

    void printHelp() {
        System.out.println("This is the list of command that you can use.");
        System.out.println(game.getCommandFactory().getCommandMap().keySet().toString());
        System.out.println("Your objective is to hunt down the dragon.");
        System.out.println("You can fight other monster to gain an upgrade.");
        System.out.println("There are useful item you can take from the map.");
    }

}
