package com.vrostov.core.weapons;

import com.vrostov.core.improvements.buffs.WeaponBuff;
import com.vrostov.core.improvements.gems.WeaponGem;
import com.vrostov.core.improvements.runes.WeaponRune;

import java.util.Arrays;

public class WeaponImproovements {
    WeaponGem[] gems;
    WeaponRune rune;
    WeaponBuff buff;

    public WeaponImproovements(int i) {
       gems=new WeaponGem[i];
        Arrays.fill(gems, new WeaponGem(0,0,0));
    }

    public WeaponGem[] getGems() {
        return gems;
    }

    public WeaponRune getRune() {
        return rune;
    }

    public void setRune(WeaponRune rune) {
        this.rune = rune;
    }

    public WeaponBuff getBuff() {
        return buff;
    }

    public void setBuff(WeaponBuff buff) {
        this.buff = buff;
    }
}
