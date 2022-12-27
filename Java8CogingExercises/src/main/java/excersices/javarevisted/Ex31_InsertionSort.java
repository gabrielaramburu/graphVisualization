package excersices.javarevisted;

import java.util.Arrays;

public class Ex31_InsertionSort {
	public static void main(String[] args) {
        int[] arr = {5, 3, 7, 8, 1, 0, 9, 6, 4, 2};
        
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);     
                } else break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    
    private static void swap(int[] arr, int j, int i) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
