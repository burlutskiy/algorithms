package graphs;

import java.util.List;

/**
 * 
 * @author alexey
 *
 * @param <V> - any object
 */
public class Graph<V> extends AbstractObjectsGraph<V, IndexedGraph>{
	public Graph(List<V> list) {
		super(list, new IndexedGraph(list.size()));
	}
	
	@Override
	public Paths<V> pathsFrom(V v) {
		return new DFSPaths<V>(graph.pathsFrom(indexMap.get(v)), this);
	}
}
