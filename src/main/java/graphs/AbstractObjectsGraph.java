package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractObjectsGraph<V, G extends IndexedDigraph> implements AbstractGraph<V>, ObjectsGraph<V>{
	final List<V> objects;
	final Map<V, Integer> indexMap;
	final G graph;
	
	public AbstractObjectsGraph(List<V> list, G graph) {
		this.objects = list;
		this.graph = graph;
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

	public int indexFor(V v) {
		return indexMap.get(v);
	}
	
	public V objFor(int index) {
		return objects.get(index);
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

}
