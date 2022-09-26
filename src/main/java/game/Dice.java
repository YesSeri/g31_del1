package game;
import java.util.Random;

public class Dice{
	public int throw_dice(){
		Random r = new Random();
		return r.nextInt(6) + 1;
	}
	public static void main(String[] args) {
		Dice d = new Dice();
		System.out.println(d.throw_dice());
	}
}