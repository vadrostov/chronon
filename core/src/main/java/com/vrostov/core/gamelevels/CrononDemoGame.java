package com.vrostov.core.gamelevels;

import com.vrostov.core.CrononGameScreen;
import com.vrostov.core.CrononObjectStatBean;
import com.vrostov.core.gamelevels.system.MoverSystem;
import playn.core.*;
import playn.scene.GroupLayer;
import playn.scene.ImageLayer;
import playn.scene.Layer;
import pythagoras.f.MathUtil;
import pythagoras.f.Point;
import react.Signal;
import react.Slot;
import tripleplay.entity.Component;
import tripleplay.entity.*;
import tripleplay.entity.System;
import tripleplay.util.Randoms;
import tripleplay.game.*;

import java.util.Random;

public class CrononDemoGame extends CrononGameScreen {


    public final Image npcImage=assets().getImage("/images/enemy.png");
    public final Image mainPersImage=assets().getImage("/images/mainpers.png");
    public final Image enemyBulletImage=assets().getImage("/images/enemybullet.png");
    public final Image friendlyBulletImage=assets().getImage("/images/enemybullet.png");

    Entity mainPers;
    public CrononDemoGame(Platform plat) {
        super(plat);
    }

    enum Size {
        TINY(20), SMALL(40), MEDIUM(60), LARGE(80);
        public final int size;
        Size (int size) { this.size = size; }
    }

    public class DemoWorld extends World{
        public final GroupLayer stage;

        public final float swidth, sheight;
        public final Randoms rando = Randoms.with(new Random());

        public static final int MAINPERS=(1<<0);
        public static final int NPC=(1<<1);
        public static final int ENEMY_BULLET=(1<<2);
        public static final int FRIENDLY_BULLET=(2<<1);



        public final Component.IMask type = new Component.IMask(this);
        public final Component.XY opos = new Component.XY(this);
        public final Component.XY pos = new Component.XY(this);
        public final Component.XY vel = new Component.XY(this); // pixels/ms
        public final Component.Generic<CrononObjectStatBean> stats = new Component.Generic<>(this);
        public final Component.Generic<Layer> sprite = new Component.Generic<Layer>(this);
        public final Component.Generic<Size> size = new Component.Generic<Size>(this);
        public final Component.FScalar spin = new Component.FScalar(this); // rads/ms
        public final Component.FScalar radius = new Component.FScalar(this);
        public final Component.IScalar expires = new Component.IScalar(this);

        public final Signal<Key> keyDown = Signal.create();
        public final Signal<Key> keyUp = Signal.create();

        int i=0;

        System moverSystem;


        public int now;

        System controls = new System(this,0) {


            {

                keyDown.connect(new Slot<Key>() {

                    @Override
                    public void onEmit(Key key) {

                        int id=mainPers.id;
                        switch (key){
                            case W: vel.set(id, vel.getX(id), -1);
                            case A: vel.set(id, -1, vel.getY(id));
                            case S:vel.set(id, vel.getX(id), 1);
                            case D:vel.set(id, 1, vel.getY(id));
                            case LEFT: createFriendlyBullet(id, pos.getX(id), pos.getY(id), -1,0);
                            case UP:  createFriendlyBullet(mainPers.id, pos.getX(mainPers.id), pos.getY(mainPers.id), 0,-1);
                            case DOWN: createFriendlyBullet(mainPers.id, pos.getX(mainPers.id), pos.getY(mainPers.id), 0,1);
                            case RIGHT: createFriendlyBullet(mainPers.id, pos.getX(mainPers.id), pos.getY(mainPers.id), 1,0);
                            default: break;
                        }
                    }
                });

                keyUp.connect(new Slot<Key>() {

                    @Override
                    public void onEmit(Key key) {
                        int id=mainPers.id;
                        switch (key){
                            case W: vel.set(id, vel.getX(id),0);
                            case A:vel.set(id, 0,vel.getY(id));
                            case S:vel.set(id, vel.getX(id),0);
                            case D:vel.set(id, 0,vel.getY(id));
                        }
                    }
                });
            }

            @Override
            protected boolean isInterested(Entity entity) {
                return type.get(entity.id)==MAINPERS;
            }
        };

