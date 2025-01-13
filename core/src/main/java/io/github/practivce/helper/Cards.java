package io.github.practivce.helper;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Cards {

    private String value; // 6 to 14 (6 to Ace)
    private TextureRegion texture; // Visual representation
    private String suit;

    public Cards(String suit, TextureAtlas.AtlasRegion texture, String value) {
        this.suit = suit;
        this.value = value;
        this.texture = texture;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }
}
