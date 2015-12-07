package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RedBlackTreeTest {
	LLRedBlackTree<Integer, Integer> tree = new LLRedBlackTree<>();

	@Before
	public void init() {
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

	@Test
	public void test() {
		String test = "S E A R C H E X A M P L E";
		String[] keys = test.split(" ");
		LLRedBlackTree<String, Integer> st = new LLRedBlackTree<String, Integer>();
		for (int i = 0; i < keys.length; i++){
			st.put(keys[i], i);
			Assert.assertTrue(tree.isBalanced());
		}
	}

}
