package com.vrostov.core.weapons;

public class RangeWeapon implements Weapon{
    private double range;
    private double attackspeed;
    private double bulletSpeed;

    WeaponImproovements weaponImproovements;

    public RangeWeapon(double range, double attackspeed, double bulletSpeed, WeaponImproovements weaponImproovements) {
        this.range = range;
        this.attackspeed = attackspeed;
        this.bulletSpeed = bulletSpeed;
        this.weaponImproovements = weaponImproovements;
    }

    @Override
    public String description() {
        return "Ну очень грозное оружие";
    }

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

    public WeaponImproovements getWeaponImproovements() {
        return weaponImproovements;
    }

    public void setWeaponImproovements(WeaponImproovements weaponImproovements) {
        this.weaponImproovements = weaponImproovements;
    }
}
