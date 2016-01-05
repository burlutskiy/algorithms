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
	private BitSet onStack;
	private int[] edgeTo;
	private Stack<V> cycle;
	private final Graph<V> graph;

	public Cycle(Graph<V> graph) {
		this.marked = new BitSet(graph.getVertices());
		this.onStack = new BitSet(graph.getVertices());
		this.edgeTo = new int[graph.getVertices()];
		this.graph = graph;
		if (hasSelfLoop())
			return;
		for (int v = 0; v < graph.getVertices(); v++) {
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
		onStack.set(v);
		for (V w : graph.adjacent(graph.objFor(v))) {
			if (cycle != null)
				return;
			int iw = graph.indexFor(w);
			if (!marked.get(iw)) {
				edgeTo[iw] = v;
				dfs(iw, v);
			} else if (onStack.get(iw) && iw != from) {
				cycle = new Stack<V>();
				cycle.push(w);
				for (int x = v; x != iw; x = edgeTo[x]) {
					cycle.push(graph.objFor(x));
				}
				cycle.push(w);
			}
		}
		onStack.clear(v);
	}

	public Iterable<V> cycle() {
		return cycle;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

}
