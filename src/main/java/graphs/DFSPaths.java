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
	private final Digraph<V> graph;
	
	public DFSPaths(IndexedDFSPaths paths, Digraph<V> graph) {
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
		paths.toString();
		for (int v = 0; v < graph.graph.getVertices(); v++) {
			if (v == paths.source)
				continue;
			if (paths.hasPathTo(v)) {
				sb.append(String.format("%s to %s:  ", graph.objects.get(paths.source), graph.objects.get(v)));
				for (int x : paths.pathTo(v)) {
					if (x == paths.source)
						sb.append(graph.objects.get(x));
					else
						sb.append("->").append(graph.objects.get(x));
				}
				sb.append("\n");
			} else {
				sb.append(String.format("%s to %s:  not connected\n", graph.objects.get(paths.source), graph.objects.get(v)));
			}
		}
		return sb.toString();
	}
}
