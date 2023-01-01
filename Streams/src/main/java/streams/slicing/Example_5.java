package streams.slicing;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

import streams.Dish;

public class Example_5 {
	/*
Dish [name=season fruit, vegetarean=true, calories=120, type=OTHER]
Dish [name=prawns, vegetarean=false, calories=300, type=FISH]
Dish [name=rice, vegetarean=true, calories=350, type=OTHER]
Dish [name=chicken, vegetarean=false, calories=400, type=MEAT]
Dish [name=salmon, vegetarean=false, calories=450, type=FISH]
Dish [name=french fries, vegetarean=true, calories=530, type=OTHER]
Dish [name=pizza, vegetarean=true, calories=550, type=OTHER]
Dish [name=beef, vegetarean=false, calories=700, type=MEAT]
Dish [name=pork, vegetarean=false, calories=800, type=MEAT]
	 */
	public final static void main (String[] args) {
		
		exampleOfTakeWhile("Example A of takeWhile", buildAscSortedStream(), dish -> dish.getCalories() < 450);
		exampleOfTakeWhile("Example B of takeWhile", buildAscSortedStream(), dish -> dish.getCalories() > 450); //it shows anything
		
		exampleOfDropWhile("Example A of dropWhile", buildAscSortedStream(), dish -> dish.getCalories() < 700);
		exampleOfDropWhile("Example B of dropWhile", buildAscSortedStream(), dish -> dish.getCalories() > 700); //it shows anything
		
		//it is very important to understand why the B examples doesn't show anything. Remember takewhie and dropwhile are not filters,
		//are slicers that improve the processing performance
	}
	
	static void exampleOfTakeWhile(String testDesc, Stream<Dish> stream, Predicate<Dish> p) {
		System.out.println(testDesc);
	
		stream
		.takeWhile(p)
		.forEach(System.out::println);
	}
	
	static void exampleOfDropWhile(String testDesc, Stream<Dish> stream, Predicate<Dish> p) {
		System.out.println(testDesc);
		
		stream
		.dropWhile(p)
		.forEach(System.out::println);
	}
	
	static Stream<Dish> buildAscSortedStream() {
		return Dish.getListOfDishes().stream()
		.sorted(Comparator.comparingInt(Dish::getCalories));
	}
}
