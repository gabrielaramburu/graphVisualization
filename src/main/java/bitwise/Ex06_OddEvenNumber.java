package bitwise;

public class Ex06_OddEvenNumber {
  public static void main(String[] args) {
    int x = Integer.valueOf(args[0]);
    System.out.println("The number " + x + " is " + isEvenOdd(x));
  }

  static String isEvenOdd(int x) {
    int i = 1;
    return (x  & i) == 1?"odd":"even";
  }
}
