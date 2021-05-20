package com.phuocdai.mariobros.Screens.Gui;

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
import com.phuocdai.mariobros.Sprites.Mario;

public class Controller {
    Viewport viewport;
    Stage stage;
    boolean upPressed, leftPressed, rightPressed, downPressed, optionPressed;
    OrthographicCamera cam;
    private MarioBros game;

    public Controller(MarioBros game){
        this.game = game;
        cam = new OrthographicCamera();
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT,cam);
        stage = new Stage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.left().bottom();
        table.setFillParent(true);

        Image upImg = new Image(new Texture("playscreen/up.png"));
        upImg.setSize(35, 35);
        upImg.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                return true;
                //return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
                //super.touchUp(event, x, y, pointer, button);
            }
        });

        Image leftImg = new Image(new Texture("playscreen/left.png"));
        leftImg.setSize(38,30);
        leftImg.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true;
                return true;
                //return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
                //super.touchUp(event, x, y, pointer, button);
            }
        });

        Image rightImg = new Image(new Texture("playscreen/right.png"));
        rightImg.setSize(38,30);
        rightImg.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true;
                return true;
                //return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
                //super.touchUp(event, x, y, pointer, button);
            }
        });

        Image downImg = new Image(new Texture("playscreen/down.png"));
        downImg.setSize(35,35);
        downImg.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = true;
                return true;
                //return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = false;
                //super.touchUp(event, x, y, pointer, button);
            }
        });

//        Image options = new Image(new Texture("playscreen/options.png"));
//        options.setSize(20,20);
//        options.addListener(new InputListener(){
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                optionPressed = true;
//                return true;
//            }
//
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                optionPressed = true;
//            }
//        });

        table.padBottom(10);
        table.padLeft(10);
        table.add(leftImg).size(leftImg.getWidth(), leftImg.getHeight());
        table.add();
        table.add(rightImg).size(rightImg.getWidth(), rightImg.getHeight());
        //table.row().pad(5,5,5,5);

        Table table1 = new Table();
        table1.right().bottom();
        table1.setFillParent(true);
        table1.padRight(20);
        table1.padBottom(20);
        table1.add(upImg).size(upImg.getWidth(), upImg.getHeight());
        //table1.add();
        table1.add(downImg).size(downImg.getWidth(), downImg.getHeight());

        //table.row().padTop(5);
        //table.add();
//        Table table2 = new Table();
//        table2.right().top();
//        table2.setFillParent(true);
////        table2.padRight(20);
////        table2.padBottom(10);
//        table2.add(options).size(options.getWidth(), options.getHeight());


        stage.addActor(table);
        stage.addActor(table1);
        //stage.addActor(table2);

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

    public boolean isOptionPressed(){return optionPressed;}

    public void resize(int width, int height){
        viewport.update(width, height);
    }

    public boolean isDownPressed() {
        return downPressed;
    }
}
