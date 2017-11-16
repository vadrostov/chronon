package com.vrostov.core.weapons;

public interface Weapon {

    public double range();
    public double attackSpeed();
    public double bulletSpeed();
    public WeaponImproovements getWeaponImproovements();

    public String description();
}
