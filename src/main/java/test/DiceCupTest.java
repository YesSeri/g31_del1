package test;

import game.Dice;

public class DiceCupTest {
    // 2 dices * 1000 throws = 2000 throws
    // 2000 throws / 6 sides = 333 times should every value occur.
    // 15 % acceptable variation means 333 * 15 % = 50. 333 - 50 = 283, 333 + 50 = 383.
    public boolean testDice() {
        Dice dice_1 = new Dice();
        Dice dice_2 = new Dice();

        // From testing, I have concluded that 15 % is an acceptable variation rate for the die.
        double acceptable_variation = 0.15;

        // dice_numbers[0] is dice face value 1, dice_numbers[1] is dice face value 2, etc.
        // We add one each time we get the value mentioned. So if we get 3 and 5 as dice value, we add 1 to dice_numbers[2] and dice_numbers[4].
        // The array will contain how many times each value has occurred.
        int[] dice_numbers = new int[6];
        // This variable will be used to check how many times the face value of the dice is the same.
        // The chance of that happening is 1/6, so we expect it to happen 1000/6 = 166.667 times.
        int equal_face_value = 0;
        for (int i = 0; i < 1000; i++) {
            int dice_value_1 = dice_1.throw_dice();
            int dice_value_2 = dice_2.throw_dice();
            // Counts how many times.
            dice_numbers[dice_value_1 - 1] += 1;
            dice_numbers[dice_value_2 - 1] += 1;
            if (dice_value_1 == dice_value_2) {
                equal_face_value += 1;
            }
        }

        System.out.println("Number of times each side occurred:\n" + "1:" + dice_numbers[0] + "\n2:" + dice_numbers[1] + "\n3:" + dice_numbers[2] + "\n4:" + dice_numbers[3] + "\n5:" + dice_numbers[4] + "\n6:" + dice_numbers[5]);
        // The average value of a die is 3.5. 3.5 * 2. We sum the total value of the dices and divide by 1000 to get the average value of the dices per roll.
        int sum = 0;
        for (int i = 0; i < dice_numbers.length; i++) {
            int times = dice_numbers[i];
            sum += times * (i + 1);
        }
        System.out.println("Average: " + sum / 1000.0);
        for (int side : dice_numbers) {
            if (side < 333 * (1 - acceptable_variation) || side > 333 * (1 + acceptable_variation)) {
                return false;
            }
        }
        if (sum / 1000.0 < 6.7 || sum / 1000.0 > 7.3) {
            return false;
        }
        System.out.println("Number of times two equal face values occurred: " + equal_face_value);
        if (equal_face_value < 166.667 * (1 - acceptable_variation) || equal_face_value > 166.667 * (1 + acceptable_variation)) {
            return false;
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