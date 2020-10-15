package trees.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;

public class CompareTwoTreesHasSameOrder {
	class TraversableTree extends Tree {
		void add(Integer...integers) {
			for(Integer value : integers)
				put(value);
		}
		
		void traverse(Node node, Consumer<Integer> consumer) {
			if(node == null)
				return;
			traverse(node.left, consumer);
			consumer.accept(node.value);
			traverse(node.right, consumer);
		}

		void traverse(Consumer<Integer> consumer) {
			traverse(root, consumer);
		}

		boolean traverse(Node node, Iterator<Integer> iterator) {
			if(node == null)
				return true;

			traverse(node.left, iterator);
			if(!iterator.hasNext() || node.value != iterator.next())
				return false;
			if(!traverse(node.right, iterator))
				return false;
			return true;
		}

		boolean traverse(Iterator<Integer> iterator) {
			return traverse(root, iterator) && !iterator.hasNext();
		}
		
	}
	
	boolean checkTwoTrees(TraversableTree t1, TraversableTree t2) {
		final List<Integer> list1 = new ArrayList<>();
		final List<Integer> list2 = new ArrayList<>();
		t1.traverse(value -> list1.add(value));
		t2.traverse(value -> list2.add(value));
		return list1.equals(list2);
	}

	boolean checkTwoTrees2(TraversableTree t1, TraversableTree t2) {
		final List<Integer> list = new ArrayList<>();
		t1.traverse(value -> list.add(value));
		return t2.traverse(list.iterator());
	}
	
	@Test
	public void test() {
		TraversableTree tree1 = new TraversableTree();
		tree1.add(1,2,3,4);
		TraversableTree tree2 = new TraversableTree();
		tree2.add(4,3,2,1);

		Assert.assertTrue(checkTwoTrees(tree1, tree2));
	}

	@Test
	public void test2() {
		TraversableTree tree1 = new TraversableTree();
		tree1.add(1,2,3,4);
		TraversableTree tree2 = new TraversableTree();
		tree2.add(4,3,2,1);

		Assert.assertTrue(checkTwoTrees2(tree1, tree2));
	}

	@Test
	public void test3() {
		TraversableTree tree1 = new TraversableTree();
		tree1.add(1,2,3,4);
		TraversableTree tree2 = new TraversableTree();
		tree2.add(1,2,3,5);
		
		Assert.assertFalse(checkTwoTrees2(tree1, tree2));
	}

	@Test
	public void test4() {
		TraversableTree tree1 = new TraversableTree();
		tree1.add(1,2,3,4);
		TraversableTree tree2 = new TraversableTree();
		tree2.add(1,2,3,4,5);
		
		Assert.assertFalse(checkTwoTrees2(tree1, tree2));
	}

	@Test
	public void test5() {
		TraversableTree tree1 = new TraversableTree();
		tree1.add(1,2,3,4);
		TraversableTree tree2 = new TraversableTree();
		tree2.add(1,2,3,4,5);
		
		Assert.assertFalse(checkTwoTrees2(tree2, tree1));
	}
	
}
