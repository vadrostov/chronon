package com.vrostov.core.weapons;

import com.vrostov.core.weapons.dimenisions.DamageDim;

public interface Weapon {

    public double range();
    public double attackSpeed();
    public double bulletSpeed();
    public WeaponImproovements getWeaponImproovements();

    public DamageDim damage();
    public  DamageDim elemDamage();

    public String description();
}
