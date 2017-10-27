package com.vrostov.core;

import playn.core.Assets;
import playn.core.Game;
import playn.core.Platform;
import tripleplay.game.ScreenStack;

public class CrononGameScreen extends ScreenStack.UIScreen{


    public CrononGameScreen(Platform plat) {
        super(plat);
    }

    @Override
    public Game game() {
        return Cronon.game;
    }


    protected Assets assets () { return game().plat.assets(); }
}
