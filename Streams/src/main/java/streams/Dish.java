package streams;

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


	
	
	
}
