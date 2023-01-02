package streams.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Example_9 {

	
	public static void main(String[] args) {
		excercise1();
		exercise2_firtAttempt();
		exercise2_usingStreams_after_see_solution();
	}
	
	/**
	 * 1. Given a list of numbers, how would you return a list of the square of each
	 * number?
	 * 
	 * For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
	 */
	private static void excercise1() {
		List<Double> numbers = new ArrayList<Double>(Arrays.asList(1D, 2D, 3D, 4D, 5D));
		numbers.stream().map(num -> Math.pow(num, 2)).forEach(System.out::println);
	}

	/**
	 * 2. Given two lists of numbers, how would you return all pairs of numbers? 
	 * For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3),
	 * (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a
	 * pair as an array with two elements.
	 */
	
	private static void exercise2_firtAttempt() {
		List<Integer> listA = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> listB = new ArrayList<>(Arrays.asList(3,4));
		List<Integer[]> output = new ArrayList<>();
		for (Integer numA:listA) {
			for (Integer numB:listB) {
				output.add(new Integer[] {numA, numB});
			}
		}
		for (Integer[] pair: output) {
			System.out.println(Arrays.toString(pair));
		}
	}
	
	/* this was my best try but it even doesn't compile :(
	private static void exercise2_usingStreams() {
		List<Integer> listA = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> listB = new ArrayList<>(Arrays.asList(4,5));
		
		List<Integer[]> output = new ArrayList<Integer[]>();
		
		List<Integer> out =
			listA.stream().map(num -> {
			List<Integer[]> aux = new ArrayList<Integer>();
			for (Integer numb: listB) {
				aux.add(new Integer[] {num, numb});
			}
			return aux.stream();
		}).flatMap(aux -> Arrays.stream(aux))
				.collect(Collectors.toList());
		
	}
*/
	
	private static void exercise2_usingStreams_after_see_solution() {
		List<Integer> listA = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> listB = new ArrayList<>(Arrays.asList(4,5));
		
		listA.stream()
				.flatMap(num -> listB.stream().map(numb -> new Integer[] {num, numb}))
				.collect(Collectors.toList())
				.forEach(pair -> System.out.println(Arrays.toString(pair)));
		
		//explanation:
		//listB.stream().map(numb -> new Integer[] {num, numb}) for each number of listB, I create a new Array, finally return an Stream of Array
		//after that I concatenate (flat) each stream in a unique stream of Arrays
		//finally I show each array
		
	}
		
}
