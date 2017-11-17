package com.vrostov.core.armor;

public class LeatherArmor implements Armor {

    private int armorclass;
    private int fireresist;
    private int waterresist;
    private int earthresist;
    private int airresist;
    private int lightresist;
    private int darkresist;
    private int weight;

    private ArmorImproovements improovements;

    private String description;
public static class Builder{
    private int armorclass;
    private int weight;
    private int fireresist=0;
    private int waterresist=0;
    private int earthresist=0;
    private int airresist=0;
    private int lightresist=0;
    private int darkresist=0;
    private String description;

    ArmorImproovements improovements;


    public Builder(int armorclass, int weight, ArmorImproovements improovements, String description) {
        this.armorclass = armorclass;
        this.weight = weight;
        this.improovements=improovements;
        this.description=description;
    }

    public Builder fireresist(int val){
        fireresist=val;
        return this;
    }

    public Builder waterresist(int val){
        waterresist=val;
        return this;
    }
    public Builder earthresist(int val){
        earthresist=val;
        return this;
    }
    public Builder airresist(int val){
        airresist=val;
        return this;
    }
    public Builder darkresist(int val){
        darkresist=val;
        return this;
    }
    public Builder lightresist(int val){
        lightresist=val;
        return this;
    }

    public LeatherArmor build(){
        return new LeatherArmor(this);
    }
}

    private LeatherArmor(Builder builder) {

    armorclass=builder.armorclass;
    weight=builder.weight;
    fireresist=builder.fireresist;
    waterresist=builder.waterresist;
    earthresist=builder.earthresist;
    airresist=builder.airresist;
    darkresist=builder.darkresist;
    lightresist=builder.lightresist;
    improovements=builder.improovements;
    description=builder.description;

    }

    @Override
    public int ac() {
        return this.armorclass;
    }

    @Override
    public int fresist() {
        return this.fireresist;
    }

    @Override
    public int wresist() {
        return this.waterresist;
    }

    @Override
    public int eresist() {
        return this.earthresist;
    }

    @Override
    public int aresist() {
        return this.airresist;
    }

    @Override
    public int lresist() {
        return this.lightresist;
    }

    @Override
    public int dresist() {
        return this.darkresist;
    }

    @Override
    public int weight() {
        return this.weight;
    }

    @Override
    public ArmorImproovements getArmorImproovements() {
        return this.improovements;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public String toString() {
        return description()+"\n"+"AC:"+ac()+" FR:"+fresist()+" WR:"+wresist()+" ER:"+eresist()+" AR:"+aresist()+" DR:"+dresist()+" LR:"+lresist()+" Weight:"+weight();
    }
}
