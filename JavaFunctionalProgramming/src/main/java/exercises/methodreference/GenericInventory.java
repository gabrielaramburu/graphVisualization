package exercises.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class GenericInventory {

	public static void main(String[] args) {

		List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(12, 13, 14,15));
		List<String> stringList = new ArrayList<String>(Arrays.asList("hello","word"));
		
		//Example of code as a first-class citizen
		Predicate<Integer> filter1 = (Integer i) -> (int)i > 13;
		Predicate<String> filter2 =  (String s) -> s.length() == 4;
		
		System.out.println("Filter numbers " + filterSomething(integerList, filter1).toString());
		System.out.println("Filter string by length " + filterSomething(stringList, filter2).toString());
	}
	
	
	public static <T> List<T> filterSomething(List<T> items, Predicate<T> filter) {
		List<T> filterItems = new ArrayList<T>();
		for (T item: items) {
			if (filter.test(item) ) {
				filterItems.add(item);
			}
		}
		return filterItems;
	}

}
