package io.github.practivce.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class UIManager {
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

    public CheckBox createCheckBox(BitmapFont font, String text, Color color, Runnable onClick) {
        CheckBox checkBox = UIHelpers.createCheckBox(font, text, color);
        checkBox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                onClick.run();
            }
        });
        return checkBox;
    }
}
