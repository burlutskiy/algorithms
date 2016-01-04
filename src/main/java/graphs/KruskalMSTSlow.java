package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author alexey
 * It uses dfs to check if one vertex is connected to another with some path which takes log(V).
 * O(V+E) = E*log(E) + E*V
 */
public class KruskalMSTSlow<V> {
	private List<Edge> mst;

	public KruskalMSTSlow(AbstractWeightedDigraph<V> graph) {
		this.mst = new ArrayList<>(graph.vertices / 2);
		IndexedGraph ig = new IndexedGraph(graph.vertices);
		PriorityQueue<Edge> pq = new PriorityQueue<>(graph.edges());
		Iterator<Edge> iterator = pq.iterator();
		while (iterator.hasNext()) {
			Edge edge = iterator.next();
			ConnectedComponents<Integer> cc = new ConnectedComponents<>(ig);
			if (!cc.areConnected(edge.v, edge.w)) {
				ig.addEdge(edge.v, edge.w);
				mst.add(edge);
			}
			iterator.remove();
		}
	}

	public List<Edge> edges() {
		return mst;
	}

}
