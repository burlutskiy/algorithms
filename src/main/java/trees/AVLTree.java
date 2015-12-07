package trees;

/**
 * @author alexey
 *
 */
public class AVLTree<K extends Comparable<K>, V> extends AbstractBST<K, V, AVLNode<K, V>> {

	AVLNode<K, V> createNode(K key, V value) {
		return new AVLNode<>(null, null, key, value);
	}

	protected AVLNode<K, V> put(AVLNode<K, V> node, K key, AVLNode<K, V> newNode) {
		node = super.put(node, key, newNode);
		if (rightHeavy(node)) {
			if (leftHeavy(node.right)) {
				node = rotateRightLeft(node);
			} else {
				node = rotateLeft(node);
			}
		} else if (leftHeavy(node)) {
			if (rightHeavy(node.left)) {
				node = rotateLeftRight(node);
			} else {
				node = rotateRight(node);
			}
		}
		return node;
	}

	private AVLNode<K, V> rotateRight(AVLNode<K, V> h) {
		AVLNode<K, V> x = h.left;
		h.left = x.right;
		x.right = h;
		return x;
	}

	private AVLNode<K, V> rotateLeftRight(AVLNode<K, V> h) {
		h.left = rotateLeft(h.left);
		return rotateRight(h);
	}

	private AVLNode<K, V> rotateLeft(AVLNode<K, V> h) {
		AVLNode<K, V> x = h.right;
		h.right = x.left;
		x.left = h;
		return x;
	}

	private AVLNode<K, V> rotateRightLeft(AVLNode<K, V> h) {
		h.right = rotateRight(h.right);
		return rotateLeft(h);
	}

	private boolean rightHeavy(AVLNode<K, V> node) {
		return height(node.right, 0) - height(node.left, 0) > 1;
	}

	private boolean leftHeavy(AVLNode<K, V> node) {
		return height(node.left, 0) - height(node.right, 0) > 1;
	}

}
