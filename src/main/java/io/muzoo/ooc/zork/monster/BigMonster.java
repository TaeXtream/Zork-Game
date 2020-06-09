package io.muzoo.ooc.zork.monster;

public class BigMonster extends Monster {

    public BigMonster(){
        this.setHealthMax(50);
        this.setHostile(true);
        this.setAttack(15);
        this.setHealth(50);
    }

    public BigMonster(String name){
        this.setHealthMax(50);
        this.setHostile(true);
        this.setName(name);
        this.setAttack(15);
        this.setHealth(50);
    }

    public BigMonster(String name, String info){
        this.setHealthMax(50);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(15);
        this.setHealth(50);
    }
}
