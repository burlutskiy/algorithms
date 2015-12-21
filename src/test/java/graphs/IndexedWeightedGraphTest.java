package graphs;

import org.junit.Assert;
import org.junit.Test;

public class IndexedWeightedGraphTest {

	@Test
	public void test() {
		IndexedWeightedGraph graph = new IndexedWeightedGraph(5);
		graph.addEdge(0, 1, .51);
		graph.addEdge(1, 3, .11);
		graph.addEdge(4, 2, .9);
		Assert.assertEquals(6, graph.edges);
		System.out.println(graph);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testAddEdge() {
		IndexedWeightedGraph graph = new IndexedWeightedGraph(5);
		graph.addEdge(0, 1);
	}
	
	@Test
	public void testDigraphTrue() throws Exception {
		IndexedWeightedGraph g = GraphTestUtil.readWeightedGraphFromFile("src/test/java/graphs/tinyEWG.txt");
		Assert.assertEquals(32, g.edges);
		System.out.println(g);
	}
}
