package stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodingGameExercises {

	//Now, starting again from a list of names, give me the total number of letters in all the names with more than 5 letters
	
	public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) { 
	    return Stream.of(names).filter(item -> item.length() > 5).mapToInt(item->item.length()).sum();  
	}
	

	//Flatten this multidimensional collection
	
	public static List<String> transform(List<List<String>> collection) {
	    return collection.stream().flatMap(lista -> lista.stream()).collect(Collectors.toList());
	}
	

	//Get the oldest person from the collection
	

	public static Person getOldestPerson(List<Person> people) {
	    return people.stream().reduce(people.get(0), (p1, p2) -> {
	            if (p1.getAge() > p2.getAge()) return p1;
	            else return p2;
	        });
	}
	

	//Sum all elements of a collection, try to use the reduce operator with identity parameter instead of an IntStream
	
	public static int calculate(List<Integer> numbers) {
	    //return numbers.stream().reduce(0, (acum, val) -> {return acum+=val;}); same as below
	    return numbers.stream().reduce(0, (acum, val) -> acum+=val);
	}
	

	//Get the names of all kids under the age of 18
	
	public static Set<String> getKidNames(List<Person> people) {
	    return people.stream().filter(kid -> kid.getAge() < 18).map(val -> val.getName()).collect(Collectors.toSet());
	}
	

	//Partition these people into adults and kids, you'll need a special collector for this one
	
	public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
	        return people.stream().collect(Collectors.partitioningBy(item -> item.getAge() >= 18));
	    }
	

	//Group these people by nationality, same kind as the previous exercise
	
	public static Map<String, List<Person>> groupByNationality(List<Person> people) {
	    return people.stream().collect(Collectors.groupingBy((p -> p.getNationality())));
	}
	

	//Return a comma-separated string of all these people's names
	
	public static String namesToString(List<Person> people) {
	    return people.stream().map(p -> p.getName()).collect(Collectors.joining(", ","Names: ", "."));
	}
	

	//Return a comma-separated string of all these people's names
	
	public static String getString(List<Integer> list) {
		return list.stream().map(number -> {
	        if (number % 2 == 0) return "o"+number;
	        else return "e"+number;
	    })
	    .collect(Collectors.joining(","));
	}
	
	
	
	
	
	
	
	
	
	class Person {

		private String name;
		private int age;
		private String nationality;

		public Person(String name, int age, String nationality) {
			this.name = name;
			this.age = age;
			this.nationality = nationality;
		}

		public Person(String name, int age) {
			this(name, age, "");
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

	  public String getNationality() {
	    return nationality;
	  }
	}
	
}
