package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;
import io.muzoo.ooc.zork.gamemap.Area;

public class GoCommand extends Command {

    public GoCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        System.out.println("Go " + arg);
        goRoom(arg);
    }

    @Override
    void printDescription() {
        System.out.println("Command that use to go around the game map.");
        System.out.println("Format: go ..direction..");
    }

    private void goRoom(String direction) {
        // Try to leave current room.
        Area nextArea = game.getCurrentArea().getExit(direction);
        if (nextArea == null) {
            System.out.println("There is no exit!");
        } else {
            game.setCurrentArea(nextArea);
            System.out.println(nextArea.getAreaInfo());
        }
    }
}
