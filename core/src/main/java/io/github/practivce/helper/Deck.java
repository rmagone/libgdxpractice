package io.github.practivce.helper;

import com.badlogic.gdx.utils.Array;

public class Deck {
    private Array<Cards> cards;

    public Deck() {
        cards = new Array<>();

    }

    public void shuffle() {
        cards.shuffle();
    }

    public Cards draw() {
        if (!cards.isEmpty()) {
            return cards.pop();
        }
        return null;
    }

    public Array<Cards> getRemainingCards() {
        return cards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
