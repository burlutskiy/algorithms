package trees;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alexey
 *
 */
public class BSTTest {
	BST<Integer, Integer> tree = new BST<>();

	TreeVisitor<Integer, Integer, TreeNode<Integer, Integer>> visitor = new PrintKeyTraversal();

	@Before
	/**
	 * _____4<br>
	 * __3______8<br>
	 * 1______6___9<br>
	 * _2_________12<br>
	 * _________11<br>
	 */
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
		tree = new BST<>();
		tree.put(10, 10);
		tree.put(5, 5);
		tree.put(9, 9);
		tree.put(6, 6);
		tree.put(7, 7);
		tree.deleteMin();
		Assert.assertFalse(tree.contains(5));
	}
	
	@Test
	public void testDeleteMin2() {
		tree = new BST<>();
		tree = new BST<>();
		addToTree(tree, "69 90 74 91");
		tree.deleteMin();
		
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
		tree.root.right.right.left = new TreeNode<>(null, null, 2, 2);
		Assert.assertFalse(tree.isBST());
	}

	@Test
	public void testIsNotBST2() {
		tree = new BST<>();
		tree.put(20, 20);
		tree.put(51, 51);
		tree.put(61, 61);
		tree.root.right.left = new TreeNode<>(null, null, 1, 11);
		Assert.assertFalse(tree.isBST());
	}

	@Test
	public void testTraversePreOrder() {
		tree.traversePreOrder(visitor);
		System.out.println();
	}

	@Test
	public void testReverse() {
		tree.reverse();
		Assert.assertFalse(tree.isBST());
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

	@Test
	public void testTraverseBreadthOrder2() {
		tree = new BST<>();
		tree.put(4, 4);
		tree.put(2, 2);
		tree.put(6, 6);
		tree.put(1, 1);
		tree.put(3, 3);
		tree.put(5, 5);
		tree.put(7, 7);
		tree.traverseBreadthFirst(visitor);
	}
	
	@Test
	public void testTraverseBreadthSearch() {
		tree = new BST<>();
		addToTree(tree, "56 91 25 84 15 97 63 77 82 37");
		tree.traverseBreadthFirst(visitor);
		System.out.println();
		System.out.println(tree);
	}

	private void addToTree(BST<Integer, Integer> tree, String str) {
		String[] numbers = str.split(" ");
		for (String number : numbers) {
			int num = Integer.parseInt(number);
			tree.put(num, num);
		}
	}

	@Test
	public void testDeleteHabbard() {
		tree = new BST<>();
		String[] numbers = "63 41 80 10 52 70 34 49 58 65 76 54".split(" ");
		for (String number : numbers) {
			int num = Integer.parseInt(number);
			tree.put(num, num);
		}
		tree.remove(65);
		tree.remove(80);
		tree.remove(41);
		tree.traverseBreadthFirst(visitor);
		System.out.println("\n"+tree);
	}
		
	@Test
	public void testRotateCW() {
		tree.rotateRight(tree.root, tree.root.left);
		Assert.assertTrue(tree.isBST());
		tree.rotateRight(null, tree.root);
		Assert.assertTrue(tree.isBST());
	}

	@Test
	public void testRotateCCW() {
		tree.rotateLeft(tree.root, tree.root.left);
		Assert.assertTrue(tree.isBST());
		tree.rotateLeft(null, tree.root);
		Assert.assertTrue(tree.isBST());
	}
	
	@Test
	public void testMaxDepth() {
		Assert.assertEquals(5, tree.height());
	}	

	@Test public void testPrintTree(){
		System.out.println(tree);
		tree.rotateLeft(tree.root, tree.root.right);
		System.out.println(tree);
	}

	@Test public void testPrintRootToLeef(){
		List<List<Integer>> rootToLeafPaths = tree.rootToLeafPaths();
		Assert.assertEquals(3, rootToLeafPaths.size());
		Assert.assertEquals(2, rootToLeafPaths.get(0).get(3).intValue());
		Assert.assertEquals(6, rootToLeafPaths.get(1).get(2).intValue());
		Assert.assertEquals(11, rootToLeafPaths.get(2).get(4).intValue());
		System.out.println(rootToLeafPaths);
	}

	@Test public void testDuplicateInsertion(){
		tree.put(11, 11);
		tree.put(12, 12);
		Assert.assertTrue(tree.isBST());
	}
	
	@Test public void test1(){
		tree = new BST<>();
		for (int i = 0; i < 10; i++) {
			tree.put(i, i);
		}
		tree.traversePreOrder(visitor);
		System.out.println();
		tree.traverseInOrder(visitor);
		System.out.println();
		tree.traversePostOrder(visitor);
		System.out.println();
//		tree = new BST<>();
//		for (int i = 0; i < 10; i++) {
//			tree.put(10-i-1, 10-i-1);
//		}
//		tree.traversePreOrder(visitor);
	}
}
