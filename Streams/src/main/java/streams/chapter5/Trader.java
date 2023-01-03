package streams.chapter5;

import lombok.Getter;

@Getter
public class Trader {
	private final String name;
	private final String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}


	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}
}
