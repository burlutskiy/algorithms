package trees;

/**
 * 
 * Pure AVLTree implementation.
 * 
 * @author burlutal
 *
 */
public class AVLTreeV1<K extends Comparable<K>, V> extends AbstractAVLTree<K, V, TreeNode<K, V>> {
	@Override
	TreeNode<K, V> createNode(K key, V value) {
		return new TreeNode<>(null, null, key, value);
	}
}
