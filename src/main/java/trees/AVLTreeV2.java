package trees;

import java.util.LinkedList;
import java.util.Queue;

import utils.Pair;

/**
 * 
 * AVLTree version based on AVLNode with height. Height is revalued every alteration on the tree.
 * Consumes more memory then AVLTreeV1 but more faster on put/delete operations.
 * 
 * @author Alexey Burlutskiy
 *
 */
public class AVLTreeV2<K extends Comparable<K>, V> extends AbstractAVLTree<K, V, AVLNode<K, V>> {

	@Override
	AVLNode<K, V> createNode(K key, V value) {
		return new AVLNode<>(null, null, key, value);
	}

	protected AVLNode<K, V> put(AVLNode<K, V> node, K key, AVLNode<K, V> newNode) {
		node = super.put(node, key, newNode);
		updateHeight(node);
		return node;
	}

	@Override
	protected AVLNode<K, V> deleteMax(AVLNode<K, V> node) {
		node = super.deleteMax(node);
		updateHeight(node);
		return node;
	}

	@Override
	protected AVLNode<K, V> deleteMin(AVLNode<K, V> node) {
		node = super.deleteMin(node);
		updateHeight(node);
		return node;
	}

	private void updateHeight(AVLNode<K, V> node) {
		if (node == null)
			return;
		node.height = height(node);
	}

	protected AVLNode<K, V> rotateRight(AVLNode<K, V> h) {
		AVLNode<K, V> x = h.left;
		h.left = x.right;
		x.right = h;
		updateHeight(h);
		updateHeight(x);
		return x;
	}

	protected AVLNode<K, V> rotateLeft(AVLNode<K, V> h) {
		AVLNode<K, V> x = h.right;
		h.right = x.left;
		x.left = h;
		updateHeight(h);
		updateHeight(x);
		return x;
	}
	
	protected boolean rightHeavy(AVLNode<K, V> node, boolean strict) {
		int rightHeight = node.right != null ? node.right.height : 0;
		int leftHeight = node.left != null ? node.left.height : 0;
		return rightHeight - leftHeight > (strict ? 1 : 0);
	}

	protected boolean leftHeavy(AVLNode<K, V> node, boolean strict) {
		int rightHeight = node.right != null ? node.right.height : 0;
		int leftHeight = node.left != null ? node.left.height : 0;
		return leftHeight - rightHeight > (strict ? 1 : 0);
	}

	public String toString() {
		final int n = height();
		final StringBuilder sb = new StringBuilder();
		Queue<Pair<AVLNode<K, V>, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<AVLNode<K, V>, Integer>(root, 0));
		int lastLevel = 0;
		while (!queue.isEmpty()) {
			Pair<AVLNode<K, V>, Integer> pair = queue.poll();
			AVLNode<K, V> node = pair.first;
			int level = pair.second;
			if (lastLevel != level) {
				sb.append("\n");
				lastLevel = level;
			}
			int numberOfSpaces = numberOfSpaces(level, n);
			for (int i = 0; i < numberOfSpaces; i++) {
				sb.append(" ");
			}
			if (node != null)
				sb.append(node.key).append("(").append(node.height).append(")");
			else
				sb.append(" ");
			for (int i = 0; i < numberOfSpaces; i++) {
				sb.append(" ");
			}
			sb.append(" ");
			if (level + 1 < n) {
				queue.add(new Pair<AVLNode<K, V>, Integer>(node == null || node.left == null ? null : node.left,
						level + 1));
				queue.add(new Pair<AVLNode<K, V>, Integer>(node == null || node.right == null ? null : node.right,
						level + 1));
			}
		}
		return sb.toString();
	}
}
