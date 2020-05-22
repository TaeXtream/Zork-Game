package io.muzoo.ooc.zork.Monster;

import io.muzoo.ooc.zork.Character.Entity;

public enum  MonsterType {

    SmallMONSTER(0.08),
    LargeMonster(0.04),
    Dragon(0.01);

    private double spawnPropbaility;


    MonsterType(double spawnPropbaility){
        this.spawnPropbaility = spawnPropbaility;

    }


    public double getSpawnPropbaility() {
        return spawnPropbaility;
    }

}
