package bitwise;

public class Ex02_FindTheUniqueNonRepetedValue {
    public static void main(String[] args){
        int a[] = {1, 2, 3, 5, 6, 4, 1, 2, 5, 3, 4};
        int v = 0;
        for (int value: a) {

            v = v ^ value;
        }
        System.out.println(v);
    }
}
