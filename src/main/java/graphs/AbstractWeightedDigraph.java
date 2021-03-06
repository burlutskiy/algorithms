package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.Pair;

/**
 * @author alexey
 *
 */
public abstract class AbstractWeightedDigraph<V> extends AbstractDigraph<V, Pair<Integer, Double>, AdjacentWeightedBad>
		implements WeightedGraph<V> {

	public AbstractWeightedDigraph(int vertices) {
		super(vertices);
	}

	public void addEdge(V v, V w) {
		throw new UnsupportedOperationException("weight cannot be null");
	}

	public void addEdge(V v, V w, double weight) {
		AdjacentWeightedBad adjacentWeightedBad = adj.get(indexFor(v));
		adjacentWeightedBad.add(indexFor(w), weight);
		edges++;
	}

	public void addEdge(Edge e) {
		AdjacentWeightedBad adjacentWeightedBad = adj.get(e.v);
		adjacentWeightedBad.add(e.w, e.weight);
		edges++;
	}

	protected AdjacentWeightedBad createAdjacentBag() {
		return new AdjacentWeightedBad();
	}

	List<Edge> edges(int iv) {
		AdjacentWeightedBad bad = adj.get(iv);
		List<Edge> list = new ArrayList<>(bad.size());
		for (int i = 0; i < bad.size(); i++) {
			list.add(new Edge(iv, bad.adj.get(i), bad.weights.get(i)));
		}
		return list;
	}

	public List<Edge> edges() {
		List<Edge> list = new ArrayList<>(edges);
		for (int v = 0; v < vertices; v++) {
			AdjacentWeightedBad bag = adj.get(v);
			Iterator<Integer> verteciesIterator = bag.adj.iterator();
			Iterator<Double> weightsIterator = bag.weights.iterator();
			while (verteciesIterator.hasNext()) {
				Integer w = verteciesIterator.next();
				Double weight = weightsIterator.next();
				if (!list.add(new Edge(v, w, weight)))
					throw new RuntimeException();
			}
		}
		return list;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(vertices + " vertices, " + edges + " edges\n");
		for (int i = 0; i < this.vertices; i++) {
			s.append(objFor(i) + ": ");
			AdjacentWeightedBad adjacentWeightedBad = adj.get(i);
			Iterator<Integer> verteciesIterator = adjacentWeightedBad.adj.iterator();
			Iterator<Double> weightsIterator = adjacentWeightedBad.weights.iterator();
			while (verteciesIterator.hasNext()) {
				Integer w = verteciesIterator.next();
				Double weight = weightsIterator.next();
				s.append(objFor(w)).append("|").append(weight).append(" ");
			}
			s.append("\n");
		}
		return s.toString();
	}
}
