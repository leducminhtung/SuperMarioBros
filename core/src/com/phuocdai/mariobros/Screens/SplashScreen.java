package com.phuocdai.mariobros.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Screens.Gui.GUI;
import com.phuocdai.mariobros.Sprites.Mario;

public class SplashScreen implements Screen {
    private Viewport viewport;
    private Stage stage;


    private LevelSelectScreen selectScreen;
    private MarioBros game;

    private GUI gui;

    public SplashScreen(MarioBros game) {
        this.game = game;
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((MarioBros) game).batch);
        gui = new GUI(game);

    }

    public void handleInput(float dt){
        if(gui.isPlayPressed())
            game.setScreen(new LevelSelectScreen(game));
            dispose();
        if(gui.isExitPressed())
            Gdx.app.exit();
    }

    public void update(float dt){
        handleInput(dt);
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gui.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {


    }
}
