package io.muzoo.ooc.zork.Monster;

import io.muzoo.ooc.zork.Character.Entity;

public abstract class Monster extends Entity {
    private boolean hostile;
    private boolean alive = true;

    void setHostile(boolean bool){
        hostile = bool;
    }

    boolean isHostile(){
        return hostile;
    }

    boolean isAlive(){
        return alive;
    }

    void dead(){
        alive = false;
    }


}
