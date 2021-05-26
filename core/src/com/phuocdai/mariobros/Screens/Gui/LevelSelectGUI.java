package com.phuocdai.mariobros.Screens.Gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.phuocdai.mariobros.MarioBros;
import com.phuocdai.mariobros.Sprites.Mario;

public class LevelSelectGUI {
    private Viewport viewport;
    private Stage stage;
    private int level;
    private OrthographicCamera cam;

    private Image backGr = new Image((MarioBros.manager.get("gui/SelectLV.png", Texture.class)));
    //private Image star = new Image((MarioBros.manager.get("gui/star_lv.png",Texture.class)));
    private Image btnPlay1 = new Image(MarioBros.manager.get("gui/tagLv1.png", Texture.class));
    private Image btnPlay2 = new Image(MarioBros.manager.get("gui/tagLv2.png",Texture.class));
    private Image btnPlay3 = new Image(MarioBros.manager.get("gui/tagLv3.png",Texture.class));
    private Image btnPlay4 = new Image(MarioBros.manager.get("gui/tagLv4.png",Texture.class));

    public LevelSelectGUI(MarioBros game){
        cam = new OrthographicCamera();
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT,cam);
        stage = new Stage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        btnPlay1.setSize(70,50);
        btnPlay1.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                level = 1;
            }
        });

        btnPlay2.setSize(70,50);
        btnPlay2.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                level = 2;
            }
        });

        btnPlay3.setSize(70,50);
        btnPlay3.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                level = 3;
            }
        });

        btnPlay4.setSize(70,50);
        btnPlay4.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                level = 4;
            }
        });

        Table table1 = new Table();
        table1.center().top();
        table1.setFillParent(true);
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label contentSeLectLV = new Label("SELECT LEVEL", font);
        table1.add(contentSeLectLV).expandX().padTop(30f);

        table.add(btnPlay1).size(btnPlay1.getWidth(), btnPlay1.getHeight()).expandX();
        //table.add();
        //table.row();
        //table.add(star);

        table.add(btnPlay2).size(btnPlay2.getWidth(), btnPlay2.getHeight()).expandX();
        table.padBottom(50);

        Table table2 = new Table();
        table2.add(btnPlay3).size(btnPlay3.getWidth(), btnPlay3.getHeight()).expandX();
        table2.add(btnPlay4).size(btnPlay4.getWidth(), btnPlay4.getHeight()).expandX();
        table2.setFillParent(true);
        table2.bottom();
        table2.padBottom(50f);




        backGr.setFillParent(true);
        stage.addActor(backGr);
        stage.addActor(table);
        stage.addActor(table1);
        stage.addActor(table2);

    }
    public void draw(){stage.draw();}

    public int getLevel() {
        return level;
    }

    public void resize(int width, int height){
        viewport.update(width, height);
    }
}
