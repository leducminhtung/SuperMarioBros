package com.phuocdai.mariobros.Sprites.Enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Array;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Screens.PlayScreen;
import com.phuocdai.mariobros.Sprites.Mario;

public class Boss extends Enemy {

    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames = new Array<>();

    private boolean setToDestroy;
    private boolean destroyed;



    public Boss(PlayScreen screen, float x, float y){
        super(screen, x, y);
        world = screen.getWorld();
        addFrames();
        walkAnimation = new Animation(0.4f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 32 / MarioBros.PPM, 32 / MarioBros.PPM);
        setToDestroy = false;
        destroyed = false;
    }

    @Override
    public void update(float dt) {
        stateTime += dt;
        if(setToDestroy && !destroyed){
            destroyed = true;
            stateTime = 0;
        }
        else if(!destroyed) {
            b2body.setLinearVelocity(velocity);
            setPosition(b2body.getPosition().x - getWidth() / 2 , b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) walkAnimation.getKeyFrame(stateTime, true));
        }
    }

    public void addFrames(){
        frames.add(new TextureRegion(MarioBros.manager.get("boss.png", Texture.class),0, 0, 32, 32));
        frames.add(new TextureRegion(MarioBros.manager.get("boss.png", Texture.class),32, 0, 32, 32));
        frames.add(new TextureRegion(MarioBros.manager.get("boss.png", Texture.class),64, 0, 32, 32));
        frames.add(new TextureRegion(MarioBros.manager.get("boss.png", Texture.class),96, 0, 32, 32));
    }

    @Override
    public void hitOnHead(Mario mario) {

    }

    @Override
    public void hitByEnemy(Enemy enemy) {

    }

    @Override
    public void hitByFireBall() {

    }

    public void defineEnemy(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(), getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(16 / MarioBros.PPM);
        fdef.filter.categoryBits = MarioBros.ENEMY_BIT;
        fdef.filter.maskBits = MarioBros.GROUND_BIT |
                MarioBros.COIN_BIT |
                MarioBros.BRICK_BIT |
                MarioBros.ENEMY_BIT |
                MarioBros.OBJECT_BIT |
                MarioBros.MARIO_BIT |
                MarioBros.FIREBALL_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

    }

    @Override
    public void draw(Batch batch) {
        if(!destroyed || stateTime < 1)
            super.draw(batch);
    }
}
