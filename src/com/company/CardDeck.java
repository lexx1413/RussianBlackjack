package com.company;

import java.util.Arrays;

public class CardDeck {
    Card[] deck = null;
    int lastCardPosition = 0;

    CardDeck() {
        deck = new Card[36];
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck[lastCardPosition++] = new Card(suit, value);
            }
        }
        lastCardPosition--;
    }

    @Override
    public String toString() {
        return "CardDeck{" +
                "deck=" + Arrays.toString(deck) +
                ", lastCardPosition=" + lastCardPosition +
                '}';
    }

    // TODO: change to Fisher-Yates algorithms
    public void shuffle() {
        int deckSize = lastCardPosition + 1;
        for (int i = 0; i < 3 * deckSize; i++) {
            int a = (int) (Math.random() * deckSize);
            int b = (int) (Math.random() * deckSize);
            Card tmp = deck[a];
            deck[a] = deck[b];
            deck[b] = tmp;
        }
    }

    public boolean isEmpty() {
        return lastCardPosition < 0;
    }

    public boolean getSize() {
        return lastCardPosition + 1;
    }

    public Card drawCard() {
        return deck[lastCardPosition--];
    }
}
