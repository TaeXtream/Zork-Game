package io.muzoo.ooc.zork.character;

public abstract class Entity {
    private int healthMax;
    private int health;
    private String name;
    private String info;
    private boolean alive;

    public Entity(){
        this.healthMax = 100;
        this.health = 100;
        this.name = "default";
        this.alive = true;
    }

    public Entity(String name, int healthMax, int health){
        this.healthMax = healthMax;
        this.health = health;
        this.name = name;
        this.alive = true;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health > healthMax) {
            health = healthMax;
        }
        this.health = health;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
        if (health > healthMax) {
            health = healthMax;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }

    boolean isAlive(){
        return alive;
    }

    void dead(){
        alive = false;
    }




}
