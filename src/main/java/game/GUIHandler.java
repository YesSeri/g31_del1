package game;

import gui_fields.GUI_Player;
import gui_main.GUI;

public class GUIHandler {
    /**
     * This is the GUIHandler class.
     */
    final private GUI gui = new GUI();


    /**
     * Adds the players to the gui.
     */
    void addPlayers(GUI_Player gui_player1, GUI_Player gui_player2) {
        gui.addPlayer(gui_player1);
        gui.addPlayer(gui_player2);
    }

    /**
     * Updates the the dice on the gui.
     */
    void setDice(int die1, int die2) {
        gui.setDice(die1, die2);
    }

    /**
     * Shows a message to the user.
     */
    void showTurnMessage(int current_round, String name, int die1, int die2, String message) {
        gui.showMessage("Turn " + current_round + "\n" + name + " got " + die1 + " and " + die2 + "!\n" + name + message);
    }
    void showMessage(String message) {
        gui.showMessage(message);
    }

    /**
     * Asks the user if they want to play again.
     * @return true if the user wants to play again.
     */
    boolean playAgain() {
        String answer = gui.getUserButtonPressed("Play again?", "Yes", "No");
        return answer.equals("Yes");
    }
}
