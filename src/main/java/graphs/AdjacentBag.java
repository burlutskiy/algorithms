package graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author alexey
 *
 */
public class AdjacentBag {
	final List<Integer> adj;

	public AdjacentBag() {
		super();
		this.adj = new LinkedList<>();
	}
	
	public int size(){
		return adj.size();
	}
	
	public void add(Integer v){
		adj.add(v);
	}
}
