package graphs;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import graphs.Bipartite;
import graphs.IndexedGraph;
import junit.framework.Assert;

public class BipartiteTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTrue() {
		IndexedGraph g = new IndexedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		Bipartite<Integer> bipartite = new Bipartite<>(g);
		Assert.assertTrue(bipartite.isBipartite());
	}

	/**
	 * 0 1 2
	 *  3 4
	 */
	@Test
	public void testCompleteBipartiteTrue() {
		IndexedGraph g = new IndexedGraph(5);
		g.addEdge(0, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		Bipartite<Integer> bipartite = new Bipartite<>(g);
		Assert.assertTrue(bipartite.isBipartite());
	}

	@Test
	public void testFalse() {
		IndexedGraph g = new IndexedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(1, 3);
		Bipartite<Integer> bipartite = new Bipartite<>(g);
		Assert.assertFalse(bipartite.isBipartite());
		GraphTest.assertEqualsIterable(bipartite.oddCycle(), Arrays.asList(new Integer[]{1,2,3,1}));
	}

}
