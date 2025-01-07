package io.github.practivce.gameClass;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.practivce.AssetLoadingScreen;

public class Drop extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
    public FitViewport viewport;
    public AssetManager manager;
//    private Camera camera;

    @Override
    public void create() {
//        Gdx.graphics.setWindowedMode(Gdx.graphics.getDisplayMode().width, Gdx.graphics.getDisplayMode().height);
        batch = new SpriteBatch();
        font = new BitmapFont();
        viewport = new FitViewport(20f ,20f);
        font.getData().setScale(viewport.getWorldHeight()*3 / Gdx.graphics.getHeight());

        manager = new AssetManager();

        font.setUseIntegerPositions(false);

        this.setScreen(new AssetLoadingScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
