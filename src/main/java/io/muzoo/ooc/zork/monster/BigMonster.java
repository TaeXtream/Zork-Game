package io.muzoo.ooc.zork.monster;

import io.muzoo.ooc.zork.gameitem.Item;

public class BigMonster extends Monster {

    public BigMonster() {
        this.setHealthMax(100);
        this.setHostile(true);
        this.setAttack(20);
        this.setHealth(100);
    }

    public BigMonster(String name) {
        this.setHealthMax(100);
        this.setHostile(true);
        this.setName(name);
        this.setAttack(20);
        this.setHealth(100);
    }

    public BigMonster(String name, String info) {
        this.setHealthMax(100);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(20);
        this.setHealth(100);
    }

    public BigMonster(String name, String info, Item drop) {
        this.setHealthMax(100);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(20);
        this.setHealth(100);
        this.drop = drop;
    }
}
