package streams;

import java.util.stream.Stream;

/**
 * An streams only can be processed once. (only one iteration cycle)
 *
 */
public class Example_2 {

	public static void main(String[] args) {
		Stream<Dish> dishStream = Dish.getListOfDishes().stream();
		dishStream.forEach(dish -> System.out.println(dish.getName()));
		//this second line thows an exception IllealStateException:
		dishStream.forEach(dish -> System.out.println(dish.getName()));
	}

}
