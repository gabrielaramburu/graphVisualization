package excersices.javarevisted2022;


public class ex1_Fibonacci {
	private int total;
		
	public static void main (String[] args) {
		ex1_Fibonacci ex1 = new ex1_Fibonacci();
		
		ex1.fibonacciSequence(0,1,50);
		
		System.out.println("Fibonacci value at position:" + ex1.fibonacciSum(13));
		
		System.out.println("Fibonacci sum all value at position:" + ex1.fibonacciSumarize(4));
		
		int testMemo = 14;
		int[] values = new int[testMemo+1];
		System.out.println("Fibo with memo: " + ex1.fiboWithMemoization(testMemo, values));
	}
	
	private void fibonacciSequence(int total, int prev, int end){
		if (total > end) return;
		System.out.println(total);
		fibonacciSequence(total + prev, total, end);
	}
	
	/* This shows the value at the position "end" of the sequence
	Ex: fibonacci(13) show 233
	0,1,1,2,3,5,8,13,21,34,55,89,144,233,
	*/
	 
	private int fibonacciSum(int end){
		if (end == 1 || end == 2) {
			return 1;
		}		
		return fibonacciSum(end - 1) + fibonacciSum(end -2);
	}

	private int fiboWithMemoization(int end, int[] val) {
		if (val[end] != 0) return val[end];
		
		if (end == 1 || end == 2)
			return 1;
		
		int aux = fiboWithMemoization(end -1, val) + fiboWithMemoization(end -2, val);
		val[end] = aux;
		return aux;
	}
		
	/*I need to fix */
	private int fibonacciSumarize(int end) {
		if (end == 1 || end == 2) {
			return 1;
		}		
		int aux = fibonacciSumarize(end - 1) + fibonacciSumarize(end -2);	
		total=total+aux;
		return total;	
	}
}
