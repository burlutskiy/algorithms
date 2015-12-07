package trees;

/**
 * @author burlutal
 *
 */
public class RedBlackNode<K extends Comparable<K>, V> extends Node<K,V,RedBlackNode<K,V>> {
	protected boolean color;
	
	public RedBlackNode(K key, V value) {
		super(null, null, key, value);
		this.color = true;
	}
	
	boolean isRed() {
		return this.color;
	}

}
