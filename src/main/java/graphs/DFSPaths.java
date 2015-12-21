package graphs;

import java.util.BitSet;

import stacks.Stack;

/**
 * 
 * @author alexey
 *
 */
public class DFSPaths<V> implements Paths<V> {
	final AbstractDigraph<V> graph;
	final BitSet marked;
	final int edgeTo[];
	final int source;

	public DFSPaths(AbstractDigraph<V> graph, V source) {
		this.graph = graph;
		this.source = graph.indexFor(source);
		this.marked = new BitSet(graph.getVertices());
		this.edgeTo = new int[graph.getVertices()];
		dfs(this.source);
	}

	private void dfs(int v) {
		marked.set(v);
		for (V w : graph.adjacent(graph.objFor(v))) {
			int iw = graph.indexFor(w);
			if (!marked.get(iw)) {
				edgeTo[iw] = v;
				dfs(iw);
			}
		}
	}

	public boolean hasPathTo(V v) {
		return marked.get(graph.indexFor(v));
	}

	public Iterable<V> pathTo(V v) {
		if (!hasPathTo(v))
			return null;
		Stack<V> stack = new Stack<>();
		for (int x = graph.indexFor(v); x != source; x = edgeTo[x]) {
			stack.push(graph.objFor(x));
		}
		stack.push(graph.objFor(source));
		return stack;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		V sourceObj = graph.objFor(source);
		for (V v : graph) {
			if (sourceObj.equals(v))
				continue;
			if (hasPathTo(v)) {
				sb.append(String.format("%s to %s:  ", sourceObj, v));
				for (V x : pathTo(v)) {
					if (sourceObj.equals(x))
						sb.append(x);
					else
						sb.append("-").append(x);
				}
				sb.append("\n");
			} else {
				sb.append(String.format("%s to %s:  not connected\n", sourceObj, v));
			}
		}
		return sb.toString();
	}
}
