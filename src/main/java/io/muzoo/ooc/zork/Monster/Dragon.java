package io.muzoo.ooc.zork.Monster;

public class Dragon extends Monster {
    private int superAttack;

    public Dragon(){
        this.setHealthMax(200);
        this.setHostile(true);
        this.setAttack(30);
        this.setHealth(200);
        this.superAttack = 80;
    }

    public Dragon(String name){
        this.setHealthMax(200);
        this.setHostile(true);
        this.setName(name);
        this.setAttack(30);
        this.setHealth(200);
        this.superAttack = 80;
    }

    public Dragon(String name, String info){
        this.setHealthMax(200);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(30);
        this.setHealth(200);
        this.superAttack = 80;
    }

    public int getSuperAttack() {
        return superAttack;
    }
}
