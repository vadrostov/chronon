package com.vrostov.core.armor;

import com.vrostov.core.improvements.buffs.ArmorBuff;
import com.vrostov.core.improvements.clock.ArmorClock;
import com.vrostov.core.improvements.gems.ArmorGem;
import com.vrostov.core.improvements.runes.ArmorRune;

import java.util.ArrayList;

public class ArmorImproovements {


    ArrayList<ArmorGem> gems;
    ArmorClock clock;
    ArmorBuff buff;
    ArmorRune rune;
    int gemsCount;

    public ArmorImproovements(int gemsCount) {
        this.gemsCount = gemsCount;
        gems=new ArrayList<>();
    }

    public int getGemsCount() {
        return gemsCount;
    }

    public ArrayList<ArmorGem> getGems() {
        return gems;
    }

    public void setGems(ArrayList<ArmorGem> gems) {
        this.gems = gems;
    }

    public ArmorClock getClock() {
        return clock;
    }

    public void setClock(ArmorClock clock) {
        this.clock = clock;
    }

    public ArmorBuff getBuff() {
        return buff;
    }

    public void setBuff(ArmorBuff buff) {
        this.buff = buff;
    }

    public ArmorRune getRune() {
        return rune;
    }

    public void setRune(ArmorRune rune) {
        this.rune = rune;
    }
}
