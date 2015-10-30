package lists;

public class LinkedList<T> {
	Node<T> root;
	Node<T> tail;
	int size;

	static class Node<T> {
		Node<T> next;
		T value;

		public Node(T value) {
			this.value = value;
		}
	}

	void add(T value) {
		if (root == null) {
			root = tail = new Node<T>(value);
		} else {
			tail.next = new Node<T>(value);
			tail = tail.next;
		}
	}

	void addIntoHead(T value) {
		if (root == null) {
			root = tail = new Node<T>(value);
		} else {
			Node<T> tmp = root.next;
			root.next = new Node<T>(value);
			root = tmp;
		}
	}

	LinkedList<Integer> sum(LinkedList<Integer> list2) {
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
				sumInternal(node1 != null ? node1.next : null, node2 != null ? node2.next : null, result, res/10);
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> node = root;
		while (node != null) {
			sb.append(node.value);
			node = node.next;
			if (node != null)
				sb.append(',');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(9);
		list1.add(9);
		list1.add(9);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(9);
		list2.add(9);
		list2.add(0);
		list2.add(0);
		list2.add(0);
		list2.add(1);
		

		LinkedList<Integer> list = list1.sum(list2);
		System.out.println(list);
	}
}
