package trees;

/**
 * @author burlutal
 *
 */
public class RedBlackNode<K extends Comparable<K>, V> extends Node<K, V, RedBlackNode<K, V>> {
	protected boolean color;
	protected int n;
	public RedBlackNode(K key, V value) {
		super(null, null, key, value);
		this.color = true;
		this.n = 1;
	}

	boolean isRed() {
		return this.color;
	}

}
