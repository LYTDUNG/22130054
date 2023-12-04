package Lab10_Tree;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void add(E e) {
		if (root == null)
			root = new BNode<>(e);
		else
			this.root.add(e);
	}

	public void add(E... col) {
		for (E e : col) {
			add(e);
		}
	}

	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	public int depth(E data) {
		return (root != null) ? root.depth(data) : -1;
	}

	public int height() {
		return (root != null) ? root.height() : -1;
	}

	public int size() {
		return (root != null) ? root.size() : 0;
	}

	public boolean contains(E e) {
		if (root == null)
			return false;
		return this.root.contains(e);
	}

	public E findMin() {
		return (root != null) ? root.findMin() : null;
	}

	public E findMax() {
		return (root != null) ? root.findMax() : null;
	}

	public boolean remove(E e) {
		if (root == null) {
			return false;
		}
		boolean[] removed = { false };
		root = removeHelper(root, e, removed);
		return removed[0];
	}

	private BNode<E> removeHelper(BNode<E> node, E e, boolean[] removed) {
		if (node == null) {
			return null;
		}

		int comp = e.compareTo(node.getData());
		if (comp < 0) {
			node.setLeft(removeHelper(node.getLeft(), e, removed));
		} else if (comp > 0) {
			node.setRight(removeHelper(node.getRight(), e, removed));
		} else {
			// Node to be deleted found
			removed[0] = true;

			// Case 1: Node with only one child or no child
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			}

			// Case 2: Node with two children, get the inorder successor (smallest in the
			// right subtree)
			node.setData(findMinHelper(node.getRight()));

			// Delete the inorder successor
			node.setRight(removeHelper(node.getRight(), node.getData(), removed));
		}
		return node;
	}

	private E findMinHelper(BNode<E> node) {
		if (node.getLeft() == null) {
			return node.getData();
		}
		return findMinHelper(node.getLeft());
	}

	public List<E> descendants(E data) {
		BNode<E> node = findNode(data);
		return (node != null) ? node.descendants(data) : null;
	}

	public List<E> ancestors(E data) {
		BNode<E> node = findNode(data);
		return (node != null) ? node.ancestors(data) : null;
	}

	public void inorder() {
		if (root != null) {
			root.inorder();
		}
		System.out.println();
	}

	public void preorder() {
		if (root != null) {
			root.preorder();
		}
		System.out.println();
	}

	public void postorder() {
		if (root != null) {
			root.postorder();
		}
		System.out.println();
	}

	private BNode<E> findNode(E data) {
		return (root != null) ? root.findNode(data) : null;
	}

	public static void main(String[] args) {

		// Test BST
		BST<Integer> bst = new BST<>();
		int[] testValues = { 4, 10, 12, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90 };

		// Add test values to BST
		for (int value : testValues) {
			bst.add(value);
		}

		System.out.println("Inorder Traversal:");
		bst.inorder(); // Expect: 4 10 12 18 22 24 25 31 35 44 50 66 70 90

		System.out.println("Preorder Traversal:");
		bst.preorder(); // Expect: 4 10 18 12 22 25 24 31 35 50 44 66 70 90

		System.out.println("Postorder Traversal:");
		bst.postorder(); // Expect: 25 24 22 18 12 10 35 31 44 70 66 50 90 4

		System.out.println("Depth of 25: " + bst.depth(25)); // Expect: 2
		System.out.println("Height: " + bst.height()); // Expect: 4
		System.out.println("Size: " + bst.size()); // Expect: 14

		System.out.println("Contains 24: " + bst.contains(24)); // Expect: true
		System.out.println("Contains 100: " + bst.contains(100)); // Expect: false

		System.out.println("Min value: " + bst.findMin()); // Expect: 4
		System.out.println("Max value: " + bst.findMax()); // Expect: 90

		System.out.println("Descendants of 22: " + bst.descendants(22)); // Expect: [18, 24]
		System.out.println("Ancestors of 24: " + bst.ancestors(24)); // Expect: [25, 22]

		// Remove node with value 18
		bst.remove(18);
		System.out.println("Inorder Traversal after removing 18:");
		bst.inorder(); // Expect: 4 10 12 22 24 25 31 35 44 50 66 70 90
	}
}
