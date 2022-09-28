package game;

import gui_fields.GUI_Player;

/**
 * @author Henrik Zenkert
 * This is the player class. It contains the player's name and points. It also has the guiPlayer.
 * When the guiPlayer gets new points, the gui gets updated automatically.
 * To ensure that always happens, we only update the value of points through the setPoints method,
 * where both the player state and the guiPlayer gets updated with the value.
 */
class Player {
    private int points = 0;
    final private GUI_Player guiPlayer;

    Player(String name) {
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

    /**
     * We always set points through this method to make sure that the GUI gets updated when adding or removing points.
     * @param points - The current points the player has.
     */
    private void setPoints(int points) {
        this.points = points;
        guiPlayer.setBalance(this.points);
    }

    public void resetPoints() {
        setPoints(0);
    }
}
