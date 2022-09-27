package game;

import java.util.Random;

public class Cup {
    Random r = new Random();

    final private Die die1 = new Die();
    final private Die die2 = new Die();


    private class Die {
        private int faceValue;

        // We throw the dice and set the faceValue to the result when initializing the dice,
        // to avoid having a non-random or null pointer.
        public Die() {
            throw_dice();
        }

        public void throw_dice() {
            this.faceValue = r.nextInt(6) + 1;
        }

        public int getFaceValue() {
            return faceValue;
        }
    }


    public int[] get_dice() {
        return new int[]{die1.getFaceValue(), die2.getFaceValue()};
    }

    public boolean is_equal() {
        return die1.getFaceValue() == die2.getFaceValue();
    }

    public void roll_cup() {
        this.die1.throw_dice();
        this.die2.throw_dice();
    }

    public int getSum() {
        return this.die1.getFaceValue() + this.die2.getFaceValue();
    }
}
