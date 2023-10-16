package Lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyArray {
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] < array[j]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void insertionSort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int minIndex = 0;
			for (int j = 1; j <= i; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	public static void mergeSort(int[] array) {
		if (array.length > 1) {
			int mid = array.length / 2;
			int[] left = Arrays.copyOfRange(array, 0, mid);
			int[] right = Arrays.copyOfRange(array, mid, array.length);
			mergeSort(left);
			mergeSort(right);
			merge(array, left, right);
		}
	}

	public static void merge(int[] array, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] > right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			array[k] = right[j];
			j++;
			k++;
		}
	}

	public static void quickSort(int[] array2) {
        if (array2.length > 1) {
            // Khai báo và gán giá trị cho biến pivot
            int pivot = array2.length > 0 ? getPivot_MedianOfThree(array2) : 0;
            int[] left = partition(array2, pivot, true);
            int[] right = partition(array2, pivot, false);
            quickSort(left);
            quickSort(right);
            concatenate(array2, left, pivot, right);
        }
    }

    private static int getPivot_MedianOfThree(int[] array) {
        int first = array[0];
        int mid = array[array.length / 2];
        int last = array[array.length - 1];
        if ((first < mid && mid < last) || (last < mid && mid < first)) {
            return mid;
        } else if ((mid < first && first < last) || (last < first && first < mid)) {
            return first;
        } else {
            return last;
        }
    }

    private static int getPivot_First(int[] array) {
        return array[0];
    }

    private static int getPivot_Last(int[] array) {
        return array[array.length - 1];
    }

    private static int getPivot_Random(int[] array) {
        int randomIndex = (int) (Math.random() * array.length);
        return array[randomIndex];
    }

    private static int[] partition(int[] array, int pivot, boolean left) {
        List<Integer> list = new ArrayList<>();
        // Duyệt qua các phần tử của mảng, không bao gồm pivot
        for (int num : array) {
            if (num != pivot) {
                // Sử dụng toán tử ba ngôi để rút ngắn điều kiện
                list.add(left ? num < pivot ? num : null : num >= pivot ? num : null);
            }
        }
        // Loại bỏ các phần tử null trong danh sách
        list.removeAll(Collections.singleton(null));
        int[] subarray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            subarray[i] = list.get(i);
        }
        return subarray;
    }

    private static void concatenate(int[] array, int[] left, int pivot, int[] right) {
        for (int i = 0; i < left.length; i++) {
            array[i] = left[i];
        }
        array[left.length] = pivot;
        for (int i = 0; i < right.length; i++) {
            array[left.length + i + 1] = right[i];
        }
    }

	public static void main(String[] args) {

		int[] array = new int[] { 5, 1, 8, 3, 9, 2 };
		array = new int[] { 5, 1, 8, 3, 9, 2 };
		selectionSort(array);
		System.out.println(Arrays.toString(array));
		array = new int[] { 5, 1, 8, 3, 9, 2 };
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		array = new int[] { 5, 1, 8, 3, 9, 2 };
		insertionSort(array);
		System.out.println(Arrays.toString(array));
		array = new int[] { 5, 1, 8, 3, 9, 2 };
		mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		int[] array2 = new int[]{7, 4, 6, 10, 12, -1};
        // In ra mảng ban đầu
        System.out.println("Mảng ban đầu: " + Arrays.toString(array2));
        // Gọi phương thức quickSort để sắp xếp mảng
        quickSort(array2);
        // In ra mảng sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(array2));

        // Đặt đoạn code gọi các phương thức getPivot và partition trong một khối lệnh riêng
        {
            int pivot = getPivot_MedianOfThree(array2);
            System.out.println(pivot);

            pivot = getPivot_First(array2);
            System.out.println(pivot);

            pivot = getPivot_Last(array2);
            System.out.println(pivot);

            pivot = getPivot_Random(array2);
            System.out.println(pivot);

            int[] left = partition(array2, pivot, true);
            int[] right = partition(array2, pivot, false);
            System.out.println(Arrays.toString(left));
            System.out.println(Arrays.toString(right));
        }
    }
}