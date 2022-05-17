public class Ex2_PrimeNumbers {
	public static void main(String[] args) {
		
		Ex2_PrimeNumbers ex2 = new Ex2_PrimeNumbers();
		
		int test1 = 3;
		System.out.printf("Checking if the number is prime, number %d",test1);
		System.out.println(ex2.isPrime(test1));
	}
	
	private boolean isPrime(int number){
		boolean isPrime = true;
		if (number !=2 && (number % 2 == 0)) return false;
		int x = (int)Math.sqrt(number);
		for (int i = 2; i < x; i++) {
			if (i % 2 == 0) {
			  isPrime = false;
			  break;
			 }
		}
		return isPrime;
	}
}

