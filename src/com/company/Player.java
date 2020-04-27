package com.company;

public interface Player {
    String getName();

    void loseGame();

    void winGame();

    void tieGame();

    int getWins();

    void takeCard(Card card);

    void resetCards();

    boolean isWillingToTakeCard();

    @Override
    String toString();

    int getRoundScore();

    Card[] getRoundCards();
}
