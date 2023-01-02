package streams.mapping;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import streams.Dish;

public class Example_7 {

	public static void main(String[] args) {
		List<Integer> case1 = Dish.getListOfDishes().stream()
			.map(dish-> dish.getName().length())
			.collect(Collectors.toList());
		
		System.out.println(case1);
		
		//idem to 
		List<Integer> case2 = Dish.getListOfDishes().stream()
			.map(Dish::getName)
			.map(String::length)
			.collect(Collectors.toList());
		
		System.out.print(case2);
	}

}
