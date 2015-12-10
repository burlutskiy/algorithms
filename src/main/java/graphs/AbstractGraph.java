/**
 * 
 */
package graphs;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @author alexey
 *
 */
public abstract class AbstractGraph<V, A extends AdjacencyList<V>> {
	private final int vertices;
	private int edges;

	private final AdjacencyList<V> adj;
	
	AbstractGraph(int vertices, A adj) {
		super();
		this.vertices = vertices;
		this.adj = adj;
	}
	
	public void addEdge(V v, V w){
		adj.get(v).add(w);
		adj.get(w).add(v);
		edges++;
	}
	
	public int degree(V v){
		return adj.get(v).size();
	}
	
	public List<V> adjacent(V v){
		return Collections.unmodifiableList(adj.get(v));
	}

	public int getVertices() {
		return vertices;
	}

	public int getEdges() {
		return edges;
	}
	
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges\n");
        for (List<V> v: adj.get()) {
            s.append(v + ": ");
            for (V w : adj.get(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
