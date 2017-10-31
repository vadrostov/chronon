package com.vrostov.core;

import playn.core.*;
import pythagoras.f.IDimension;
import react.Slot;
import tripleplay.game.ScreenStack;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;

public abstract class CrononGameScreen extends ScreenStack.UIScreen{

    public static final Font TITLE_FONT = new Font("Helvetica", 24);

    public Button back;



    public CrononGameScreen() {
        super(Cronon.game.plat);
    }

    @Override
    public Game game() {
        return Cronon.game;
    }

    @Override
    public void wasAdded() {
        super.wasAdded();
        final Root root=iface.createRoot(AxisLayout.vertical().gap(0).offStretch(), stylesheet(),layer);
        root.addStyles(Style.BACKGROUND.is(background()), Style.VALIGN.top);
        sizeValue().connectNotify(new Slot<IDimension>() {
            public void onEmit (IDimension size) {
                root.setSize(size);
            }
        });
        Background bg = Background.solid(0xFFCC99FF).inset(0, 0, 5, 0);
        root.add(new Group(AxisLayout.horizontal(), Style.HALIGN.left, Style.BACKGROUND.is(bg)).add(
                this.back = new Button("Back"),
                new Label(title()).addStyles(Style.FONT.is(TITLE_FONT), Style.HALIGN.center).
                        setConstraint(AxisLayout.stretched())));
        if (subtitle() != null) root.add(new Label(subtitle()));
        Group iface = createIface(root);
        if (iface != null) root.add(iface.setConstraint(AxisLayout.stretched()));


    }

    @Override
    public void wasRemoved() {
        super.wasRemoved();
    }

    protected Input input () { return game().plat.input(); }
    protected Assets assets () { return game().plat.assets(); }

    protected Stylesheet stylesheet () {
        return SimpleStyles.newSheet(game().plat.graphics());
    }

    protected Background background () {
        return Background.bordered(0xFFCCCCCC, 0xFFCC99FF, 5).inset(5);
    }

    protected String subtitle () { return null; }

    protected abstract String title ();

    protected abstract String name ();


    protected Graphics graphics () { return game().plat.graphics(); }

    protected abstract Group createIface (Root root);

}
