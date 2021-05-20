package com.phuocdai.mariobros.Screens;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.World;
import com.phuocdai.mariobros.Scenes.Hud;

public class LevelSelect {
    public final int level;
    public TmxMapLoader mapLoader;
    public TiledMap map;
    public String levelText;
    public TmxMapLoader mapLoader2;

    public LevelSelect(int level){
        mapLoader = new TmxMapLoader();
        //mapLoader2 = new TmxMapLoader();
        this.level = level;
        switch (level){
            case 1:
                levelText = "1-1";
                map = mapLoader.load("level1.tmx");
                break;
            case 2:
                levelText = "1-2";
                map = mapLoader.load("level2.tmx");
                break;
            case 3:
                levelText = "1-3";
                map = mapLoader.load("level3.tmx");
                break;
            default:
                throw new IllegalArgumentException("Select one of predefined sizes");
        }
    }
}
