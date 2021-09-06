package bitwise;

public class Ex02_FindTheUniqueNonRepetedValue {
    public static void main(String[] args){
        int a[] = {1, 2 , 3, 5, 6, 2, 4, 1, 2, 5, 3};
        int v = 0;
        for (int value: a) {
            v = v ^ a;
        }
        System.out.println(v);
    }
}
