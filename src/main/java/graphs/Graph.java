/**
 * 
 */
package graphs;

/**
 * @author burlutal
 *
 */
public class Graph extends AbstractGraph<Integer, AdjacencyArrayList> {

	public Graph(int vertices) {
		super(vertices, new AdjacencyArrayList(vertices));
	}

}
