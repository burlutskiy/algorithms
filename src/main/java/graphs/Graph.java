package graphs;

import java.util.List;

public interface Graph<V> extends Iterable<V>{

	void addEdge(V v, V w);

	int degree(V v);

	List<V> adjacent(V v);

	int getVertices();

	int getEdges();
	
	int indexFor(V v);
	
	V objFor(int index);
}
