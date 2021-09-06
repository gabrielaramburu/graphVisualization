package bitwise;

public class Ex01_SumOfTwoNumberWithoutAritmeticOperator {
    public static void main(String args[]) {
      int a = Integer.valueOf(args[0]);
      int b = Integer.valueOf(args[1]);
      //int result = rippleCarryAdder(a, b);
      int result = adder(a, b);
      System.out.println("Adding " + a + " and " + b + " = " + result);
    }

    public static int adder(int a, int b) {
      int carry;
      while (b != 0) {
        //the same operation as a halfAdder
        carry = a & b;
        a = a ^ b;

        //this part a very unintuitive
        b = carry<<1;
      }
      return a;
    }

    //does not work
    public static int rippleCarryAdder(int a, int b){
        int aux = 1;
        int carryIn = 0;
        for (int i = aux;i > 0; i = i << 1) {

          AdderResult res = fullAdder(a & i, b & i, carryIn);
          carryIn = res.carryOut;
          System.out.print(res.result);
        }
        return 0;
    }

    //Simulation of FullAdder
    public static AdderResult fullAdder(int a, int b, int carryIn) {


      AdderResult res1 = halfAdder(a, b);
      AdderResult res2 = halfAdder(res1.result, carryIn);
      int carryOut = res1.carryOut | res2.carryOut;

      //System.out.println("a " + a + " b " + b + " cIn " + carryIn + " cOut " + carryOut + " result " + res2.result);
      return new AdderResult(res2.result, carryOut);
    }

    public static AdderResult halfAdder(int a, int b) {
      return new AdderResult(a ^ b, a & b);
    }

    public static class AdderResult {
      int result;
      int carryOut;

      public AdderResult(int res, int cOut) {
        this.result = res;
        this.carryOut = cOut;
      }
    }
}
