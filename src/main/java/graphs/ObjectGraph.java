package graphs;

import java.util.List;

/**
 * 
 * @author alexey
 *
 */
public class ObjectGraph<V> extends ObjectDigraph<V> {

	public ObjectGraph(List<V> list) {
		super(list);
	}

	public void addEdge(V v, V w) {
		super.addEdge(v, w);
		adj.get(indexFor(w)).add(indexFor(v));
	}

}
