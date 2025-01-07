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
    private BitmapFont font;
    private SpriteBatch batch;
    private ProgressBar progressBar;
    private Stage stage;
    private Skin skin;

    public AssetLoadingScreen(final Drop game) {
        this.game = game;
        this.manager = game.manager;
        this.batch = game.batch;
        this.stage = new Stage(new FitViewport(20, 20));
        Gdx.input.setInputProcessor(stage);

        float worldUnitHeight = 0.5f; // Desired font height in world units
        float pixelsPerUnit = Gdx.graphics.getHeight() / 20f; // Pixels per world unit

        // Load and scale font
        font = new BitmapFont(Gdx.files.internal("ui/comicsan/52.fnt"));
        float fontScaleFactor = (worldUnitHeight * pixelsPerUnit) / font.getLineHeight();
        font.getData().setScale(fontScaleFactor);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        System.out.println("Font Original LineHeight (pixels): " + font.getLineHeight());
        System.out.println("Font Scale Factor: " + fontScaleFactor);
        System.out.println("Font Scaled LineHeight (pixels): " + font.getLineHeight() * font.getData().scaleY);
        System.out.println("Font Scaled LineHeight (world units): " + (font.getLineHeight() * font.getData().scaleY / pixelsPerUnit));

        // Progress bar
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();
        progressBarStyle.background = skin.newDrawable("white", Color.RED);
        progressBarStyle.knob = skin.newDrawable("white", Color.BLUE);
        progressBarStyle.knobBefore = skin.newDrawable("white", Color.GREEN);

        progressBar = new ProgressBar(0f, 1f, 0.01f, false, progressBarStyle);
        progressBar.setSize(20, 1);

        // Add the progress bar to the stage
        Table table = new Table();
        table.setFillParent(true);
        table.add(progressBar).width(20).height(1).padBottom(1f).center();
        stage.addActor(table);

        // Debugging table
        stage.setDebugAll(true);

        // Load assets
        manager.load("Spades/spades.atlas", TextureAtlas.class);
        manager.load("background.png", Texture.class);
        manager.load("bucket.png", Texture.class);
        manager.load("drop.png", Texture.class);
        manager.load("drop.mp3", Sound.class);
        manager.load("music.mp3", Music.class);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        // Update the progress bar value
        progressBar.setValue(manager.getProgress());

        // Draw the stage (progress bar)
        stage.act(delta);
        stage.draw();

        // Debugging: Log progress bar details
        System.out.println("Progress Bar Width: " + progressBar.getWidth());
        System.out.println("Progress Bar Height: " + progressBar.getHeight());
        System.out.println("Progress Bar X: " + progressBar.getX());
        System.out.println("Progress Bar Y: " + progressBar.getY());

        // Render the text below the progress bar
        batch.setProjectionMatrix(stage.getViewport().getCamera().combined);
        batch.begin();

        // Calculate text position
        String loadingText = "Loading... " + (int) (manager.getProgress() * 100) + "%";
        GlyphLayout layout = new GlyphLayout(font, loadingText);

        float textX = (stage.getViewport().getWorldWidth() - layout.width) / 2f;
        float textY = progressBar.getY() - progressBar.getHeight() - layout.height - 0.1f;

        // Debugging: Log text position and layout details
        System.out.println("Text X: " + textX);
        System.out.println("Text Y: " + textY);
        System.out.println("Layout Width: " + layout.width);
        System.out.println("Layout Height: " + layout.height);

        // Draw text
        font.draw(batch, layout, textX, textY);

        batch.end();

        // Debugging: Draw a rectangle around the text bounds
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(stage.getViewport().getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(textX, textY - layout.height, layout.width, layout.height);
        shapeRenderer.end();

        // Debugging: Log viewport details
        System.out.println("Viewport Width: " + stage.getViewport().getWorldWidth());
        System.out.println("Viewport Height: " + stage.getViewport().getWorldHeight());

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
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        font.dispose();
    }
}
