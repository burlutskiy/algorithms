package graphs;

/**
 * @author alexey
 *
 */
public abstract class AbstractUnweightedDigraph<V> extends AbstractDigraph<V, Integer, AdjacentBag> {

	public AbstractUnweightedDigraph(int vertices) {
		super(vertices);
	}
	
	public Paths<V> pathsFrom(V v){
		return new DFSPaths<V>(this, v);
	}
	
	protected AdjacentBag createAdjacentBag() {
		return new AdjacentBag();
	}
}
