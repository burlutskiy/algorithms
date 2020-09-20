package lists;

import java.util.HashSet;
import java.util.Set;

import lists.LinkedList.Node;

/**
 * Write code to remove duplicates from an unsorted linked list. FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * Assuming we can use HashSet, if not we can sort if first and then remove
 * duplicates
 * 
 * @param list
 */

public class DeleteDublicates<T extends Comparable<T>> {
	
	private final LinkedList<T> list;
	
	public DeleteDublicates(LinkedList<T> list) {
		this.list = list;
	}

	public void deleteDuplicates() {
		Node<T> root = list.root;
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

}
