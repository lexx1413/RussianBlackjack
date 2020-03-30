package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Player[] players;
    CardDeck cardDeck;
    int roundNumber = 1;

    Game() {
        cardDeck = new CardDeck();
        cardDeck.shuffle();
    }

    public void initPlayers() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Enter number of players: ");
        }
        int playersCount = in.nextInt();
        in.nextLine(); // Чтобы при считывании Имени игрока не вывести пустую строку, оставшуюся от кол-ва игроков
        players = new Player[playersCount];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(in.nextLine());
        }
    }

    public void playRound() {
        cardDeck.reset();
        System.out.println(System.lineSeparator() + "New round " + roundNumber);
        for (Player player : players) {
            player.resetCards();
            System.out.println("  " + player.getName());
            player.takeCard(cardDeck.drawCard());
            player.takeCard(cardDeck.drawCard());
            System.out.println("  " + Arrays.toString(player.getRoundCards()) + " sum: " + player.getRoundScore());
            while (player.getRoundScore() < 21 && player.isWillingToTakeCard()) {
                player.takeCard(cardDeck.drawCard());
                System.out.println("  " + Arrays.toString(player.getRoundCards()) + " sum: " + player.getRoundScore());
            }
        }
        System.out.println();
        roundNumber++;
    }

    public void play() {
        while (winsCount() < 10) {
            playRound();
        }
    }

    private int winsCount() {
        int maxWins = 0;
        for (Player player : players) {
            if (maxWins < player.getWins()) {
                maxWins = player.getWins();
            }
        }
        return maxWins;
    }

    public Player[] getPlayers() {
        return players;
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }
}