package graphs;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author alexey
 *
 */
public class LazyPrimMST<V> {
	private BitSet marked;
	private List<Edge> mst;
	private PriorityQueue<Edge> pq;
	private double weight;

	public LazyPrimMST(AbstractWeightedDigraph<V> graph) {
		this.mst = new ArrayList<>(graph.vertices / 2);
		pq = new PriorityQueue<>();
		marked = new BitSet();
		for (int v = 0; v < graph.vertices; v++)
			if (!marked.get(v))
				prim(graph, v); 
	}

	private void prim(AbstractWeightedDigraph<V> graph, int s) {
		scan(graph, s);
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int v = e.v, w = e.w;
			if (verticesInEdgeAreInMST(e))
				continue;
			mst.add(e);
			weight += e.weight;
			if (!marked.get(v))
				scan(graph, v);
			if (!marked.get(w))
				scan(graph, w);
		}
	}

	private boolean verticesInEdgeAreInMST(Edge e) {
		return marked.get(e.v) && marked.get(e.w);
	}

	private void scan(AbstractWeightedDigraph<V> graph, int v) {
		marked.set(v);
		List<Edge> edges = graph.edges(v);
		for (Edge e : edges) {
			if (!marked.get(e.other(v)))
				pq.add(e);
		}
	}

	public List<Edge> edges() {
		return mst;
	}
}
