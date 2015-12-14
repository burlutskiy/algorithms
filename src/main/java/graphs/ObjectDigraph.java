package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ObjectDigraph<V> extends AbstractDigraph<V>{
	final List<V> objects;
	final Map<V, Integer> indexMap;
	
	public ObjectDigraph(List<V> list) {
		super(list.size());
		this.objects = list;
		this.indexMap = new HashMap<>();
		for (int v = 0; v < list.size(); v++) {
			V vertex = list.get(v);
			indexMap.put(vertex, v);
		}
	}

	public List<V> adjacent(V v) {
		List<V> list = new ArrayList<>();
		for (Integer w : adj.get(indexFor(v))) {
			list.add(objects.get(w));
		}
		return list;
	}

	public int indexFor(V v) {
		return indexMap.get(v);
	}
	
	public V objFor(int index) {
		return objects.get(index);
	}

	@Override
	public Iterator<V> iterator() {
		return objects.iterator();
	}

}
