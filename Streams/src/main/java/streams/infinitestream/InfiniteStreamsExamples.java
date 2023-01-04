package streams.infinitestream;

import java.util.Arrays;
import java.util.stream.Stream;

public class InfiniteStreamsExamples {

	public static void main(String[] args) {
		example1();
		example2();
		example3();
	}
	
	public static void example1() {
		Stream
			.iterate(0, n -> n + 2)
			.limit(10)
			.forEach(System.out::println);
	}
	
	public static void example2() {
		//fibonacci series
		Stream
			.iterate( new int[] {0,1}, n -> new int[] {n[1] , n[0]+ n[1]})
			.limit(10)
			.forEach(pair -> System.out.println(Arrays.toString(pair)));
		
		//fibonacci series
		Stream
			.iterate( new int[] {0,1}, n -> new int[] {n[1] , n[0]+ n[1]})
			.limit(10)
			.map(pair -> pair[1])
			.forEach(System.out::println);
	}

	public static void example3() {
		Stream
			.generate(Math::random)
			.limit(10)
			.forEach(System.out::println);
	}
}
