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
    private LastCup lastCup;

    Player(String name) {
        this.name = name;
        this.guiPlayer = new GUI_Player(name, 0);
        // We initiate it to an irrelevant value the first time.
        this.lastCup = new LastCup(1, 2);
    }

    boolean lastCupIsTwoSixes() {
        return lastCup.isTwoSixes();
    }

    void setLastCup(int die1, int die2) {
        this.lastCup = new LastCup(die1, die2);
    }

    private class LastCup extends Cup {

        LastCup(int die1, int die2) {
            super(die1, die2);
        }

        private boolean isTwoSixes() {
            return isEqualFaceValue() && get_dice()[0] == 6;
        }
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
