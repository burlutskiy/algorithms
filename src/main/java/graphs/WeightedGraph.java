package graphs;

/**
 * 
 * @author alexey
 *
 */
public interface WeightedGraph<V> {
	void addEdge(V v, V w, double weight);
}
