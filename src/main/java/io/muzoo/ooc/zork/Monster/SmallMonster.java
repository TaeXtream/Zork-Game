package io.muzoo.ooc.zork.Monster;

import io.muzoo.ooc.zork.Character.Entity;

public class SmallMonster extends Monster {

    public SmallMonster(){
        this.setHealthMax(20);
        this.setHostile(false);
        this.setAttack(5);
        this.setHealth(20);
    }

    public SmallMonster(String name){
        this.setHealthMax(20);
        this.setHostile(false);
        this.setName(name);
        this.setAttack(5);
        this.setHealth(20);
    }

    public SmallMonster(String name, String info){
        this.setHealthMax(20);
        this.setHostile(false);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(5);
        this.setHealth(20);
    }
}
