package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author alexey
 *
 * @param <V> - any object
 */
public class Graph<V> implements AbstractGraph<V>{
	final List<V> objects;
	final Map<V, Integer> indexMap;
	final IndexedGraph graph;
	
	public Graph(List<V> list) {
		this.objects = list;
		this.graph = new IndexedGraph(list.size());
		this.indexMap = new HashMap<>();
		for (int v = 0; v < list.size(); v++) {
			V vertex = list.get(v);
			indexMap.put(vertex, v);
		}
	}

	public void addEdge(V v, V w) {
		graph.addEdge(indexMap.get(v), indexMap.get(w));
	}

	public int degree(V v) {
		return graph.degree(indexMap.get(v));
	}

	public List<V> adjacent(V v) {
		List<V> list = new ArrayList<>();
		for (Integer w : graph.adjacent(indexMap.get(v))) {
			list.add(objects.get(w));
		}
		return list;
	}

	public int getVertices() {
		return graph.getVertices();
	}

	public int getEdges() {
		return graph.getEdges();
	}
		
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(graph.getVertices() + " vertices, " + graph.getEdges() + " edges\n");
        for (int v = 0; v < graph.getVertices(); v++) {
            s.append(objects.get(v) + ": ");
            for (Integer w : graph.adjacent(v)) {
                s.append(objects.get(w) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

	@Override
	public DFSPaths<V> pathsFrom(V v) {
		return new DFSPaths<V>(graph.pathsFrom(indexMap.get(v)), this);
	}
}
