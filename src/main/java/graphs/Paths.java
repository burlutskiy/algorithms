package graphs;

/**
 * 
 * @author alexey
 *
 * @param <V>
 */
public interface Paths<V> {
	boolean hasPathTo(V v);

	Iterable<V> pathTo(V v);
}
