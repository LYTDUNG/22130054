package order;

import java.util.Arrays;
import java.util.Comparator;

public class TestOrder {
	public static void main(String[] args) {
		Product p1 = new Product("001", "Coca", 10.0, "Soft Drink");
		Product p2 = new Product("002", "Chips", 5.0, "Snack");
		Product p3 = new Product("003", "Coca", 7.0, "Soft Drink");
		Product p4 = new Product("004", "Garham Cookie", 3.0, "Cookie");
		OrderItem oit1 = new OrderItem(p1, 2);
		OrderItem oit2 = new OrderItem(p2, 2);
		OrderItem oit3 = new OrderItem(p3, 3);
		OrderItem oit4 = new OrderItem(p4, 1);
		OrderItem[] item = { oit1, oit2, oit3, oit4 };

		Integer[] arr = { 1, 3, 0, 2, 4 };
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		String arrString = Arrays.toString(arr);
		System.out.println(arrString);

		    System.out.println("Selection sort:");
		    System.out.println("Before sorting:");
		    System.out.println(Arrays.toString(item));
		    Order.selectionSort(item);
		    System.out.println("After sorting:");
		    System.out.println(Arrays.toString(item));

		    System.out.println("Bubble sort:");
		    System.out.println("Before sorting:");
		    System.out.println(Arrays.toString(item));
		    Order.bubbleSort(item);
		    System.out.println("After sorting:");
		    System.out.println(Arrays.toString(item));

		    System.out.println("Insertion sort:");
		    System.out.println("Before sorting:");
		    System.out.println(Arrays.toString(item));
		    Order.insertionSort(item);
		    System.out.println("After sorting:");
		    System.out.println(Arrays.toString(item));
		}
	}

