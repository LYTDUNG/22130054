package Lab6;

import java.util.LinkedList;

public class Node<E> {

	private E data;
	private Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public String toString() {
		return data.toString();
	}

	public Node<E> getNext() {
		return null;
	}
}

//Tạo một lớp SinglyLinkedList<E> để quản lý các node
class SinglyLinkedList<E> {

	private Node<E> head; // Đầu của danh sách liên kết
	private Node<E> tail; // Cuối của danh sách liên kết
	private int size; // Số lượng node trong danh sách liên kết

	public SinglyLinkedList() {
		super();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getData();
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getData();
	}

	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e, null);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		E removedElement = head.getData();
		head = head.getNext();
		if (isEmpty()) {
			tail = null;
		}
		size--;
		return removedElement;
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		E removedElement = tail.getData();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node<E> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
		}
		size--;
		return removedElement;
	}

	// Thêm một phương thức getHead() để trả về node đầu tiên của danh sách liên kết
	public Node<E> getHead() {
		return head;
	}

	// Thêm một phương thức clear() để xóa tất cả các node của danh sách liên kết
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	public static void main(String[] args) {
		// Tạo một đối tượng SinglyLinkedList<Integer>
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		System.out.println("list size: " + list.size()); // 0
		System.out.println("list isEmpty: " + list.isEmpty()); // true

		// Thêm các phần tử vào đầu và cuối của list
		list.addFirst(10);
		list.addLast(20);
		list.addFirst(30);
		list.addLast(40);
		System.out.println("list size: " + list.size()); // 4
		System.out.println("list isEmpty: " + list.isEmpty()); // false

		// In ra phần tử đầu tiên và cuối cùng của list
		System.out.println("list first: " + list.first()); // 30
		System.out.println("list last: " + list.last()); // 40

		// Xóa phần tử đầu tiên và cuối cùng của list
		list.removeFirst();
		list.removeLast();
		System.out.println("list size: " + list.size()); // 2

		// In ra các phần tử còn lại của list
		Node<Integer> current = list.getHead();
		while (current != null) {
			System.out.print(current.getData() + " "); // 10 20
			current = current.getNext();
		}
		System.out.println();

		// Tạo một đối tượng SinglyLinkedList<String>
		SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
		System.out.println("list2 size: " + list2.size()); // 0

		// Thêm các phần tử vào đầu và cuối của list2
		list2.addFirst("Hello");
		list2.addLast("World");
		System.out.println("list2 size: " + list2.size()); // 2

		// In ra các phần tử của list2
		Node<String> current2 = list2.getHead();
		while (current2 != null) {
			System.out.print(current2.getData() + " "); // Hello World
			current2 = current2.getNext();
		}
		System.out.println();

		// Xóa tất cả các phần tử của list2
		list2.clear();
		System.out.println("list2 size: " + list2.size()); // 0
		System.out.println("list2 isEmpty: " + list2.isEmpty()); // true
	}
}
