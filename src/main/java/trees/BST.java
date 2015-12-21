package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Recursive implementation of binary search tree
 * 
 * @author burlutal
 *
 */
public class BST<K extends Comparable<K>, V> extends AbstractBST<K, V, TreeNode<K, V>> {

	public void traverseBreadthFirstRecursive(TreeVisitor<K, V, TreeNode<K, V>> visitor) {
		HashMap<Integer, List<TreeNode<K, V>>> map = new HashMap<Integer, List<TreeNode<K, V>>>();
		traverseBreadthFirstRecursive(root, 0, map);
		int depth = 0;
		while (map.get(depth) != null) {
			List<TreeNode<K, V>> list = map.get(depth++);
			for (TreeNode<K, V> node : list) {
				visitor.visitNode(node, depth - 1);
			}
		}
	}

	private void traverseBreadthFirstRecursive(TreeNode<K, V> node, int depth, HashMap<Integer, List<TreeNode<K, V>>> map) {
		if (node != null) {
			List<TreeNode<K, V>> list = map.get(depth);
			if (list == null) {
				list = new LinkedList<>();
				map.put(depth, list);
			}
			list.add(node);
			traverseBreadthFirstRecursive(node.left, depth + 1, map);
			traverseBreadthFirstRecursive(node.right, depth + 1, map);
		}
	}

	public void reverse() {
		traversePreOrder(new TreeVisitor<K, V, TreeNode<K, V>>() {
			@Override
			public void visitNode(TreeNode<K, V> node, int level) {
				TreeNode<K, V> tmp = node.left;
				node.left = node.right;
				node.right = tmp;
			}
		});
	}

	void rotateRight(TreeNode<K, V> parent, TreeNode<K, V> node) {
		if (node.left == null)
			return;
		TreeNode<K, V> tmp = node.left;
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

	void rotateLeft(TreeNode<K, V> parent, TreeNode<K, V> node) {
		if (node.right == null)
			return;
		TreeNode<K, V> tmp = node.right;
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

	TreeNode<K, V> createNode(K key, V value) {
		return new TreeNode<>(null, null, key, value);
	}

}
