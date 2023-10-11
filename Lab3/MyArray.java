package Lab3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	private int recursiveLinearSearchHelper(int target, int start) {
		if (start >= array.length) {
			return -1;
		} else {
			if (array[start] == target) {
				return start;
			} else {
				return recursiveLinearSearchHelper(target, start + 1);
			}
		}
	}

	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelper(target, 0);
	}

	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// a helper method to sort the array using bubble sort
	private int[] sort(int[] array) {
		int[] sortedArray = array.clone(); // make a copy of the original array
		for (int i = 0; i < sortedArray.length - 1; i++) {
			for (int j = 0; j < sortedArray.length - i - 1; j++) {
				if (sortedArray[j] > sortedArray[j + 1]) {
					// swap the adjacent elements if they are in wrong order
					int temp = sortedArray[j];
					sortedArray[j] = sortedArray[j + 1];
					sortedArray[j + 1] = temp;
				}
			}
		}
		return sortedArray;
	}

	public int recursiveBinarySearch(int target) {
		int[] sortedArray = sort(array); // sort the array before applying binary search
		return recursiveBinarySearchHelper(target, 0, sortedArray.length - 1);
	}

	private int recursiveBinarySearchHelper(int target, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				return recursiveBinarySearchHelper(target, mid + 1, high);
			} else {
				return recursiveBinarySearchHelper(target, low, mid - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray myArray = new MyArray(array);
		// test cases for linear search
		// System.out.println("Iterative linear search for " + array[0] + ": " + myArray.iterativeLinearSearch(array[0])); // 0
		System.out.println("Iterative linear search for " + array[3] + ": " + myArray.iterativeLinearSearch(array[3]));
		// System.out.println("Iterative linear search for " + array[7] + ": " + myArray.iterativeLinearSearch(array[7]));
		System.out.println("Iterative linear search for " + 15 + ": " + myArray.iterativeLinearSearch(15));
		// test cases for binary search
		// System.out.println("Iterative binary search for " + array[0] + ": " + myArray.iterativeBinarySearch(array[0]));
		// System.out.println("Iterative binary search for " + array[3] + ": " + myArray.iterativeBinarySearch(array[3]));
		// System.out.println("Iterative binary search for " + array[7] + ": " + myArray.iterativeBinarySearch(array[7]));
		// System.out.println("Iterative binary search for " + 15 + ": " + myArray.iterativeBinarySearch(15));
	}

}
