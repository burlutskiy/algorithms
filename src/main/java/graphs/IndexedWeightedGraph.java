package graphs;

/**
 * 
 * @author alexey
 *
 */
public class IndexedWeightedGraph extends IndexedWeightedDigraph {

	public IndexedWeightedGraph(int vertices) {
		super(vertices);
	}

	@Override
	public void addEdge(Integer v, Integer w, double weight) {
		super.addEdge(v, w, weight);
		AdjacentWeightedBad adjacentWeightedBad = adj.get(indexFor(w));
		adjacentWeightedBad.add(indexFor(v), weight);
		edges++;
	}
	
	public IndexedWeightedGraph createInstance(int v) {
		return new IndexedWeightedGraph(v);
	}
}
