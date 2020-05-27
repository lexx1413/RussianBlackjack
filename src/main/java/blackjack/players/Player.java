package blackjack.players;

import blackjack.cards.Card;
import blackjack.cards.CardDeck;
import blackjack.cards.CardValue;

import java.util.Arrays;

public abstract class Player {
    String name = null;
    int wins = 0;
    int losses = 0;
    int ties = 0;
    int roundScore = 0;
    Card[] roundCards = null;
    int cardsCount = 0;
    CardDeck gameDeck;

    public Player(String name) {
        this.name = name;
        roundCards = new Card[36];
    }

    public String getName() {
        return name;
    }

    public void loseGame() {
        losses++;
    }

    public void winGame() {
        wins++;
    }

    public void tieGame() {
        ties++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }

    public void takeCard(Card card) {
        roundCards[cardsCount++] = card;
        updateScore();
    }

    public void resetCards() {
        cardsCount = 0;
        updateScore();
    }

    public abstract boolean isWillingToTakeCard();

    @Override
    public String toString() {
        return name;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public Card[] getRoundCards() {
        return Arrays.copyOfRange(roundCards, 0, cardsCount);
    }

    public void takeGameInformation(CardDeck deck) {
        gameDeck = deck;
    }

    private void updateScore() {
        roundScore = computeCardsScore(roundCards, cardsCount);
    }

    public static int computeCardScore(Card card) {
        int score = 0;
        switch (card.getValue()) {
            case N6:
                score = 6;
                break;
            case N7:
                score = 7;
                break;
            case N8:
                score = 8;
                break;
            case N9:
                score = 9;
                break;
            case N10:
                score = 10;
                break;
            case NJ:
                score = 2;
                break;
            case NQ:
                score = 3;
                break;
            case NK:
                score = 4;
                break;
            case NA:
                score = 1;
                break;
        }
        return score;
    }

    public static int computeCardsScore(Card[] cards, int cardsCount) {
        boolean acesFound = false;
        int score = 0;
        for (int i = 0; i < cardsCount; i++) {
            score += computeCardScore(cards[i]);
            if (cards[i].getValue() == CardValue.NA) {
                acesFound = true;
            }
        }
        if (score <= 11 && acesFound) {
            score += 10;
        }
        return score;
    }
}
