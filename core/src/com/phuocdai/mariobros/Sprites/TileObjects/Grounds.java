package com.phuocdai.mariobros.Sprites.TileObjects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Screens.PlayScreen;
import com.phuocdai.mariobros.Sprites.Mario;

public class Grounds extends InteractiveTileObject {
    public Grounds(PlayScreen screen, MapObject object){
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.GROUND_BIT);
    }

    @Override
    public void marioTouchMileStones(Mario mario) {

    }

    @Override
    public void onHeadHit(Mario mario) {

    }
}
