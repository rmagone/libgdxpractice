package io.github.practivce.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import io.github.practivce.gameClass.Drop;
import io.github.practivce.helper.Cards;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class GameScreen implements Screen {
    final Drop game;
    private Stage stage;
    TextureAtlas club, heart, diamonds, spade;

    public GameScreen(final Drop game) {
        this.game = game;
        this.stage = new Stage(game.viewport);
        loadAllCards();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
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

    private void loadAllCards() {
        Array<Cards> list = new Array<>();
        club = game.manager.get("Clubs/clubs.atlas", TextureAtlas.class);
        club.getRegions().forEach(region -> {
            list.add(new Cards("club", club.findRegion(region.name), region.name));
        });

        heart = game.manager.get("Hearts/hearts.atlas", TextureAtlas.class);
        heart.getRegions().forEach(region -> {
            list.add(new Cards("hearts", heart.findRegion(region.name), region.name));
        });
        diamonds = game.manager.get("Diamonds/diamonds.atlas", TextureAtlas.class);
        diamonds.getRegions().forEach(region -> {
            list.add(new Cards("diamonds", diamonds.findRegion(region.name), region.name));
        });
        spade = game.manager.get("Spades/spades.atlas", TextureAtlas.class);
        spade.getRegions().forEach(region -> {
            list.add(new Cards("spade", spade.findRegion(region.name), region.name));
        });
        list.shuffle();
    System.out.println(list);

    }

    private void computerAttacks() {

    }

    private void computerDefends() {

    }

    private void playerAttacks() {

    }

    private void playerDefends() {

    }

    private void decideWhoStarts() {
        //TODO: Implement this method
        //get lowest trump  card from computer
        //get lowest trump card from player
        //compare the two cards
        //notify who starts
        //if player show label
        //if computer start then execute computer turn
    }
}
