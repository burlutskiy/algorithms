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
	public void testGraphTrue() {
		IndexedGraph g = new IndexedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		Cycle<Integer> cycle = new Cycle<>(g);
		Assert.assertTrue(cycle.hasCycle());
		AssertUtils.assertEquals(cycle.cycle(), Arrays.asList(new Integer[]{0,1,2,3,0}));
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
		AssertUtils.assertEquals(cycle.cycle(), Arrays.asList(new Integer[]{1,1}));
	}

	@Test
	public void testDigraphFalse() throws Exception {
		IndexedDigraph g = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/vertices1.txt");
		Cycle<Integer> cycle = new Cycle<>(g);
		Assert.assertFalse(cycle.hasCycle());
	}

	@Test
	public void testDigraphAcyclicFalse() throws Exception {
		IndexedDigraph g = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/tinyDAG.txt");
		Cycle<Integer> cycle = new Cycle<>(g);
		Assert.assertFalse(cycle.hasCycle());
	}

	@Test
	public void testDigraphTrue() throws Exception {
		IndexedDigraph g = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/tinyDG.txt");
		Cycle<Integer> cycle = new Cycle<>(g);
		Assert.assertTrue(cycle.hasCycle());
	}


}
