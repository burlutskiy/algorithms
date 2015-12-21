package graphs;

import java.util.LinkedList;
import java.util.List;

public class AdjacentWeightedBad extends AdjacentBag{
	final List<Double> weights;

	public AdjacentWeightedBad() {
		super();
		this.weights = new LinkedList<>();
	}
	
	public void add(Integer v, double w){
		super.add(v);
		weights.add(w);
	}
	
}
