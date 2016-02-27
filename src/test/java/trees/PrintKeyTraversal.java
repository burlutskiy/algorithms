package trees;

public final class PrintKeyTraversal<K extends Comparable<K>, V, N extends Node<K, V, N>> implements TreeVisitor<K, V, N> {
	@Override
	public void visitNode(N node, int level) {
		System.out.print(node.key + " ");
	}
}