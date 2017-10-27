package com.vrostov.core.gamelevels.system;

import playn.core.Clock;
import tripleplay.entity.Entity;
import tripleplay.entity.System;
import tripleplay.entity.World;

public class MoverSystem extends System {


    public MoverSystem(World world, int priority) {
        super(world, priority);
    }

    @Override
    protected void update(Clock clock, Entities entities) {
        super.update(clock, entities);
    }

    @Override
    protected boolean isInterested(Entity entity) {
        return false;
    }
}
