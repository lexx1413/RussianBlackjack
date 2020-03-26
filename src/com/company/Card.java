package com.company;

public class Card {
    CardSuit suit;
    CardValue value;

    @Override
    public String toString() {
        return "(" +  suit + ":" + value + ')';
    }

    public Card(CardSuit s, CardValue v) {
        suit = s;
        value = v;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
}
