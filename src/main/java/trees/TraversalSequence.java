package trees;

import java.util.ArrayList;
import java.util.List;

public class TraversalSequence<K extends Comparable<K>, V, N extends Node<K, V, N>> implements TreeVisitor<K, V, N> {
	private List<K> sequence = new ArrayList<>();

	public void visitNode(N node, int level) {
		sequence.add(node.key);
	}

	public List<K> getSequence() {
		return sequence;
	}
}
