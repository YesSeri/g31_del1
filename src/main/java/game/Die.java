package game;

import java.util.Random;

public class Die {
    private int faceValue;
    Random r = new Random();

    /**
     * We throw the dice and set the faceValue to the result in the constructor,
     * to avoid having a non-random value or null pointer.
     */
    public Die() {
        throwDice();
    }

    public Die(int faceValue) {
        this.faceValue = faceValue;
    }

    public void throwDice() {
        this.faceValue = r.nextInt(6) + 1;
//            this.faceValue = 6;
    }

    public int getFaceValue() {
        return faceValue;

    }
}
