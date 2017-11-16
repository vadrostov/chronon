package com.vrostov.core.improvements.runes;

import com.vrostov.core.weapons.dimenisions.DamageDim;

public class WeaponRune {


    private DamageDim elemDamage;

    public WeaponRune(DamageDim elemDamage) {
        this.elemDamage = elemDamage;
    }

    public DamageDim getElemDamage() {
        return elemDamage;
    }

    public void setElemDamage(DamageDim elemDamage) {
        this.elemDamage = elemDamage;
    }
}
