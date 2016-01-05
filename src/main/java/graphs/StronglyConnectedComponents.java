package graphs;

import java.util.BitSet;

import stacks.Stack;

/**
 * Kosaraju-Sharir algorithm. <br>
 * Given a digraph G, compute the reverse postorder of its reverse <br>
 * Run standard DFS on G, but consider the unmarked vertices in the order just computed instead of the standard numerical order.
 * 
 * @author alexey
 *
 * @param <V>
 */
public class StronglyConnectedComponents<V> {
	private BitSet marked;
	private int[] cc;
	private int[] size;
	private Stack<V> cycle;
	private final AbstractUnweightedDigraph<V> graph;
	private int count;    
			
	public StronglyConnectedComponents(AbstractUnweightedDigraph<V> graph) {
		this.graph = graph;
		this.marked = new BitSet(graph.vertices);
		this.cc = new int[graph.vertices];
		this.size = new int[graph.vertices];
		TopologicalOrder<V> order = new TopologicalOrder<>(graph.reverse());
		for (V v : order.order()) {
			int iv = graph.indexFor(v);
			if (!marked.get(iv)) {
				dfs(iv);
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
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < count; i++) {
    		for (int j = 0; j < cc.length; j++) {
				if(cc[j] == i){
					sb.append(j).append(" ");
				}
			}
    		sb.append("\n");
    	}
    	return sb.toString();
    }
}
