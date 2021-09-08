package bitwise;

public class Ex08_TurnOffKthBitOnNumber {
	public static void main(String arg[]) {
		int num = Integer.valueOf(arg[0]);
		int k = Integer.valueOf(arg[1]);

		System.out.println("The number " + num + " in binary is " 
			+ Integer.toBinaryString(num));

		num = num & ~ (1 << (k - 1));
		System.out.println("After turn off the " + k + " digit, the number is "  +
			Integer.toBinaryString(num));

	}
}