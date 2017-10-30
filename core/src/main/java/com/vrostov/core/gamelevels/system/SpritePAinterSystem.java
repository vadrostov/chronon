package com.vrostov.core.gamelevels.system;

import com.vrostov.core.gamelevels.CrononDemoGame;
import playn.core.Clock;
import tripleplay.entity.Entity;
import tripleplay.entity.System;
import tripleplay.entity.World;

public class SpritePAinterSystem extends System {

    CrononDemoGame.DemoWorld demoGame;
    public SpritePAinterSystem(World world, int priority) {
        super(world, priority);
        demoGame=(CrononDemoGame.DemoWorld) world;
    }

    @Override
    protected void paint(Clock clock, Entities entities) {
        super.paint(clock, entities);
    }

    @Override
    protected boolean isInterested(Entity entity) {
        return (entity.has(demoGame.sprite));
    }
}
