package trees;

public class TreeNode<K extends Comparable<K>, V> extends Node<K, V, TreeNode<K, V>>{
	public TreeNode(TreeNode<K, V> left, TreeNode<K, V> right, K key, V value) {
		super(left, right, key, value);
	}
}
