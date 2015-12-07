/**
 * 
 */
package trees;

/**
 * @author alexey
 *
 */
public class AVLTree<K extends Comparable<K>, V> extends AbstractBST<K, V, AVLNode<K, V>> {

	@Override
	AVLNode<K, V> createNode(K key, V value) {
		return new AVLNode<>(null, null, key, value);
	}

}
