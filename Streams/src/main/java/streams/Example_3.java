package streams;

import java.util.stream.Collectors;

/**
 * Intermediate operation execute altogether for each element.
 *
 */
public class Example_3 {

	public static void main(String[] args) {
		Dish.getListOfDishes().stream()
			.filter(dish ->{ 
							System.out.println("Filtering dish: " + dish.getName());
							return true;})
				.map(dish -> {System.out.println("Mapping dish:" + dish.getName());
						return dish.getName();})
				.collect(Collectors.toList());
		
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
