package com.vrostov.core.armor.decorators;

import com.vrostov.core.armor.Armor;
import com.vrostov.core.armor.ArmorImproovements;
import com.vrostov.core.improvements.gems.ArmorGem;

public class ArmorGemDecorator extends ArmorDecorator{

    Armor armor;
    ArmorImproovements armorImproovements;
    ArmorGem gem;

    public ArmorGemDecorator(Armor armor, ArmorGem gem) {
        this.armor = armor;
        this.gem = gem;
        this.armorImproovements=armor.getArmorImproovements();
    }


    @Override
    public ArmorImproovements getArmorImproovements() {
        return armorImproovements;
    }

    @Override
    public int ac() {
        return armor.ac();
    }

    @Override
    public int fresist() {
        return armor.fresist()+gem.getFireresist();
    }

    @Override
    public int wresist() {
        return armor.wresist()+gem.getWaterresist();
    }

    @Override
    public int eresist() {
        return armor.eresist()+gem.getEarthresist();
    }

    @Override
    public int aresist() {
        return armor.aresist()+gem.getAirresist();
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
    public String description() {
        return armor.description()+"\n +GEM fr="+gem.getFireresist()+", wr="+gem.getWaterresist()+", er="+gem.getEarthresist()+" ,ar="+gem.getAirresist();
    }
    @Override
    public String toString() {
        return description()+"\n"+"AC:"+ac()+" FR:"+fresist()+" WR:"+wresist()+" ER:"+eresist()+" AR:"+aresist()+" DR:"+dresist()+" LR:"+lresist()+" Weight:"+weight();
    }
}
