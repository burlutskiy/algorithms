package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	interface NodeVisitor {
		public void visitNode(BST.TreeNode node);
	}

	public V get(K key) {
		return get(root, key);
	}

	private V get(TreeNode node, K key) {
		if (node == null)
			return null;
		if (less(key, node.key)) {
			return get(node.left, key);
		} else if (greather(key, node.key)) {
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
			if (lessOrEquals(key, node.key)) {
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
		return min(root).value;
	}

	private TreeNode min(TreeNode node) {
		if (node.left == null)
			return node;
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
			if (node.left != null)
				return node.left;
			else
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
			if (node.right != null)
				return node.right;
			else
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
		if (less(key, node.key)) {
			return remove(node, node.left, key);
		} else if (greather(key, node.key)) {
			return remove(node, node.right, key);
		} else {
			if (parent == null) {
				root = null;
				if (node.left != null)
					root = put(root, node.left.key, node.left);
				if (node.right != null)
					root = put(root, node.right.key, node.right);
			} else {
				if (parent.left == node) {
					parent.left = null;
					if (node.left != null)
						parent.left = put(parent.left, node.left.key, node.left);
					if (node.right != null)
						root = put(root, node.right.key, node.right);
				} else {
					parent.right = null;
					if (node.right != null)
						parent.right = put(parent.right, node.right.key, node.right);
					if (node.left != null)
						root = put(root, node.left.key, node.left);
				}
			}
			return node.value;
		}
	}

	@Override
	public String toString() {
		return root != null ? root.toString() : "";
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(TreeNode node) {
		if (node == null)
			return true;
		if ((node.left != null && greather(min(node.left).key, node.key))
				|| (node.right != null && lessOrEquals(min(node.right).key, node.key)))
			return false;
		if (!isBST(node.left))
			return false;
		if (!isBST(node.right))
			return false;
		return true;
	}

	private boolean lessOrEquals(K k1, K k2) {
		return k1.compareTo(k2) <= 0;
	}

	private boolean less(K k1, K k2) {
		return k1.compareTo(k2) < 0;
	}

	private boolean greather(K k1, K k2) {
		return k1.compareTo(k2) > 0;
	}

	public void traversePreOrder(NodeVisitor visitor) {
		traversePreOrder(root, visitor);
	}

	private void traversePreOrder(TreeNode node, NodeVisitor visitor) {
		if (node == null)
			return;
		visitor.visitNode(node);
		traversePreOrder(node.left, visitor);
		traversePreOrder(node.right, visitor);
	}

	public void traverseInOrder(NodeVisitor visitor) {
		traverseInOrder(root, visitor);
	}

	private void traverseInOrder(TreeNode node, NodeVisitor visitor) {
		if (node == null)
			return;
		traverseInOrder(node.left, visitor);
		visitor.visitNode(node);
		traverseInOrder(node.right, visitor);
	}

	public void traversePostOrder(NodeVisitor visitor) {
		traversePostOrder(root, visitor);
	}

	private void traversePostOrder(TreeNode node, NodeVisitor visitor) {
		if (node == null)
			return;
		traversePostOrder(node.left, visitor);
		traversePostOrder(node.right, visitor);
		visitor.visitNode(node);
	}

	public void traverseBreadthFirstNonReqursive(NodeVisitor visitor) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			visitor.visitNode(node);
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
	}
	
	public void traverseBreadthFirst(NodeVisitor visitor) {
		HashMap<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
		traverseBreadthFirst(root, 0, map);
		int depth = 0;
		while (map.get(depth) != null) {
			List<TreeNode> list = map.get(depth++);
			for (TreeNode treeNode : list) {
				visitor.visitNode(treeNode);
			}
		}
	}

	private void traverseBreadthFirst(TreeNode node, int depth, HashMap<Integer, List<TreeNode>> map) {
		if (node != null) {
			List<TreeNode> list = map.get(depth);
			if (list == null) {
				list = new LinkedList<>();
				map.put(depth, list);
			}
			list.add(node);
			traverseBreadthFirst(node.left, depth + 1, map);
			traverseBreadthFirst(node.right, depth + 1, map);
		}
	}
}
