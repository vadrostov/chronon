package com.vrostov.core.armor;

public interface Armor {

    public int ac();

    public int fresist();

    public int wresist();

    public int eresist();

    public int aresist();

    public int lresist();

    public int dresist();

    public int weight();


    public ArmorImproovements getArmorImproovements();
    public String description();


}
