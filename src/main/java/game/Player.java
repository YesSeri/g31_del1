package game;

import gui_fields.GUI_Player;

class Player {
    private int points = 0;
    final private String name;
    final private GUI_Player guiPlayer;

    Player(String name) {
        this.name = name;
        this.guiPlayer = new GUI_Player(name, 0);
    }

    public GUI_Player getGuiPlayer() {
        return guiPlayer;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        setPoints(this.points + points);
    }

    public String toString() {
        return this.name + "score: " + getPoints();
    }

    private void setPoints(int points) {
        this.points = points;
        guiPlayer.setBalance(this.points);
    }

    public void reset() {
        setPoints(0);
    }
}
