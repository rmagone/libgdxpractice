package io.github.practivce.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.practivce.gameClass.Drop;
import io.github.practivce.helper.GameSettings;
import io.github.practivce.ui.UIManager;

import static io.github.practivce.ui.UIHelpers.createLabel;


public class SettingsScreen implements Screen {
    final Drop game;
    private BitmapFont font;
    private Stage stage;
    private CheckBox easyCheckBox;
    private CheckBox mediumCheckBox;
    private CheckBox hardCheckBox;
    UIManager uiManager;
    private int tempDifficulty;
    private GameSettings gameSettings;

    public SettingsScreen(final Drop game) {
        gameSettings = new GameSettings();
        uiManager = new UIManager();
        this.game = game;
        stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);
        font = game.font;
        stage.addActor(setupDifficultytable());
        setDefaultDifficulty(gameSettings);
        stage.addActor(setSoundTable());
        stage.addActor(setNavigationTable());
//        stage.setDebugAll(true);
    }


    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
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

    public Table setNavigationTable() {
        Table navigationTable = new Table();
        navigationTable.setSize(8, 2);
        navigationTable.setPosition(6,0);
        navigationTable.add(setupBackButton()).width(3).height(2).padRight(1);
        navigationTable.add(setupApplyButton()).width(3).height(2);
        return navigationTable;
    }

    public Table setSoundTable() {
        Label lblSound = createLabel(font, "Sound settings", Color.TEAL);
        Table soundTable = new Table();
        soundTable.setSize(7, 4);
        soundTable.setPosition(13, 10);
        soundTable.add(lblSound).width(7).height(2);

        return soundTable;
    }

    public Table setupDifficultytable() {
        Table difficultyTable = new Table();
        Label lblDifficulty = createLabel(font, "Difficulty", Color.TEAL);
        difficultyTable.setSize(7, 10);
        difficultyTable.setPosition(0, 10);
        difficultyTable.add(lblDifficulty).width(7).height(2);
        difficultyTable.row();
        difficultyTable.add(setupEasyCheckBox()).width(7).height(2).padBottom(1f);
        difficultyTable.row();
        difficultyTable.add(setupMediumCheckBox()).width(7).height(2).padBottom(1f);
        difficultyTable.row();
        difficultyTable.add(setupHardCheckBox()).width(7).height(2);

        return difficultyTable;
    }

    private CheckBox setupEasyCheckBox() {
        easyCheckBox = uiManager.createCheckBox(font, "Easy", Color.TEAL, () -> {
            easyCheckBox.setChecked(true);
            mediumCheckBox.setChecked(false);
            hardCheckBox.setChecked(false);
            tempDifficulty = 1;

        });
        easyCheckBox.align(8);
        return easyCheckBox;

    }

    private CheckBox setupMediumCheckBox() {
        mediumCheckBox = uiManager.createCheckBox(font, "Medium", Color.TEAL, () -> {
            easyCheckBox.setChecked(false);
            mediumCheckBox.setChecked(true);
            hardCheckBox.setChecked(false);
            tempDifficulty = 2;
        });
        mediumCheckBox.align(8);
        return mediumCheckBox;
    }

    private CheckBox setupHardCheckBox() {
        hardCheckBox = uiManager.createCheckBox(font, "Hard", Color.TEAL, () -> {
            easyCheckBox.setChecked(false);
            mediumCheckBox.setChecked(false);
            hardCheckBox.setChecked(true);
            tempDifficulty = 3;
        });
        hardCheckBox.align(8);
        return hardCheckBox;
    }

    private TextButton setupBackButton() {
        return uiManager.createButton(new Texture("buttonbg.png"), game.font, "Back", () -> {
            game.setScreen(new MainMenuScreen(game));
            stage.dispose();
        });
    }

    private TextButton setupApplyButton() {
        return uiManager.createButton(new Texture("buttonbg.png"), game.font, "Apply", () -> {
            game.setScreen(new MainMenuScreen(game));
            gameSettings.setDifficulty(tempDifficulty);
            stage.dispose();
        });
    }

    private void setDefaultDifficulty(GameSettings gameSettings) {
        switch (gameSettings.getDifficulty()) {
            case 1:
                tempDifficulty = 1;
                easyCheckBox.setChecked(true);
                break;
            case 2:
                tempDifficulty = 2;
                mediumCheckBox.setChecked(true);
                break;
            case 3:
                tempDifficulty = 3;
                hardCheckBox.setChecked(true);
                break;
            default:
                tempDifficulty = 1;
                easyCheckBox.setChecked(true);
        }
    }

}
