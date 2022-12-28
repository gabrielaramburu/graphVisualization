package exercises.behaviorparameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import exercises.behaviorparameterization.Apple.Color;

public class Inventory {

	public static void main(String[] args) {
		Grocery grocery = new Grocery(
				Apple.of(34, Color.GREEN),
				Apple.of(30,Color.GREEN),
				Apple.of(20, Color.RED));
		
		//This is a kind of strategy pattern.
		//The problem with this approach is that I need to create a new Object that implements the Interface.
		List<Apple> greenApples = grocery.filterApples(new Filterable() {
			public boolean applyFilter(Apple apple) {
				return apple.color.equals(Apple.Color.GREEN) ? true:false;
			}
		});
		
		System.out.println("Green apples:"+ greenApples.toString());
		
		//A better approach is to consider the method as a first-class citizen. 
		System.out.println("Red apples:" + grocery.filterApplesUsingMethodReference(Apple::isRed));
		
		//Even better could be to use an anonymous function or lambda expresion.
		System.out.println("Apples bigger than 30g " + grocery.filterApplesUsingMethodReference((Apple a) -> a.weight > 30));
	}

}

class Apple {
	public static enum Color {RED, GREEN};
	Color color;
	int weight;
	
	public Apple(int weight, Color color) {
		this.color = color;
		this.weight = weight;
	}
	
	public static Apple of (int weight, Color color) {
		return new Apple(weight, color);
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
	boolean isRed() {
		return this.color.equals(color.RED) ? true: false;
	}
	
	
}

class Grocery {
	List<Apple> apples;
	
	Grocery() {
		apples = new ArrayList();
	}
	
	Grocery(Apple... apples) {
		this.apples = new ArrayList<Apple>(Arrays.asList(apples));
	}
	
	List<Apple> filterApples(Filterable filter) {
		List<Apple> inventory = new ArrayList<Apple>();
		for (Apple apple: apples) {
			if (filter.applyFilter(apple)) {
				inventory.add(apple);
			}
		}
		return inventory;
	}
	
	//this second version uses functional interface
	List<Apple> filterApplesUsingMethodReference(Predicate<Apple> filter){
		List<Apple> inventory = new ArrayList<Apple>();
		for (Apple apple: apples) {
			if (filter.test(apple)) {
				inventory.add(apple);
			}
		}
		return inventory;
	}
}

interface Filterable {
	boolean applyFilter(Apple apple);
}

