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
		return balance(super.put(node, key, newNode));
	}

	private AVLNode<K, V> balance(AVLNode<K, V> node) {
		if (rightHeavy(node, true)) {
			if (leftHeavy(node.right, false))
				node = rotateRightLeft(node);
			else
				node = rotateLeft(node);
		} else if (leftHeavy(node, true)) {
			if (rightHeavy(node.left, false))
				node = rotateLeftRight(node);
			else
				node = rotateRight(node);
		}
		return node;
	}

	protected AVLNode<K, V> remove(AVLNode<K, V> node, K key) {
		if (less(key, node.key)) {
			node.left = remove(node.left, key);
		} else if (greather(key, node.key)) {
			node.right = remove(node.right, key);
		} else {
            node = removeNode(node);
		}
		return balance(node);
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

	private boolean rightHeavy(AVLNode<K, V> node, boolean strict) {
		return height(node.right, 0) - height(node.left, 0) > (strict ? 1 : 0);
	}

	private boolean leftHeavy(AVLNode<K, V> node, boolean strict) {
		return height(node.left, 0) - height(node.right, 0) > (strict ? 1 : 0);
	}

}
