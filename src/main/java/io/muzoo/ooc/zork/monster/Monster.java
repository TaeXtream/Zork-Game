package io.muzoo.ooc.zork.monster;

import io.muzoo.ooc.zork.character.Entity;
import io.muzoo.ooc.zork.gameitem.Item;

public abstract class Monster extends Entity {
    private boolean hostile;
    private int attack;
    Item drop;

    void setHostile(boolean bool){
        hostile = bool;
    }

    boolean isHostile(){
        return hostile;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public Item getDrop() {
        return drop;
    }

    public void setDrop(Item drop) {
        this.drop = drop;
    }
}
