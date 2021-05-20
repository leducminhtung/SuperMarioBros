package com.phuocdai.mariobros.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Screens.Gui.OptionsInGameGUI;

public class OptionsInGameScreen implements Screen {
    private Viewport viewport;
    private Stage stage;

    private MarioBros game;
    private OptionsInGameGUI op;

    public OptionsInGameScreen(MarioBros game){
        this.game = game;
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((MarioBros) game).batch);
        op = new OptionsInGameGUI(game);
    }

    public void handleInput(float dt){

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
