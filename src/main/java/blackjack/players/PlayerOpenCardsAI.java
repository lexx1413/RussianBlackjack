package blackjack.players;

import blackjack.cards.Card;

public class PlayerOpenCardsAI extends Player {
    public PlayerOpenCardsAI(String name) {
        super(name);
    }

    @Override
    public boolean isWillingToTakeCard() {
        if (roundScore <= 10) {
            return true;
        }
        Card[] gameCards = gameDeck.getAvailableCards();
        int sumOfAllCards = computeCardsScore(gameCards, gameCards.length);
        return 21 - roundScore >= sumOfAllCards / gameCards.length;
    }
}
