package graphs;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author alexey
 *
 */
public class IndexedWeightedDigraph extends AbstractWeightedDigraph<Integer> {

	public IndexedWeightedDigraph(int vertices) {
		super(vertices);
	}

	@Override
	public List<Integer> adjacent(Integer v) {
		return adj.get(v).adj;
	}

	@Override
	public int indexFor(Integer v) {
		return v;
	}

	@Override
	public Integer objFor(int index) {
		return index;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int iter = 0;
			public Integer next() {
				return iter++;
			}
			
			@Override
			public boolean hasNext() {
				return iter < getVertices();
			}
		};
	}

	@Override
	public IndexedWeightedDigraph createInstance(int v) {
		return new IndexedWeightedDigraph(v);
	}

}
