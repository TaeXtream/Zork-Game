package io.muzoo.ooc.zork.gameitem;

import io.muzoo.ooc.zork.character.Player;

public class HealthUpgradeItem extends UpgradeItem {
    int addHealth;

    public HealthUpgradeItem(String newName, int addHealth) {
        super(newName);
        this.addHealth = addHealth;
    }

    public HealthUpgradeItem(String newName, String info, int addHealth) {
        super(newName, info);
        this.addHealth = addHealth;
    }

    @Override
    public void itemEffect(Player player) {
        player.setHealthMax(player.getHealthMax() + addHealth);
    }

    @Override
    public void printEffect() {
        System.out.println("Upgrade Player health by " + this.addHealth);
    }
}
