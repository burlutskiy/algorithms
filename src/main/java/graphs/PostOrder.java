package graphs;

import java.util.LinkedList;
import java.util.List;

public class PostOrder<V> {
	private List<V> order;

	public PostOrder(AbstractDigraph<V> graph) {
		final LinkedList<V> list = new LinkedList<>();
		GraphVisitor<V> visitor = new GraphVisitor<V>() {
			@Override
			public void visitNode(V object) {
				list.add(object);
			}
		};
		new Order<>(graph, visitor, GraphVisitor.Direction.POST);
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
