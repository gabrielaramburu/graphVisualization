package streams.grouping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import streams.Dish;
import streams.Dish.Type;

public class Exercise_11 {

	public static void main(String[] args) {
		groupingDishesByType();
		groupingByCaloriesRange();
		
		groupinDishesByTypeFilteringByCalories();
	}



	/**
	 * Suppose you want to classify the dishes in the menu according to their type,
	 * putting the ones containing meat in a group, the ones with fish in another
	 * group, and all others in a third group
	 */
	private static void groupingDishesByType() {
		Map<Type, List<Dish>> result = Dish.getListOfDishes().stream()
				.collect(Collectors.groupingBy(Dish::getType));

		System.out.println(result.toString());
		
		//just return the name of the dish
		Map<Type, List<String>> result2 = Dish.getListOfDishes().stream()
				.collect(
						Collectors.groupingBy(
								Dish::getType,
								Collectors.mapping(Dish::getName, Collectors.toList())));

		System.out.println("Just dishe's name " + result2.toString());
		
	}
	
	
	/**
	 * To classify as “diet” all dishes with 400 calories or fewer,
	 * set to “normal” the dishes having between 400 and 700 calories, 
	 * and set to “fat” the ones with more than 700 calories.
	 */
	enum CaloriesLevel  {NORMAL, FAT, DIET};
	private static void groupingByCaloriesRange() {
		Map<CaloriesLevel, List<Dish>> result = 
				Dish.getListOfDishes().stream()
				.collect(Collectors.groupingBy(d -> {
					if (d.getCalories() < 400) return CaloriesLevel.DIET;
					else if (d.getCalories() < 700) return CaloriesLevel.NORMAL;
					else return CaloriesLevel.FAT;
				}));
		
		System.out.println(result);
	}
	
	
	/**
	 * Grouping by type an filter only the caloric dishes, 
	 * let’s say the ones with more than 500 calories.
	 */
	private static void groupinDishesByTypeFilteringByCalories() {
		//the problem whith this approcah (filtering first) is that the type FISH
		// is not included in the map
		Map<Type, List<Dish>> result =Dish.getListOfDishes().stream()
			.filter(d -> d.getCalories()>500)
			.collect(Collectors.groupingBy(Dish::getType));
		
		System.out.println(result);
		
		//better solution
		result =Dish.getListOfDishes().stream()
				.collect(
						Collectors.groupingBy(
								Dish::getType, 
								//The filtering method is another static factory method of the Collectors class
								//accepting a Predicate to filter the elements in each group and a further Collector
								//that is used to regroup the filtered elements.
								
								Collectors.filtering(
									d -> d.getCalories() > 500, 
									Collectors.toList())));
			
			System.out.println(result);
	}

}
