package io.muzoo.ooc.zork.Map;

public interface Map {

    String getName();
    String getDiscription();

    void generateArea();

    void generateItem();

    void generateMonster();

}
