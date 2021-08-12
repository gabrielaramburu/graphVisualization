package excersices.javarevisted;
import java.util.*;

public class Ex8_ReverseString {
	public static void main(String[] args) {
		char[] s = {'h', 'o', 'l', 'a'};
		reverseString(s);
		
		reverseStringRecursive("hola");
		
		reverseBacktracking("bien, gracias");
	}
	
	 static void reverseString(char[] s) {
		for (int i = 0; i < s.length / 2; i++) {
			int rPos = s.length - 1 - i;
			char aux = s[i];
			s[i] = s[rPos];
			s[rPos] = aux;
		}

		System.out.println(Arrays.toString(s));
	}
	
	 static void reverseStringRecursive(String string) {
		reverseUtil(string, string.length() - 1);
	}
	
	 static void reverseUtil(String s,  int pos) {
		if (pos < 0) return;
		System.out.println(s.charAt(pos));
		reverseUtil(s, pos - 1);
	}
	
	 static void reverseBacktracking(String string) {
		reverseBackTracking(string, 0);
	}
	 
	 static void reverseBackTracking(String s, int pos) {
		 if (pos == s.length()) return ;
		 reverseBackTracking(s, pos + 1);
		 System.out.print(s.charAt(pos));
	 }
	
}
