package graphs;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class ShortestPathTest {
	@Test
	public void testShortestPath() {
		IndexedGraph g = new IndexedGraph(8);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 0);
		ShortestPath<Integer> path = new ShortestPath<>(g, 0);
		Assert.assertTrue(path.hasPathTo(6));
		AssertUtils.assertEquals(path.pathTo(6), Arrays.asList(new Integer[]{0,7,6}));
	}

}
