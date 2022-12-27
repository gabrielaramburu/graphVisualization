package bitwise;

public class Ex05_CountTheBitsInInteger {
  public static void main(String[] args) {
    int x = Integer.valueOf(args[0]);
    System.out.println("The number " + x + " containg " + counterBits(x) + " bits equal 1");
  }

  private static int counterBits(int x) {
    int c = 1;
    int total = 0;
    while (c > 0) {
      if ((x & c) >= 1) total++;
      c= c<<1;
    }

    return total;
  }
}
