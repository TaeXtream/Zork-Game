package io.muzoo.ooc.zork.gameitem;

import io.muzoo.ooc.zork.gamemap.GameLibrary;

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
        throw new IllegalArgumentException("Unknown Item Type");
    }

    public Item createItem(String name) {
        if (gameLibrary.getHealItemBook().containsKey(name)) {
            return createItem(ItemType.HealItem, name);
        } else if (gameLibrary.getMaxHealItemBook().contains(name)) {
            return createItem(ItemType.MaxHealItem, name);
        } else if (gameLibrary.getSmallHealthItemBook().contains(name)) {
            return createItem(ItemType.SmallHealthItem, name);
        } else if (gameLibrary.getLargeHealthItemBook().contains(name)) {
            return createItem(ItemType.LargeHealthItem, name);
        } else if (gameLibrary.getSmallAttackItemBook().contains(name)) {
            return createItem(ItemType.SmallAttackItem, name);
        } else if (gameLibrary.getLargeAttackItemBook().contains(name)) {
            return createItem(ItemType.LargeAttackItem, name);
        } else if (gameLibrary.getVictoryItem().contains(name)) {
            return createItem(ItemType.VictoryItem, name);
        }
        throw new IllegalArgumentException("Unknown Item Type");
    }
}
