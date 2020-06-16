package io.muzoo.ooc.zork.monster;

import io.muzoo.ooc.zork.gameitem.Item;
import io.muzoo.ooc.zork.gameitem.ItemFactory;
import io.muzoo.ooc.zork.gamemap.GameLibrary;

public class MonsterFactory {

    GameLibrary gameLibrary = new GameLibrary();
    ItemFactory itemFactory = new ItemFactory();

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

    public Monster createMonster(MonsterType type, String name, String info, Item drop) {
        switch (type) {
            case SmallMonster:
                return new SmallMonster(name, info, drop);
            case BigMonster:
                return new BigMonster(name, info, drop);
            case Dragon:
                return new Dragon(name, info, drop);
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }

    public Monster createMonsterByName(String name) {
        if (gameLibrary.getSmallMonstersBook().containsKey(name)) {
            String info = gameLibrary.getSmallMonstersBook().get(name).getKey();
            Item drop = itemFactory.createItem(gameLibrary.getSmallMonstersBook().get(name).getValue());
            return createMonster(MonsterType.SmallMonster, name, info, drop);
        } else if (gameLibrary.getBigMonstersBook().containsKey(name)) {
            String info = gameLibrary.getBigMonstersBook().get(name).getKey();
            Item drop = itemFactory.createItem(gameLibrary.getBigMonstersBook().get(name).getValue());
            return createMonster(MonsterType.BigMonster, name, info, drop);
        } else if (gameLibrary.getDragonBook().containsKey(name)) {
            String info = gameLibrary.getDragonBook().get(name).getKey();
            Item drop = itemFactory.createItem(gameLibrary.getDragonBook().get(name).getValue());
            return createMonster(MonsterType.Dragon, name, info, drop);
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }


}
