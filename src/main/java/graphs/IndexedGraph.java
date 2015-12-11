package graphs;

/**
 * @author alexey
 *
 */
public class IndexedGraph extends IndexedDigraph {
	public IndexedGraph(int vertices) {
		super(vertices);
	}

	public void addEdge(Integer v, Integer w){
		super.addEdge(v, w);
		adj.get(w).add(v);
	}
}
