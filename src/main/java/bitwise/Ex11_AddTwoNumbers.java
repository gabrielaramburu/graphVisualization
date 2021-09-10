package bitwise;

public class Ex11_AddTwoNumbers {
	public static void main(String args[]) {
		int val1 = Integer.valueOf(args[0]);
		int val2 = Integer.valueOf(args[1]);

		System.out.println("Sum of " + val1 + " and " + val2 + " is " + add(val1, val2));
	}

	private static int add(int val1, int val2) {
		int sum, carry;
		while (val2 > 0) {
			sum = val1 ^ val2;
			carry = val1 & val2;
			val1 = sum;
			val2 = carry << 1;		
		}
		return val1;
	}
}