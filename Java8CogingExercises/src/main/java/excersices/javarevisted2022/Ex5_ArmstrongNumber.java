package excersices.javarevisted2022;

public class Ex5_ArmstrongNumber {
	public static void main(String[] args) {
		int number = Integer.valueOf(args[0]);
		int aux = number;
		double total = 0;
		while(aux>0) {
			int digit = aux % 10;
			total = total + Math.pow(digit, 3);
			aux = aux/10;
		}
		
		if (number == total) System.out.printf("%d is ArmstrongNumber",number);
		else System.out.printf("%d is not an ArmstrongNumber", number);
	}
}
