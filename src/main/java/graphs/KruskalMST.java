package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import uf.UF;

/**
 * @author alexey
 *
 * O(N) = E*log(E) + E*log*(V), where log*(V) - iterated logarithm
 */
public class KruskalMST<V> {
	private List<Edge> mst; 
	
	public KruskalMST(AbstractWeightedDigraph<V> graph) {
		this.mst = new ArrayList<>(graph.vertices/2);
		PriorityQueue<Edge> pq = new PriorityQueue<>(graph.edges());
		Iterator<Edge> iterator = pq.iterator();
		UF uf = new UF(graph.vertices);
		while(iterator.hasNext()){
			Edge edge = iterator.next();
            if (!uf.connected(edge.v, edge.w)) { // v-w does not create a cycle
                uf.union(edge.v, edge.w);  // merge v and w components
				mst.add(edge);
			}
		}
	}

	public List<Edge> edges(){
		return mst;
	}
}
