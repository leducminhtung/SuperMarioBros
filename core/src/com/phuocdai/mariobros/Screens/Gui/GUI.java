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

public class GUI {
    private Viewport viewport;
    private Stage stage;
    private boolean playPressed, optionsPressed, exitPressed;
    private OrthographicCamera camera;

    public Image background = new Image(MarioBros.manager.get("gui/Screen.png", Texture.class));
    public Image playBtn = new Image(MarioBros.manager.get("gui/play.png", Texture.class));
    public Image optionsBtn = new Image(MarioBros.manager.get("gui/options.png", Texture.class));
    public Image exitBtn = new Image(MarioBros.manager.get("gui/exit.png", Texture.class));

    public GUI(MarioBros game) {
        camera = new OrthographicCamera();
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT,camera);
        stage = new Stage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        playBtn.setSize(50, 20);
        playBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playPressed = true;
            }
        });

        optionsBtn.setSize(50, 20);
        optionsBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                optionsPressed = true;
            }
        });

        exitBtn.setSize(50, 20);
        exitBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                exitPressed = true;
            }
        });

        table.center();
        table.padTop(62);
        table.add(playBtn).size(playBtn.getWidth(), playBtn.getHeight());
        table.row();
        table.add(optionsBtn).size(playBtn.getWidth(),playBtn.getHeight());
        table.row();
        table.add(exitBtn).size(playBtn.getWidth(),playBtn.getHeight());

        background.setFillParent(true);
        stage.addActor(background);
        stage.addActor(table);
    }
    public void draw(){
        stage.draw();
    }

    public boolean isPlayPressed() {
        return playPressed;
    }

    public boolean isOptionsPressed() {
        return optionsPressed;
    }

    public boolean isExitPressed() {
        return exitPressed;
    }

    public void resize(int width, int height){
        viewport.update(width, height);
    }
}
