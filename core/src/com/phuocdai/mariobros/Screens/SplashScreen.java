package com.phuocdai.mariobros.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.phuocdai.mariobros.MarioBros;

public class SplashScreen implements Screen {
    private Viewport viewport;
    private Stage stage;
    private MarioBros game;

    private Texture optionsButton;
    private Texture playButton;
    private Texture exitButton;

    public SplashScreen(MarioBros game) {
        this.game = game;
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, game.batch);

        optionsButton = MarioBros.manager.get("gui/options.png", Texture.class);
        playButton = MarioBros.manager.get("gui/play.png", Texture.class);
        exitButton = MarioBros.manager.get("gui/exit.png", Texture.class);
    }

    @Override
    public void show() {

    }

    public void update(float dt){
        if(Gdx.input.isTouched())
            optionsButton = MarioBros.manager.get("gui/options_click.png", Texture.class);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(optionsButton, MarioBros.V_WIDTH - 100, MarioBros.V_HEIGHT);
        game.batch.draw(playButton, MarioBros.V_WIDTH - 100, MarioBros.V_HEIGHT + 50);
        game.batch.draw(exitButton, MarioBros.V_WIDTH - 100, MarioBros.V_HEIGHT - 50);
        game.batch.end();
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
