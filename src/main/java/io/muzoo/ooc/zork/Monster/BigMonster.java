package io.muzoo.ooc.zork.Monster;

public class BigMonster extends Monster {
    public BigMonster(String name, String info){
        this.setHealthMax(50);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(15);
        this.setHealth(50);
    }
}
