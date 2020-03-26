package com.company;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class CardDeck {
    Card[] deck;
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

    // Fisher-Yates algorithm
    public void shuffle() {
        int deckSize = lastCardPosition + 1;
        for (int i = deckSize - 1; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(i + 1);
            Card tmp = deck[i];
            deck[i] = deck[j];
            deck[j] = tmp;
        }
    }

    public boolean isEmpty() {
        return lastCardPosition < 0;
    }

    public int getSize() {
        return lastCardPosition + 1;
    }

    public Card drawCard() {
        return deck[lastCardPosition--];
    }
}
