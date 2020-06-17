package io.muzoo.ooc.zork.monster;


import io.muzoo.ooc.zork.gameitem.Item;

public class Dragon extends Monster {
    private final int superAttack;

    public Dragon() {
        this.setHealthMax(300);
        this.setHostile(true);
        this.setAttack(40);
        this.setHealth(300);
        this.superAttack = 100;
    }

    public Dragon(String name) {
        this.setHealthMax(300);
        this.setHostile(true);
        this.setName(name);
        this.setAttack(40);
        this.setHealth(300);
        this.superAttack = 100;
    }

    public Dragon(String name, String info) {
        this.setHealthMax(300);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(40);
        this.setHealth(300);
        this.superAttack = 100;
    }

    public Dragon(String name, String info, Item drop) {
        this.setHealthMax(300);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(40);
        this.setHealth(300);
        this.superAttack = 100;
        this.drop = drop;
    }

    public int getSuperAttack() {
        return superAttack;
    }
}
