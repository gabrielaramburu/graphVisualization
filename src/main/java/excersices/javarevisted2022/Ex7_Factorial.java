package excersices.javarevisted2022;

public class Ex7_Factorial 
	{
	static int total = 0;
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	
	private static int factorial(int i){
		if (i == 0) return 1;
		
		return i * factorial(i - 1);

		
	}
}

