package graphs;

public interface ObjectsGraph<V> {
	int indexFor(V v);
	V objFor(int index);
}
