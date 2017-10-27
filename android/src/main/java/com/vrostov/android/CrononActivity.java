package com.vrostov.android;

import playn.android.GameActivity;

import com.vrostov.core.Cronon;

public class CrononActivity extends GameActivity {

  @Override public void main () {
    new Cronon(platform());
  }
}
