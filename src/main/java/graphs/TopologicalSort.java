/**
 * 
 */
package graphs;

import stacks.Stack;

/**
 * @author alexey
 *
 *         Given a digraph, put the vertices in order such that all its directed
 *         edges point from a vertex earlier in the order to a vertex later in
 *         the order. Proposition. A digraph has a topological order if and only
 *         if it is a DAG. <br>
 *         Proposition. Reverse postorder in a DAG is a topological sort.<br>
 *         Proposition. With depth-first search, we can topologically sort a DAG
 *         in time proportional to V + E.<br>
 */
public class TopologicalSort<V> {
	private Stack<V> order;

	public TopologicalSort(AbstractDigraph<V, ?, ?> graph) {
		final Stack<V> stack = new Stack<>();
		GraphVisitor<V> visitor = new GraphVisitor<V>() {
			@Override
			public void visitNode(V object) {
				stack.push(object);
			}
		};
		new Order<>(graph, visitor, GraphVisitor.Direction.POST);
		if (!stack.isEmpty()) {
			order = stack;
		}
	}

	public boolean hasOrder() {
		return order != null;
	}

	public Iterable<V> order() {
		return order;
	}
}
