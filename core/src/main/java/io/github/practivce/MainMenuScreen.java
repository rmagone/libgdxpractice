package io.github.practivce;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.practivce.gameClass.Drop;

public class MainMenuScreen implements Screen {
    final Drop game;
    private Stage stage;
    private Table table;
    private TextButton playButton;
    private TextButton settingButton;
    private ButtonGroup<Button> buttonGroup;
    private Skin skin;

    public MainMenuScreen(final Drop game) {
        this.game = game;
        this.stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = game.font;
        buttonStyle.up = skin.newDrawable("white",Color.GREEN);
        buttonStyle.down =skin.newDrawable("white",Color.RED);
        buttonStyle.over =skin.newDrawable("white",Color.BLUE);
        playButton = new TextButton("Play", buttonStyle);
        playButton.align(Align.center);
//        playButton.setSize(20, 3);

        settingButton = new TextButton("Setting", buttonStyle);
//        settingButton.setSize(20, 3);
        settingButton.align(Align.center);

        table = new Table();
        table.align(Align.center);
        table.setFillParent(true);
        table.add(playButton).width(10).height(2).padBottom(0.5f).center();
        table.row().width(10);
        table.add(settingButton).width(10).height(2).padTop(0.5f).center();
//        stage.setDebugAll(true);
        stage.addActor(table);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);

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
