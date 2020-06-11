package io.muzoo.ooc.zork.gameitem;

public abstract class UpgradeItem extends Item {

    public UpgradeItem(String newName) {
        super(newName);
    }

    public UpgradeItem(String newName, String info) {
        super(newName, info);
    }

}
