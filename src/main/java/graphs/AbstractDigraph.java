package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alexey
 *
 */
public abstract class AbstractDigraph<V> implements AbstractGraph<V> {
	final int vertices; //TODO make not final
	int edges;
	final ArrayList<List<Integer>> adj;
	
	public AbstractDigraph(int vertices) {
		this.vertices = vertices;
		this.adj = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++) {
			adj.add(new LinkedList<>());
		}
	}
	
	public void addEdge(V v, V w){
		adj.get(indexFor(v)).add(indexFor(w));
		edges++;
	}
	
	public int degree(V v){
		return adj.get(indexFor(v)).size();
	}
	
	public int getVertices() {
		return vertices;
	}

	public int getEdges() {
		return edges;
	}
	
	public abstract AbstractDigraph<V> createInstance(int v);

	public AbstractDigraph<V> reverse(){
		AbstractDigraph<V> clone = createInstance(vertices);
		for (V v : this) {
			for(V w : adjacent(v)){
				clone.addEdge(w, v);
			}
		}
		return clone;
	}
	
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges\n");
        for(V v: this){
        	s.append(v + ": ");
        	for (V w : adjacent(v)){
        		s.append(w + " ");
        	}
        	s.append("\n");
        }
        return s.toString();
    }

	public Paths<V> pathsFrom(V v){
		return new DFSPaths<V>(this, v);
	}
}
