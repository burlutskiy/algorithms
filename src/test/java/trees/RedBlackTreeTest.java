package trees;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RedBlackTreeTest {
	LLRedBlackTree<Integer, Integer> tree = new LLRedBlackTree<>();

	@Test
	public void test1() {
		tree.put(2, 2);
		tree.put(0, 0);
		tree.put(1, 1);
		tree.put(3, 3);
		TraversalSequence<Integer, Integer, RedBlackNode<Integer, Integer>> sequence = new TraversalSequence<>();
		tree.traverseBreadthFirst(sequence);
		Assert.assertArrayEquals(new Integer[] { 1, 0, 3, 2 }, sequence.getSequence().toArray(new Integer[sequence.getSequence().size()]));
	}

	@Test
	public void test2() {
		tree.put(2, 2);
		tree.put(0, 0);
		tree.put(3, 3);
		tree.put(1, 1);
		TraversalSequence<Integer, Integer, RedBlackNode<Integer, Integer>> sequence = new TraversalSequence<>();
		tree.traverseBreadthFirst(sequence);
		Assert.assertArrayEquals(new Integer[] { 2, 1, 3, 0 }, sequence.getSequence().toArray(new Integer[sequence.getSequence().size()]));
	}

	@Test
	public void test() {
		String test = "S E A R C H E X A M P L E";
		String[] keys = test.split(" ");
		LLRedBlackTree<String, Integer> st = new LLRedBlackTree<String, Integer>();
		for (int i = 0; i < keys.length; i++) {
			st.put(keys[i], i);
			Assert.assertTrue(tree.isBalanced());
		}
	}

	@Test
	public void testRedNodes() {
		tree = new LLRedBlackTree<>();
		String[] s = "47 21 93 16 24 71 95 13 20 70 72 94 50".split(" ");
		for (int i = 0; i < s.length; i++) {
			int k = Integer.parseInt(s[i]);
			tree.put(k, k);
		}
		final List<Integer> list = new ArrayList<>();
		TreeVisitor<Integer, Integer, RedBlackNode<Integer, Integer>> visitor = new TreeVisitor<Integer, Integer, RedBlackNode<Integer, Integer>>() {
			public void visitNode(RedBlackNode<Integer, Integer> node, int level) {
				if (node.color)
					list.add(node.key);
			}
		};
		tree.traverseBreadthFirst(visitor);
		Assert.assertArrayEquals(new Integer[] { 16, 71, 94, 50 }, list.toArray(new Integer[list.size()]));
	}

	@Test
	public void testRedNodes2() {
		tree = new LLRedBlackTree<>();
		String[] s = "23 11 56 10 20 34 92 15 32 40 71 51 68".split(" ");
		for (int i = 0; i < s.length; i++) {
			int k = Integer.parseInt(s[i]);
			tree.put(k, k);
		}
		final List<Integer> list = new ArrayList<>();
		TreeVisitor<Integer, Integer, RedBlackNode<Integer, Integer>> visitor = new TreeVisitor<Integer, Integer, RedBlackNode<Integer, Integer>>() {
			public void visitNode(RedBlackNode<Integer, Integer> node, int level) {
				if (node.color)
					list.add(node.key);
			}
		};
		tree.traverseBreadthFirst(visitor);
		System.out.println(tree);
		Assert.assertEquals(56, tree.root.key.intValue());
		Assert.assertArrayEquals(new Integer[] { 23, 15, 40 }, list.toArray(new Integer[list.size()]));
	}

	@Test
	public void testRedNodes3() {
		tree = new LLRedBlackTree<>();
		String[] s = "71 48 87 29 69 80 98 17 32 93 52 41 54".split(" ");
		for (int i = 0; i < s.length; i++) {
			int k = Integer.parseInt(s[i]);
			tree.put(k, k);
		}
		TreeVisitor<Integer, Integer, RedBlackNode<Integer, Integer>> visitor = new PrintKeyTraversal<>();
		tree.traverseBreadthFirst(visitor);
		System.out.println(tree);
	}
}
