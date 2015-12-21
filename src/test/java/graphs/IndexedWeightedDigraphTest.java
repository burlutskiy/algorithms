package graphs;

import org.junit.Test;

public class IndexedWeightedDigraphTest {

	@Test
	public void test() {
		IndexedWeightedDigraph graph = new IndexedWeightedDigraph(5);
		graph.addEdge(0, 1, .51);
		graph.addEdge(1, 3, .11);
		graph.addEdge(4, 2, .9);
		System.out.println(graph);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testAddEdge() {
		IndexedWeightedDigraph graph = new IndexedWeightedDigraph(5);
		graph.addEdge(0, 1);
	}
}
