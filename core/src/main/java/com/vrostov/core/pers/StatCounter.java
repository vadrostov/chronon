package com.vrostov.core.pers;

import com.vrostov.core.improvements.buffs.WeaponBuff;
import com.vrostov.core.improvements.gems.WeaponGem;
import com.vrostov.core.improvements.runes.WeaponRune;
import com.vrostov.core.weapons.RangeWeapon;
import com.vrostov.core.weapons.Weapon;
import com.vrostov.core.weapons.WeaponImproovements;
import com.vrostov.core.weapons.decorators.WeaponBuffDecorator;
import com.vrostov.core.weapons.decorators.WeaponGemDecorator;
import com.vrostov.core.weapons.decorators.WeaponRuneDecorator;

public class StatCounter {


    public static void main(String[] args){


        Weapon weapon=new RangeWeapon(12,3.3,4.5, new WeaponImproovements(2));
        WeaponGem[]gems=weapon.getWeaponImproovements().getGems();
         gems[0]=new WeaponGem(12,0,3.0);
        gems[1]=new WeaponGem(0,3.4,0.0);
        weapon.getWeaponImproovements().setRune(new WeaponRune(1,0,3.0));
        weapon.getWeaponImproovements().setBuff(new WeaponBuff(5,3,2.0));

        weapon=statsDecorate(weapon);
        System.out.println(weapon.description());
        System.out.println("Скорость атаки:"+weapon.attackSpeed()+", Скорость снаряда: "+weapon.bulletSpeed()+", Радиус атаки: "+weapon.range());

    }

    public static Weapon statsDecorate(Weapon weapon){

        for (WeaponGem gem:weapon.getWeaponImproovements().getGems()){
            weapon=new WeaponGemDecorator(weapon, gem);
        }
        weapon=new WeaponRuneDecorator(weapon, weapon.getWeaponImproovements().getRune());
        weapon=new WeaponBuffDecorator(weapon,weapon.getWeaponImproovements().getBuff());
        return weapon;
    }

}
