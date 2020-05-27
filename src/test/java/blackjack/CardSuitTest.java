package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardSuitTest {

    @Test
    @DisplayName("All four card suits should be available on CardSuit by name")
    void allCardSuitsAreAvailable() {
        assertEquals(CardSuit.valueOf("DIAMONDS"), CardSuit.DIAMONDS);
        assertEquals(CardSuit.valueOf("CLUBS"), CardSuit.CLUBS);
        assertEquals(CardSuit.valueOf("HEARTS"), CardSuit.HEARTS);
        assertEquals(CardSuit.valueOf("SPADES"), CardSuit.SPADES);
    }

    @Test
    @DisplayName("All four card suits should have corresponding symbols")
    void allCardsSuitsShouldHaveSymbols() {
        assertEquals(CardSuit.DIAMONDS.getSymbol(), "♦");
        assertEquals(CardSuit.CLUBS.getSymbol(), "♣");
        assertEquals(CardSuit.HEARTS.getSymbol(), "♥");
        assertEquals(CardSuit.SPADES.getSymbol(), "♠");
    }
}