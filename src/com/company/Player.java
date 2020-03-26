package com.company;

import java.util.Arrays;

public class Player {
    String name = null;
    int wins = 0;
    int loses = 0;
    int ties = 0;
    int roundScore = 0;
    Card[] roundCards = null;
    int lastCardPosition = 0;

    Player(String name) {
        this.name = name;
        roundCards = new Card[36];
    }

    public void loseGame() {
        loses++;
    }

    public void winGame() {
        wins++;
    }

    public void tieGame() {
        ties++;
    }

    public void takeCard(Card card) {
        roundCards[lastCardPosition++] = card;
        updateScore();
    }

    @Override
    public String toString() {
        return name;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public Card[] getRoundCards() {
        return Arrays.copyOfRange(roundCards, 0, lastCardPosition + 1);
    }

    private void updateScore() {
        roundScore = 0;
        boolean acesFound = false;
        for (int i = 0; i <= lastCardPosition; i++) {
            switch (roundCards[i].getValue()) {
                case N6:
                    roundScore += 6;
                    break;
                case N7:
                    roundScore += 7;
                    break;
                case N8:
                    roundScore += 8;
                    break;
                case N9:
                    roundScore += 9;
                    break;
                case N10:
                    roundScore += 10;
                    break;
                case NJ:
                    roundScore += 2;
                    break;
                case NQ:
                    roundScore += 3;
                    break;
                case NK:
                    roundScore += 4;
                    break;
                case NA:
                    roundScore += 1;
                    acesFound = true;
                    break;
            }
        }
        if (roundScore <= 11 && acesFound) {
            roundScore += 10;
        }
    }
}