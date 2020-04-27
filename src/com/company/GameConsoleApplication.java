package com.company;

import java.util.Arrays;

public class GameConsoleApplication {
    public static void main(String[] args) {
        Game game = new Game();
        game.initPlayers();
        System.out.println(Arrays.toString(game.getPlayers()));
        game.play();
    }
}

