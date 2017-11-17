package com.vrostov.core.improvements.gems;

public class ArmorGem {

    private int fireresist, earthresist, waterresist, airresist;

    public ArmorGem(int fireresist, int earthresist, int waterresist, int airresist) {
        this.fireresist = fireresist;
        this.earthresist = earthresist;
        this.waterresist = waterresist;
        this.airresist = airresist;
    }

    public int getFireresist() {
        return fireresist;
    }

    public void setFireresist(int fireresist) {
        this.fireresist = fireresist;
    }

    public int getEarthresist() {
        return earthresist;
    }

    public void setEarthresist(int earthresist) {
        this.earthresist = earthresist;
    }

    public int getWaterresist() {
        return waterresist;
    }

    public void setWaterresist(int waterresist) {
        this.waterresist = waterresist;
    }

    public int getAirresist() {
        return airresist;
    }

    public void setAirresist(int airresist) {
        this.airresist = airresist;
    }
}
