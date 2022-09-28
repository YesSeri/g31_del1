package game;

/**
 * This is the cup class. It contains the dice and the sum of the dice.
 */
public class Cup {

    private Die die1 = new Die();
    private Die die2 = new Die();

    public Cup(){

    }
    public Cup(int die1, int die2) {
        this.die1 = new Die(die1);
        this.die2 = new Die(die2);
    }



    /**
     * @return returns an array of size 2 containing the value of die 1 and die 2.
     */
    public int[] getDice() {
        return new int[]{die1.getFaceValue(), die2.getFaceValue()};
    }


    public boolean isEqualFaceValue() {
        return die1.getFaceValue() == die2.getFaceValue();
    }

    /**
     * throws the dice.
     */
    public void roll() {
        this.die1.throwDice();
        this.die2.throwDice();
    }

    /**
     * @return returns the sum of the dice.
     */
    public int getSum() {
        return this.die1.getFaceValue() + this.die2.getFaceValue();
    }
}
