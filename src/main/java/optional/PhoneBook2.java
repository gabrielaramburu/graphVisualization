package optional;

import java.util.Optional;

public class PhoneBook2 {
	private PhoneBook phoneBook;

	public PhoneBook2(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	public static void main(String[] args) {
		PhoneBook2 phoneBook = new PhoneBook2(new PhoneBook());
		System.out.println(phoneBook.findPhoneNumberByNameAndPunishIfNothingFound("Kris de Vis"));
		
		System.out.println(phoneBook.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Kris de "));
	}

	public String findPhoneNumberByNameAndPunishIfNothingFound(String name) {
		return Optional.ofNullable(phoneBook.getPhoneBookEntries().get(name))
				.orElseThrow(() -> new IllegalArgumentException("No phone number found"));
	}

	public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name) {
		return Optional.ofNullable(phoneBook.getPhoneBookEntries().get(name))
				.orElse(phoneBook.getPhoneBookEntries().toString());
	}

	public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber) {
		return Optional.ofNullable(phoneBook.getPhoneBookEntries().get(name))
				.orElse(phoneBook.getPhoneBookEntries().entrySet().stream()
						.filter(e -> e.getValue().equals(phoneNumber))
						.map(e -> e.getKey())
						.findFirst()
							.orElse(phoneBook.getPhoneBookEntries().get("Jos de Vos"))
						);
	}

	public PhoneBook getPhoneBook() {
		return phoneBook;
	}
}
