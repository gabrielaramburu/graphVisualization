package streams.reducing;

import java.util.List;
import java.util.stream.IntStream;

import streams.Dish;

public class Example_10 {

	
	public static void main(String[] args) {
		numberOfDishes();
		totalAmountOfCalories();
		reduceUsingPararellProcessing();
	}
	
	
	private static void numberOfDishes() {
		int dishes = Dish.getListOfDishes().stream()
				.map((dish) -> 1)
				.reduce(0,Integer::sum);
			
			System.out.println("number of dishes: " + dishes);
			
			//just in case
			System.out.println("number of dishes:" + Dish.getListOfDishes().stream().count());
	}
	
	private static void totalAmountOfCalories() {
		int calories = Dish.getListOfDishes().stream()
			.map(Dish::getCalories)
			.reduce(0, (Integer::sum));
		System.out.println("Calories " + calories);
	}
	
	private static void reduceUsingPararellProcessing() {
		int aux = IntStream.range(0, 1000).reduce(0, (v1, v2) -> v1 + v2);
		System.out.println("reduce example a " + aux);
		
		
		//this also works, even thought the combiner operation is not indicated
		int aux2 = IntStream.range(0, 1000)
			.parallel()
			.peek(num -> System.out.println(Thread.currentThread().getName() + "v: " +num))
			.reduce(0, (v1, v2) -> v1 + v2);
		System.out.println("reduce example b " + aux2);
		
		//it also works
		String aux3 = List.of("one","two","three","four","five").stream()
		.parallel()
		.reduce("",(s1,s2) -> s1+s2);
		System.out.println("example 3:" + aux3);
		
		//therefore parallelism is not the key to understand the collector functions.
		
		
		//this is the key
		int aux4 = List.of("one","two","three","four","five").stream()
				.reduce(0,(accum, s2) -> accum + s2.length(),(acc1, acc2) -> acc1 + acc2);
		
				System.out.println("example 4:" + aux4);
				
	//this doesn't compile			
//		List.of("one","two","three","four","five").stream()
//						.reduce(0,(accum, s2) -> accum + s2.length());
				
		/* From: stackoverflow https://stackoverflow.com/a/24316429/2014619
		 * If we aren't switching types, 
		 
				it turns out that the accumulator function is the same as the combiner function. 
				That's why reduction to the same type has only the accumulator 
				function and reduction to a different type requires separate accumulator and combiner functions.	
				*/	
	}

}
