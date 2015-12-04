package trees;

import trees.BST.TreeNode;

public class BTree<K extends Comparable<K>, V> implements Tree<K, V> {
	Node root;
	BTreeOfOrder type;

	static enum BTreeOfOrder {
		B2_3_4(4), B2_3(3);
		final int size;

		BTreeOfOrder(int size) {
			this.size = size;
		}
	}

	class Node {
		K key;
		V value;
		Node next;
		Node down;

		public Node() {
			super();
		}

	}

	public V get(K key) {
		return get(root, null, key);
	}

	private V get(Node node, Node next, K key) {
		if (node == null)
			return null;
		
		if(equals(key, node.key))
			return node.value;
		else if (less(key, node.key)) {
			return get(node.down, null, key);
		} else if (greather(key, node.key)) {
			return get(node.next, key);
		} else
			return node.value;
	}

	public boolean contains(K key) {
		return false;
	}

	public void put(K key, V value) {

	}

	public V min() {
		return null;
	}

	public V max() {
		return null;
	}

	public V remove(K key) {
		return null;
	}

	public int height() {
		return 0;
	}
}
