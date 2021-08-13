package excersices.javarevisted;

public class Ex10_printPyramidPattern {

	public static void main(String[] args) {
		int levels = 10;
		for (int i = 0; i < levels; i++) {
			for (int iz = 0; iz < levels; iz++) {
				char charOut;
				if (iz < levels - i)
					charOut = ' ';
				else
					charOut = '*';

				System.out.print(charOut);
			}
			for (int iq = 0; iq < levels; iq++) {
				char charOut;
				if (iq < i)
					charOut = '*';
				else
					charOut = ' ';

				System.out.print(charOut);
			}
			System.out.println(" ");
		}
	}
}
