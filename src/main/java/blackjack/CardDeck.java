package blackjack;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class CardDeck {
    Card[] deck;
    int cardsCount = 0;

    CardDeck() {
        deck = new Card[36];
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck[cardsCount++] = new Card(suit, value);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(deck, 0, cardsCount)) + " (" + cardsCount + " cards)";
    }

    // Fisher-Yates algorithm
    public void shuffle() {
        for (int i = cardsCount - 1; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(i + 1);
            Card tmp = deck[i];
            deck[i] = deck[j];
            deck[j] = tmp;
        }
    }

    public void reset() {
        cardsCount = 36;
        this.shuffle();
    }

    public boolean isEmpty() {
        return cardsCount == 0;
    }

    public int getSize() {
        return cardsCount;
    }

    public Card drawCard() {
        return deck[--cardsCount];
    }

    public Card[] getAvailableCards() {
        return Arrays.copyOf(deck, cardsCount);
    }


}
