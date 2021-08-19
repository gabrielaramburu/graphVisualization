package excersices.javarevisted;

import java.util.Map;
import java.util.stream.Collectors;

public class Ex21_FirstRepeteadChar {
	public static void main(String[] args) {
		System.out.println(firstNonRepeatedChar("hello"));
		System.out.println(firstNonRepeatedChar("aabbccd"));
		System.out.println(firstNonRepeatedChar("ggg11nnv22"));
		System.out.println(firstNonRepeatedChar("aabbccdd"));
	}

	private static Character firstNonRepeatedChar(String word) {
		Map<Character, Long> counting = word.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		return word.chars().mapToObj(c -> (char) c).filter(c -> {
			if (counting.get(c) == 1)
				return true;
			else
				return false;
		}).findFirst().orElse('$');
	}
}
