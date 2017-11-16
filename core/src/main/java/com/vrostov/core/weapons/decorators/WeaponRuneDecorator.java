package com.vrostov.core.weapons.decorators;

import com.vrostov.core.improvements.runes.WeaponRune;
import com.vrostov.core.weapons.Weapon;
import com.vrostov.core.weapons.WeaponImproovements;
import com.vrostov.core.weapons.dimenisions.DamageDim;

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
    public WeaponImproovements getWeaponImproovements() {
        return weaponImproovements;
    }

    @Override
    public DamageDim damage() {
        return weapon.damage();
    }

    @Override
    public DamageDim elemDamage() {
        return new DamageDim(weapon.elemDamage().getMin()+rune.getElemDamage().getMin(), weapon.elemDamage().getMax()+rune.getElemDamage().getMax());
    }

    @Override
    public String description() {
        return weapon.description()+"\n +Руна";
    }
}
