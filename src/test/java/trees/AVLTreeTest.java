package trees;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author burlutal
 *
 */
public class AVLTreeTest {
	AbstractAVLTree<Integer, Integer, ?>[] trees = new AbstractAVLTree[] { new AVLTreeV1<>(), new AVLTreeV2<>() };

	@Before
	public void init() {
		for (AbstractAVLTree<Integer, Integer, ?> tree : trees) {
			tree.put(1, 1);
			tree.put(2, 2);
			tree.put(3, 3);
			tree.put(4, 4);
			tree.put(5, 5);
			tree.put(6, 6);
			tree.put(16, 16);
			tree.put(15, 15);
			tree.put(14, 14);
			tree.put(13, 13);
			tree.put(12, 12);
			tree.put(11, 11);
			tree.put(10, 10);
			tree.put(9, 9);
			tree.put(8, 8);
			tree.put(7, 7);
		}
	}

	@Test
	public void test() {
		for (AbstractAVLTree<Integer, Integer, ?> tree : trees) {
			Assert.assertTrue(tree.isBST());
			Assert.assertEquals(5, tree.height());
		}
	}

	@Test
	public void testRemove() {
		for (AbstractAVLTree<Integer, Integer, ?> tree : trees) {
			tree.remove(10);
			tree.remove(11);
			tree.remove(8);
			tree.remove(9);
			Assert.assertEquals(4, tree.height());
		}
	}

	@Test
	public void testBalanced() {
		for (AbstractAVLTree tree : trees) {
			Assert.assertTrue(tree.isBalanced());
			tree.get(tree.root, 7).right = new AVLNode<Integer, Integer>(null, null, 5, 5);
			Assert.assertFalse(tree.isBalanced());
		}
	}

	@Test
	public void testBalanced2() {
		for (AbstractAVLTree<Integer, Integer, ?> tree : trees) {
			tree = new AVLTreeV2<>();
			tree.put(3, 3);
			tree.put(1, 1);
			tree.put(2, 2);
			Assert.assertTrue(tree.isBalanced());
		}
	}

	@Test
	public void testStressTest() {
		for (AbstractAVLTree<Integer, Integer, ?> tree : trees) {
			Random r = new Random();
			tree = new AVLTreeV2<>();
			for (int i = 0; i < 1000; i++) {
				int k = r.nextInt(1000);
				tree.put(k, i);
			}
			Assert.assertTrue(tree.isBalanced());
		}
	}
}
