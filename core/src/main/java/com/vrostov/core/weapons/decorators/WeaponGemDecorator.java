package com.vrostov.core.weapons.decorators;

import com.vrostov.core.improvements.gems.WeaponGem;
import com.vrostov.core.weapons.Weapon;

public class WeaponGemDecorator extends  WeaponDecorator {

    private double range;
    private double attackspeed;
    private double bulletSpeed;

    Weapon weapon;
    WeaponGem gem;


    WeaponGemDecorator(Weapon weapon, WeaponGem weaponGem){
        this.weapon=weapon;
        this.gem=weaponGem;
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
}
