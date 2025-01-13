package io.github.practivce.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.practivce.gameClass.Drop;
import io.github.practivce.ui.UIManager;

public class MainMenuScreen extends ScreenAdapter {
    final Drop game;
    private Stage stage;
    private Table table;
    private TextButton playButton;
    private TextButton settingButton;

    public MainMenuScreen(final Drop game) {
        this.game = game;
        this.stage = new Stage(game.viewport);
        table = new Table();
        table.align(Align.center);
        table.setFillParent(true);
        UIManager uiManager = new UIManager();

        Texture backgroundTexture = game.manager.get("background.png", Texture.class);
        Gdx.input.setInputProcessor(stage);

        table.background(new TextureRegionDrawable(backgroundTexture));

        playButton = uiManager.createButton(new Texture("buttonbg.png"), game.font, "Play",
            () -> {
                game.setScreen(new GameScreen(game));
                stage.dispose();
            });
        settingButton = uiManager.createButton(new Texture("buttonbg.png"), game.font, "Settings", () -> {
            game.setScreen(new SettingsScreen(game));
            stage.dispose();
        });
        table.add(playButton).width(10).height(2).padBottom(1);
        table.row();
        table.add(settingButton).width(10).height(2).padBottom(1);

        stage.addActor(table);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
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
