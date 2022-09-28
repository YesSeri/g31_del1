package test;

import game.Cup;

public class DiceTest {

    double acceptable_variation = 0.15;

    // Test the dice 1000 times and see if they are within normal parameters.
    // Test 1
    // 2 dices * 1000 throws = 2000 throws
    // 2000 throws / 6 sides = 333 times should every value occur.
    // 15 % acceptable variation means 333 * 15 % = 50. 333 - 50 = 283, 333 + 50 = 383.


    private boolean test_distribution_face_values(Cup cup) {

        // dice_numbers[0] is dice face value 1, dice_numbers[1] is dice face value 2, etc.
        // We add one each time we get the value mentioned.
        // So if we get 3 and 5 as dice value, we add 1 to dice_numbers[2] and dice_numbers[4].
        // The array will contain how many times each value has occurred.

        int[] dice_numbers = new int[6];

        for (int i = 0; i < 1000; i++) {
            cup.roll();
            int[] dice = cup.get_dice();
            int die1_val = dice[0];
            int die2_val = dice[1];
            dice_numbers[die1_val - 1] += 1;
            dice_numbers[die2_val - 1] += 1;
        }

        System.out.println("Number of times each side occurred:\n" + "1:" + dice_numbers[0] + "\n2:" + dice_numbers[1] + "\n3:" + dice_numbers[2] + "\n4:" + dice_numbers[3] + "\n5:" + dice_numbers[4] + "\n6:" + dice_numbers[5]);
        for (int side : dice_numbers) {
            if (side < 333 * (1 - acceptable_variation) || side > 333 * (1 + acceptable_variation)) {
                return false;
            }
        }
        return true;
    }

    // Test 2
    // The average value of a die is 3.5. 3.5 * 2 = 7. We sum the total value of the dices and divide by 1000 to get the average value of the dices per roll.
    // The result should be approx. 7.
    private boolean test_average_face_values(Cup cup) {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            cup.roll();
            sum += cup.getSum();
        }

        System.out.println("Average: " + sum / 1000.0);
        if (sum / 1000.0 < 6.7 || sum / 1000.0 > 7.3) {
            return false;
        }
        return true;
    }

    // Test 3
    // The chance that the dice have the same value is 1/6. So we expect it to happen 1000/6 = 166.667 times.
    private boolean test_equal_face_value(Cup cup) {
        int equal = 0;

        for (int i = 0; i < 1000; i++) {
            cup.roll();
            if (cup.isEqualFaceValue()) {
                equal++;
            }
        }

        System.out.println("Equal: " + equal);
        if (equal < 166.667 * (1 - acceptable_variation) || equal > 166.667 * (1 + acceptable_variation)) {
            return false;
        }
        return true;
    }

    private boolean test_dice() {
        Cup cup = new Cup();
        return test_average_face_values(cup) && test_distribution_face_values(cup) && test_equal_face_value(cup);
    }

    public static void main(String[] args) {
        DiceTest dt = new DiceTest();
        boolean test_result = dt.test_dice();
        if (test_result) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}
