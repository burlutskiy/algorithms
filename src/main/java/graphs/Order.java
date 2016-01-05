package graphs;

import java.util.BitSet;

/**
 * 
 * @author alexey
 *
 * @param <V>
 *            object
 */
public class Order<V> {
	final Graph<V> graph;
	final BitSet marked;
	final int edgeTo[];
	final GraphVisitor<V> visitor;
	final GraphVisitor.Direction direction;

	public Order(Graph<V> graph, GraphVisitor<V> visitor, GraphVisitor.Direction direction) {
		super();
		this.graph = graph;
		this.visitor = visitor;
		this.direction = direction;
		this.marked = new BitSet(graph.getVertices());
		this.edgeTo = new int[graph.getVertices()];
		for (int v = 0; v < graph.getVertices(); v++) {
			if (!marked.get(v)) {
				dfs(v);
			}
		}
	}

	private void dfs(int v) {
		marked.set(v);
		if (direction == GraphVisitor.Direction.PRE)
			visitor.visitNode(graph.objFor(v));
		for (V w : graph.adjacent(graph.objFor(v))) {
			int iw = graph.indexFor(w);
			if (!marked.get(iw)) {
				edgeTo[iw] = v;
				dfs(iw);
			}
		}
		if (direction == GraphVisitor.Direction.POST)
			visitor.visitNode(graph.objFor(v));
	}
}
