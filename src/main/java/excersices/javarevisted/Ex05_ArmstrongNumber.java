package excersices.javarevisted;

public class Ex05_ArmstrongNumber {
	// 153 is true = 1^3 + 5^3 + 3^3 = 153

	public static void main(String[] args) {
		System.out.println(isArmstrong(153));
		System.out.println(isArmstrong(154));

	}

	private static boolean isArmstrong(int number) {
		int total = 0;
		int originalNumber = number;
		while (number > 0) {
			int lastDigit = number % 10;
			total += Math.pow(lastDigit, 3);
			number /= 10;
		}
		System.out.println(total);
		return total == originalNumber ? true : false;
	}
}
