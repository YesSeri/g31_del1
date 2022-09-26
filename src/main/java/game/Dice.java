import java.util.Random;

public class Dice{
	int throw_dice(){
		Random r = new Random();
		return r.nextInt(6) + 1;
	}
	public static void main(String[] args) {
		Dice d = new Dice();
		System.out.println(d.throw_dice());
	}
}