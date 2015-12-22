/**
 * 
 */
package graphs;

/**
 * @author alexey
 *
 */
public class Edge implements Comparable<Edge>{
	final Integer v;
	final Integer w;
	final Double weight;

	public Edge(Integer v, Integer w, Double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public Integer getV() {
		return v;
	}
	
	public Integer getW() {
		return w;
	}

	public Double getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.getWeight().compareTo(edge.getWeight());
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}
	
}
