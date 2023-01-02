package streams.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example_8 {

	/*
	 * How could you return a list of all the unique characters for a list of words?
	 * For example, given the list of words ["Hello," "World"] you’d like to return
	 * the list ["H," "e," "l," "o," "W," "r," "d"] .
	 */
	public static void main(String[] args) {
		attempt1();
		attempt2();
	}

	private static void attempt1() { //it does not work
		System.out.println("attempt 1");
		String str = "Hello word";
		Stream.of(str)
			.map(item -> item.split(""))
			.map(Arrays::stream)
			.forEach(item -> System.out.println(item + "\n"));
		
		//this build an unique Stream<String>, after the split method we get an Array<String>
		//and we transform the array in another stream
		//finally we print the stream which is not correct.
	}
	
	private static void attempt2() { //it works
		System.out.println("attempt 2");
		List<String> words = new ArrayList<>(Arrays.asList("hello", "word"));
		List<String> output = words.stream()
			.map(item -> item.split(""))
			//.map(Arrays.stream) it does not work because it return List<Stream<String>>
			.flatMap(Arrays::stream)
			.distinct()
			.collect(Collectors.toList());
		System.out.println(output.toString());
	}
}
