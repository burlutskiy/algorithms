package graphs;

import java.util.BitSet;

import stacks.Stack;

/**
 * 
 * @author alexey
 *
 */
public class Cycle<V> {
	private BitSet marked;
	private int[] edgeTo;
	private Stack<V> cycle;
	private final AbstractDigraph<V> graph;

	public Cycle(AbstractDigraph<V> graph) {
		this.marked = new BitSet(graph.vertices);
		this.edgeTo = new int[graph.vertices];
		this.graph = graph;
		if (hasSelfLoop())
			return;
		for (int v = 0; v < graph.vertices; v++) {
			if (!marked.get(v)) {
				dfs(v, -1);
			}
		}
	}

	public boolean hasSelfLoop() {
		for (V v : graph) {
			for (V w : graph.adjacent(v)) {
				if (v.equals(w)) {
					cycle = new Stack<V>();
					cycle.push(v);
					cycle.push(v);
					return true;
				}
			}
		}
		return false;
	}

	private void dfs(int v, int from) {
		marked.set(v);
		for (V w : graph.adjacent(graph.objFor(v))) {
			if (cycle != null)
				return;
			int iw = graph.indexFor(w);
			if (!marked.get(iw)) {
				edgeTo[iw] = v;
				dfs(iw, v);
			} else if (iw != from) {
				cycle = new Stack<V>();
				cycle.push(w);
				for (int x = v; x != iw; x = edgeTo[x]) {
					cycle.push(graph.objFor(x));
				}
				cycle.push(w);
			}
		}
	}

	public Iterable<V> cycle() {
		return cycle;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

}
