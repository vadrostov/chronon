package com.vrostov.core.weapons.decorators;

import com.vrostov.core.weapons.Weapon;

public abstract class WeaponDecorator implements Weapon{

    @Override
    public abstract double range() ;

    @Override
    public abstract double attackSpeed() ;

    @Override
    public abstract double bulletSpeed() ;
}
