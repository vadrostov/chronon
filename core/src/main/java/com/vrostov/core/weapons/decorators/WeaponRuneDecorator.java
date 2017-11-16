package com.vrostov.core.weapons.decorators;

import com.vrostov.core.improvements.runes.WeaponRune;
import com.vrostov.core.weapons.Weapon;
import com.vrostov.core.weapons.WeaponImproovements;

public class WeaponRuneDecorator extends WeaponDecorator {


    Weapon weapon;
    WeaponRune rune;
    WeaponImproovements weaponImproovements;

    public WeaponRuneDecorator(Weapon weapon, WeaponRune weaponRune) {
        this.weapon = weapon;
        this.rune = weaponRune;
        this.weaponImproovements=weapon.getWeaponImproovements();
    }

    @Override
    public double range() {
        return weapon.range()+ rune.getRange();
    }

    @Override
    public double attackSpeed() {
        return weapon.attackSpeed()+rune.getAttackspeed();
    }

    @Override
    public double bulletSpeed() {
        return weapon.bulletSpeed()+rune.getBulletSpeed();
    }

    @Override
    public WeaponImproovements getWeaponImproovements() {
        return weaponImproovements;
    }

    @Override
    public String description() {
        return weapon.description()+"\n +Руна";
    }
}
