public class DiceCupTest {
	public boolean testDice() {
		Dice dice_1 = new Dice();
		Dice dice_2 = new Dice();
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			int x = dice_1.throw_dice();
			int y = dice_2.throw_dice();
			sum += x + y;
		}
		double average = sum / 1000.0;
		System.out.println(average);
		if (average > 6.7 && average < 7.3) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DiceCupTest dct = new DiceCupTest();
		boolean passed_test = dct.testDice();
		if (passed_test) {
			System.out.println("Test passed");
		} else {
			throw new RuntimeException("Test failed");
		}
	}
}