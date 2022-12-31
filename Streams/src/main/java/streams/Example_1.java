package streams;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The way we use streams is more declarative than the way we use Collection (imperative)
 * It also allows us to form a chain of responsability.
 * It also use implicit iteration (vs explicit iteration used by Collections"
 *
 */
public class Example1 {
	public static void main(String[] args) {
		//get 3 names of dishes with more than 300 calories.
		List<String> filteredDishes = 
				Dish.getListOfDishes().stream()
					.filter(dish -> dish.getCalories() > 300)
					.map(Dish::getName)
					.limit(3)
					.collect(Collectors.toList());
		
		System.out.println(filteredDishes);
	}
				
	
}
