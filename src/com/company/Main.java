package com.company;

public class Main {
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);

        Card player1Card1 = deck.drawCard();
        Card player1Card2 = deck.drawCard();

        Card player2Card1 = deck.drawCard();
        Card player2Card2 = deck.drawCard();

        for (int i = 0; i < 40; i++) {
            if (!deck.isEmpty()) {
                Card card = deck.drawCard();
                System.out.println(card);
            } else {
                System.out.println("The deck is empty!");
            }
        }
    }
}
