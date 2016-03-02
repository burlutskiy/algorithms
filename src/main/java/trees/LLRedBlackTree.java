package trees;

import java.util.LinkedList;
import java.util.Queue;

import utils.Pair;

public class LLRedBlackTree<K extends Comparable<K>, V> extends AbstractBST<K, V, RedBlackNode<K, V>> {

	public boolean isBalanced() {
		int black = 0;
		RedBlackNode<K, V> x = root;
		while (x != null) {
			if (!isRed(x))
				black++;
			x = x.left;
		}
		return isBalanced(root, black);
	}

	public void put(K key, V value) {
		super.put(key, value);
		root.color = false;
	}

	public Iterable<K> keys() {
		return null;
	}

	/**
	 * @param key
	 * @return Largest key <= a given key
	 */
	public K floor(K key) {
		return floor(root, key).key;
	}

	public RedBlackNode<K, V> floor(RedBlackNode<K, V> node, K key) {
		if (node == null)
			return null;
		int compareTo = key.compareTo(node.key);
		if (compareTo == 0)
			return node;
		if (compareTo < 0)
			return floor(node.left, key);
		RedBlackNode<K, V> t = floor(node.right, key);
		if (t != null)
			return t;
		else
			return node;
	}

	/**
	 * @param key
	 * @return Smallest key >= a given key
	 */
	public K ceiling(K key) {
		return ceiling(root, key).key;
	}

	public RedBlackNode<K, V> ceiling(RedBlackNode<K, V> node, K key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if (cmp == 0)
			return node;
		if (cmp > 0)
			return ceiling(node.right, key);
		RedBlackNode<K, V> t = ceiling(node.left, key);
		if (t != null)
			return t;
		else
			return node;
	}

	/**
	 * @param key
	 * @return number of keys less then a given key
	 */
	public int rank(K key) {
		return rank(key, root);
	}

	private int rank(K key, RedBlackNode<K, V> node) {
		if (node == null)
			return 0;
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			return rank(key, node.left);
		else if (cmp > 0)
			return 1 + size(node.left) + rank(key, node.right);
		else
			return size(node.left);
	}

	/**
	 * 
	 * @param k
	 * @return Return the kth smallest key in the symbol table.
	 */
	public K select(int k) {
		if (k < 0 || k >= size())
			throw new IllegalArgumentException();
		RedBlackNode<K, V> x = select(root, k);
		return x.key;
	}

	// the key of rank k in the subtree rooted at x
	private RedBlackNode<K, V> select(RedBlackNode<K, V> node, int k) {
		int t = size(node.left);
		if (t > k)
			return select(node.left, k);
		else if (t < k)
			return select(node.right, k - t - 1);
		else
			return node;
	}

	public Iterable<K> rangeSearch(K lo, K hi) {
		Queue<K> queue = new LinkedList<>();
		rangeSearch(root, queue, lo, hi);
		return queue;
	}

	private void rangeSearch(RedBlackNode<K, V> node, Queue<K> queue, K lo, K hi) {
		if(node == null)
			return;
		int cmplo = lo.compareTo(node.key);
		int cmphi = hi.compareTo(node.key);
		if(cmplo < 0) rangeSearch(node.left, queue, lo, hi);
		if(cmplo <= 0 && cmphi >= 0) queue.add(node.key);
		if(cmphi > 0) rangeSearch(node.right, queue, lo, hi);
	}


	public int rangeCount(K lo, K hi) {
        if (lo == null) throw new NullPointerException("first argument to size() is null");
        if (hi == null) throw new NullPointerException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
	}

	public String toString() {
		final int n = height();
		final StringBuilder sb = new StringBuilder();
		Queue<Pair<RedBlackNode<K, V>, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<RedBlackNode<K, V>, Integer>(root, 0));
		int lastLevel = 0;
		while (!queue.isEmpty()) {
			Pair<RedBlackNode<K, V>, Integer> pair = queue.poll();
			RedBlackNode<K, V> node = pair.first;
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
				sb.append(node.key).append(node.color ? "." : "");
			else
				sb.append(" ");
			for (int i = 0; i < numberOfSpaces; i++) {
				sb.append(" ");
			}
			sb.append(" ");
			if (level + 1 < n) {
				queue.add(new Pair<RedBlackNode<K, V>, Integer>(node == null || node.left == null ? null : node.left,
						level + 1));
				queue.add(new Pair<RedBlackNode<K, V>, Integer>(node == null || node.right == null ? null : node.right,
						level + 1));
			}
		}
		return sb.toString();
	}

	private void flipColors(RedBlackNode<K, V> node) {
		node.color = true;
		node.left.color = false;
		node.right.color = false;
	}

	private RedBlackNode<K, V> rotateLeft(RedBlackNode<K, V> h) {
		RedBlackNode<K, V> x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = x.left.color;
		x.left.color = true;
		updateSize(x);
		updateSize(h);
		return x;
	}

	private RedBlackNode<K, V> rotateRight(RedBlackNode<K, V> h) {
		RedBlackNode<K, V> x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = x.right.color;
		x.right.color = true;
		updateSize(x);
		updateSize(h);
		return x;
	}

	protected RedBlackNode<K, V> balance(RedBlackNode<K, V> h) {
		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);
		updateSize(h);
		return h;
	}

	private void updateSize(RedBlackNode<K, V> h) {
		h.n = size(h.left) + size(h.right) + 1;
	}

	protected boolean isBalanced(RedBlackNode<K, V> x, int black) {
		if (x == null)
			return black == 0;
		if (!isRed(x))
			black--;
		return isBalanced(x.left, black) && isBalanced(x.right, black);
	}

	protected boolean isRed(RedBlackNode<K, V> h) {
		if (h == null)
			return false;
		return h.isRed();
	}

	protected RedBlackNode<K, V> put(RedBlackNode<K, V> node, K key, RedBlackNode<K, V> newNode) {
		return balance(super.put(node, key, newNode));
	}

	RedBlackNode<K, V> createNode(K key, V value) {
		return new RedBlackNode<>(key, value);
	}

	public int size() {
		return size(root);
	}

	private int size(RedBlackNode<K, V> node) {
		if (node == null)
			return 0;
		return node.n;
	}
}
