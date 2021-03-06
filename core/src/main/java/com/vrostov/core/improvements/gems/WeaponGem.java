package com.vrostov.core.improvements.gems;

public class WeaponGem {

    private double range;
    private double attackspeed;
    private double bulletSpeed;



    public WeaponGem(double range, double attackspeed, double bulletSpeed) {
        this.range = range;
        this.attackspeed = attackspeed;
        this.bulletSpeed = bulletSpeed;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getAttackspeed() {
        return attackspeed;
    }

    public void setAttackspeed(double attackspeed) {
        this.attackspeed = attackspeed;
    }

    public double getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletSpeed(double bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }
}
