package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utils.Pair;

/**
 * @author alexey
 *
 */
public abstract class AbstractBST<K extends Comparable<K>, V, N extends Node<K, V, N>> extends AbstractBinaryTree<K, V, N> {
	public V get(K key) {
		return get(root, key).value;
	}

	protected N get(N node, K key) {
		if (node == null)
			return null;
		if (less(key, node.key)) {
			return get(node.left, key);
		} else if (greather(key, node.key)) {
			return get(node.right, key);
		} else
			return node;
	}

	public boolean contains(K key) {
		return contains(root, key);
	}

	protected boolean contains(N node, K key) {
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
		root = put(root, key, createNode(key, value));
	}

	protected N put(N node, K key, N newNode) {
		if (node == null) {
			return newNode;
		} else {
			if (less(key, node.key)) {
				node.left = put(node.left, key, newNode);
			} else if(greather(key, node.key)) {
				node.right = put(node.right, key, newNode);
			} else {
				node.value = newNode.value;
			}
		}
		return node;
	}

	public V min() {
		if (root == null)
			return null;
		return min(root).value;
	}

	protected N min(N node) {
		if (node.left == null)
			return node;
		return min(node.left);
	}

	public V max() {
		if (root == null)
			return null;
		return max(root).value;
	}

	protected N max(N node) {
		if (node.right == null)
			return node;
		else
			return max(node.right);
	}

	public void deleteMax() {
		if (root == null)
			return;
		root = deleteMax(root);
	}

	protected N deleteMax(N node) {
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

	protected N deleteMin(N node) {
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

	public void remove(K key) {
		if (root == null)
			return;
		root = remove(root, key);
	}
	
	protected N remove(N node, K key) {
		if (less(key, node.key)) {
			node.left = remove(node.left, key);
		} else if (greather(key, node.key)) {
			node.right = remove(node.right, key);
		} else {
			node = removeNode(node);
		}
		return node;
	}

	protected N removeNode(N node) {
		if (node.right == null) return node.left;
		if (node.left  == null) return node.right;
		N min = min(node.right);
		node.right = deleteMin(node.right);
		node.key = min.key;
		node.value = min.value;
		return node;
	}
	
	public int height() {
		return height(root, 0);
	}

	protected int height(N node, int depth) {
		if (node == null)
			return depth;
		return Math.max(height(node.left, depth + 1), height(node.right, depth + 1));
	}
	
	public void traversePreOrder(NodeVisitor<K,V,N> visitor) {
		traversePreOrder(root, visitor, 0);
	}

	private void traversePreOrder(N node, NodeVisitor<K,V,N> visitor, int depth) {
		if (node == null)
			return;
		visitor.visitNode(node, depth);
		traversePreOrder(node.left, visitor, depth + 1);
		traversePreOrder(node.right, visitor, depth + 1);
	}

	public void traverseInOrder(NodeVisitor<K,V,N> visitor) {
		traverseInOrder(root, visitor, 0);
	}

	private void traverseInOrder(N node, NodeVisitor<K,V,N> visitor, int depth) {
		if (node == null)
			return;
		traverseInOrder(node.left, visitor, depth + 1);
		visitor.visitNode(node, depth);
		traverseInOrder(node.right, visitor, depth + 1);
	}

	public void traversePostOrder(NodeVisitor<K,V,N> visitor) {
		traversePostOrder(root, visitor, 0);
	}

	private void traversePostOrder(N node, NodeVisitor<K,V,N> visitor, int depth) {
		if (node == null)
			return;
		traversePostOrder(node.left, visitor, depth + 1);
		traversePostOrder(node.right, visitor, depth + 1);
		visitor.visitNode(node, depth);
	}

	public void traverseBreadthFirst(NodeVisitor<K,V,N> visitor) {
		Queue<Pair<N, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<N, Integer>(root, 0));
		while (!queue.isEmpty()) {
			Pair<N, Integer> pair = queue.poll();
			N node = pair.first;
			visitor.visitNode(node, pair.second);
			if (node.left != null)
				queue.add(new Pair<N, Integer>(node.left, pair.second + 1));
			if (node.right != null)
				queue.add(new Pair<N, Integer>(node.right, pair.second + 1));
		}
	}
	
	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(N node) {
		if (node == null)
			return true;
		if ((node.left != null && greatherOrEquals(max(node.left).key, node.key))
				|| (node.right != null && lessOrEquals(min(node.right).key, node.key)))
			return false;
		return isBST(node.left) && isBST(node.right);
	}

	public List<List<K>> rootToLeafPaths(){
		List<List<K>> paths = new LinkedList<>();
		rootToLeafPaths(new Stack<K>(), root, paths);
		return paths;
	}
	
	private void rootToLeafPaths(Stack<K> path, N node, List<List<K>> paths){
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

	public int size() {
		return size;
	}

	public String toString() {
		final int n = height();
		final StringBuilder sb = new StringBuilder();
		Queue<Pair<N, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<N, Integer>(root, 0));
		int lastLevel = 0;
		while (!queue.isEmpty()) {
			Pair<N, Integer> pair = queue.poll();
			N node = pair.first;
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
				sb.append(node.key);
			else
				sb.append(" ");
			for (int i = 0; i < numberOfSpaces; i++) {
				sb.append(" ");
			}
			sb.append(" ");
			if (level + 1 < n) {
				queue.add(new Pair<N, Integer>(node == null || node.left == null ? null : node.left, level + 1));
				queue.add(new Pair<N, Integer>(node == null || node.right == null ? null : node.right, level + 1));
			}
		}
		return sb.toString();
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	protected boolean isBalanced(N node) {
		if (node == null)
			return true;
		if (Math.abs(height(node.left, 0) - height(node.right, 0)) > 1)
			return false;
		else {
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}
	
	private int numberOfSpaces(int l, int n) {
		return (int) Math.pow(2, n - l - 1) - 1;
	}

}
