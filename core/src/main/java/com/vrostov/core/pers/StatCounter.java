package com.vrostov.core.pers;

import com.vrostov.core.armor.Armor;
import com.vrostov.core.armor.ArmorImproovements;
import com.vrostov.core.armor.LeatherArmor;
import com.vrostov.core.armor.decorators.ArmorBuffDecorator;
import com.vrostov.core.armor.decorators.ArmorGemDecorator;
import com.vrostov.core.armor.decorators.ArmorRuneDecorator;
import com.vrostov.core.improvements.buffs.ArmorBuff;
import com.vrostov.core.improvements.buffs.WeaponBuff;
import com.vrostov.core.improvements.gems.ArmorGem;
import com.vrostov.core.improvements.gems.WeaponGem;
import com.vrostov.core.improvements.runes.ArmorRune;
import com.vrostov.core.improvements.runes.WeaponRune;
import com.vrostov.core.weapons.RangeWeapon;
import com.vrostov.core.weapons.Weapon;
import com.vrostov.core.weapons.WeaponImproovements;
import com.vrostov.core.weapons.decorators.WeaponBuffDecorator;
import com.vrostov.core.weapons.decorators.WeaponGemDecorator;
import com.vrostov.core.weapons.decorators.WeaponRuneDecorator;
import com.vrostov.core.weapons.dimenisions.DamageDim;

import java.util.Random;

public class StatCounter {


    public static void main(String[] args){


        Weapon weapon=new RangeWeapon(12,3.3,4.5,new DamageDim(12,15), new DamageDim(0,0), new WeaponImproovements(2));
        WeaponGem[]gems=weapon.getWeaponImproovements().getGems();
         gems[0]=new WeaponGem(12,0,3.0);
        gems[1]=new WeaponGem(0,3.4,0.0);
        weapon.getWeaponImproovements().setRune(new WeaponRune(new DamageDim(11,16)));
        weapon.getWeaponImproovements().setBuff(new WeaponBuff(new DamageDim(3,5)));

        weapon=statsDecorate(weapon);
        System.out.println(weapon.description());
        System.out.println("Урон: "+weapon.damage()+", Урон от стихий: "+weapon.elemDamage()+", Скорость атаки:"+weapon.attackSpeed()+", Скорость снаряда: "+weapon.bulletSpeed()+", Радиус атаки: "+weapon.range());


        Random random=new Random();
        Armor armor=new LeatherArmor.Builder(120, 300, new ArmorImproovements(random.nextInt(4)), "Кожаная броня").lightresist(23).fireresist(113).build();
        for (int i=0; i<armor.getArmorImproovements().getGemsCount();i++){
            armor.getArmorImproovements().getGems().add(i, new ArmorGem(new Random().nextInt(23), new Random().nextInt(23), new Random().nextInt(23), new Random().nextInt(23)));
        }
        armor.getArmorImproovements().setRune(new ArmorRune(random.nextInt(23), random.nextInt(23)));
        armor.getArmorImproovements().setBuff(new ArmorBuff(random.nextInt(23)));

        armor=armorDecorate(armor);
        System.out.println(armor);

/*        System.out.println(armor.description());
        System.out.println("AC:"+armor.ac()+" FR:"+armor.fresist()+" WR:"+armor.wresist()+" ER:"+armor.eresist()+" AR:"+armor.aresist()+" DR:"+armor.dresist()+" LR:"+armor.lresist()+" Weight:"+armor.weight());
  */




    }

    public static Weapon statsDecorate(Weapon weapon){

        for (WeaponGem gem:weapon.getWeaponImproovements().getGems()){
            weapon=new WeaponGemDecorator(weapon, gem);
        }
        weapon=new WeaponRuneDecorator(weapon, weapon.getWeaponImproovements().getRune());
        weapon=new WeaponBuffDecorator(weapon,weapon.getWeaponImproovements().getBuff());
        return weapon;
    }

    public static Armor armorDecorate(Armor armor){
        for (ArmorGem gem:armor.getArmorImproovements().getGems()){
            armor=new ArmorGemDecorator(armor, gem);
        }
        armor=new ArmorRuneDecorator(armor, armor.getArmorImproovements().getRune());
        armor=new ArmorBuffDecorator(armor, armor.getArmorImproovements().getBuff());
        return armor;
    }

}
