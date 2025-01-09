package io.github.practivce.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.practivce.gameClass.Drop;
import io.github.practivce.screens.GameScreen;

public class UIManager {
    private Stage stage;
    private Drop game;
    private Table table;

    public UIManager(Table table, Stage stage, Drop game) {
        this.stage = stage;
        this.game = game;
        this.table = table;
    }

    public TextButton createButton(Texture bgTexture, BitmapFont font, String text, Runnable onClick) {
        TextButton playButton = UIHelpers.createRoundedTextButton(bgTexture, font, text);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                onClick.run();
            }
        });
        return playButton;
    }
}
