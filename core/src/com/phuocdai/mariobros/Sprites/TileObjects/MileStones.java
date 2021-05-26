package com.phuocdai.mariobros.Sprites.TileObjects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.phuocdai.mariobros.MarioBros;

import com.phuocdai.mariobros.Scenes.Hud;
import com.phuocdai.mariobros.Screens.PlayScreen;
import com.phuocdai.mariobros.Sprites.Mario;

public class MileStones extends InteractiveTileObject{
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;

    public MileStones(PlayScreen screen, MapObject object){
        super(screen, object);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.FINISH);

    }
    @Override
    public void marioTouchMileStones(Mario mario) {
        if (!object.getProperties().containsKey("Finish")) {
            mario.finish();
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            Hud.addScore(200);
        } else
            mario.afterFinish();
    }

    @Override
    public void onHeadHit(Mario mario) {

    }
}
