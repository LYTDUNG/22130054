package Lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public void growSize() {
		E[] newElements = (E[]) new Object[elements.length * 2];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}
		return elements[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}
		E oldElement = elements[i];
		elements[i] = e;
		return oldElement;
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}
		if (size == elements.length) {
			growSize();
		}
		for (int j = size - 1; j >= i; j--) {
			elements[j + 1] = elements[j];
		}
		elements[i] = e;
		size++;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}

		E removedElement = elements[i];
		for (int j = i + 1; j < size; j++) {
			elements[j - 1] = elements[j];
		}
		return removedElement;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			array[i] = elements[i];
		}
		return array;
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> copy = new MyArrayList<>(elements.length);
		for (int i = 0; i < size; i++) {
			copy.elements[i] = elements[i];
		}
		copy.size = size;
		return copy;
	}

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean remove(E e) {
		int index = indexOf(e);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}
	public static void main(String[] args) {
		// Tạo một đối tượng MyArrayList<Integer> với capacity mặc định
		MyArrayList<Integer> list1 = new MyArrayList<>();
		System.out.println("list1 size: " + list1.size()); // 0
		System.out.println("list1 isEmpty: " + list1.isEmpty()); // true

		// Thêm các phần tử vào list1
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(50);
		System.out.println("list1 size: " + list1.size()); // 5
		System.out.println("list1 isEmpty: " + list1.isEmpty()); // false

		// In ra các phần tử của list1
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " "); // 10 20 30 40 50
		}
		System.out.println();

		// Thay đổi phần tử tại vị trí 2 của list1 thành 25
		list1.set(2, 25);
		System.out.println("list1 element at index 2: " + list1.get(2)); // 25

		// Thêm phần tử 15 vào vị trí 0 của list1
		list1.add(0, 15);
		System.out.println("list1 element at index 0: " + list1.get(0)); // 15

		// Xóa phần tử tại vị trí cuối cùng của list1
		list1.remove(list1.size() - 1);
		System.out.println("list1 size: " + list1.size()); // 5

		// Xóa phần tử có giá trị là 25 khỏi list1
		list1.remove((Integer)25);
		System.out.println("list1 size: " + list1.size()); // 4

		// Kiểm tra xem list1 có chứa phần tử có giá trị là 40 hay không
		System.out.println("list1 contains 40: " + list1.contains(40)); // true

		// Tìm vị trí đầu tiên xuất hiện của phần tử có giá trị là 20 trong list1
		System.out.println("list1 index of 20: " + list1.indexOf(20)); // 2

		// Tìm vị trí cuối cùng xuất hiện của phần tử có giá trị là 10 trong list1
		System.out.println("list1 last index of 10: " + list1.lastIndexOf(10)); // 0

        // Tạo một đối tượng MyArrayList<String> với capacity là 5
        MyArrayList<String> list2 = new MyArrayList<>(5);
        System.out.println("list2 size: " + list2.size()); // 0

        // Thêm các phần tử vào list2
        list2.add("Hello");
        list2.add("World");
        list2.add("Java");
        System.out.println("list2 size: " + list2.size()); // 3

        // In ra các phần tử của list2
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " "); // Hello World Java
        }
        System.out.println();

        // Sắp xếp các phần tử của list2 theo thứ tự từ điển bằng cách sử dụng Comparator<String>
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };
        list2.sort(comp);

        // In ra các phần tử của list2 sau khi sắp xếp
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " "); // Hello Java World
        }
        System.out.println();

        // Tạo một bản sao của list2 bằng cách sử dụng hàm clone()
        MyArrayList<String> copy = list2.clone();
        System.out.println("copy size: " + copy.size()); // 3

        // In ra các phần tử của copy
        for (int i = 0; i < copy.size(); i++) {
            System.out.print(copy.get(i) + " "); // Hello Java World
        }
        System.out.println();

        // Xóa tất cả các phần tử của list2 bằng cách sử dụng hàm clear()
        list2.clear();
        System.out.println("list2 size: " + list2.size()); // 0
	}
}
