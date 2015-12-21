package graphs;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author alexey
 *
 */
public class ConnectedComponentsTest {
	
	@Test
	public void testGraphTrue() throws Exception {
		IndexedGraph digraph = new IndexedGraph(5);
		digraph.addEdge(0, 1);
		digraph.addEdge(0, 2);
		digraph.addEdge(1, 2);
		ConnectedComponents<Integer> components = new ConnectedComponents<>(digraph);
		Assert.assertTrue(components.areConnected(0, 2));
	}

	@Test
	public void testMediumDGFalse() throws Exception {
		IndexedDigraph graph = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/mediumDG.txt");
		ConnectedComponents<Integer> components = new ConnectedComponents<>(graph);
		Assert.assertEquals(4, components.count());
//		Assert.assertEquals(10, components.count());
	}

	@Test
	public void testDigraphFalse() throws Exception {
		IndexedDigraph graph = new IndexedDigraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		//
		graph.addEdge(2, 3);
		//
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		ConnectedComponents<Integer> components = new ConnectedComponents<>(graph);
		Assert.assertEquals(1, components.count());
//		Assert.assertEquals(2, components.count());
	}
	
}
