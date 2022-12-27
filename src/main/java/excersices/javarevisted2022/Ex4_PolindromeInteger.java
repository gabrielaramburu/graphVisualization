package excersices.javarevisted2022;

import java.util.*;
public class Ex4_PolindromeInteger {
	public static void main (String[] args) {
		isPolindrome(10012);
		isPolindrome(1001);
		isPolV2(1001);
		isPolV2(10011);
		
	}
	
	public static void isPolindrome(int number) {
		String aux;
		Integer integerVal = number;
		System.out.printf("%d %b %n",number,isPolindrome(integerVal.toString()));
	}
	
	private static boolean isPolindrome(String word){
		word = word.toLowerCase();
		boolean isPol = true;
		for (int i=0;i < word.length() - 1; i++){
			if (word.charAt(i) != word.charAt((word.length() -1) - i)){
				isPol = false;
				break;
			} 
		}
		return isPol;
	}
	
	public static void isPolV2(int number) {
		boolean result = true;
		int n = number;
		int digit;
		List<Integer> digits = new ArrayList<Integer>();
		while (n > 0){
			digit = n % 10;
			n = n / 10;
			digits.add(digit);
		}
		System.out.println(digits.toString());
		
		for (int i = 0; i < digits.size(); i++){
			if (!digits.get(i).equals(digits.get(digits.size() -1- i))) {
		
			result = false;
			break;
			}
		}
		System.out.printf("%d %b %n",number,result);
	}
	
}
