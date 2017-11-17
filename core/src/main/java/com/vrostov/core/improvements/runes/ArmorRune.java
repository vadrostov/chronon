package com.vrostov.core.improvements.runes;

public class ArmorRune {

    private int darkresist, lightresist;

    public ArmorRune(int darkresist, int lightresist) {
        this.darkresist = darkresist;
        this.lightresist = lightresist;
    }

    public int getDarkresist() {
        return darkresist;
    }

    public void setDarkresist(int darkresist) {
        this.darkresist = darkresist;
    }

    public int getLightresist() {
        return lightresist;
    }

    public void setLightresist(int lightresist) {
        this.lightresist = lightresist;
    }
}
