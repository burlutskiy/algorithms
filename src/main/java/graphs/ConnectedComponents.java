package graphs;

import java.util.BitSet;

import stacks.Stack;

public class ConnectedComponents<V> {
	private BitSet marked;
	private int[] cc;
	private int[] size;
	private Stack<V> cycle;
	private final AbstractDigraph<V> graph;
	private int count;    

	public ConnectedComponents(AbstractDigraph<V> graph) {
		this.marked = new BitSet(graph.vertices);
		this.cc = new int[graph.vertices];
		this.size = new int[graph.vertices];
		this.graph = graph;
		for (int v = 0; v < graph.vertices; v++) {
			if (!marked.get(v)) {
				dfs(v);
				count++;
			}
		}
	}

	private void dfs(int v) {
		marked.set(v);
		cc[v] = count;
		size[count]++;
		for (V w : graph.adjacent(graph.objFor(v))) {
			if (cycle != null)
				return;
			int iw = graph.indexFor(w);
			if (!marked.get(iw)) {
				dfs(iw);
			}
		}
	}

	/**
     * Returns the component id of the connected component containing vertex <tt>v</tt>.
     *
     */
	public int id(V v) {
        return cc[graph.indexFor(v)];
    }
	
	public boolean areConnected(V v, V w) {
        return id(v) == id(w);
    }
	
    public int size(int v) {
        return size[cc[v]];
    }

    public int count() {
        return count;
    }
}
