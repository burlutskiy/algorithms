package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alexey
 *
 */
public class IndexedDigraph implements AbstractGraph<Integer> {
	final int vertices;
	int edges;
	final ArrayList<List<Integer>> adj;
	
	public IndexedDigraph(int vertices) {
		this.vertices = vertices;
		this.adj = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++) {
			adj.add(new LinkedList<>());
		}
	}
	
	public void addEdge(Integer v, Integer w){
		adj.get(v).add(w);
		edges++;
	}
	
	public int degree(Integer v){
		return adj.get(v).size();
	}
	
	public List<Integer> adjacent(Integer v){
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
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (Integer w : adj.get(v)) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

	public IndexedDFSPaths pathsFrom(Integer v) {
		return new IndexedDFSPaths(this, v);
	}
}
