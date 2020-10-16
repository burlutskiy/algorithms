package graphs.flat;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * In a multithreaded environment, it's possible that different processes will
 * need to use the same resource. A wait-for graph represents the different
 * processes as nodes in a directed graph, where an edge from node i to node j
 * means that the node j is using a resource that node i needs to use (and
 * cannot use until node j releases it).
 * 
 * We are interested in whether or not this digraph has any cycles in it. If it
 * does, it is possible for the system to get into a state where no process can
 * complete.
 * 
 * We will represent the processes by integers 0, ...., n - 1. We represent the
 * edges using a two-dimensional list connections. If j is in the list
 * connections[i], then there is a directed edge from process i to process j.
 * 
 * Write a function that returns True if connections describes a graph with a
 * directed cycle, or False otherwise.
 * 
 * 
 * @author alexey
 *
 */
public class HasCycleOrDeadlock {
	class Digraph {
		final int[][] graph;
		final int n;

		public Digraph(int[][] graph) {
			this.graph = graph;
			this.n = graph.length;
		}

		int[] adjacent(int v) {
			assert v < graph.length;
			return graph[v];
		}

		public boolean hasCycle() {
			boolean[] visited = new boolean[n];
			Set<Integer> onStack = new LinkedHashSet<>();
			for (int i = 0; i < n; i++)
				if (!visited[i]) {
					if (visit(i, visited, onStack))
						break;
				}
			return onStack.size() > 0;
		}

		boolean visit(int v, boolean[] visited, Set<Integer> onStack) {
			visited[v] = true;
			onStack.add(v);
			for (int i : adjacent(v)) {
				if (!visited[i]) {
					if (visit(i, visited, onStack))
						return true;
				} else if (onStack.contains(i))
					return true;
			}
			onStack.remove(v);
			return false;
		}
	}

	boolean check(int[][] connections) {
		Digraph graph = new Digraph(connections);
		return graph.hasCycle();
	}

	@Test
	public void test1() {
		Assert.assertTrue(check(new int[][] { { 1 }, { 2 }, { 3, 4 }, { 4 }, { 0 } }));
	}

	@Test
	public void test2() {
		Assert.assertFalse(check(new int[][] { { 1, 4 }, { 2, 3, 4 }, { 3 }, {}, { 3 } }));
	}

	@Test
	public void test3() {
		Assert.assertTrue(check(new int[][] { { 1, 4 }, { 2, 3, 4 }, { 3 }, { 1 }, { 3 } }));
	}

	@Test
	public void test4() {
		Assert.assertTrue(check(new int[][] { { 0 } }));
	}

}
