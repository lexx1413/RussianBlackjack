package com.company.players;

public class PlayerSimpleAI extends Player {
    public PlayerSimpleAI(String name) {
        super(name);
    }

    @Override
    public boolean isWillingToTakeCard() {
        if (roundScore <= 10) {
            return true;
        }
        int sumOfAllCards = 210 - roundScore;
        int countOfAllCards = 36 - cardsCount;
        return 21 - roundScore >= sumOfAllCards / countOfAllCards;
    }
}
