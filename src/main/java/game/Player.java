package game;

import gui_fields.GUI_Player;

public class Player {
    private int points = 0;
    private String name;
    private GUI_Player gui_player;
    public Player(String name) {
        this.name = name;
         this.gui_player = new GUI_Player(name, points);
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
        gui_player.setBalance(this.points);
    }

    public String toString() {
        return this.name + "score: " + getPoints();
    }

    public String getName() {
        return name;
    }
}
