package graphs;

import org.junit.Assert;
import org.junit.Test;

public class IndexedWeightedDigraphTest {

	@Test
	public void test() {
		IndexedWeightedDigraph graph = new IndexedWeightedDigraph(5);
		graph.addEdge(0, 1, .51);
		graph.addEdge(1, 3, .11);
		graph.addEdge(4, 2, .9);
		Assert.assertEquals(3, graph.edges);
		System.out.println(graph);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testAddEdge() {
		IndexedWeightedDigraph graph = new IndexedWeightedDigraph(5);
		graph.addEdge(0, 1);
	}
	
	@Test
	public void testDigraphTrue() throws Exception {
		IndexedWeightedDigraph g = GraphTestUtil.readWeightedDigraphFromFile("src/test/java/graphs/tinyEWG.txt");
		Assert.assertEquals(16, g.edges);
		System.out.println(g);
	}
}
