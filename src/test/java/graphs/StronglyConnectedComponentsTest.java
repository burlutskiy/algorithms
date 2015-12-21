package graphs;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author alexey
 *
 */
public class StronglyConnectedComponentsTest {
	
	@Test
	public void testMediumDGFalse() throws Exception {
		IndexedDigraph graph = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/mediumDG.txt");
		StronglyConnectedComponents<Integer> components = new StronglyConnectedComponents<>(graph);
		Assert.assertEquals(10, components.count());
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
		StronglyConnectedComponents<Integer> components = new StronglyConnectedComponents<>(graph);
		Assert.assertEquals(2, components.count());
	}
	
	@Test
	public void testDigraph3SCC() throws Exception {
		IndexedDigraph graph = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/wikiStrongComponents.txt");
		StronglyConnectedComponents<Integer> components = new StronglyConnectedComponents<>(graph);
		Assert.assertTrue(components.areConnected(2, 7));
		Assert.assertFalse(components.areConnected(1, 4));
		Assert.assertFalse(components.areConnected(1, 2));
		Assert.assertFalse(components.areConnected(4, 7));
		Assert.assertEquals(3, components.count());
	}

}
