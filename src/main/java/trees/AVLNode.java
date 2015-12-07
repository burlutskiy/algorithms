package trees;

/**
 * @author alexey
 *
 */
public class AVLNode<K extends Comparable<K>, V> extends Node<K, V, AVLNode<K, V>> {
	int lh; // left height
	int rh; // right height

	public AVLNode(AVLNode<K, V> left, AVLNode<K, V> right, K key, V value) {
		super(left, right, key, value);
	}
}
