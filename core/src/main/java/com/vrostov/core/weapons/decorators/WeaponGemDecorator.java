package com.vrostov.core.weapons.decorators;

import com.vrostov.core.improvements.gems.WeaponGem;
import com.vrostov.core.weapons.Weapon;
import com.vrostov.core.weapons.WeaponImproovements;
import com.vrostov.core.weapons.dimenisions.DamageDim;

public class WeaponGemDecorator extends  WeaponDecorator {

    Weapon weapon;
    WeaponGem gem;
    WeaponImproovements weaponImproovements;

    public WeaponGemDecorator(Weapon weapon, WeaponGem weaponGem){
        this.weapon=weapon;
        this.gem=weaponGem;
        this.weaponImproovements=weapon.getWeaponImproovements();
    }

    @Override
    public double range() {
        return gem.getRange()+weapon.range();
    }

    @Override
    public double attackSpeed() {
        return gem.getAttackspeed()+weapon.attackSpeed();
    }

    @Override
    public double bulletSpeed() {
        return gem.getBulletSpeed()+weapon.bulletSpeed();
    }

    @Override
    public String description() {
        return weapon.description()+"\n +Камень";
    }

    @Override
    public DamageDim damage() {
        return weapon.damage();
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
