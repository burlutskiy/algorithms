package graphs;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author alexey
 *
 */
public class IndexedDigraph extends AbstractDigraph<Integer> {

	public IndexedDigraph(int vertices) {
		super(vertices);
	}

	@Override
	public List<Integer> adjacent(Integer v) {
		return adj.get(v);
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
	public AbstractDigraph<Integer> createInstance(int v) {
		return new IndexedDigraph(v);
	}
}
