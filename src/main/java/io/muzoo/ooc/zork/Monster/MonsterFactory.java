package io.muzoo.ooc.zork.Monster;

import java.util.*;

public class MonsterFactory {

    public enum MonsterType {
        SmallMonster, BigMonster, Dragon
    }


    public Monster createMonster(MonsterType type){
        switch (type){
            case SmallMonster:
                return new SmallMonster();
            case BigMonster:
                return new BigMonster();
            case Dragon:
                return new Dragon();
        }
        throw  new IllegalArgumentException("Unknown Monster Type");
    }

}
