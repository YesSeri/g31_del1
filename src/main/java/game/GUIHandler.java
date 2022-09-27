package game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class GUIHandler {
    private GUI gui = new GUI();
    void add_players(Player player1, Player player2) {
        GUI_Player gui_player1 = new GUI_Player(player1.getName(), 0, new GUI_Car());
        GUI_Player gui_player2 = new GUI_Player(player2.getName(), 0, new GUI_Car());
        gui.addPlayer(gui_player1);
        gui.addPlayer(gui_player2);

    }
    void prompt_roll(){
        gui.getUserSelection("Roll Dice","Roll");
    }
}
