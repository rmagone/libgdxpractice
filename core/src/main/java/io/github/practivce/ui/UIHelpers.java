package io.github.practivce.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class UIHelpers {

    /**
     * Creates a TextButton with a rounded background and custom text.
     *
     * @param backgroundTexture The texture for the button background.
     * @param font              The font for the button text.
     * @param text              The text to display on the button.
     * @return A configured TextButton instance.
     */
    public static TextButton createRoundedTextButton(Texture backgroundTexture, BitmapFont font, String text) {
        // Create a drawable for the rounded background
        TextureRegionDrawable roundedBackground = new TextureRegionDrawable(backgroundTexture);

        // Create the TextButtonStyle
        TextButtonStyle style = new TextButtonStyle();
        style.up = roundedBackground; // Normal background
        style.down = roundedBackground.tint(Color.LIGHT_GRAY); // Pressed background
        style.over = roundedBackground.tint(Color.LIGHT_GRAY); // Pressed background
        style.font = font; // Font for the text
        style.fontColor = Color.WHITE; // Text color

        // Create and return the TextButton
        return new TextButton(text, style);
    }

    public static ProgressBar createProgressBar() {
//        define progress bar style
        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();
        progressBarStyle.background = new TextureRegionDrawable(new Texture("progressbarbg.png"));
//        progressBarStyle.knob = new TextureRegionDrawable(new Texture("progressbarknobbg.png"));
        progressBarStyle.knobBefore = new TextureRegionDrawable(new Texture("progressbarknobbg.png"));
        progressBarStyle.background.setMinWidth(20);
        progressBarStyle.background.setMinHeight(1f);
;
        progressBarStyle.knobBefore.setMinWidth(1f);
        progressBarStyle.knobBefore.setMinHeight(1f);

        // Create and return the progress at
        return new ProgressBar(0f, 1f, 0.01f, false, progressBarStyle);
    }

    public static Label createLabel(BitmapFont font) {
        Label.LabelStyle labelStyle = new Label.LabelStyle(font, Color.RED);
        return new Label("Loading...", labelStyle);
    }
}
