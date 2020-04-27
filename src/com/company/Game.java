package com.company;

import java.util.Arrays;
import java.util.Scanner;

enum EndOfRoundPlayerStatus {
    WON,
    LOST,
    TIED
}

public class Game {
    Player[] players;
    CardDeck cardDeck;
    EndOfRoundPlayerStatus[] lastRoundPlayersStatuses;

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
        players = new Player[playersCount];
        in.nextLine();
        String playerName = in.nextLine().strip();
        if (!playerName.equals("")) {
            players[0] = new PlayerHuman(playerName);
        }
        int i = 1;
        while (i < players.length) {
            players[i++] = new PlayerAI("bot" + (i - 1));
        }
    }

    public void playRound() {
        cardDeck.reset();
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
        updateRoundResults();
    }

    private void printRoundResultsTable() {
        // Взять players[i] и взять lastRoundPlayersStatuses[i]
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + " - " + lastRoundPlayersStatuses[i]);
        }

    }

    public void play() {
        int roundNumber = 1;
        while (winsCount() < 10) {
            System.out.println(System.lineSeparator() + "New round " + roundNumber + System.lineSeparator());
            playRound();
            System.out.println();
            printRoundResultsTable();
            roundNumber++;
        }
    }

    private void updateRoundResults() {
        lastRoundPlayersStatuses = getRoundResults();
        for (int i = 0; i < players.length; i++) {
            switch (lastRoundPlayersStatuses[i]) {
                case WON:
                    players[i].winGame();
                    break;
                case TIED:
                    players[i].tieGame();
                    break;
                case LOST:
                    players[i].loseGame();
                    break;
            }
        }
    }

    private EndOfRoundPlayerStatus[] getRoundResults() {
        EndOfRoundPlayerStatus[] statuses = new EndOfRoundPlayerStatus[players.length];
        int max = 0;
        int maxCount = 1;
        for (Player player : players) {
            if (player.getRoundScore() > max && player.getRoundScore() <= 21) {
                max = player.getRoundScore();
                maxCount = 1;
            } else if (player.getRoundScore() == max) {
                maxCount++;
            }
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i].getRoundScore() == max && maxCount > 1) {
                statuses[i] = EndOfRoundPlayerStatus.TIED;
            } else if (players[i].getRoundScore() == max && maxCount == 1) {
                statuses[i] = EndOfRoundPlayerStatus.WON;
            } else {
                statuses[i] = EndOfRoundPlayerStatus.LOST;
            }
        }
        return statuses;
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