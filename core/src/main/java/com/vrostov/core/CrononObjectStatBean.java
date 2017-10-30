package com.vrostov.core;

public class CrononObjectStatBean {

    private double radius;
    private double bulletSize;
    private double atackspeed;
    private double speed;
    private double bulletspeed;

    private CrononObjectStatBean(Builder builder) {
        this.radius = builder.radius;
        this.bulletSize = builder.bulletSize;
        this.atackspeed = builder.atackspeed;
        this.speed = builder.speed;
        this.bulletspeed=builder.bulletspeed;
    }


    public static class Builder{
        private double radius=0;
        private double bulletSize=0;
        private double atackspeed=0;
        private double speed=0;
        private double bulletspeed=0;

        public Builder(double radius) {
            this.radius = radius;
        }


        public Builder bulletSpeed(double val){
            bulletspeed=val;
            return this;
        }

        public Builder bulletSize(double val){
            bulletSize=val;
            return this;
        }

        public Builder attackSpeed(double val){
            atackspeed=val;
            return this;

        }

        public Builder speed(double val){
            speed=val;
            return this;
        }

        public CrononObjectStatBean build(){
            return new CrononObjectStatBean(this);
        }

    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getBulletSize() {
        return bulletSize;
    }

    public void setBulletSize(double bulletSize) {
        this.bulletSize = bulletSize;
    }

    public double getAtackspeed() {
        return atackspeed;
    }

    public void setAtackspeed(double atackspeed) {
        this.atackspeed = atackspeed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getBulletspeed() {
        return bulletspeed;
    }

    public void setBulletspeed(double bulletspeed) {
        this.bulletspeed = bulletspeed;
    }
}
