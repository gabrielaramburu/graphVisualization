package excersices.javarevisted;

import java.util.*;

public class Ex50_MergeSort {

	public static void main(String args[]) {
		int arr[] = { 9, 2, 5, 7, 8, 0, 1, 3, 4, 6 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int arr[]) {
		sort(arr, 0, arr.length);
	}

	static void sort(int arr[], int low, int hi) {
		System.out.println("low " + low + " hi " + hi);
		if ((hi - low) > 1) {
			int mid = low + (hi - low) / 2;

			sort(arr, low, mid);
			sort(arr, mid, hi);
			merge(arr, low, hi, mid);
		}
	}

	static void merge(int arr[], int low, int hi, int mid) {
		List<Integer> aux = new ArrayList<Integer>();
		System.out.println("merge: low " + low + " hi " + hi + " mid " + mid);
		int i = low;
		int j = mid;
		for (int k = 0; k < (hi - low); k++) {
			if (i == mid)
				aux.add(arr[j++]);
			else if (j == hi)
				aux.add(arr[i++]);
			else if (arr[i] < arr[j])
				aux.add(arr[i++]);
			else
				aux.add(arr[j++]);
		}
		System.out.println(aux.toString());
		updateArr(arr, aux, low);
	}

	static void updateArr(int arr[], List<Integer> list, int low) {
		for (Integer i : list) {
			arr[low++] = i;
		}
	}

}
