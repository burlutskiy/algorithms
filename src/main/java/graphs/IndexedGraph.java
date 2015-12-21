package graphs;

/**
 * 
 * @author alexey
 *
 */
public class IndexedGraph extends IndexedDigraph {

	public IndexedGraph(int vertices) {
		super(vertices);
	}

	public void addEdge(Integer v, Integer w) {
		super.addEdge(v, w);
		adj.get(indexFor(w)).add(indexFor(v));
	}
	
	public IndexedGraph createInstance(int v) {
		return new IndexedGraph(v);
	}
}
