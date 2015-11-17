package trees;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author alexey
 *
 */
public class BSTTest {

	@Test public void test(){
		BST<Integer> tree = new BST<>();
		tree.put(4);
		tree.put(1);
		tree.put(8);
		tree.put(9);
		tree.put(6);
		tree.put(12);
		Assert.assertEquals(1, tree.min().intValue());
		Assert.assertEquals(12, tree.max().intValue());
		Assert.assertTrue(tree.contains(12));
		Assert.assertTrue(tree.contains(1));
		Assert.assertTrue(tree.contains(9));
		Assert.assertFalse(tree.contains(5));
		Assert.assertFalse(tree.contains(7));
		Assert.assertFalse(tree.contains(11));
		
	}
}
