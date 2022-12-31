package streams;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class Dish {
	public enum Type {MEAT, FISH, OTHER}; 
	
	private final String name;
	private final boolean vegetarean;
	private final int calories;
	private final Type type;
	
	
	public Dish(String name, boolean vegetarean, int calories, Type type) {
		super();
		this.name = name;
		this.vegetarean = vegetarean;
		this.calories = calories;
		this.type = type;
	}


	public static List<Dish> getListOfDishes() {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		return menu;
	}
	
	
}
