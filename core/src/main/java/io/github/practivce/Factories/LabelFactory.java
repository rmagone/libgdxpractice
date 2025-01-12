package io.github.practivce.Factories;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class LabelFactory {
    private final BitmapFont font;

    public LabelFactory(BitmapFont font) {
        this.font = font;
    }

    public Label createLabel(String text, Color color) {
        Label.LabelStyle style = new Label.LabelStyle(font, color);
        return new Label(text, style);
    }

    public Label createSettingsLabel(String text) {
        Label.LabelStyle style = new Label.LabelStyle(font, Color.WHITE);
        return new Label(text, style);
    }

    public Label createLoadingScreenLabel(String text) {
        Label.LabelStyle style = new Label.LabelStyle(font, Color.RED);
        return new Label(text, style);
    }

}
