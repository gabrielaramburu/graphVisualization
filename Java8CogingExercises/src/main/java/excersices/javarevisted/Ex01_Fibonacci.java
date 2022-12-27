package excersices.javarevisted;

public class Ex01_Fibonacci {
	// 1, 1, 2, 3, 5, 8, 13, .....
	public static void main(String[] args) {
		System.out.println("Result recursion:" + fibonacciRec(13));
		System.out.println("Result boocle:" + fibonacciBoocle(13));

		int value = 13;
		int[] calculatedValues = new int[value + 1];
		System.out.println("Result with momoization : " + fibonacciRecWithMemoization(value, calculatedValues));

		fibonacciSequenceRec(0, 1, 20);
		fibonacciSequenceWithBoocle(20);
	}

	private static int fibonacciRec(int n) {
		// n indicates the quantuty of values of the sequence

		// Fn = Fn-2 + Fn-1
		// n=1 Fn=1
		// n=0 Fn=0

		if (n == 1 || n == 2)
			return 1;

		return fibonacciRec(n - 1) + fibonacciRec(n - 2);
	}

	private static int fibonacciRecWithMemoization(int n, int[] values) {
		if (values[n] != 0)
			return values[n];
		if (n == 1 || n == 2)
			return 1;

		int res = fibonacciRecWithMemoization(n - 2, values) + fibonacciRecWithMemoization(n - 1, values);
		values[n] = res;
		return res;
	}

	private static int fibonacciBoocle(int n) {
		int a = 0;
		int b = 1;
		int tot = 0;
		for (int i = 2; i <= n; i++) { // it start form two because a and b are already initialized
			tot = a + b;
			a = b;
			b = tot;
		}
		return tot;
	}

	private static void fibonacciSequenceRec(int a, int b, int end) {
		// show the sequence
		if (b < end) {
			if (a != 0)
				System.out.println(a + ", ");
			fibonacciSequenceRec(a + b, a, end);
		}
	}

	private static void fibonacciSequenceWithBoocle(int end) {
		int a = 1;
		int b = 1;
		System.out.print(a + "," + b + ",");
		while (b < end) {
			int tot = a + b;
			System.out.print(tot + ",");
			a = b;
			b = tot;
		}
		// to summatize the sequence values is not the same as to calculate the value of
		// Fibonacci sequence at some position
		// System.out.println("Result: " + tot);
	}
}
