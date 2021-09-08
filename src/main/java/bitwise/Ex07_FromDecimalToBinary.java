package bitwise;

import java.util.*;

public class Ex07_FromDecimalToBinary {

	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>();

		int x = Integer.valueOf(args[0]);
		System.out.println("The number " + x + " is " + Integer.toBinaryString(x));
		int y = 1;
		while (y > 0) {
		  	int aux = (x & y) >=1?1:0;
		  	stack.addFirst(aux);
		  	y = y<<1;
  		}
  		System.out.println(stack.toString());
	}
}