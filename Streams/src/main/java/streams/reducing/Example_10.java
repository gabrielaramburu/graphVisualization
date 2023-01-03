package streams.reducing;

import streams.Dish;

public class Example_10 {

	
	public static void main(String[] args) {
		numberOfDishes();
		totalAmountOfCalories();
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

}
