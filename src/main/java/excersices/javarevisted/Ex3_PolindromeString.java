package excersices.javarevisted;

public class Ex3_PolindromeString {
	public static void main(String[] args) {
        System.out.println(ifPolindrome("fafaf"));
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
}
