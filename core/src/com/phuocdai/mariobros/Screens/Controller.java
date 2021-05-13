package com.phuocdai.mariobros.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.phuocdai.mariobros.MarioBros;

public class Controller {
    private Viewport viewport;
    private Stage stage;
    private boolean upPressed, leftPressed, rightPressed;
    private OrthographicCamera camera;
    private MarioBros game;

    public Controller(MarioBros game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT,camera);
        stage = new Stage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.left().bottom();
        table.setFillParent(true);

        Image leftBtn = new Image(MarioBros.manager.get("playscreen/left.png", Texture.class));
        leftBtn.setSize(38, 30);
        leftBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
            }
        });

        Image rightBtn = new Image(MarioBros.manager.get("playscreen/right.png", Texture.class));
        rightBtn.setSize(38, 30);
        rightBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
            }
        });

        Image upBtn = new Image(MarioBros.manager.get("playscreen/up.png", Texture.class));
        upBtn.setSize(35, 35);
        upBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
            }
        });

        table.padBottom(10);
        table.padLeft(10);
        table.add(leftBtn).size(leftBtn.getWidth(), leftBtn.getHeight());
        table.add();
        table.add(rightBtn).size(rightBtn.getWidth(), rightBtn.getHeight());

        Table table1 = new Table();
        table1.right().bottom();
        table1.setFillParent(true);
        table1.padBottom(30);
        table1.padRight(30);

        table1.add(upBtn).size(upBtn.getWidth(),upBtn.getHeight());

        stage.addActor(table1);
        stage.addActor(table);
    }

    public void draw(){
        stage.draw();
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void resize(int width, int height){
        viewport.update(width, height);
    }
}
