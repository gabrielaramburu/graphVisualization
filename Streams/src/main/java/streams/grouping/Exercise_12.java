package streams.grouping;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise_12 {

	public static void main(String[] args) {
		extractDishLabels();
	}
	
	/**
	 * In case you are required to extract these tags for each group of type of dishes
	 */
	private static void extractDishLabels() {
		
		labels().entrySet().stream()
			.map(v -> v.getValue())
			.collect(Collectors.flatMapping(v -> v.stream(), Collectors.toSet()))
			.forEach(System.out::println);
		
		
		String result =labels().entrySet().stream()
			.flatMap(v -> v.getValue().stream())
			.collect(Collectors.joining(" ,"));
		System.out.println(result);

	}

	static Map<String, List<String>> labels() {
		Map<String, List<String>> dishTags = new HashMap<>();
		dishTags.put("pork", asList("greasy", "salty"));
		dishTags.put("beef", asList("salty", "roasted"));
		dishTags.put("chicken", asList("fried", "crisp"));
		dishTags.put("french fries", asList("greasy", "fried"));
		dishTags.put("rice", asList("light", "natural"));
		dishTags.put("season fruit", asList("fresh", "natural"));
		dishTags.put("pizza", asList("tasty", "salty"));
		dishTags.put("prawns", asList("tasty", "roasted"));
		dishTags.put("salmon", asList("delicious", "fresh"));
		return dishTags;
	}

}
