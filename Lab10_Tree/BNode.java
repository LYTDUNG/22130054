package Lab10_Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void add(E e) {
		int comp = data.compareTo(e);
		if (comp == 0) {
			// Duplicate values are not allowed, handle accordingly
		} else if (comp < 0) {
			if (right == null) {
				right = new BNode<>(e);
			} else {
				right.add(e);
			}
		} else {
			if (left == null) {
				left = new BNode<>(e);
			} else {
				left.add(e);
			}
		}
	}

	public boolean contains(E e) {
		int comp = e.compareTo(data);
		if (comp == 0) {
			return true;
		} else if (comp < 0) {
			return (left == null) ? false : left.contains(e);
		} else {
			return (right == null) ? false : right.contains(e);
		}
	}

	public int depth(E data) {
		return (this != null) ? depthHelper(data, 0) : -1;
	}

	private int depthHelper(E data, int currentDepth) {
		if (data.compareTo(this.data) == 0) {
			return currentDepth;
		} else if (data.compareTo(this.data) < 0 && left != null) {
			return left.depthHelper(data, currentDepth + 1);
		} else if (right != null) {
			return right.depthHelper(data, currentDepth + 1);
		} else {
			return -1;
		}
	}

	public int height() {
		return (this != null) ? heightHelper() - 1 : -1;
	}

	private int heightHelper() {
		int leftHeight = (left != null) ? left.heightHelper() : 0;
		int rightHeight = (right != null) ? right.heightHelper() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public int size() {
		return (this != null) ? sizeHelper() : 0;
	}

	private int sizeHelper() {
		int leftSize = (left != null) ? left.sizeHelper() : 0;
		int rightSize = (right != null) ? right.sizeHelper() : 0;
		return 1 + leftSize + rightSize;
	}

	public List<E> descendants(E e) {
		int comp = data.compareTo(e);
		List<E> re = new ArrayList<>();
		if (comp == 0) {
			if (left != null) {
				re.add(left.data);
				re.addAll(left.descendants(e));
			}
			if (right != null) {
				re.add(right.data);
				re.addAll(right.descendants(e));
			}
		}
		return re;
	}

	public List<E> ancestors(E e) {
		int comp = e.compareTo(data);
		List<E> re = new ArrayList<>();
		if (comp == 0) {
			return re;
		}
		if (comp < 0 && left != null) {
			if (left.contains(e)) {
				re.add(data);
				re.addAll(left.ancestors(e));
			}
		} else if (comp > 0 && right != null) {
			re.add(data);
			re.addAll(right.ancestors(e));
		}
		return re;
	}

	public E findMin() {
		return (left != null) ? left.findMin() : data;
	}

	public E findMax() {
		return (right != null) ? right.findMax() : data;
	}

	public BNode<E> remove(E e) {
		return this;
	}

	public List<E> descendantsHelper(E data) {
		List<E> descendantsList = new ArrayList<>();
		descendantsHelper(data, descendantsList);
		return descendantsList;
	}

	private void descendantsHelper(E data, List<E> descendantsList) {
		int comp = data.compareTo(this.data);
		if (comp == 0) {
			if (left != null) {
				descendantsList.add(left.data);
				left.descendantsHelper(data, descendantsList);
			}
			if (right != null) {
				descendantsList.add(right.data);
				right.descendantsHelper(data, descendantsList);
			}
		} else if (comp < 0 && left != null) {
			left.descendantsHelper(data, descendantsList);
		} else if (comp > 0 && right != null) {
			right.descendantsHelper(data, descendantsList);
		}
	}

	public List<E> ancestorsHelper(E data) {
		List<E> ancestorsList = new ArrayList<>();
		ancestorsHelper(data, ancestorsList);
		return ancestorsList;
	}

	private void ancestorsHelper(E data, List<E> ancestorsList) {
		int comp = data.compareTo(this.data);
		if (comp == 0) {
			// Do nothing, as the current node is the ancestor
		} else if (comp < 0 && left != null) {
			ancestorsList.add(this.data);
			left.ancestorsHelper(data, ancestorsList);
		} else if (comp > 0 && right != null) {
			ancestorsList.add(this.data);
			right.ancestorsHelper(data, ancestorsList);
		}
	}

	public void inorder() {
		if (left != null) {
			left.inorder();
		}
		System.out.print(data + " ");
		if (right != null) {
			right.inorder();
		}
	}

	public void preorder() {
		System.out.print(data + " ");
		if (left != null) {
			left.preorder();
		}
		if (right != null) {
			right.preorder();
		}
	}

	public void postorder() {
		if (left != null) {
			left.postorder();
		}
		if (right != null) {
			right.postorder();
		}
		System.out.print(data + " ");
	}

	public BNode<E> findNode(E data) {
		int comp = data.compareTo(this.data);
		if (comp == 0) {
			return this;
		} else if (comp < 0 && left != null) {
			return left.findNode(data);
		} else if (comp > 0 && right != null) {
			return right.findNode(data);
		}
		return null;
	}

	public E getData() {
		return data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public void setData(E data) {
		this.data = data;
	}
}
