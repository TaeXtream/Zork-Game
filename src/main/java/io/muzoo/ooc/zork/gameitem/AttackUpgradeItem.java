package io.muzoo.ooc.zork.gameitem;

import io.muzoo.ooc.zork.character.Player;

public class AttackUpgradeItem extends UpgradeItem {
    int addDamage;

    public AttackUpgradeItem(String newName, int addDamage) {
        super(newName);
        this.addDamage = addDamage;
    }

    @Override
    public void itemEffect(Player player) {
        player.weapon.addDamage(addDamage);
    }

    @Override
    public void printEffect() {
        System.out.println("Upgrade Player attack by " + this.addDamage);
    }
}
