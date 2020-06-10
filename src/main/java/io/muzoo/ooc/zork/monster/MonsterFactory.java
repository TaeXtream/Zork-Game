package io.muzoo.ooc.zork.monster;

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
        throw new IllegalArgumentException("Unknown Monster Type");
    }

    public Monster createMonster(MonsterType type, String name) {
        switch (type) {
            case SmallMonster:
                return new SmallMonster(name);
            case BigMonster:
                return new BigMonster(name);
            case Dragon:
                return new Dragon(name);
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }

    public Monster createMonster(MonsterType type, String name, String info) {
        switch (type) {
            case SmallMonster:
                return new SmallMonster(name, info);
            case BigMonster:
                return new BigMonster(name, info);
            case Dragon:
                return new Dragon(name, info);
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }


}
