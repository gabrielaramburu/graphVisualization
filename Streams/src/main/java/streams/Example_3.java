package streams;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Intermediate operation execute altogether for each element.
 *
 */
public class Example_3 {

	public static void main(String[] args) {
		List<String> dishes = Dish.getListOfDishes().stream()
			.filter(dish ->{ 
							System.out.println("Filtering dish: " + dish.getName());
							return dish.getCalories() > 300;})
				.map(dish -> {System.out.println("Mapping dish:" + dish.getName());
						return dish.getName();})
				.collect(Collectors.toList());
		
		System.out.println(dishes);
		
		/* Partial out put:
		 * 
		 * 	Filtering dish: pork
			Mapping dish:pork
			Filtering dish: beef
			Mapping dish:beef
			Filtering dish: chicken
			Mapping dish:chicken
		 */
	}

}
