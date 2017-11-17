package com.vrostov.core.armor.decorators;

import com.vrostov.core.armor.Armor;
import com.vrostov.core.armor.ArmorImproovements;
import com.vrostov.core.improvements.runes.ArmorRune;

public class ArmorRuneDecorator extends ArmorDecorator {

    Armor armor;
    ArmorImproovements armorImproovements;
    ArmorRune rune;

    public ArmorRuneDecorator(Armor armor, ArmorRune rune) {
        this.armor = armor;
        this.rune = rune;
        this.armorImproovements=armor.getArmorImproovements();
    }

    @Override
    public int ac() {
        return armor.ac();
    }

    @Override
    public int fresist() {
        return armor.fresist();
    }

    @Override
    public int wresist() {
        return armor.wresist();
    }

    @Override
    public int eresist() {
        return armor.eresist();
    }

    @Override
    public int aresist() {
        return armor.aresist();
    }

    @Override
    public int lresist() {
        return armor.lresist()+rune.getLightresist();
    }

    @Override
    public int dresist() {
        return armor.dresist()+rune.getDarkresist();
    }

    @Override
    public int weight() {
        return armor.weight();
    }

    @Override
    public ArmorImproovements getArmorImproovements() {
        return armorImproovements;
    }

    @Override
    public String description() {
        return armor.description()+"\n +RUNE LR="+rune.getLightresist()+", DR"+rune.getDarkresist();
    }

    @Override
    public String toString() {
        return description()+"\n"+"AC:"+ac()+" FR:"+fresist()+" WR:"+wresist()+" ER:"+eresist()+" AR:"+aresist()+" DR:"+dresist()+" LR:"+lresist()+" Weight:"+weight();
    }
}
