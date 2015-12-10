/**
 * 
 */
package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author burlutal
 *
 */
public class AdjacencyArrayList implements AdjacencyList<Integer> {
	private final ArrayList<Integer>
	private final ArrayList<List<Integer>> adj;
	
	public AdjacencyArrayList(Integer vertices) {
		this.adj = new ArrayList<>(vertices);
	}

	@Override
	public List<Integer> get(Integer vertex) {
		return adj.get(vertex);
	}

	@Override
	public List<List<Integer>> get() {
		return adj;
	}

}
