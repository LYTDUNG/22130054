package order;

public class Order {
	private OrderItem[] items;
	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}
	public double cost() {
		return 0.0;
	}
	public boolean contains(Product p) {
		return false;
	}
	public Product[] filter(String type) {
		return null;
	}
	public static void selectionSort(OrderItem[] array) {
	  for (int i = 0; i < array.length - 1; i++) {
	    int maxIndex = i;
	    for (int j = i + 1; j < array.length; j++) {
	      if (array[j].getProduct().getPrice() > array[maxIndex].getProduct().getPrice()) {
	        maxIndex = j;
	      }
	    }
	    OrderItem temp = array[i];
	    array[i] = array[maxIndex];
	    array[maxIndex] = temp;
	  }
	}

	public static void bubbleSort(OrderItem[] array) {
	  boolean swapped = true;
	  while (swapped) {
	    swapped = false;
	    for (int i = 0; i < array.length - 1; i++) {
	      if (array[i].getProduct().getPrice() < array[i + 1].getProduct().getPrice()) {
	        OrderItem temp = array[i];
	        array[i] = array[i + 1];
	        array[i + 1] = temp;
	        swapped = true;
	      }
	    }
	  }
	}
	public static void insertionSort(OrderItem[] array) {
	  for (int i = 1; i < array.length; i++) {
	    OrderItem current = array[i];
	    int j = i - 1;
	    while (j >= 0 && array[j].getProduct().getPrice() < current.getProduct().getPrice()) {
	      array[j + 1] = array[j];
	      j--;
	    }
	    array[j + 1] = current;
	  }
	}


}

