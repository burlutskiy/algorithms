package graphs;

import java.util.PriorityQueue;

import stacks.Stack;

/**
 * Dijkstra Algorithms combines finding SPT for weighted digraph or for weighted acyclic digraphs.
 * 
 * @author alexey
 *
 */
public class DijkstraShortestPath<V> {
	private int[] edgeTo;
	private double[] distTo;
	private final PriorityQueue<DistanceTo> pq;
	private final AbstractWeightedDigraph<V> graph;
	private final int source;
	

	private static class DistanceTo implements Comparable<DistanceTo>{
		final int to;
		final double weight;
		
		public DistanceTo(int to, double weight) {
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(DistanceTo distTo) {
			return Double.compare(weight, distTo.weight);
		}
	}
	
	public DijkstraShortestPath(AbstractWeightedDigraph<V> graph, V source) {
		this.edgeTo = new int[graph.vertices];
		this.distTo = new double[graph.vertices];
		this.pq = new PriorityQueue<>(graph.vertices);
		this.graph = graph;
		this.source = graph.indexFor(source);
		for (int v = 0; v < graph.vertices; v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[this.source] = 0;
		Cycle<V> testDAG = new Cycle<>(graph);
		if(!testDAG.hasCycle()){
			TopologicalOrder<V> order = new TopologicalOrder<>(graph);
			relaxAcyclicWeightedDigraph(order);
		} else {
			relaxWeightedDigraph();
		}
	}

	private void relaxAcyclicWeightedDigraph(TopologicalOrder<V> order){
		for (V v : order.order()) {
			for (Edge e : graph.edges(graph.indexFor(v))){
				relax(e);
			}
		}
	}

	private void relaxWeightedDigraph(){
		pq.add(new DistanceTo(this.source, 0));
		while (!pq.isEmpty()) {
			DistanceTo distination = pq.poll();
			for (Edge e : graph.edges(distination.to))
				relax(e);
		}
	}
	
	private void relax(Edge e) {
		int v = e.v, w = e.w;
		if (distTo[w] > distTo[v] + e.weight) {
			distTo[w] = distTo[v] + e.weight;
			edgeTo[w] = v;
			if (pq.contains(w)){
				pq.remove(new DistanceTo(w, distTo[w]));
//				pq.decreaseKey(w, distTo[w]); TODO implement IndexedPriorityQueue
			}
			else
				pq.add(new DistanceTo(w, distTo[w]));
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(V v) {
		return distTo[graph.indexFor(v)] < Double.POSITIVE_INFINITY;
	}

	public Iterable<V> pathTo(V v) {
		if (!hasPathTo(v))
			return null;
		Stack<V> stack = new Stack<>();
		for (int x = graph.indexFor(v); distTo[x] != 0; x = edgeTo[x]) {
			stack.push(graph.objFor(x));
		}
		stack.push(graph.objFor(source));
		return stack;
	}

}
