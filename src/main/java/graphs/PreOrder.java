package graphs;

import java.util.LinkedList;
import java.util.List;

public class PreOrder<V> {
	private List<V> order;

	public PreOrder(AbstractUnweightedDigraph<V> graph) {
		final LinkedList<V> list = new LinkedList<>();
		GraphVisitor<V> visitor = new GraphVisitor<V>() {
			@Override
			public void visitNode(V object) {
				list.add(object);
			}
		};
		new Order<>(graph, visitor, GraphVisitor.Direction.PRE);
		if (!list.isEmpty()) {
			order = list;
		}
	}

	public boolean hasOrder() {
		return order != null;
	}

	public Iterable<V> order() {
		return order;
	}
}
