package graphs;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 * @author alexey
 *
 */
public class CycleTest {

	@Test
	public void testTrue() {
		IndexedGraph g = new IndexedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		Cycle<Integer> cycle = new Cycle<>(g);
		Assert.assertTrue(cycle.hasCycle());
		AssertGraph.assertEquals(cycle.cycle(), Arrays.asList(new Integer[]{0,1,2,3,0}));
	}

	@Test
	public void testFalse() {
		IndexedGraph g = new IndexedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		Cycle<Integer> cycle = new Cycle<>(g);
		Assert.assertFalse(cycle.hasCycle());
	}

	@Test
	public void testSelfLoops() {
		IndexedGraph g = new IndexedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 1);
		Cycle<Integer> cycle = new Cycle<>(g);
		Assert.assertTrue(cycle.hasCycle());
		Assert.assertTrue(cycle.hasSelfLoop());
		AssertGraph.assertEquals(cycle.cycle(), Arrays.asList(new Integer[]{1,1}));
	}

}
