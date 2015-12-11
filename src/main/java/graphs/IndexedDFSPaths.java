package graphs;

import java.util.BitSet;
import java.util.List;

import stacks.Stack;

public class IndexedDFSPaths implements Paths<Integer> {
	final IndexedDigraph graph;
	final BitSet marked;
	final int edgeTo[];
	final int source;

	public IndexedDFSPaths(IndexedDigraph graph, int source) {
		this.graph = graph;
		this.source = source;
		this.marked = new BitSet(graph.getVertices());
		this.edgeTo = new int[graph.getVertices()];
		dfs(source);
	}

	private void dfs(int v) {
		marked.set(v);
		List<Integer> adjacent = graph.adjacent(v);
		for (Integer w : adjacent) {
			if (!marked.get(w)) {
				edgeTo[w] = v;
				dfs(w);
			}
		}
	}

	@Override
	public boolean hasPathTo(Integer v) {
		return marked.get(v);
	}

	@Override
	public Iterable<Integer> pathTo(Integer v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> stack = new Stack<>();
		for (int x = v; x != source; x = edgeTo[x]) {
			stack.push(x);
		}
		stack.push(source);
		return stack;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int v = 0; v < graph.getVertices(); v++) {
			if (v == source)
				continue;
			if (hasPathTo(v)) {
				sb.append(String.format("%d to %d:  ", source, v));
				for (int x : pathTo(v)) {
					if (x == source)
						sb.append(x);
					else
						sb.append("-").append(x);
				}
				sb.append("\n");
			} else {
				sb.append(String.format("%d to %d:  not connected\n", source, v));
			}
		}
		return sb.toString();
	}

}
