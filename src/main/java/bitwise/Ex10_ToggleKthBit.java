package bitwise;

public class Ex10_ToggleKthBit {
	public static void main(String args[]) {
		int num = Integer.valueOf(args[0]);
		int k = Integer.valueOf(args[1]);

		System.out.println("Toggle the " + k + "th bit of " +
			Integer.toBinaryString(num));

		num = num ^ (1 << (k - 1));
		System.out.println("Result " + num + " which is " + Integer.toBinaryString(num));

	}
}