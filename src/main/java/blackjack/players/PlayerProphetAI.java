package blackjack.players;

import blackjack.cards.Card;

public class PlayerProphetAI extends Player {
    public PlayerProphetAI(String name) {
        super(name);
    }

    @Override
    public boolean isWillingToTakeCard() {
        Card[] gameCards = gameDeck.getAvailableCards();
        Card nextCard = gameCards[gameCards.length - 1];
        return roundScore + computeCardScore(nextCard) <= 21;
    }
}
