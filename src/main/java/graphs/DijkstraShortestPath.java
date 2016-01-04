package graphs;

import java.util.BitSet;

public class DijkstraShortestPath<V> {
	   private BitSet marked;
	    private int[] edgeTo; 
	    private double[] distTo;
	    private final AbstractWeightedDigraph<V> graph;
	    private final int source;
		
	    public DijkstraShortestPath(AbstractWeightedDigraph<V> graph, int source) {
	        this.marked = new BitSet(graph.vertices);
	        this.edgeTo = new int[graph.vertices];
	        this.distTo = new double[graph.vertices];
			this.graph = graph;
			this.source = source;
			for (int v = 0; v < graph.vertices; v++) 
				distTo[v] = Double.POSITIVE_INFINITY;
			distTo[source] = 0;
		}
}
