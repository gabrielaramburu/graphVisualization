package excersices.javarevisted;

class Ex17_BynarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 8, 543 };
		System.out.println("Result " + binarySearch(arr, 543));
		System.out.println("Result " + binarySearch(arr, 1));
		System.out.println("Result " + binarySearch(arr, 7));
		System.out.println("Result " + binarySearch(arr, 55));
	}

	private static boolean binarySearch(int[] arr, int x) {
		return binarySearchRecursive(arr, x, 0, arr.length);
	}

	private static boolean binarySearchRecursive(int[] arr, int x, int ini, int end) {
		System.out.println("ini " + ini + " fin " + end);
		if (end <= ini) {
			if (x == arr[ini])
				return true;
			else
				return false;
		}
		int mid = ini + (end - ini) / 2;
		System.out.println("mid " + mid + " va " + arr[mid]);
		if (arr[mid] == x)
			return true;
		if (x > arr[mid])
			return binarySearchRecursive(arr, x, mid + 1, end);
		else
			return binarySearchRecursive(arr, x, ini, mid - 1);
	}
}
