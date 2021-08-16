package excersices.javarevisted;

class Ex13_squareRoot {
	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		System.out.println("sqrt:" + sqrt(Integer.valueOf(args[0])));

	}

	private static double sqrt(int x) throws InterruptedException {
		double r = x;
		double t = 0;
		while (Math.abs(r - t)>= 1) {  
			t = r;
			r =  (x/r  + r) / 2 ;
			System.out.println(r);
			Thread.sleep(300);
		}
		return r;
	}
}
