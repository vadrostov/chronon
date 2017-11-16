package com.vrostov.core.weapons;

import com.vrostov.core.weapons.dimenisions.DamageDim;

public class RangeWeapon implements Weapon{
    private double range;
    private double attackspeed;
    private double bulletSpeed;
    private DamageDim damage;
    private DamageDim elemDamage;

    WeaponImproovements weaponImproovements;

    public RangeWeapon(double range, double attackspeed, double bulletSpeed, DamageDim damage, DamageDim elemDamage, WeaponImproovements weaponImproovements) {
        this.range = range;
        this.attackspeed = attackspeed;
        this.bulletSpeed = bulletSpeed;
        this.weaponImproovements = weaponImproovements;
        this.damage=damage;
        this.elemDamage=elemDamage;
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

    @Override
    public DamageDim damage() {
        return this.damage;
    }

    @Override
    public DamageDim elemDamage() {
        return this.elemDamage;
    }

    public WeaponImproovements getWeaponImproovements() {
        return weaponImproovements;
    }

    public void setWeaponImproovements(WeaponImproovements weaponImproovements) {
        this.weaponImproovements = weaponImproovements;
    }
}
