package io.github.practivce.gameClass;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.practivce.Factories.LabelFactory;
import io.github.practivce.screens.AssetLoadingScreen;

public class Drop extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
    public FitViewport viewport;
    public AssetManager manager;
    public LabelFactory labelFactory;
//    private Camera camera;

    @Override
    public void create() {
//        Gdx.graphics.setWindowedMode(Gdx.graphics.getDisplayMode().width, Gdx.graphics.getDisplayMode().height);
        batch = new SpriteBatch();
        font = new BitmapFont();
        manager = new AssetManager();
        viewport = new FitViewport(20f, 20f);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/comicsan/comicsans.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 32;       // The size (in pixels) you want
        parameter.color = Color.WHITE;               // Base color of your font
        parameter.magFilter = Texture.TextureFilter.Linear;  // For smoother scaling
        parameter.minFilter = Texture.TextureFilter.Linear;
        font = generator.generateFont(parameter);
        generator.dispose();
        font.getData().setScale(viewport.getWorldHeight()  / Gdx.graphics.getHeight());
        font.setUseIntegerPositions(false);
        labelFactory = new LabelFactory(font);
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
