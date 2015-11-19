package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import trees.BST.NodeVisitor;
import trees.BST.TreeNode;

/**
 * @author alexey
 *
 */
public class BSTTest {
	BST<Integer, Integer> tree = new BST<>();

	NodeVisitor visitor = new NodeVisitor() {
		@Override
		public void visitNode(TreeNode node) {
			System.out.print(node.value + " ");
		}
	};
	
	@Before
	public void setup() {
		tree.put(4, 4);
		tree.put(3, 3);
		tree.put(1, 1);
		tree.put(2, 2);
		tree.put(8, 8);
		tree.put(9, 9);
		tree.put(6, 6);
		tree.put(12, 12);
		tree.put(11, 11);
	}

	@Test
	public void test() {
		Assert.assertEquals(1, tree.min().intValue());
		Assert.assertEquals(12, tree.max().intValue());
		Assert.assertEquals(9, tree.get(9).intValue());
		Assert.assertEquals(1, tree.get(1).intValue());
		Assert.assertEquals(12, tree.get(12).intValue());
		Assert.assertTrue(tree.contains(12));
		Assert.assertTrue(tree.contains(1));
		Assert.assertTrue(tree.contains(9));
		Assert.assertFalse(tree.contains(5));
		Assert.assertFalse(tree.contains(7));
	}

	@Test
	public void testEmpty() {
		tree = new BST<>();
		Assert.assertNull(tree.min());
		Assert.assertNull(tree.max());
		Assert.assertFalse(tree.contains(1));
		Assert.assertNull(tree.remove(1));
	}

	@Test
	public void testOneElement() {
		tree = new BST<>();
		tree.put(1, 1);
		Assert.assertEquals(1, tree.min().intValue());
		Assert.assertEquals(1, tree.max().intValue());
		Assert.assertTrue(tree.contains(1));
		Assert.assertFalse(tree.contains(2));
	}

	@Test
	public void testDeleteMax() {
		tree.put(11, 11);
		tree.deleteMax();
		Assert.assertEquals(11, tree.max().intValue());
		Assert.assertTrue(tree.contains(11));
	}

	@Test
	public void testDeleteMin() {
		tree.put(2, 2);
		tree.deleteMin();
		Assert.assertEquals(2, tree.min().intValue());
		Assert.assertTrue(tree.contains(2));
	}

	@Test
	public void testRemoveWhole() {
		tree.remove(8);
		Assert.assertFalse(tree.contains(8));
		Assert.assertTrue(tree.contains(6));
		Assert.assertTrue(tree.contains(9));
		Assert.assertTrue(tree.contains(12));
		Assert.assertEquals(12, tree.max().intValue());
	}

	@Test
	public void testRemoveRight() {
		tree.remove(9);
		Assert.assertFalse(tree.contains(9));
		Assert.assertTrue(tree.contains(6));
		Assert.assertTrue(tree.contains(8));
		Assert.assertTrue(tree.contains(12));
		Assert.assertEquals(12, tree.max().intValue());
	}

	@Test
	public void testRemoveLeft() {
		tree.remove(6);
		Assert.assertFalse(tree.contains(6));
		Assert.assertTrue(tree.contains(9));
		Assert.assertTrue(tree.contains(8));
		Assert.assertTrue(tree.contains(12));
		Assert.assertEquals(12, tree.max().intValue());
	}

	@Test
	public void testRemoveRoot() {
		tree.remove(4);
		Assert.assertFalse(tree.contains(4));
		Assert.assertTrue(tree.contains(1));
		Assert.assertTrue(tree.contains(6));
		Assert.assertTrue(tree.contains(8));
		Assert.assertTrue(tree.contains(12));
		Assert.assertEquals(12, tree.max().intValue());
		Assert.assertEquals(1, tree.min().intValue());
	}

	@Test
	public void testIsBST() {
		Assert.assertTrue(tree.isBST());
	}

	@Test
	public void testIsNotBST() {
		tree.root.right.right.left = tree.new TreeNode(null, null, 2, 2);
		Assert.assertFalse(tree.isBST());
	}


	@Test
	public void testTraversePreOrder() {
		tree.traversePreOrder(visitor);
		System.out.println();
	}

	@Test
	public void testTraverseInOrder() {
		tree.traverseInOrder(visitor);
		System.out.println();
	}

	@Test
	public void testTraversePostOrder() {
		tree.traversePostOrder(visitor);
		System.out.println();
	}

	@Test
	public void testTraverseBreadthOrder() {
		tree.traverseBreadthFirst(visitor);
		System.out.println();
	}

}
