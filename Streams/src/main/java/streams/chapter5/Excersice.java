package streams.chapter5;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Excersice {

	/**
	 * 1 Find all transactions in the year 2011 and sort them by value (small to high). 
	 * 2 What are all the unique cities where the traders work? 
	 * 3 Find all traders from Cambridge and sort them by name. 
	 * 4 Return a string of all traders’ names sorted alphabetically. 
	 * 5 Are any traders based in Milan? 
	 * 6 Print the values of all transactions from the traders living in Cambridge. 
	 * 7 What’s the highest value of all the transactions? 
	 * 8 Find the transaction with the smallest value.
	 */
	public static void main(String[] args) {
		System.out.println("* Find all transactions in the year 2011 and sort them by value (small to high)");
		findAllTransactionIn2011();
		
		System.out.println("* What are all the unique cities where the traders work? ");
		uniqueCitiesWhereTraderWork();
		
		System.out.println("* Find all traders from Cambridge and sort them by name. ");
		findAllTraderFromCambridge();
		
		System.out.println(" * Return a string of all traders’ names sorted alphabetically");
		allTradersName();
		
		System.out.println("Are any traders based in Milan? ");
		traderBasedInMilan();
		
		System.out.println(" * The values of all transactions from the traders living in Cambridge.");
		allTransactionFromTradersLivingInCanbridge();
		
		System.out.println("*  Highest value of all the transactions? ");
		highestTransactionValue();
		
		System.out.println(" * The transaction with the smallest value.");
		smallestValueTransaction();
	}


	private static void findAllTransactionIn2011() {
	
		buildTransactions().stream()
				.filter(t -> t.getYear() == 2011)
				.sorted((a, b) -> Integer.compare(a.getValue(), b.getValue())).collect(Collectors.toList())
				.forEach(System.out::println);

	}

	private static void uniqueCitiesWhereTraderWork() {
		
		buildTransactions().stream()
			.map(t -> t.getTrader().getCity())
			.distinct().collect(Collectors.toList())
			.forEach(System.out::println);
	}

	private static void findAllTraderFromCambridge() {
		
		buildTransactions().stream()
			.map(t -> t.getTrader())
			.filter(t -> t.getCity().equals("Cambridge"))
			.sorted((n1, n2) -> n1.getName().compareTo(n2.getName()))
			.collect(Collectors.toSet())
			.forEach(System.out::println);

	}
	
	private static void allTradersName() {
	
		String aux = buildTransactions().stream()
			.map(t -> t.getTrader().getName())
			.distinct()
			.sorted((n1, n2) -> n1.compareTo(n2))
			.reduce("", (a, b) -> a.concat(" " + b));
			
		System.out.println(aux);
			
	}
	
	private static void traderBasedInMilan() {
		
		boolean aux = buildTransactions().stream()
			.map(t -> t.getTrader().getCity())
			.anyMatch(c -> c.equals("Milan"));
			System.out.println(aux);
	}
	
	private static void allTransactionFromTradersLivingInCanbridge() {
		
		buildTransactions().stream()
			.filter(t -> "Cambridge".equals(t.getTrader().getCity())) //very strange form of equals method invocation
			.map(Transaction::getValue)
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}


	private static void highestTransactionValue() {
		Optional<Transaction> max = buildTransactions().stream()
				.max((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		System.out.println(max.get());
		
		Optional<Integer> max2 = buildTransactions().stream()
				.map(Transaction::getValue)
				.max((v1, v2) -> Integer.compare(v1, v2));
		
		System.out.println(max2.get());
	}
	
	private static void smallestValueTransaction() {
		Optional<Transaction> min = buildTransactions().stream()
			.min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		
		System.out.println(min.orElseGet(() -> new Transaction(null, 0, 0)));
	}
	
	static List<Transaction> buildTransactions() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		return transactions;
	}
}
