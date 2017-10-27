package com.vrostov.html;

import com.google.gwt.core.client.EntryPoint;
import playn.html.HtmlPlatform;
import com.vrostov.core.Cronon;

public class CrononHtml implements EntryPoint {

  @Override public void onModuleLoad () {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // use config to customize the HTML platform, if needed
    HtmlPlatform plat = new HtmlPlatform(config);
    plat.assets().setPathPrefix("chrononn/");
    new Cronon(plat);
    plat.start();
  }
}
