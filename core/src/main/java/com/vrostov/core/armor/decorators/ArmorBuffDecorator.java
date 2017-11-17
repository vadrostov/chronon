package com.vrostov.core.armor.decorators;

import com.vrostov.core.armor.Armor;
import com.vrostov.core.armor.ArmorImproovements;
import com.vrostov.core.improvements.buffs.ArmorBuff;

public class ArmorBuffDecorator extends ArmorDecorator{

    Armor armor;
    ArmorImproovements armorImproovements;
    ArmorBuff buff;

    public ArmorBuffDecorator(Armor armor, ArmorBuff buff) {
        this.armor = armor;
        this.buff = buff;
        this.armorImproovements=armor.getArmorImproovements();
    }

    @Override
    public int ac() {
        return armor.ac()+buff.getArmorclass();
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
        return armor.lresist();
    }

    @Override
    public int dresist() {
        return armor.dresist();
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
        return armor.description()+"\n +BUFF AC="+buff.getArmorclass();
    }

    @Override
    public String toString() {
        return description()+"\n"+"AC:"+ac()+" FR:"+fresist()+" WR:"+wresist()+" ER:"+eresist()+" AR:"+aresist()+" DR:"+dresist()+" LR:"+lresist()+" Weight:"+weight();
    }
}
