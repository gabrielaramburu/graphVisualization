package excersices.javarevisted;

import java.util.ArrayList;
import java.util.List;

public class Ex04_PolindromeInteger {
	
	private static boolean polindromeNumber(int number) {
        boolean result = true;
        List<Integer> digits = digits(number);
        for (int i = 0; i < digits.size() / 2; i++) {
            if (digits.get(i) != digits.get(digits.size() - 1 - i)) {
                result = false;
                break;   
            }
        }
        return result;
    }
    
    private static List<Integer> digits(int number) {
        List<Integer> digits = new ArrayList<Integer>();
        while (number > 0) {
            int lastNumber = number % 10;
            number/=10;    
            digits.add(lastNumber);
        }
        return digits;
    }
}
