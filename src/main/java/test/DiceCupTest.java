package test;

import game.Dice;

public class DiceCupTest {
    // 2 dices * 1000 throws = 2000 throws
    // 2000 throws / 6 sides = 333 times should every value occur.
    // 15 % acceptable variation means 333 * 15 % = 50. 333 - 50 = 283, 333 + 50 = 383.
    public boolean testDice() {
        Dice dice_1 = new Dice();
        Dice dice_2 = new Dice();

        int[] dice_numbers = new int[6];
        for (int i = 0; i < 1000; i++) {

            dice_numbers[dice_1.throw_dice() - 1] += 1;
            dice_numbers[dice_2.throw_dice() - 1] += 1;
        }

        System.out.println("Number of times each side occurred:\n" + "1:" + dice_numbers[0] + "\n2:" + dice_numbers[1] + "\n3:" + dice_numbers[2] + "\n4:" + dice_numbers[3] + "\n5:" + dice_numbers[4] + "\n6:" + dice_numbers[5]);
        for (int side: dice_numbers) {
            if (side < 283 || side > 383) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DiceCupTest dct = new DiceCupTest();
        boolean passed_test = dct.testDice();
        if (passed_test) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}