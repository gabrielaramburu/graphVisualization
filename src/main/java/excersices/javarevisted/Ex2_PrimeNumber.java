package excersices.javarevisted;

public class Ex2_PrimeNumber {
    
    public static void main(String[] args) {
        System.out.println(isPrime(97));    
    }
    
    public static boolean isPrime(int number) {
        if (number !=2 && number % 2 == 0) return false; //the only one prime number that is par is the number 2
        
        int square = (int)Math.sqrt(number);
        for (int i = 2; i < square; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
}