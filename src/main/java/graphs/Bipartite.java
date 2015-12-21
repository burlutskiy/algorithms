package graphs;

import java.util.BitSet;

import stacks.Stack;

public class Bipartite<V> {
    private boolean isBipartite;
    private BitSet color;
    private BitSet marked;
    private int[] edgeTo; 
    private Stack<V> cycle;  // odd-length cycle
    private AbstractUnweightedDigraph<V> graph;
    /**
     * Determines whether an undirected graph is bipartite and finds either a
     * bipartition or an odd-length cycle.
     * @param G the graph
     */
    public Bipartite(AbstractUnweightedDigraph<V> graph) {
    	this.isBipartite = true;
        this.color  = new BitSet(graph.vertices);
        this.marked = new BitSet(graph.vertices);
        this.edgeTo = new int[graph.vertices];
        this.graph = graph;
        for (int v = 0; v < graph.vertices; v++) {
            if (!marked.get(v)) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) { 
        marked.set(v);
        for (V w : graph.adjacent(graph.objFor(v))) {
            if (cycle != null) return;
			int iw = graph.indexFor(w);
			if (!marked.get(iw)) {
				edgeTo[iw] = v;
				color.set(iw, !color.get(v));
				dfs(iw);
			}
            else if (color.get(iw) == color.get(v)) {
                isBipartite = false;
                cycle = new Stack<V>();
                cycle.push(w);
                for (int x = v; x != iw; x = edgeTo[x]) {
                    cycle.push(graph.objFor(x));
                }
                cycle.push(w);
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }
 
    public boolean color(int v) {
        if (!isBipartite)
            throw new UnsupportedOperationException("Graph is not bipartite");
        return color.get(v);
    }

    public Iterable<V> oddCycle() {
        return cycle; 
    }

}
