package trees;
/**
 * 
 * @author alexey
 *
 * @param <K> key
 * @param <V> value
 */
class Node<K extends Comparable<K>, V, N extends Node<K, V, N>> {
	N left, right;
	K key;
	V value;

	public Node(N left, N right, K key, V value) {
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
