package io.muzoo.ooc.zork.gameitem;

public class Weapon extends Item {

    int damage;
    public Weapon(String newName, String info, int damage) {
        super(newName, info);
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
