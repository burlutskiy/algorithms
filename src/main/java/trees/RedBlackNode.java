package trees;

/**
 * @author burlutal
 *
 */
public class RedBlackNode<K extends Comparable<K>, V> extends Node<K,V,RedBlackNode<K,V>> {
	protected boolean color;
	
	public RedBlackNode(RedBlackNode<K, V> left, RedBlackNode<K, V> right, K key, V value) {
		super(left, right, key, value);
	}

}
