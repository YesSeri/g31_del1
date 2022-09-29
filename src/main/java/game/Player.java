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
    final private String name;
    final private GUI_Player guiPlayer;
    private Cup prevCup;

    Player(String name) {
        this.name = name;
        this.guiPlayer = new GUI_Player(name, 0);
        // We initiate it to an irrelevant value the first time.
        this.prevCup = new Cup(1, 2);
    }

    boolean prevTurnTwoSixes() {
        return prevCup.getSum() == 12;
    }

    // We do like this to ensure that the pointer is not to the same cup as the one the game uses.
    void setPrevCup(int die1, int die2) {
        this.prevCup = new Cup(die1, die2);
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
     *
     * @param points - The current points the player has.
     */
    private void setPoints(int points) {
        this.points = points;
        guiPlayer.setBalance(this.points);
    }

    public void resetPoints() {
        setPoints(0);
    }

    public String getName() {
        return name;
    }
}
