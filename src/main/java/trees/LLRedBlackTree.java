package trees;

import java.util.LinkedList;
import java.util.Queue;

import utils.Pair;

public class LLRedBlackTree <K extends Comparable<K>, V> extends AbstractBST<K, V, RedBlackNode<K, V>> {

	@Override
	RedBlackNode<K, V> createNode(K key, V value) {
		return new RedBlackNode<>(key, value);
	}

	@Override
	protected RedBlackNode<K, V> put(RedBlackNode<K, V> node, K key, RedBlackNode<K, V> newNode) {
		return balance(super.put(node, key, newNode));
	}
	
	@Override
	public void put(K key, V value) {
		super.put(key, value);
		root.color = false;
	}

	protected RedBlackNode<K, V> balance(RedBlackNode<K, V> h) {
		if (isRed(h.left) && isRed(h.left.left) || (isRed(h.left) && isRed(h.left.right)))
			h = rotateRight(h);
		if(isRed(h.right) && isRed(h.right.right) || (isRed(h.right) && isRed(h.right.left)))
			h = rotateLeft(h);
		return h;
	}

	private RedBlackNode<K, V> rotateRight(RedBlackNode<K, V> h) {
		RedBlackNode<K, V> x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = x.right.color;
		x.right.color = true;
		return x;
	}

	private RedBlackNode<K, V> rotateLeft(RedBlackNode<K, V> h) {
		RedBlackNode<K, V> x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = x.left.color;
		x.left.color = true;
		return x;
	}

	protected boolean isRed(RedBlackNode<K, V> h) {
		if (h == null)
			return false;
		return h.isRed();
	}
	
    public boolean isBalanced() { 
        int black = 0;
        RedBlackNode<K, V> x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(root, black);
    }

    protected boolean isBalanced(RedBlackNode<K, V> x, int black) {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
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

	public static void main(String[] args) {
		LLRedBlackTree<Integer, Integer> tree = new LLRedBlackTree<>();
//		String[] s = "47 21 93 16 24 71 95 13 20 70 72 94 50".split(" ");
		String[] s = "23 11 56 10 20 34 92 15 32 40".split(" ");
		for (int i = 0; i < s.length; i++) {
			int k = Integer.parseInt(s[i]);
			tree.put(k, k);
		}
		System.out.println(tree);
	}
}
