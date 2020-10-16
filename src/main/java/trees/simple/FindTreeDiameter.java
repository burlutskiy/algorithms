package trees.simple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class FindTreeDiameter {
	Node root;

	class Node {
		Node left;
		Node right;
		int key;
		int leftPath;
		int rightPath;

		Node(int key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return "[" + key + "]";
		}

	}

	Node find(int k, Node node) {
		if (node == null)
			return null;
		if (node.key == k)
			return node;
		Node left = find(k, node.left);
		if (left != null)
			return left;
		return find(k, node.right);
	}

	void add(int parent, int child) {
		Node pnode = find(parent, root);
		if (pnode == null) {
			root = new Node(parent);
			add(parent, child);
		} else if (pnode.left == null)
			pnode.left = new Node(child);
		else if (pnode.right == null)
			pnode.right = new Node(child);
		else
			assert false;
	}

	void buildTree(int[][] tree) {
		for (int i = 0; i < tree.length; i++) {
			assert tree[i].length == 2;
			add(tree[i][0], tree[i][1]);
		}
	}

	int rank(Node node) {
		if (node == null)
			return 0;
		rank(node.left);
		rank(node.right);
		if (node.left != null)
			node.leftPath = Math.max(node.left.leftPath, node.left.rightPath) + 1;
		if (node.right != null)
			node.rightPath = Math.max(node.right.leftPath, node.right.rightPath) + 1;

		return longestPath = Math.max(longestPath, node.leftPath + node.rightPath);
	}

	int longestPath = 0;

	int treeDiameter(int n, int[][] tree) {
		buildTree(tree);
		return rank(root);
	}

	@Test
	public void test() {
		Assert.assertEquals(7, treeDiameter(10, new int[][] { { 2, 5 }, { 5, 7 }, { 5, 1 }, { 1, 9 }, { 1, 0 }, { 7, 6 }, { 6, 3 }, { 3, 8 }, { 8, 4 } }));
	}

	@Test
	@Ignore
	public void test2() {
		Assert.assertEquals(6, treeDiameter(10, new int[][] { { 1, 3 }, { 7, 3 }, { 5, 3 }, { 8, 7 }, { 4, 1 }, { 2, 3 }, { 9, 4 }, { 0, 8 }, { 6, 8 } }));
	}

}
