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

    public void shuffle() {
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 36);
            int b = (int) (Math.random() * 36);
            Card tmp = deck[a];
            deck[a] = deck[b];
            deck[b] = tmp;
        }
    }

    public boolean isEmpty() {
        return lastCardPosition < 0;
    }

    public Card drawCard() {
        return deck[lastCardPosition--];
    }
}
