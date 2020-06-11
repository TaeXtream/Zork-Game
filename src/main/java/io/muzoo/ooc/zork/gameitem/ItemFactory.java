package io.muzoo.ooc.zork.gameitem;

import io.muzoo.ooc.zork.gamemap.GameLibrary;
import io.muzoo.ooc.zork.monster.*;

public class ItemFactory {
    GameLibrary gameLibrary = new GameLibrary();

    public Item createItem(ItemType type, String name) {
        switch (type) {
            case HealItem:
                return new Healitem(name, gameLibrary.getHealItemBook().get(name));
            case MaxHealItem:
                return new HealMaxitem(name);
            case SmallHealthItem:
                return new HealthUpgradeItem(name, 10);
            case LargeHealthItem:
                return new HealthUpgradeItem(name, 50);
            case SmallAttackItem:
                return new AttackUpgradeItem(name, 10);
            case LargeAttackItem:
                return new AttackUpgradeItem(name, 50);
            case VictoryItem:
                return new VictoryItem(name);
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }
}
