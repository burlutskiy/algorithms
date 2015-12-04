package trees;

public interface Tree<K extends Comparable<K>, V> {

	V get(K key);

	boolean contains(K key);

	void put(K key, V value);

	V min();

	V max();

	V remove(K key);

	int height();

	default boolean less(K k1, K k2) {
		return k1.compareTo(k2) < 0;
	}

	default boolean lessOrEquals(K k1, K k2) {
		return k1.compareTo(k2) <= 0;
	}

	default boolean equals(K k1, K k2) {
		return k1.compareTo(k2) <= 0;
	}

	default boolean greather(K k1, K k2) {
		return k1.compareTo(k2) > 0;
	}

}