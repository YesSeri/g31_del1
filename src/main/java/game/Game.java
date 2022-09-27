package game;

public class Game {
    final private Player player1 = new Player("Player 1");
    final private Player player2 = new Player("Player 2");
    final private GUIHandler guiHandler = new GUIHandler();
    final private Cup cup = new Cup();
    private boolean player1Turn = true;
    private int current_turn = 0;

    public Game() {
        guiHandler.addPlayers(player1.getGuiPlayer(), player2.getGuiPlayer());
    }
//   The rules are:
//   1. The game is played with two players.
//   2. Each player has a turn to roll the dice.
//   3. The player rolls the dice and the score gets added to their sum.
//   4. First one to 40 points wins.


    public void start() {
        do {
            while (player1.getPoints() < 40 && player2.getPoints() < 40) {
                if (player1Turn) {
                    current_turn++;
                }
                cup.roll();
                Player current_player = player1Turn ? player1 : player2;
                guiHandler.showMessage("Turn " + current_turn + "\nRoll dice!");
                int[] dice = cup.get_dice();
                guiHandler.setDice(dice[0], dice[1]);
                current_player.addPoints(cup.getSum());
                player1Turn = !player1Turn;
            }
            if (player1.getPoints() > player2.getPoints()) {
                guiHandler.showMessage("Player 1 wins!");
            } else {
                guiHandler.showMessage("Player 2 wins!");
            }
            restart_game();
        } while (guiHandler.playAgain());

    }

    private void restart_game() {
        player1Turn = true;
        current_turn = 0;
        player1.reset();
        player2.reset();
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

//   OPTIONAL
//   1. Spilleren mister alle sine point hvis spilleren slår to 1'ere.
//   2. Spilleren får en ekstra tur hvis spilleren slår to ens.
//   3. Spilleren kan vinde spillet ved at slå to 6'ere, hvis spilleren også i forrige kast slog to 6'ere uanset om det er på ekstrakast eller i forrige tur.
//   4. Spilleren skal slå to ens for at vinde spillet, efter at man har opnået 40 point.
