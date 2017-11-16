package com.vrostov.core;

import com.vrostov.core.gamelevels.CrononDemoGame;
import playn.core.Game;
import playn.core.Platform;
import pythagoras.f.IDimension;
import react.Slot;
import react.UnitSlot;
import tripleplay.game.ScreenStack;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;
import tripleplay.ui.layout.TableLayout;

public class CrononMenuScreen extends ScreenStack.UIScreen {

    protected final String[] _rlabels;
    protected final CrononGameScreen[] _screens;
    protected final ScreenStack _stack;


    public CrononMenuScreen(ScreenStack stack) {
        super(Cronon.game.plat);
        _stack=stack;
        _rlabels=new String[]{"Cronon game"};
        _screens=new CrononGameScreen[]{new CrononDemoGame()};

    }

    @Override
    public Game game() {
        return Cronon.game;
    }

    @Override
    public void wasAdded() {
        super.wasAdded();
        final Root root=iface.createRoot(AxisLayout.vertical().gap(15), SimpleStyles.newSheet(game().plat.graphics()));
        root.addStyles(Style.BACKGROUND.is(Background.bordered(0xFFCCCCCC, 0xFF99CCFF, 5).inset(5,10)));
        sizeValue().connectNotify(new Slot<IDimension>() {
            @Override
            public void onEmit(IDimension size) {
                root.setSize(size());
            }
        });
        root.add(new Label("Хроно")).addStyles(Style.FONT.is(CrononGameScreen.TITLE_FONT));
        Group grid = new Group(new TableLayout(
                TableLayout.COL.alignRight(),
                TableLayout.COL.stretch(),
                TableLayout.COL.stretch(),
                TableLayout.COL.stretch()).gaps(10, 10));
        root.add(grid);



        for (int ii = 0; ii < _screens.length; ii++) {
            if (ii%3 == 0) grid.add(new Label(_rlabels[ii/3]));
            final CrononGameScreen screen = _screens[ii];
            if (screen == null) {
                grid.add(new Shim(1, 1));
            } else {
                grid.add(new Button(screen.name()).onClick(new UnitSlot() { public void onEmit () {
                    _stack.push(screen);
                    screen.back.clicked().connect(new UnitSlot() { public void onEmit () {
                        _stack.remove(screen);
                    }});
                }}));


            }
        }

    }

    @Override
    public void wasRemoved() {
        super.wasRemoved();
        iface.disposeRoots();
    }
}
