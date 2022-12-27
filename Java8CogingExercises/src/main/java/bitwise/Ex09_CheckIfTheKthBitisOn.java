package bitwise;

public class Ex09_CheckIfTheKthBitisOn {
	public static void main(String args[]) {
		int num = Integer.valueOf(args[0]);
		int k = Integer.valueOf(args[1]);

		System.out.println("The binary number of " + num + " is " 
			+ Integer.toBinaryString(num));

		String result = (num & (1 << (k - 1))) >= 1?"on":"off";
		System.out.println("The " + k + "th digits is " + result);
	}
}