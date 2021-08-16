package excersices.javarevisted;

class Ex13_squareRoot {
	public static void main(String[] args) {
		System.out.println("sqrt:" + sqrt(Integer.valueOf(args[0])));

	}

	private static int sqrt(int x) {
		int r = x;
		int t = 0;
		while (r > 0.1) { //0.1 determine the precision of the result 
			t = r;
			r =  (x/r  + r) / 2 ;
		}
		return r;
	}
}
