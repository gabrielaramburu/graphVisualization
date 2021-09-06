package bitwise;

public class Ex01_SumOfTwoNumberWithoutAritmeticOperator {
    public static void main(String args[]) {
      int a = Integer.valueOf(args[0]);
      int b = Integer.valueOf(args[1]);
      int result = rippleCarryAdder(a, b);
      //int result = adder(a, b);
      System.out.println("");
      System.out.println("Adding " + a + " and " + b + " = " + result);
    }

    public static int adder(int a, int b) {
      int carry;
      while (b != 0) {
        //the same operation as a halfAdder
        carry = a & b;
        a = a ^ b;
        System.out.println(a);
        //this part a very unintuitive
        b = carry<<1;
      }
      return a;
    }


    public static int rippleCarryAdder(int a, int b){
        StringBuilder sb = new StringBuilder();
        int carryIn = 0;
        int result = 0;

        String binA = toBinary(a);
        String binB = toBinary(b);

        for (int i = binA.length() - 1 ;i >=0; i--) {
          AdderResult res = fullAdder(
            Character.getNumericValue(binA.charAt(i)),
            Character.getNumericValue(binB.charAt(i)), carryIn);

          carryIn = res.carryOut;
          result = res.result;
          sb.append(Integer.toBinaryString(result));
        }
        System.out.println(sb.reverse().toString());
        return Integer.parseInt(sb.toString(), 2);
    }

    //Simulation of FullAdder
    public static AdderResult fullAdder(int a, int b, int carryIn) {

      AdderResult res1 = halfAdder(a, b);
      AdderResult res2 = halfAdder(res1.result, carryIn);
      int carryOut = res1.carryOut | res2.carryOut;

      //System.out.println("a " + a + " b " + b + " cIn " + carryIn + " cOut " + carryOut + " result " + res2.result);
      return new AdderResult(res2.result, carryOut);
    }

    public static String toBinary(int a) {
          String aux = Integer.toBinaryString(a);
          aux = "00000000000000000000000000000000"+aux;
          aux = aux.substring(aux.length() - 32, aux.length());
          //System.out.println(a + " = " + aux);
          return aux;
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
