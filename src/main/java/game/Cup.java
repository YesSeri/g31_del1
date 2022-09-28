package game;

import java.util.Random;

/**
 * This is the cup class. It contains the dice and the sum of the dice.
 */
public class Cup {
    Random r = new Random();

    private Die die1;
    private Die die2;

    public Cup() {
        this.die1 = new Die();
        this.die2 = new Die();
    }

    public Cup(int die1, int die2) {
        this.die1 = new Die(die1);
        this.die2 = new Die(die2);
    }


    /**
     * Rolls the dice and updates the sum.
     */
    private class Die {
        private int faceValue;

        /**
         * We throw the dice and set the faceValue to the result in the constructor,
         * to avoid having a non-random value or null pointer.
         */
        public Die() {
            throw_dice();
        }

        public Die(int faceValue) {
            this.faceValue = faceValue;
        }

        public void throw_dice() {
            this.faceValue = r.nextInt(6) + 1;
//            this.faceValue = 6;
        }

        public int getFaceValue() {
            return faceValue;
        }
    }

    /**
     * @return returns an array of size 2 containing the value of die 1 and die 2.
     */
    public int[] get_dice() {
        return new int[]{die1.getFaceValue(), die2.getFaceValue()};
    }


    public boolean isEqualFaceValue() {
        return die1.getFaceValue() == die2.getFaceValue();
    }

    /**
     * throws the dice.
     */
    public void roll() {
        this.die1.throw_dice();
        this.die2.throw_dice();
    }

    /**
     * @return returns the sum of the dice.
     */
    public int getSum() {
        return this.die1.getFaceValue() + this.die2.getFaceValue();
    }
}
