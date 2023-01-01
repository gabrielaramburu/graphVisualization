package streams.filtering;

import streams.Dish;

public class Example_4 {

	public static void main(String[] args) {
		Dish.getListOfDishes().stream()
			.filter(Dish::isVegetarean)
			.filter(dish -> dish.isVegetarean()) //the same as previous line
			.distinct()
			.forEach(System.out::println);
			//same as previous line
			//.forEach(dish -> System.out.println(dish.getName())); 
	}

}
