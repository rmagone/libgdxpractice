package io.github.practivce;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.practivce.gameClass.Drop;

public class AssetLoadingScreen implements Screen {
    final Drop game;
    AssetManager manager;
    private ProgressBar progressBar;
    private Stage stage;
    private Skin skin;
    Label.LabelStyle labelStyle;
    Label loadingLabel;

    public AssetLoadingScreen(final Drop game) {
        this.game = game;
        this.manager = game.manager;
        this.stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);
        // ----------------------------------------------------------------------------
        // 1. Create a LabelStyle using the newly generated TTF font.
        // ----------------------------------------------------------------------------
        labelStyle = new Label.LabelStyle(game.font, Color.RED);
        loadingLabel = new Label("Loading...", labelStyle);
        loadingLabel.setAlignment(Align.center);
        // ----------------------------------------------------------------------------
        // 2. Create a progress bar style and bar, then arrange them in a Table.
        // ----------------------------------------------------------------------------

        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();
        progressBarStyle.background = skin.newDrawable("white", Color.DARK_GRAY);
        progressBarStyle.knob = skin.newDrawable("white", Color.BLUE);
        progressBarStyle.knobBefore = skin.newDrawable("white", Color.BLUE);

        progressBar = new ProgressBar(0f, 1f, 0.01f, false, progressBarStyle);
        progressBar.setSize(20, 1);

        // Add the progress bar to the stage
        Table table = new Table();
        table.setFillParent(true);
        table.add(progressBar).width(20).height(1).padBottom(1f).center();
        table.row();
        table.add(loadingLabel).width(20).height(1).padBottom(1f).center();
        stage.addActor(table);

        // Load assets
        manager.load("Spades/spades.atlas", TextureAtlas.class);
        manager.load("background.png", Texture.class);
        manager.load("bucket.png", Texture.class);
        manager.load("drop.png", Texture.class);
        manager.load("drop.mp3", Sound.class);
        manager.load("music.mp3", Music.class);
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
        skin.dispose();
    }
}
