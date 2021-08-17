package excersices.javarevisted;

import java.util.*;
public class Ex14_reverseArrayInGroup {

	public static void main (String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		reverseArray(arr, 3);
		System.out.println(Arrays.toString(arr));

		int[] arr2 = {1,2,3,4,5,6,7,8,9,0};
		reverseArray(arr2, 4);                    	
		System.out.println(Arrays.toString(arr2));
	}

	private static void reverseArray(int[] arr, int group) {
		int startGroup = 0;
		int x = startGroup;
		int j = group - 1;
		for (int i = 0; i < arr.length/ 2; i++) {
			swap(arr, x, j);
			x++;
			j--;
			if (j <= x) {
				startGroup +=group; 	
				x = startGroup;
				j = x + group - 1;
				if (x >= arr.length) break;
				if (j >= arr.length) j = arr.length - 1;
			}
		}
	}

	private static void swap(int[] arr, int x, int j) {
		int aux = arr[j];
		arr[j] = arr[x];
	       	arr[x] = aux;	
	}

}

