package blackjack;

public class GameConsoleApplication {
    public static void main(String[] args) {
        Game game = new Game();
        game.initPlayers();
        game.play();
        game.printLeaderboard();
    }
}

