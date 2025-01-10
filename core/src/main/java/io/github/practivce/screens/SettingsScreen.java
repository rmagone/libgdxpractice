package io.github.practivce.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.practivce.gameClass.Drop;
import io.github.practivce.ui.UIManager;

import static io.github.practivce.ui.UIHelpers.createLabel;


public class SettingsScreen implements Screen {
    final Drop game;
    private BitmapFont font;
    private Stage stage;
    private Table table;
    private Label easyText;
    private Label mediumText;
    private Label hardText;
    private CheckBox easyCheckBox;
    private CheckBox mediumCheckBox;
    private CheckBox hardCheckBox;

    public SettingsScreen(final Drop game) {
        UIManager uiManager = new UIManager(table, stage, game);
        this.game = game;
        stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);
        font = game.font;
        table = new Table();
        easyCheckBox = uiManager.createCheckBox(font, "Easy", Color.TEAL, () -> {
            easyCheckBox.setChecked(true);
            mediumCheckBox.setChecked(false);
            hardCheckBox.setChecked(false);
        });
        mediumCheckBox = uiManager.createCheckBox(font, "Medium", Color.TEAL, () -> {
            easyCheckBox.setChecked(false);
            mediumCheckBox.setChecked(true);
            hardCheckBox.setChecked(false);
        });
        hardCheckBox = uiManager.createCheckBox(font, "Hard", Color.TEAL, () -> {
            easyCheckBox.setChecked(false);
            mediumCheckBox.setChecked(false);
            hardCheckBox.setChecked(true);
        });
        easyCheckBox.setChecked(true);
        mediumCheckBox.setChecked(false);
        hardCheckBox.setChecked(false);
        table.setFillParent(true);
        table.align(Align.center);
        table.add(easyCheckBox).width(10).height(2).padBottom(1);
//        table.add(easyText).width(10).height(2).padBottom(1);
        table.row();
        table.add(mediumCheckBox).width(10).height(2).padBottom(1);
//        table.add(mediumText).width(10).height(2).padBottom(1);
        table.row();
        table.add(hardCheckBox).width(10).height(2).padBottom(1);
//        table.add(hardText).width(10).height(2).padBottom(1);

        stage.addActor(table);
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
}
