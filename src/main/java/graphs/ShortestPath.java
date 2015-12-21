package graphs;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

import stacks.Stack;

/**
 * 
 * @author alexey
 *
 */
public class ShortestPath<V> {
    private BitSet marked;
    private int[] edgeTo; 
    private int[] distTo;
    private Stack<V> cycle;
    private final AbstractUnweightedDigraph<V> graph;
    private final int source;
	
    public ShortestPath(AbstractUnweightedDigraph<V> graph, int source) {
        this.marked = new BitSet(graph.vertices);
        this.edgeTo = new int[graph.vertices];
        this.distTo = new int[graph.vertices];
		this.graph = graph;
		this.source = source;
		for (int v = 0; v < graph.vertices; v++) 
			distTo[v] = Integer.MAX_VALUE;
		bfs(source);
	}
    
    private void bfs(int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        distTo[s] = 0;
        marked.set(s);
        q.offer(s);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (V w : graph.adjacent(graph.objFor(v))) {
            	int iw = graph.indexFor(w);
                if (!marked.get(iw)) {
                    edgeTo[iw] = v;
                    distTo[iw] = distTo[v] + 1;
                    marked.set(iw);
                    q.offer(iw);
                }
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
		for (int x = graph.indexFor(v); distTo[x] != 0; x = edgeTo[x]) {
			stack.push(graph.objFor(x));
		}
		stack.push(graph.objFor(source));
		return stack;
	}

}
