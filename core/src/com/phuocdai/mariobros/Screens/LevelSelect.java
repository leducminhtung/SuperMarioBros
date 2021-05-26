package com.phuocdai.mariobros.Screens;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.World;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Scenes.Hud;

public class LevelSelect {
    public final int level;
    public TmxMapLoader mapLoader;
    public TiledMap map;
    public String levelText;
    public Music music;

    public LevelSelect(int level){
        mapLoader = new TmxMapLoader();
        //mapLoader2 = new TmxMapLoader();
        this.level = level;
        switch (level){
            case 1:
                levelText = "1-1";
                map = mapLoader.load("level1.tmx");
                music = MarioBros.manager.get("audio/music/mario_music.ogg", Music.class);
                music.setLooping(true);
                music.setVolume(0.3f);
                music.play();
                break;
            case 2:
                levelText = "1-2";
                map = mapLoader.load("level2.tmx");
                music = MarioBros.manager.get("audio/music/mario_music.ogg", Music.class);
                music.setLooping(true);
                music.setVolume(0.3f);
                music.play();
                break;
            case 3:
                levelText = "1-3";
                map = mapLoader.load("level3.tmx");
                music = MarioBros.manager.get("audio/music/mario_music.ogg", Music.class);
                music.setLooping(true);
                music.setVolume(0.3f);
                music.play();
                break;
            case 4:
                levelText = "1-4";
                map = mapLoader.load("level4.tmx");
                MarioBros.manager.get("audio/sounds/warning.wav", Sound.class).loop();
                MarioBros.manager.get("audio/music/mario_music.ogg", Music.class).pause();
                break;
            default:
                throw new IllegalArgumentException("Select one of predefined sizes");
        }
    }
}
