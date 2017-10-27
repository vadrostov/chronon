package com.vrostov.core.gamelevels;

import com.vrostov.core.CrononGameScreen;
import com.vrostov.core.gamelevels.system.MoverSystem;
import playn.core.Image;
import playn.core.Key;
import playn.core.Platform;
import playn.scene.GroupLayer;
import playn.scene.ImageLayer;
import playn.scene.Layer;
import pythagoras.f.Point;
import react.Signal;
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
    Entity mainPers;
    public CrononDemoGame(Platform plat) {
        super(plat);
    }

    enum Size {
        TINY(20), SMALL(40), MEDIUM(60), LARGE(80);
        public final int size;
        Size (int size) { this.size = size; }
    }

    class DemoWorld extends World{
        public final GroupLayer stage;

        public final float swidth, sheight;
        public final Randoms rando = Randoms.with(new Random());

        public static final int MAINPERS=(1<<0);
        public static final int NPC=(1<<1);
        public static final int ENEMY_BULLET=(1<<2);

        public final Component.IMask type = new Component.IMask(this);
        public final Component.XY opos = new Component.XY(this);
        public final Component.XY pos = new Component.XY(this);
        public final Component.XY vel = new Component.XY(this); // pixels/ms
        public final Component.Generic<Layer> sprite = new Component.Generic<Layer>(this);
        public final Component.Generic<Size> size = new Component.Generic<Size>(this);
        public final Component.FScalar spin = new Component.FScalar(this); // rads/ms
        public final Component.FScalar radius = new Component.FScalar(this);
        public final Component.IScalar expires = new Component.IScalar(this);

        public final Signal<Key> keyDown = Signal.create();
        public final Signal<Key> keyUp = Signal.create();

        System moverSystem;


        public int now;


        public DemoWorld(GroupLayer stage, float swidth, float sheight) {
            this.stage = stage;
            this.swidth = swidth;
            this.sheight = sheight;
            moverSystem=new MoverSystem(this,0);

        }

        public void startGame(int wave){
            if (wave==0){
                for (Entity e: this){
                    e.close(); }
                    createMain(swidth/2, sheight/2);
                    createNPC((float) swidth/100*15, sheight/100*15);
                    createNPC((float) swidth/100*15, sheight/100*85);
                    createNPC((float) swidth/100*85, sheight/100*15);
                    createNPC((float) swidth/100*15, sheight/100*85);


            }

            for(Entity e:_entities){
                if (type.get(e.id)==NPC){

                }
            }



        }



        public Entity createMain(float x, float y){
            mainPers=create(true);
            mainPers.add(type, sprite, opos, pos, vel, spin, radius);
            float ah=mainPersImage.height();
            ImageLayer imageLayer=new ImageLayer(mainPersImage);
            layer.setOrigin(ah/2, ah/2);

            int id=mainPers.id;
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

            int id=npc.id;
            ImageLayer npcLayer=new ImageLayer(npcImage.region(iidx*ah, 0, ah, ah));
            type.set(id,NPC);
            sprite.set(id, npcLayer);
            opos.set(id,x,y);
            pos.set(id,x,y);
            vel.set(id,0,0);
            radius.set(id, ah/2);

            return npc;


        }

        public Entity createBullet(int npcId){

            final Point p=new Point();
            Entity enemyBullet=create(true);
            enemyBullet.add(type, sprite, opos, pos, vel, spin, radius);
            float ah=enemyBulletImage.height();
            ImageLayer layer = new ImageLayer(enemyBulletImage);
            int id=enemyBullet.id;
            type.set(id, ENEMY_BULLET);
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
