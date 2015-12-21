package graphs;

import java.util.Iterator;

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

	@Override
	protected AdjacentWeightedBad createAdjacentBag() {
		return new AdjacentWeightedBad();
	}
    
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges\n");
        for (int i = 0; i < this.vertices; i++) {
        	s.append(objFor(i) + ": ");
			AdjacentWeightedBad adjacentWeightedBad = adj.get(i);
			Iterator<Integer> verteciesIterator = adjacentWeightedBad.adj.iterator();
			Iterator<Double> weightsIterator = adjacentWeightedBad.weights.iterator();
			while(verteciesIterator.hasNext()){
				Integer w = verteciesIterator.next();
				Double weight = weightsIterator.next();
				s.append(objFor(w)).append("|").append(weight).append(" ");
			}
			s.append("\n");
		}
        return s.toString();
    }
}
