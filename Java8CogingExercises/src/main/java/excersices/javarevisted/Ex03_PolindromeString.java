package excersices.javarevisted;

public class Ex03_PolindromeString {
	 private static boolean result = true;
	    
	    public static void main(String[] args) {
	        //System.out.println(ifPolindrome("fafaf"));
	         System.out.println(ifPolindromeRecursive("aca"));
	    }
	    
	    public static boolean ifPolindrome(String data) {
	        boolean result = true;
	        for (int i = 0; i < data.length(); i++) {
	            if (data.charAt(i) != data.charAt((data.length() - 1) - i)) {
	                result = false;
	                break;
	            }
	        }
	        return result;
	    }
	    
	    public static boolean ifPolindromeRecursive(String data) {
	        ifPolindromeUtil(data, 0);
	        return Ex03_PolindromeString.result;
	    }
	    
	    private static void ifPolindromeUtil(String data, int pos) {
	        if (pos < data.length()) {
	            ifPolindromeUtil(data, pos + 1);    
	            if (data.charAt(pos) != data.charAt((data.length() - 1) - pos)) Ex03_PolindromeString.result = false;;
	        }
	    }
}