        System spritePainterSystem = new System(this,0) {

            @Override
            protected void paint(Clock clock, Entities entities) {
                super.paint(clock, entities);
                float alpha=clock.alpha;
                Point op=_oldPos, p=_pos;
                for (int ii=0; ii<entities.size();ii++){

                    int entId=entities.get(ii);
                    pos.get(entId, p);
                    opos.set(entId,p);
                    sprite.get(entId).setTranslation(MathUtil.lerp(op.x, p.x, alpha), MathUtil.lerp(op.y, p.y, alpha));
                }


            }

            @Override
            protected void wasAdded(Entity entity) {
                super.wasAdded(entity);
                stage.addAt(sprite.get(entity.id), pos.getX(entity.id), pos.getY(entity.id));
            }

            @Override
            protected void wasRemoved(Entity entity, int index) {
                super.wasRemoved(entity, index);
                stage.remove(sprite.get(entity.id));
            }

            @Override
            protected boolean isInterested(Entity entity) {
                return (entity.has(sprite)&&entity.has(opos)&&entity.has(pos));
            }

            protected final Point _oldPos = new Point(), _pos = new Point();
        };


        public DemoWorld(GroupLayer stage, float swidth, float sheight) {
            this.stage = stage;
            this.swidth = swidth;
            this.sheight = sheight;
            moverSystem=new MoverSystem(this,0);
            closeOnHide(input().keyboardEvents.connect(new Keyboard.KeySlot() {
                @Override
                public void onEmit(Keyboard.KeyEvent event) {

                    (event.down?keyDown:keyUp).emit(event.key);
                }
            }));


        }

        public void startWave(int wave){
            if (wave==0){
                for (Entity e: this){
                    e.close(); }
                    createMain(swidth/2, sheight/2);
                    createNPC((float) swidth/100*15, sheight/100*15);
                    createNPC((float) swidth/100*15, sheight/100*85);
                    createNPC((float) swidth/100*85, sheight/100*15);
                    createNPC((float) swidth/100*15, sheight/100*85);


            }

            ++i;
            if (i>=30) {
                for (Entity e : _entities) {
                    if (type.get(e.id) == NPC) {
                        createBullet(e.id);
                    }
                }
                i=0;
            }



        }



        public Entity createMain(float x, float y){
            mainPers=create(true);
            mainPers.add(type, sprite, opos, pos, vel, spin, radius, stats);
            float ah=mainPersImage.height();
            ImageLayer imageLayer=new ImageLayer(mainPersImage);
            layer.setOrigin(ah/2, ah/2);

            CrononObjectStatBean statBean=new CrononObjectStatBean.Builder(ah/2).attackSpeed(1).bulletSize(5).speed(1).build();

            int id=mainPers.id;
            stats.set(id, statBean);
            sprite.set(id, layer);
            type.set(id, MAINPERS);
            pos.set(id, x, y);
            vel.set(id, 0,0);
            radius.set(id, 40);
            return mainPers;


        }

        public Entity createNPC(float x, float y){
            Entity npc=create(true);
            npc.add(type, sprite, opos, pos, vel, spin, radius);
            float ah=npcImage.height();
            int iidx=rando.getInt(4);
            int rand=rando.getInRange(6,10);

            CrononObjectStatBean statBean=new CrononObjectStatBean.Builder(ah/2).bulletSize(5).attackSpeed(rand*0.1).build();

            int id=npc.id;
            stats.set(id, statBean);
            ImageLayer npcLayer=new ImageLayer(npcImage.region(iidx*ah, 0, ah, ah));
            type.set(id,NPC);
            sprite.set(id, npcLayer);
            opos.set(id,x,y);
            pos.set(id,x,y);
            vel.set(id,0,0);
            radius.set(id, ah/2);

            return npc;


        }

        public Entity createFriendlyBullet(int mpId, float x, float y, float vx, float vy){

            Entity friendlyBullet=create(true);
            friendlyBullet.add(type, sprite, opos, pos, vel, radius);
            int id=friendlyBullet.id;
            ImageLayer layer=new ImageLayer(friendlyBulletImage);
            type.set(id, FRIENDLY_BULLET);
            sprite.set(id, layer);
            opos.set(id,x,y);
            pos.set(id,x,y);
            vel.set(id, vx, vy);
            radius.set(id,5);

            return friendlyBullet;

        }

        public Entity createBullet(int npcId){

            final Point p=new Point();
            Entity enemyBullet=create(true);
            enemyBullet.add(type, sprite, opos, pos, vel, spin, radius);
            float ah=enemyBulletImage.height();
            ImageLayer layer = new ImageLayer(enemyBulletImage);
            int id=enemyBullet.id;

            CrononObjectStatBean statBean=new CrononObjectStatBean.Builder(5).speed(stats.get(npcId).getBulletspeed()).build();
            type.set(id, ENEMY_BULLET);
            stats.set(id,statBean);
            sprite.set(id, layer);
            opos.set(id, pos.getX(npcId), pos.getY(npcId));
            pos.set(id, pos.getX(npcId), pos.getY(npcId));
            vel.set(id, 0.02f, 0.02f);
            spin.set(id, 0.0015f);
            radius.set(id, ah/2);

            return enemyBullet;



        }


    }
}
