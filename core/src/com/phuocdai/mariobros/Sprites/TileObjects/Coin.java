package com.phuocdai.mariobros.Sprites.TileObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Scenes.Hud;
import com.phuocdai.mariobros.Screens.PlayScreen;
import com.phuocdai.mariobros.Sprites.Items.Flowers;
import com.phuocdai.mariobros.Sprites.Items.ItemDef;
import com.phuocdai.mariobros.Sprites.Items.Mushroom;
import com.phuocdai.mariobros.Sprites.Mario;


public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;

    public Coin(PlayScreen screen, MapObject object){
        super(screen, object);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);
    }

    @Override
    public void marioTouchMileStones(Mario mario) {

    }

    @Override
    public void onHeadHit(Mario mario) {
        if(getCell().getTile().getId() == BLANK_COIN)
            MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();
        else {
            if(object.getProperties().containsKey("mushroom")) {
                if (mario.isBig())
                    screen.spawnItem(new ItemDef(new Vector2(body.getPosition().x, body.getPosition().y + 16 / MarioBros.PPM), Flowers.class));
                else
                    screen.spawnItem(new ItemDef(new Vector2(body.getPosition().x, body.getPosition().y + 16 / MarioBros.PPM), Mushroom.class));
                MarioBros.manager.get("audio/sounds/powerup_spawn.wav", Sound.class).play();
            }
            else
                MarioBros.manager.get("audio/sounds/coin.wav", Sound.class).play();
            getCell().setTile(tileSet.getTile(BLANK_COIN));
            Hud.addScore(100);
        }
    }

}