package graphs;

/**
 * 
 * @author alexey
 *
 * @param <V> object
 */
public interface GraphVisitor<V> {
	public enum Direction {
		PRE, POST
	}

	void visitNode(V object);
}
