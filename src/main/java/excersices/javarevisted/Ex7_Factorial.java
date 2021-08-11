package excersices.javarevisted;

public class Ex7_Factorial {
	static long factorial(int N) {
		// return factorialUtil(N, 1L);
		return factorialIterative(N);
	}

	// this does not work for big numbers stackOverfloe
	static long factorialUtil(int n, long total) {
		if (n == 1)
			return total;
		return factorialUtil(n - 1, total * n);
	}

	static long factorialIterative(int n) {
		long facto = 1;
		for (int i = n; i > 0; i--) {
			facto *= i;
		}
		return facto;
	}
}
