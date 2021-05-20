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

public class OptionsInGameGUI {
    private Viewport viewport;
    private Stage stage;
    private boolean stop, quit, resume;

    private OrthographicCamera cam;

    private Image btnStop = new Image(MarioBros.manager.get("playscreen/stop.png", Texture.class));
    private Image btnResume = new Image(MarioBros.manager.get("playscreen/resume.png", Texture.class));
    private Image btnQuit = new Image(MarioBros.manager.get("playscreen/quit.png", Texture.class));

    public OptionsInGameGUI(MarioBros game){
        cam = new OrthographicCamera();
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT,cam);
        stage = new Stage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);

        final Table table = new Table();
        table.center();
        table.setFillParent(true);

        btnStop.setSize(70,50);
        btnStop.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                stop = true;
            }
        });

        btnResume.setSize(70,50);
        btnResume.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                resume = true;
            }
        });

        btnQuit.setSize(70,50);
        btnQuit.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                quit = true;
            }
        });

        table.center();
        table.add(btnResume).size(btnResume.getWidth(), btnQuit.getHeight());
        table.add();
        table.add(btnStop).size(btnStop.getWidth(), btnStop.getHeight());
        table.row();
        table.add(btnQuit).size(btnQuit.getWidth(), btnQuit.getHeight());

        stage.addActor(table);
    }
    public void draw(){
        stage.draw();
    }

    public boolean isResumePress(){return resume;}

    public boolean isStopPress(){return stop;}

    public boolean isQuitPress(){return quit;}

    public void resize(int width, int height){
        viewport.update(width, height);
    }
}
