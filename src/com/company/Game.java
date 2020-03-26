package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Player[] players;
    CardDeck cardDeck;

    Game() {
        cardDeck = new CardDeck();
        cardDeck.shuffle();
    }

    public void initPlayers() {
        Scanner in = new Scanner(System.in);
        int playersCount = in.nextInt();
        in.nextLine();
        players = new Player[playersCount];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(in.nextLine());
        }
    }

    public void playRound() {
        for (Player player : players) {
            player.takeCard(cardDeck.drawCard());
            player.takeCard(cardDeck.drawCard());
            System.out.println(Arrays.toString(player.getRoundCards()));
        }
    }

    public void play() {
        playRound();
    }

    public Player[] getPlayers() {
        return players;
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }
}