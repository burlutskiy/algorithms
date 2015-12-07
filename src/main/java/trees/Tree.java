package trees;

/**
 * 
 * @author alexey
 *
 * @param <K>
 *            key
 * @param <V>
 *            value
 */
interface Tree<K extends Comparable<K>, V, N extends Node<K, V, N>> {

	V get(K key);

	boolean contains(K key);

	void put(K key, V value);

	V min();

	V max();

	void remove(K key);

	int height();

	void deleteMax();

	void deleteMin();

	int size();

	void traversePreOrder(NodeVisitor<K, V, N> visitor);

	void traverseInOrder(NodeVisitor<K, V, N> visitor);

	void traversePostOrder(NodeVisitor<K, V, N> visitor);

	void traverseBreadthFirst(NodeVisitor<K, V, N> visitor);

	boolean isBST();
	
	boolean isBalanced();
	
	default boolean less(K k1, K k2) {
		return k1.compareTo(k2) < 0;
	}

	default boolean lessOrEquals(K k1, K k2) {
		return k1.compareTo(k2) <= 0;
	}

	default boolean greatherOrEquals(K k1, K k2) {
		return k1.compareTo(k2) >= 0;
	}

	default boolean equals(K k1, K k2) {
		return k1.compareTo(k2) == 0;
	}

	default boolean greather(K k1, K k2) {
		return k1.compareTo(k2) > 0;
	}
	

}