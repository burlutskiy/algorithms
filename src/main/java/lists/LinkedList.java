package lists;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @author burlutal
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {
	Node<T> root;
	Node<T> tail;
	int size = 0;

	static class Node<T> {
		Node<T> next;
		T value;

		@Override
		public String toString() {
			return String.valueOf(value);
		}

	}

	public void add(T value) {
		Node<T> node = new Node<>();
		node.value = value;
		if (root == null) {
			root = node;
		} else {
			tail.next = node;
			tail = tail.next;
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
		if (node.next != null)
			findRecursevely(node.next, k, result, counter);
		if (result.get() == null) {
			if (counter.get() == k) {
				result.set(node.value);
			} else {
				counter.incrementAndGet();
			}
		}
	}

	public void print() {
		System.out.println(this);
	}

	/**
	 * Assuming values in the list are not null
	 * 
	 * @param value
	 */
	public void rearangeAround(T value) {
		Node<T> lessTail = null;
		Node<T> lessRoot = null;
		Node<T> moreTail = null;
		Node<T> moreRoot = null;
		Node<T> node = root;
		Node<T> prev = null;
		while (node != null) {
			Node<T> nextNode = node.next;
			if (node.value.compareTo(value) != 0) {
				if (prev == null) {// root
					root = node.next;
				} else {
					prev.next = node.next;
				}
			}
			if (node.value.compareTo(value) > 0) {
				if (moreRoot == null) {
					moreTail = moreRoot = node;
				} else {
					moreTail.next = node;
				}
			} else if (node.value.compareTo(value) < 0) {
				if (lessRoot == null) {
					lessTail = lessRoot = node;
				} else {
					lessTail.next = node;
				}
			} else {
				prev = node;
			}
			node = nextNode;
		}
		lessTail.next = root;
		root = lessRoot;
		prev.next = moreRoot;
		tail = moreTail;
	}

	public boolean hasACycle() {
		Node<T> slow = root;
		Node<T> fast = slow;
		do {
			if (slow.next == null || fast.next == null || fast.next.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		} while (slow != fast && slow.next != null);
		return slow == fast;
	}

	/**
	 * Let us denote <br>
	 * m = steps to a cycle point <br>
	 * L = size of a loop<br>
	 * d = steps from a meet point ahead of the cycle point<br>
	 * x = fast: steps ahead of the meet point<br>
	 * y = slow: steps ahead of the meet point<br>
	 * then x = 2y & x = m + n*L - d & y = m + L - d; => <br>
	 * => m + n*L - d = 2(m + L - d) => d = m + (2-n)*L => <br>
	 * => d = m (mod L) which means the distance between a root and the cycle point is
	 * same a distance between the meeting point and the cycle point multiplied by some
	 * (2-n), which is doesn't matter, so that if we go from fast and root until
	 * we meet again and the meet point will be the cycle point.
	 */
	public Node<T> getCyclePoint() {
		Node<T> slow = root;
		Node<T> fast = slow;
		do {
			if (slow.next == null || fast.next == null || fast.next.next == null)
				return null;
			slow = slow.next;
			fast = fast.next.next;
		} while (slow != fast && slow.next != null);

		slow = root;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public LinkedList<Integer> sum(LinkedList<Integer> list2) {
		LinkedList<Integer> result = new LinkedList<>();
		sumInternal((Node<Integer>) this.root, list2.root, result, 0);
		return result;
	}

	private static void sumInternal(Node<Integer> node1, Node<Integer> node2, LinkedList<Integer> result, int add) {
		if (node1 != null || node2 != null || add > 0) {
			int res = (node1 != null ? node1.value : 0) + (node2 != null ? node2.value : 0) + add;
			if (res < 10) {
				result.add(res);
				sumInternal(node1 != null ? node1.next : null, node2 != null ? node2.next : null, result, 0);
			} else {
				result.add(res - 10);
				sumInternal(node1 != null ? node1.next : null, node2 != null ? node2.next : null, result, res / 10);
			}
		}
	}

	@Override
	public String toString() {
		Node<T> node = this.root;
		StringBuffer sb = new StringBuffer();
		int count = 0;
		do {
			sb.append(node.value);
			node = node.next;
			if (node != null)
				sb.append(",");
		} while (node != null && ++count <= size);
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.tail.next = list.root.next.next;
		System.out.println(list.getCyclePoint());
	}
}
