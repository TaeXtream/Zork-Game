package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;
import io.muzoo.ooc.zork.gameitem.VictoryItem;

public class CheatCommand extends Command {

    public CheatCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        cheese(arg);
    }

    @Override
    void printDescription() {
        System.out.println("NOOOO!");
        System.out.println("Don't!!!!");
    }

    void cheese(String arg) {
        switch (arg) {
            case "ultimate":
                game.getPlayer().getWeapon().addDamage(9000);
                game.getPlayer().setHealthMax(9000);
                game.getPlayer().setHealth(9000);
                break;
            case "victory":
                game.getPlayer().getInventory().add(new VictoryItem("Cheese"));
                break;
            case "kill":
                game.getTarget().dead();
                break;
            case "weak":
                game.getPlayer().getWeapon().setDamage(1);
                game.getPlayer().setHealthMax(10);
                game.getPlayer().setHealth(10);
                break;
            default:
                System.out.println("Cheese don't exist!");
                break;
        }
    }
}
