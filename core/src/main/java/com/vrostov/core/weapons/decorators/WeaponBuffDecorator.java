package com.vrostov.core.weapons.decorators;

import com.vrostov.core.improvements.buffs.WeaponBuff;
import com.vrostov.core.weapons.Weapon;
import com.vrostov.core.weapons.WeaponImproovements;
import com.vrostov.core.weapons.dimenisions.DamageDim;

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
        return weapon.range();
    }

    @Override
    public double attackSpeed() {
        return weapon.attackSpeed();
    }

    @Override
    public double bulletSpeed() {
        return weapon.bulletSpeed();
    }

    @Override
    public String description() {
        return weapon.description()+"\n +Бафф";
    }


    @Override
    public DamageDim damage() {
        return new DamageDim(weapon.damage().getMin()+buff.getDamage().getMin(),weapon.damage().getMax()+buff.getDamage().getMax());
    }

    @Override
    public DamageDim elemDamage() {
        return weapon.elemDamage();
    }

    @Override
    public WeaponImproovements getWeaponImproovements() {
        return weaponImproovements;
    }
}
