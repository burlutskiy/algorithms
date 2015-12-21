package trees;

/**
 * 
 * @author alexey
 *
 * @param <K> key
 * @param <V> value
 * @param <N> node
 */
public interface TreeVisitor<K extends Comparable<K>, V, N extends Node<K, V, N>> {
	void visitNode(N node, int level);
}
