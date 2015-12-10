package graphs;

import java.io.Serializable;
import java.util.List;

public interface AdjacencyList<V extends Serializable & Comparable<Integer>> {
	public List<V> get(V vertex);
	public List<List<V>> get();
}