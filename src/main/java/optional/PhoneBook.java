package optional;

import java.util.HashMap;
import java.util.Optional;

public class PhoneBook {
	 private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
	        {
	            put("Jos de Vos", "016/161616");
	            put("An de Toekan", "016/161617");
	            put("Kris de Vis", "016/161618");
	        }
	    };

	    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

	    PhoneBook() { }

	    public HashMap<String, String> getPhoneBookEntries() {
	        return phoneBookEntries;
	    }

	    public Optional<String> findPhoneNumberByName(String name){
	        return Optional.ofNullable(phoneBookEntries.get(name));
	    }

	    public Optional<String> findNameByPhoneNumber(String phoneNumber){
	        Optional<String> name = phoneBookEntries.entrySet().stream()
	            .filter(e -> e.getValue().equals(phoneNumber))
	            .map(e -> e.getKey())
	            .findFirst();
	        return name;
	    }

	    @Override
	    public String toString() {
	        System.out.println("Hello from PhoneBook's toString method");
	        return "PhoneBook{" +
	                "phoneBookEntries=" + phoneBookEntries +
	                '}';
	    }
}
