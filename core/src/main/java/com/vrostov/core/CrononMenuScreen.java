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

        root.add(new Button("Play").onClick(new UnitSlot() {
            @Override
            public void onEmit() {
                _stack.push(new CrononDemoGame());
            }
        }));

    }

    @Override
    public void wasRemoved() {
        super.wasRemoved();
        iface.disposeRoots();
    }
}
