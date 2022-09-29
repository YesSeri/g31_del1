package game;

public class Game {
    final private Player player1 = new Player("Player 1");
    final private Player player2 = new Player("Player 2");
    final private GUIHandler guiHandler = new GUIHandler();
    final private Cup cup = new Cup();
    private int currentRound = 1;
    private Player currentPlayer;
    final private int winLimit = 40;

    public Game() {
        guiHandler.addPlayers(player1.getGuiPlayer(), player2.getGuiPlayer());
        currentPlayer = player1;
    }
//   The rules are:
//   1. The game is played with two players.
//   2. Each player has a turn to roll the dice.
//   3. The player rolls the dice and the score gets added to their sum.
//   4. First one to 40 points wins.

    private void showTurnMessage(Cup cup, int[] dice, boolean rollAgain) {
        String name = currentPlayer.getName();
        Player otherPlayer = currentPlayer == player1 ? player2 : player1;
        String message = "Turn " + currentRound + "\n" + name + " got " + dice[0] + " and " + dice[1] + "!\n";

        if (rollAgain) {
            message += "You got two equal face values! " + currentPlayer.getName() + " gets another turn!";
        } else {
            message += "You got two different face values! " + otherPlayer.getName() + " gets the next turn!";
        }

        if ((rollAgain && currentPlayer.getPoints() >= winLimit)
                || (!rollAgain && otherPlayer.getPoints() >= winLimit)) {
            message += "\nNext roll is critical! " +
                    "\nYou are above the win limit of " + winLimit + " points. " +
                    "\nYou need to roll a pair, but it can't be a pair of 1's, since they reset your score." +
                    "\nAll other pairs will win you the game.";
        }

        guiHandler.showMessage(message);
    }

    public void start() {
        do {
            playGame();
        } while (guiHandler.playAgain());
    }

    private void playGame() {
        Player winner = null;
        while (true) {
            cup.roll();
            int[] dice = cup.getDice();
            guiHandler.setDice(dice[0], dice[1]);
            currentPlayer.addPoints(cup.getSum());

            boolean rollAgain = false;
            if (cup.isEqualFaceValue()) {
                // If the player rolls two equal face values, and dice are 1 and 1, they lose all their points.
                if (dice[0] == 1) {
                    currentPlayer.resetPoints();
                } else if (dice[0] == 6) {
                    // If the player rolls two equal face values, and dice are 6 and 6, and they did it last turn, they win.
                    if (currentPlayer.prevTurnTwoSixes()) {
                        winner = currentPlayer;
                    }
                }
                // If player is above winLimit when rolling two equal face values, and it is not one, they win.
                if (currentPlayer.getPoints() >= winLimit) {
                    winner = currentPlayer;
                }
                // If the player rolls two equal face values, they get another turn.
                rollAgain = true;
            }
            currentPlayer.setPrevCup(dice[0], dice[1]);
            // If we have a winner, we break the game loop and show the winner.
            if (winner != null) {
                break;
            }
            // If we have no winner we show the turn message and switch players.
            showTurnMessage(cup, dice, rollAgain);
            if (rollAgain) {
                continue;
            }
            switchPlayer();
        }
        showWinner();
        resetGame();
        // The gui asks the user if they want to play again, and returns a boolean.
    }


    private void showWinner() {
        guiHandler.showMessage(currentPlayer.getName() + " won!");
    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
            currentRound++;
        }

    }

    private void resetGame() {
        currentPlayer = player1;
        currentRound = 1;
        player1.resetPoints();
        player2.resetPoints();
    }
}

//   OPTIONAL
//   1. Spilleren mister alle sine point hvis spilleren slår to 1'ere.
//   2. Spilleren får en ekstra tur hvis spilleren slår to ens.
//   3. Spilleren kan vinde spillet ved at slå to 6'ere, hvis spilleren også i forrige kast slog to 6'ere uanset om det er på ekstrakast eller i forrige tur.
//   4. Spilleren skal slå to ens for at vinde spillet, efter at man har opnået 40 point.