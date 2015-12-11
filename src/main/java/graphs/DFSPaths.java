package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author alexey
 *
 */
public class DFSPaths<V> implements Paths<V>{
	private final IndexedDFSPaths paths;
	private final AbstractObjectsGraph<V, ?> graph;
	
	public DFSPaths(IndexedDFSPaths paths, AbstractObjectsGraph<V, ?>  graph) {
		this.paths = paths;
		this.graph = graph;
	}

	public boolean hasPathTo(V v) {
		return paths.hasPathTo(graph.indexMap.get(v));
	}

	public Iterable<V> pathTo(V v) {
		List<V> list = new ArrayList<>();
		Iterable<Integer> pathTo = paths.pathTo(graph.indexMap.get(v));
		for (Integer w : pathTo) {
			list.add(graph.objects.get(w));
		}
		return list;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int v = 0; v < graph.getVertices(); v++) {
			if (v == paths.source)
				continue;
			if (paths.hasPathTo(v)) {
				sb.append(String.format("%s to %s:  ", graph.objFor(paths.source), graph.objFor(v)));
				for (int x : paths.pathTo(v)) {
					if (x == paths.source)
						sb.append(graph.objFor(x));
					else
						sb.append("->").append(graph.objFor(x));
				}
				sb.append("\n");
			} else {
				sb.append(String.format("%s to %s:  not connected\n", graph.objFor(paths.source), graph.objFor(v)));
			}
		}
		return sb.toString();
	}
}
