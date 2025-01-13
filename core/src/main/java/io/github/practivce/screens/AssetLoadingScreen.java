package io.github.practivce.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.practivce.gameClass.Drop;
import static io.github.practivce.ui.UIHelpers.createProgressBar;

public class AssetLoadingScreen implements Screen {
    final Drop game;
    private AssetManager manager;
    private ProgressBar progressBar;
    private Stage stage;
    private Label.LabelStyle labelStyle;
    private Label loadingLabel;
    private Table table;

    public AssetLoadingScreen(final Drop game) {
        this.game = game;
        this.manager = game.manager;
        this.stage = new Stage(game.viewport);
        Texture backgroundTexture = new Texture(Gdx.files.internal("teamlogo.png"));
        Image img = new Image(backgroundTexture);
        Gdx.input.setInputProcessor(stage);


        loadingLabel = game.labelFactory.createLoadingScreenLabel("Loading...");
        loadingLabel.setAlignment(Align.center);
        progressBar = createProgressBar();
        // Add the progress bar to the stage
        table = new Table();
        table.setFillParent(true);
        table.align(Align.center);
        table.add(img).width(6).height(6).center();
        table.row();
        table.add(progressBar).width(20).height(1).padBottom(1f).center();
        table.row();
        table.add(loadingLabel).width(10).height(1).padBottom(1f).center();

        stage.addActor(table);
        // Load assets
        manager.load("Clubs/clubs.atlas", TextureAtlas.class);
        manager.load("Spades/spades.atlas", TextureAtlas.class);
        manager.load("Diamonds/diamonds.atlas", TextureAtlas.class);
        manager.load("Hearts/hearts.atlas", TextureAtlas.class);
        manager.load("background.png", Texture.class);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        // Update the progress bar value
        progressBar.setValue(manager.getProgress());
        loadingLabel.setText("Loading... " + (int) (manager.getProgress() * 100));

        // Draw the stage (progress bar)
        stage.act(delta);
        stage.draw();
        // Check if assets are fully loaded
        if (manager.update()) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
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
        stage.dispose();
//        skin.dispose();
    }
}
