package io.muzoo.ooc.zork.monster;

import io.muzoo.ooc.zork.gamemap.GameLibrary;

public class MonsterFactory {

    GameLibrary gameLibrary = new GameLibrary();

    public Monster createMonster(MonsterType type) {
        switch (type) {
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
                return new SmallMonster(name, gameLibrary.getSmallMonstersBook().get(name).getKey());
            case BigMonster:
                return new BigMonster(name, gameLibrary.getBigMonstersBook().get(name).getKey());
            case Dragon:
                return new Dragon(name, gameLibrary.getDragonBook().get(name).getKey());
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
