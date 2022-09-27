package game;
import gui_main.GUI;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gui.setDice(3, 4);
    }
}