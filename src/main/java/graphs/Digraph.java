package graphs;

import java.util.List;

/**
 * 
 * @author alexey
 *
 */
public class Digraph<V> extends AbstractObjectsGraph<V, IndexedDigraph>{
	public Digraph(List<V> list) {
		super(list, new IndexedDigraph(list.size()));
	}
}