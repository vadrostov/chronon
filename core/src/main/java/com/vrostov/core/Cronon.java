package com.vrostov.core;

import javafx.stage.Screen;
import playn.core.*;
import playn.scene.*;
import playn.scene.Pointer;
import tripleplay.game.ScreenStack;

public class Cronon extends SceneGame {

  public static Cronon game;

  public final ScreenStack screens = new ScreenStack(this, rootLayer) {
    @Override protected Transition defaultPushTransition () { return slide(); }
    @Override protected Transition defaultPopTransition () { return slide().right(); }
  };

  public Cronon (Platform plat) {
    super(plat, 33); // update our "simulation" 33ms (30 times per second)
    game=this;
    new Pointer(plat, rootLayer, true);
    screens.push(new CrononMenuScreen(screens));
    // create and add background image layer

  }
}
