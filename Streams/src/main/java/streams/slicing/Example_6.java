package streams.slicing;

import streams.Dish;

public class Example_6 {

	public static void main(String[] args) {
		Dish.getListOfDishes().stream().forEach(System.out::println);
		System.out.println("Skip example");
		Dish.getListOfDishes().stream().skip(3).forEach(System.out::println);
		
		System.out.println("Limit example");
		Dish.getListOfDishes().stream().limit(3).forEach(System.out::println);
	}

}
