package trees;

/**
 *
 * Recursive implementation of binary search tree
 * 
 * @author burlutal
 *
 */
public class BST<K extends Comparable<K>, V> {
	TreeNode root;
	long size;

	class TreeNode {
		TreeNode left, right;
		K key;
		V value;

		public TreeNode(TreeNode left, TreeNode right, K key, V value) {
			super();
			this.left = left;
			this.right = right;
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[" + key + ":" + value + "," + left + "," + right + "]";
		}
	}

	public V get(K key) {
		return get(root, key);
	}

	private V get(TreeNode node, K key) {
		if (node == null)
			return null;
		int compareTo = key.compareTo(node.key);
		if (compareTo < 0) {
			return get(node.left, key);
		} else if (compareTo > 0) {
			return get(node.right, key);
		} else
			return node.value;
	}

	public boolean contains(K key) {
		return contains(root, key);
	}

	private boolean contains(TreeNode node, K key) {
		if (node == null)
			return false;
		int compareTo = key.compareTo(node.key);
		if (compareTo < 0) {
			return contains(node.left, key);
		} else if (compareTo > 0) {
			return contains(node.right, key);
		} else
			return true;
	}

	public void put(K key, V value) {
		root = put(root, key, new TreeNode(null, null, key, value));
	}

	private TreeNode put(TreeNode node, K key, TreeNode newNode) {
		if (node == null) {
			return newNode;
		} else {
			int compareTo = key.compareTo(node.key);
			if (compareTo <= 0) {
				node.left = put(node.left, key, newNode);
			} else {
				node.right = put(node.right, key, newNode);
			}
		}
		return node;
	}

	public V min() {
		if (root == null)
			return null;
		return min(root);
	}

	private V min(TreeNode node) {
		if (node.left == null)
			return node.value;
		return min(node.left);
	}

	public V max() {
		if (root == null)
			return null;
		return max(root);
	}

	private V max(TreeNode node) {
		if (node.right == null)
			return node.value;
		else
			return max(node.right);
	}

	public void deleteMax() {
		if (root == null)
			return;
		root = deleteMax(root);
	}

	private TreeNode deleteMax(TreeNode node) {
		if (node.right == null) {
			return null;
		} else {
			node.right = deleteMax(node.right);
		}
		return node;
	}

	public void deleteMin() {
		if (root == null)
			return;
		root = deleteMin(root);
	}

	private TreeNode deleteMin(TreeNode node) {
		if (node.left == null) {
			return null;
		} else {
			node.left = deleteMin(node.left);
		}
		return node;
	}

	public V remove(K key) {
		if (root == null)
			return null;
		return remove(null, root, key);
	}

	private V remove(TreeNode parent, TreeNode node, K key) {
		int compareTo = key.compareTo(node.key);
		if (compareTo < 0) {
			return remove(node, node.left, key);
		} else if (compareTo > 0) {
			return remove(node, node.right, key);
		} else {
			if (parent == null) {
				root = null;
			} else {
				if (parent == node.left) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			if (node.left != null)
				root = put(root, node.left.key, node.left);
			if (node.right != null)
				root = put(root, node.right.key, node.right);
			return node.value;
		}
	}

	@Override
	public String toString() {
		return root != null ? root.toString() : "";
	}

}
