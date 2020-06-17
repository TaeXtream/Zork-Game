package io.muzoo.ooc.zork.gameitem;

import java.io.Serializable;

public class Weapon implements Serializable {

    int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }
}
