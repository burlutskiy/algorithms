package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utils.Pair;

/**
 *
 * Recursive implementation of binary search tree
 * 
 * @author burlutal
 *
 */
public class BST<K extends Comparable<K>, V> implements Tree<K, V> {
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
		public void visitNode(BST.TreeNode node, int level);
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

	public String toString() {
		final int n = height();
		final StringBuilder sb = new StringBuilder();
		Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<TreeNode, Integer>(root, 0));
		int lastLevel = 0;
		while (!queue.isEmpty()) {
			Pair<TreeNode, Integer> pair = queue.poll();
			BST<K, V>.TreeNode node = pair.first;
			int level = pair.second;
			if (lastLevel != level) {
				sb.append("\n");
				lastLevel = level;
			}
			int numberOfSpaces = numberOfSpaces(level, n);
			for (int i = 0; i < numberOfSpaces; i++) {
				sb.append(" ");
			}
			if (node != null)
				sb.append(node.key).append(":").append(node.value);
			else
				sb.append(" ");
			for (int i = 0; i < numberOfSpaces; i++) {
				sb.append(" ");
			}
			sb.append(" ");
			if (level + 1 < n) {
				queue.add(new Pair<TreeNode, Integer>(node == null || node.left == null ? null : node.left, level + 1));
				queue.add(new Pair<TreeNode, Integer>(node == null || node.right == null ? null : node.right, level + 1));
			}
		}
		return sb.toString();
	}

	private int numberOfSpaces(int l, int n) {
		return (int) Math.pow(2, n - l - 1) - 1;
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

	public void traversePreOrder(NodeVisitor visitor) {
		traversePreOrder(root, visitor, 0);
	}

	private void traversePreOrder(TreeNode node, NodeVisitor visitor, int depth) {
		if (node == null)
			return;
		visitor.visitNode(node, depth);
		traversePreOrder(node.left, visitor, depth + 1);
		traversePreOrder(node.right, visitor, depth + 1);
	}

	public void traverseInOrder(NodeVisitor visitor) {
		traverseInOrder(root, visitor, 0);
	}

	private void traverseInOrder(TreeNode node, NodeVisitor visitor, int depth) {
		if (node == null)
			return;
		traverseInOrder(node.left, visitor, depth + 1);
		visitor.visitNode(node, depth);
		traverseInOrder(node.right, visitor, depth + 1);
	}

	public void traversePostOrder(NodeVisitor visitor) {
		traversePostOrder(root, visitor, 0);
	}

	private void traversePostOrder(TreeNode node, NodeVisitor visitor, int depth) {
		if (node == null)
			return;
		traversePostOrder(node.left, visitor, depth + 1);
		traversePostOrder(node.right, visitor, depth + 1);
		visitor.visitNode(node, depth);
	}

	public void traverseBreadthFirstNonReqursive(NodeVisitor visitor) {
		Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<TreeNode, Integer>(root, 0));
		while (!queue.isEmpty()) {
			Pair<TreeNode, Integer> pair = queue.poll();
			BST<K, V>.TreeNode node = pair.first;
			visitor.visitNode(node, pair.second);
			if (node.left != null)
				queue.add(new Pair<TreeNode, Integer>(node.left, pair.second + 1));
			if (node.right != null)
				queue.add(new Pair<TreeNode, Integer>(node.right, pair.second + 1));
		}
	}

	public void traverseBreadthFirst(NodeVisitor visitor) {
		HashMap<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
		traverseBreadthFirst(root, 0, map);
		int depth = 0;
		while (map.get(depth) != null) {
			List<TreeNode> list = map.get(depth++);
			for (TreeNode treeNode : list) {
				visitor.visitNode(treeNode, depth - 1);
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

	public void reverse() {
		traversePreOrder(new NodeVisitor() {
			@Override
			public void visitNode(BST.TreeNode node, int level) {
				TreeNode tmp = node.left;
				node.left = node.right;
				node.right = tmp;
			}
		});
	}

	void rotateCW(TreeNode parent, TreeNode node) {
		if (node.left == null)
			return;
		TreeNode tmp = node.left;
		node.left = tmp.right;
		if (parent == null) {
			root = tmp;
		} else if (parent.left == node) {
			parent.left = tmp;
		} else {
			parent.right = tmp;
		}
		tmp.right = node;
	}

	void rotateCCW(TreeNode parent, TreeNode node) {
		if (node.right == null)
			return;
		TreeNode tmp = node.right;
		node.right = tmp.left;
		if (parent == null) {
			root = tmp;
		} else if (parent.right == node) {
			parent.right = tmp;
		} else {
			parent.left = tmp;
		}
		tmp.left = node;
	}

	@Override
	public int height() {
		return height(root, 0);
	}

	private int height(TreeNode node, int depth) {
		if (node == null)
			return depth;
		return Math.max(height(node.left, depth + 1), height(node.right, depth + 1));
	}
	
	public List<List<K>> rootToLeafPaths(){
		List<List<K>> paths = new LinkedList<>();
		rootToLeafPaths(new Stack<K>(), root, paths);
		return paths;
	}
	
	private void rootToLeafPaths(Stack<K> path, TreeNode node, List<List<K>> paths){
		path.push(node.key);
		try{
			if(node.left == null && node.right == null){
				paths.add(new LinkedList<>(path));
				return;
			}
			if(node.left != null)
				rootToLeafPaths(path, node.left, paths);
			if(node.right != null)
				rootToLeafPaths(path, node.right, paths);
		} finally {
			path.pop();
		}
	}
	
}
