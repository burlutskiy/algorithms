package graphs;

import java.util.List;

public interface AbstractGraph<V> {

	void addEdge(V v, V w);

	int degree(V v);

	List<V> adjacent(V v);

	int getVertices();

	int getEdges();
	
	Paths<V> pathsFrom(V v); 

}
