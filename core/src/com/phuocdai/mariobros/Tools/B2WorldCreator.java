package com.phuocdai.mariobros.Tools;

import  com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Screens.PlayScreen;
import com.phuocdai.mariobros.Sprites.Enemies.Enemy;
import com.phuocdai.mariobros.Sprites.Enemies.Turtle;
import com.phuocdai.mariobros.Sprites.TileObjects.Brick;
import com.phuocdai.mariobros.Sprites.TileObjects.Coin;
import com.phuocdai.mariobros.Sprites.Enemies.Goomba;
import com.phuocdai.mariobros.Sprites.TileObjects.Grounds;
import com.phuocdai.mariobros.Sprites.TileObjects.Pipes;

public class B2WorldCreator {
    private Array<Goomba> goombas;
    private Array<Turtle> turtles;


    public Array<Goomba> getGoombas() {
        return goombas;
    }
    public Array<Enemy> getEnemies(){
        Array<Enemy> enemies = new Array<>();
        enemies.addAll(goombas);
        enemies.addAll(turtles);
        return enemies;
    }

    public B2WorldCreator(PlayScreen screen){
        World world = screen.getWorld();
        TiledMap map = screen.getMap();

        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        //Grounds
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){

            new Grounds(screen,object);
        }
        //Pipes
        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){

            new Pipes(screen,object);
        }
        //Bricks
        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){

            new Brick(screen,object);
        }
        //Coins
        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){

            new Coin(screen,object);
        }

        //Goombas
        goombas = new Array<Goomba>();
        for(MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            goombas.add(new Goomba(screen, rect.getX() / MarioBros.PPM, rect.getY() / MarioBros.PPM));
        }
        //Turtles
        turtles = new Array<Turtle>();
        for(MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            turtles.add(new Turtle(screen, rect.getX() / MarioBros.PPM, rect.getY() / MarioBros.PPM));
        }
    }
}
