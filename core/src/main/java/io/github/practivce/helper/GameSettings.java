package io.github.practivce.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GameSettings {
    private static final String PREFS_NAME = "game_settings";
    private Preferences preferences;

    public GameSettings() {
        preferences = Gdx.app.getPreferences(PREFS_NAME);
    }

    public void setDifficulty(int difficulty) {
        preferences.putInteger("difficulty", difficulty);
        preferences.flush();
    }
    public int getDifficulty() {
        return preferences.getInteger("difficulty", 1);
    }
}
