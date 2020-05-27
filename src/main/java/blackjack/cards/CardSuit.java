package blackjack.cards;

public enum CardSuit {
    DIAMONDS("♦"), // Бубны
    CLUBS("♣"),    // Трефы
    HEARTS("♥"),   // Черви
    SPADES("♠");   // Пики

    String symbol;

    CardSuit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

}
