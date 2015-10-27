package lists;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author burlutal
 */
public class LinkedList<T> implements List<T> {
	Node<T> root;
	Node<T> tail;

	class Node<T> {
		Node<T> next;
		T value;
	}

	public void add(T value) {
		Node<T> node = new Node<>();
		node.value = value;
		if (root == null) {
			root = node;
		} else {
			tail.next = node;
		}
		tail = node;
	}

	/**
	 * Assuming we can use HashSet, if not we can sort if first and then remove duplicates
	 * 
	 * @param list
	 */
	public void deleteDuplicates() {
		if (root == null || root.next == null)
			return;
		Set<T> set = new HashSet<>();
		Node<T> node = root;
		Node<T> prev = null;
		do {
			T value = node.value;
			if (set.contains(value)) {
				prev.next = node.next;
			} else {
				set.add(value);
				prev = node;
			}
			node = node.next;
		} while (node != null);
	}

	public void print() {
		Node<T> node = root;
		do {
			System.out.print(node.value);
			node = node.next;
			if(node != null)
				System.out.print(",");
		} while (node != null);
		System.out.println();
	}
}
