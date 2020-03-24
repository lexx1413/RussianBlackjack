package com.company;

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

    private void updateScore() {
        roundScore = 0;
        boolean acesFound = false;
        for (int i = 0; i <= lastCardPosition; i++) {
            switch (roundCards[i]) {
                case CardValue.N6:
                    roundScore += 6;
                    break;
                case CardValue.N7:
                    roundScore += 7;
                    break;
                case CardValue.N8:
                    roundScore += 8;
                    break;
                case CardValue.N9:
                    roundScore += 9;
                    break;
                case CardValue.N10:
                    roundScore += 10;
                    break;
                case CardValue.NJ:
                    roundScore += 2;
                    break;
                case CardValue.NQ:
                    roundScore += 3;
                    break;
                case CardValue.NK:
                    roundScore += 4;
                    break;
                case CardValue.NA:
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