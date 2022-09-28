package test;

import game.Cup;

public class DiceTest {

    Cup cup = new Cup();

    // Test the dice 1000 times and see if they are within normal parameters.
    // Test 1
    // 2 dices * 1000 throws = 2000 throws
    // 2000 throws / 6 sides = 333 times should every value occur.
    // 15 % acceptable variation means 333 * 15 % = 50. 333 - 50 = 283, 333 + 50 = 383.


    private boolean testDistributionFaceValues() {
        double acceptableVariation = 0.15;
        System.out.println("=====================================");
        System.out.println("testDistributionFaceValues() running.");

        // diceNumbers[0] is dice face value 1, diceNumbers[1] is dice face value 2, etc.
        // We add one each time we get the value mentioned.
        // So if we get 3 and 5 as dice value, we add 1 to diceNumbers[2] and diceNumbers[4].
        // The array will contain how many times each value has occurred.

        int[] diceNumbers = new int[6];

        for (int i = 0; i < 1000; i++) {
            cup.roll();
            int[] dice = cup.getDice();
            int die1 = dice[0];
            int die2 = dice[1];
            diceNumbers[die1 - 1] += 1;
            diceNumbers[die2 - 1] += 1;
        }

        System.out.println("Number of times each side occurred:\n" + "1:" + diceNumbers[0] + "\t2:" + diceNumbers[1] + "\t3:" + diceNumbers[2] + "\t4:" + diceNumbers[3] + "\t5:" + diceNumbers[4] + "\t6:" + diceNumbers[5]);
        for (int side : diceNumbers) {
            if (side < 333 * (1 - acceptableVariation) || side > 333 * (1 + acceptableVariation)) {
                System.out.println("Distribution of dice face values is not within acceptable parameters. testDistributionFaceValues() failed.");
                return false;
            }
        }
        System.out.println("Test succeeded");
        return true;
    }

    // Test 2
    // The average value of a die is 3.5. 3.5 * 2 = 7. We sum the total value of the dices and divide by 1000 to get the average value of the dices per roll.
    // The result should be approx. 7.
    private boolean testAverageFaceValues() {
        System.out.println("=====================================");
        System.out.println("testAverageFaceValues() running.");
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            cup.roll();
            sum += cup.getSum();
        }

        System.out.println("Average: " + sum / 1000.0);
        if (sum / 1000.0 < 6.7 || sum / 1000.0 > 7.3) {
            System.out.println("The average value of the dice is not within acceptable parameters. testAverageFaceValues() failed.");
            return false;
        }
        System.out.println("Test succeeded");
        return true;
    }

    // Test 3
    // The chance that the dice have the same value is 1/6. So we expect it to happen 1000/6 = 166.667 times.
    private boolean testEqualFaceValue() {
        System.out.println("=====================================");
        System.out.println("testEqualFaceValue() running.");
        int equal = 0;

        for (int i = 0; i < 1000; i++) {
            cup.roll();
            if (cup.isEqualFaceValue()) {
                equal++;
            }
        }

        System.out.println("Equal: " + equal);
        double acceptableVariation = 0.05;
        if (equal < 166.667 * (1 - acceptableVariation) || equal > 166.667 * (1 + acceptableVariation)) {
            System.out.println("Distribution of equal face values is not within acceptable parameters. testEqualFaceValues() failed.");
            return false;
        }
        System.out.println("Test succeeded");
        return true;
    }

    private boolean runDiceTests() {
        boolean test1 = testEqualFaceValue();
        boolean test2 = testAverageFaceValues();
        boolean test3 = testDistributionFaceValues();
        return test1 && test2 && test3;
    }

    public static void main(String[] args) {
        DiceTest diceTester = new DiceTest();
        boolean testResult = diceTester.runDiceTests();
        System.out.println("=====================================");
        if (testResult) {
            System.out.println("Tests passed.");
        } else {
            System.out.println("Tests failed.");
        }
    }
}
