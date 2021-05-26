package com.phuocdai.mariobros.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Scenes.Hud;
import com.phuocdai.mariobros.Screens.Gui.LevelSelectGUI;

import org.graalvm.compiler.phases.common.NodeCounterPhase;

public class LevelSelectScreen implements Screen {
    private Viewport viewport;
    private Stage stage;

    private LevelSelect levelSelect;
    private MarioBros game;

    private LevelSelectGUI selectGUI;

    public LevelSelectScreen(MarioBros game){
        this.game = game;
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((MarioBros)game).batch);
        selectGUI = new LevelSelectGUI(game);
    }

    public void handleInput(float dt){
        switch (selectGUI.getLevel()){
            case 1:
                game.setScreen((new PlayScreen(game, new LevelSelect(1))));
                break;
            case 2:
                game.setScreen((new PlayScreen(game, new LevelSelect(2))));
                break;
            case 3:
                game.setScreen((new PlayScreen(game, new LevelSelect(3))));
                break;
            case 4:
                game.setScreen((new PlayScreen(game, new LevelSelect(4))));
                break;
        }

//        if(selectGUI.isSelectLevel1())
//            game.setScreen((new PlayScreen(game, new LevelSelect(1))));
//        else
//            if(selectGUI.isSelectLevel2())
//                game.setScreen((new PlayScreen(game, new LevelSelect(2))));
//            else
//                if(selectGUI.isSelectLevel3())
//                    game.setScreen((new PlayScreen(game, new LevelSelect(3))));
//                else
//                    if(selectGUI.isSelectLevel4())
//                        game.setScreen(new PlayScreen(game,new LevelSelect(4)));
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
        selectGUI.draw();
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
