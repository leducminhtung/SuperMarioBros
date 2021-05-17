package com.phuocdai.mariobros.Sprites.TileObjects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Screens.PlayScreen;
import com.phuocdai.mariobros.Sprites.Mario;
import com.phuocdai.mariobros.Sprites.TileObjects.InteractiveTileObject;

public class Pipes extends InteractiveTileObject {

    public Pipes(PlayScreen screen, MapObject object) {
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.OBJECT_BIT);
    }

    @Override
    public void marioTouchMileStones(Mario mario) {

    }

    @Override
    public void onHeadHit(Mario mario) {

    }
}
