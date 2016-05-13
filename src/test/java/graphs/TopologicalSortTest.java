package graphs;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class TopologicalSortTest {

	@Test
	public void test() throws Exception {
		IndexedDigraph g = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/tinyDAG.txt");
		TopologicalOrder<Integer> sort = new TopologicalOrder<>(g);
		Assert.assertTrue(sort.hasOrder());
		AssertUtils.assertEquals(sort.order(),
				Arrays.asList(new Integer[] { 8, 7, 2, 3, 0, 5, 1, 6, 9, 11, 10, 12, 4 }));
	}

	@Test
	public void test1() throws Exception {
		IndexedDigraph g = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/smallDependencies.txt");
		TopologicalOrder<Integer> sort = new TopologicalOrder<>(g);
		Cycle<Integer> cycle = new Cycle<>(g);
		Assert.assertFalse(cycle.hasCycle());
		Assert.assertTrue(sort.hasOrder());
		AssertUtils.assertEquals(sort.order(),
				Arrays.asList(new Integer[] { 4,3,2,1,0 }));
	}
}
