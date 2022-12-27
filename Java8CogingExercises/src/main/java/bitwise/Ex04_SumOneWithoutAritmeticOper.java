package bitwise;

public class Ex04_SumOneWithoutAritmeticOper {
  public static void main(String[] args) {
    int x = Integer.valueOf(args[0]);
    System.out.println("Adding 1 to " + x + " = " + addOne(x));
  }

  static int addOne(int x) {
    int c = 1;
    while ( (x & c) >= 1) {   //iterate through the bits until the first 0
      //flip 1 to 0
      x = x ^ c;
      //next bit
      c = c<<1;
    }
    //finaly change the first 0 to 1
    x = x ^ c;

    return x;
  }
}
