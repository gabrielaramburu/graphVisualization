package excersices.javarevisted;

import java.util.HashMap;
import java.util.Map;

public class Ex18_isAnagram {
	public static void main(String[] args) {
		// System.out.println(isAnagram("holaaa", "alohaa"));
		System.out.println(isAnagram("hholaa", "alohaa"));
	}

	private static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		Map<Character, Counter> hashChar = buildHash(s1);
		System.out.println(hashChar.toString());

		boolean result = s2.chars().mapToObj(c -> (char) c).allMatch(c -> {
			if (hashChar.get(c) == null)
				return false;
			else if (hashChar.get(c).total() > 0) {
				hashChar.get(c).decrement();
				return true;
			} else
				return false;
		});

		System.out.println(hashChar.toString());
		return result;
	}

	private static Map<Character, Counter> buildHash(String str) {
		Map<Character, Counter> hash = new HashMap<Character, Counter>();
		str.chars().forEach(i -> {
			if (hash.get(Character.valueOf((char) i)) == null) {
				hash.put(Character.valueOf((char) i), new Counter());
			} else {
				hash.get(Character.valueOf((char) i)).add();
			}
		});
		return hash;
	}

}

class Counter {
	int totalChars = 1;

	int total() {
		return totalChars;
	}

	void add() {
		totalChars++;
	}

	void decrement() {
		totalChars--;
	}

	@Override
	public String toString() {
		return totalChars + "";
	}
}
