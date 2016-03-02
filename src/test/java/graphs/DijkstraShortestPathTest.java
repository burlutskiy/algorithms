package graphs;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class DijkstraShortestPathTest {

	@Test
	public void test() {
		IndexedWeightedDigraph graph = new IndexedWeightedDigraph(6);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 3);
		graph.addEdge(2, 1, 2);
		graph.addEdge(2, 4, 10);
		graph.addEdge(3, 5, 1);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 5, 1);
		DijkstraShortestPath<Integer> sp = new DijkstraShortestPath<>(graph, 0);
		Assert.assertEquals(6., sp.distTo(5));
		AssertUtils.assertEquals(sp.pathTo(5), Arrays.asList(new Integer[] { 0, 2, 1, 3, 5 }));
	}

}
