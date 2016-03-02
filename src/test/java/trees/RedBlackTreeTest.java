package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import graphs.AssertUtils;

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
		addToTree("71 48 87 29 69 80 98 17 32 93 52 41 54");
		TreeVisitor<Integer, Integer, RedBlackNode<Integer, Integer>> visitor = new PrintKeyTraversal<>();
		tree.traverseBreadthFirst(visitor);
		System.out.println(tree);
	}

	private void addToTree(String numbers) {
		String[] s = numbers.split(" ");
		for (int i = 0; i < s.length; i++) {
			int k = Integer.parseInt(s[i]);
			tree.put(k, k);
		}
	}
	
	@Test
	public void testFloorAndCeiling(){
		addToTree("8 0 12 5 2 4");
		Assert.assertEquals(0, tree.floor(1).intValue());
		Assert.assertEquals(2, tree.ceiling(1).intValue());
		Assert.assertEquals(2, tree.floor(3).intValue());
		Assert.assertEquals(4, tree.ceiling(3).intValue());
	}
	
	@Test
	public void testRank(){
		addToTree("8 0 12 5 2 4");
		Assert.assertEquals(0, tree.rank(0));
		Assert.assertEquals(1, tree.rank(2));
		Assert.assertEquals(2, tree.rank(4));
		Assert.assertEquals(3, tree.rank(5));
		Assert.assertEquals(4, tree.rank(8));
		Assert.assertEquals(5, tree.rank(12));
		//
		Assert.assertEquals(1, tree.rank(1));
		Assert.assertEquals(2, tree.rank(3));
		Assert.assertEquals(4, tree.rank(6));
		Assert.assertEquals(4, tree.rank(7));
		Assert.assertEquals(5, tree.rank(9));
		Assert.assertEquals(6, tree.rank(13));
	}
	
	@Test
	public void testSelect(){
		addToTree("8 0 12 5 2 4");
		Assert.assertEquals(0, tree.select(0).intValue());
		Assert.assertEquals(2, tree.select(1).intValue());
		Assert.assertEquals(4, tree.select(2).intValue());
		Assert.assertEquals(5, tree.select(3).intValue());
		Assert.assertEquals(8, tree.select(4).intValue());
		Assert.assertEquals(12, tree.select(5).intValue());
	}
	
	@Test
	public void testRangeSearch(){
		addToTree("8 0 12 5 2 4");
		AssertUtils.assertEquals(Arrays.asList(2, 4, 5), tree.rangeSearch(1, 6));
	}

	@Test
	public void testRangeCount(){
		addToTree("8 0 12 5 2 4");
		Assert.assertEquals(3, tree.rangeCount(1, 6));
	}
}
