package excersices.javarevisted;

public class Ex12_gcdEuclideanAlgo {
	public static void main(String[] args){

		System.out.println("mcd " + mcd(270,192));
	}

	private static int mcd(int a,int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		return mcd(b, a % b);
	}

}
