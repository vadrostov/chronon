package com.vrostov.core.improvements.buffs;

import com.vrostov.core.weapons.dimenisions.DamageDim;

public class WeaponBuff {

    DamageDim damage;

    public WeaponBuff(DamageDim damage) {
        this.damage = damage;
    }

    public DamageDim getDamage() {
        return damage;
    }

    public void setDamage(DamageDim damage) {
        this.damage = damage;
    }
}
