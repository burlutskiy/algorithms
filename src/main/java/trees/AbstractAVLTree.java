package trees;

/**
 * @author alexey
 *
 */
public abstract class AbstractAVLTree<K extends Comparable<K>, V, N extends Node<K, V, N>> extends AbstractBST<K,V,N> {

	protected N put(N node, K key, N newNode) {
		return balance(super.put(node, key, newNode));
	}

	@Override
	protected N deleteMax(N node) {
		return super.deleteMax(node);
	}

	@Override
	protected N deleteMin(N node) {
		return super.deleteMin(node);
	}

	protected N balance(N node) {
		if(node == null) return null;
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

	protected N remove(N node, K key) {
		if (less(key, node.key)) {
			node.left = remove(node.left, key);
		} else if (greather(key, node.key)) {
			node.right = remove(node.right, key);
		} else {
			node = removeNode(node);
		}
		return balance(node);
	}

	protected N rotateRight(N h) {
		N x = h.left;
		h.left = x.right;
		x.right = h;
		return x;
	}

	private N rotateLeftRight(N h) {
		h.left = rotateLeft(h.left);
		return rotateRight(h);
	}

	protected N rotateLeft(N h) {
		N x = h.right;
		h.right = x.left;
		x.left = h;
		return x;
	}

	private N rotateRightLeft(N h) {
		h.right = rotateRight(h.right);
		return rotateLeft(h);
	}

	protected boolean rightHeavy(N node, boolean strict) {
		return height(node.right) - height(node.left) > (strict ? 1 : 0);
	}

	protected boolean leftHeavy(N node, boolean strict) {
		return height(node.left) - height(node.right) > (strict ? 1 : 0);
	}

	public void clear() {
		root = null;
		size = 0;
	}

}
