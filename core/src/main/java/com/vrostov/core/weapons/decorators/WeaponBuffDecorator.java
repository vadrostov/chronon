package com.vrostov.core.weapons.decorators;

import com.vrostov.core.improvements.buffs.WeaponBuff;
import com.vrostov.core.weapons.Weapon;
import com.vrostov.core.weapons.WeaponImproovements;

public class WeaponBuffDecorator extends WeaponDecorator {

    Weapon weapon;
    WeaponBuff buff;
    WeaponImproovements weaponImproovements;

    public WeaponBuffDecorator(Weapon weapon, WeaponBuff buff) {
        this.weapon = weapon;
        this.buff = buff;
        this.weaponImproovements=weapon.getWeaponImproovements();
    }

    @Override
    public double range() {
        return weapon.range()+buff.getRange();
    }

    @Override
    public double attackSpeed() {
        return weapon.attackSpeed()+buff.getAttackspeed();
    }

    @Override
    public double bulletSpeed() {
        return weapon.bulletSpeed()+buff.getBulletSpeed();
    }

    @Override
    public String description() {
        return weapon.description()+"\n +Бафф";
    }

    @Override
    public WeaponImproovements getWeaponImproovements() {
        return weaponImproovements;
    }
}
