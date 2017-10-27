package com.vrostov.java;

import playn.java.LWJGLPlatform;

import com.vrostov.core.Cronon;

public class CrononJava {

  public static void main (String[] args) {

    LWJGLPlatform.Config config = new LWJGLPlatform.Config();
    // use config to customize the Java platform, if needed
    LWJGLPlatform plat = new LWJGLPlatform(config);
    new Cronon(plat);
    plat.start();


  }
}
