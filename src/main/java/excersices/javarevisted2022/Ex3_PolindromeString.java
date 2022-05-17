public class Ex3_PolindromeString {
	public static void main(String[] args){
		Ex3_PolindromeString ex3 = new Ex3_PolindromeString();
		ex3.isPolindrome("Bob");
		ex3.isPolindrome("Bobf");
	}
	
	private boolean isPolindrome(String word){
		word = word.toLowerCase();
		boolean isPol = true;
		for (int i=0;i < word.length() - 1; i++){
			if (word.charAt(i) != word.charAt((word.length() -1) - i)){
				isPol = false;
				break;
			} 
		}
		System.out.printf("The word %s is polindrome? %b %n", word, isPol);
		return isPol;
	}
	
	
	
}
