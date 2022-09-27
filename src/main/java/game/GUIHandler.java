package game;

import gui_fields.GUI_Player;
import gui_main.GUI;

public class GUIHandler {
    final private GUI gui = new GUI();

    void addPlayers(GUI_Player gui_player1, GUI_Player gui_player2) {
        gui.addPlayer(gui_player1);
        gui.addPlayer(gui_player2);
    }

    void setDice(int die1, int die2) {
//   setDice has 3 constructors, but we use this one. If the dice are always in the same place it is easier to find them.
//   setDice(int faceValue1, int rotation1, int x1, int y1, int faceValue2, int rotation2, int x2, int y2)
        int y = 120;
        gui.setDice(die1, 120, y, die2, 100, y);
    }

    void showMessage(String message) {
        gui.showMessage(message);
    }

    boolean playAgain() {
        String answer = gui.getUserButtonPressed("Play again?", "Yes", "No");
        return answer.equals("Yes");
    }
}
