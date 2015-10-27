package lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @author burlutal
 */
public class LinkedList<T> implements List<T> {
	Node<T> root;
	Node<T> tail;
	int size = 0;

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
		size++;
	}

	/**
	 * Assuming we can use HashSet, if not we can sort if first and then remove
	 * duplicates
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

	public T nthToLast(int k) {
		if (k <= 0)
			return null;
		Node<T> p1 = root;
		Node<T> p2 = root;
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return null; // Error check
			p2 = p2.next;
		}
		if (p2 == null)
			return null;

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1.value;
	}

	public T nthToLastRecurcive(int k) {
		AtomicReference<T> result = new AtomicReference<>();
		AtomicInteger counter = new AtomicInteger();
		findRecursevely(root, k, result, counter);
		return result.get();
	}

	private void findRecursevely(Node<T> node, int k, AtomicReference<T> result, AtomicInteger counter) {
		if(node.next != null)
			findRecursevely(node.next, k, result, counter);
		if(result.get() == null){
			if(counter.get() == k){
				result.set(node.value);
			} else {
				counter.incrementAndGet();
			}
		}
	}

	public void print() {
		Node<T> node = root;
		do {
			System.out.print(node.value);
			node = node.next;
			if (node != null)
				System.out.print(",");
		} while (node != null);
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(1);
	}
}
