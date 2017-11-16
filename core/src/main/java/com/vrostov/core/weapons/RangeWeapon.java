package com.vrostov.core.weapons;

public class RangeWeapon implements Weapon{
    private double range;
    private double attackspeed;
    private double bulletSpeed;

    @Override
    public double range() {
        return this.range;
    }

    @Override
    public double attackSpeed() {
        return this.attackspeed;
    }

    @Override
    public double bulletSpeed() {
        return this.bulletSpeed;
    }
}
