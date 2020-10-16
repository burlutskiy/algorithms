package graphs.flat;

import org.junit.Assert;
import org.junit.Test;

public class SinglePointOfFailure {

	class Graph {
		final int[][] graph;
		final int n;

		Graph(int[][] graph) {
			this.graph = graph;
			this.n = graph.length;
		}

		boolean allConnected(int from) {
			boolean[] marked = new boolean[n];
			return dfs_count(from, marked) == n;
		}
		
		int dfs_count(int vertex, boolean[] marked) {
			marked[vertex] = true;
			int count = 1;
			for (int j = 0; j < n; j++) {
				if (vertex != j && graph[vertex][j] == 1 && !marked[j]) {
					count += dfs_count(j, marked);
				}
			}
			return count;
		}

	}

	int singlePointOfFailure(int[][] arr) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] = 0;
					Graph g = new Graph(arr);
					if(!g.allConnected(i))
						count++;
					arr[i][j] = 1;
				}
			}
		}
		return count;
	}

	@Test
	public void test() {
		int[][] matrix = { { 0, 1, 1, 1, 0, 0 }, { 1, 0, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0, 0 } };
		Assert.assertEquals(3, singlePointOfFailure(matrix));
	}

	@Test
	public void test2() {
		int[][] matrix = {{0, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}};
		Assert.assertEquals(4, singlePointOfFailure(matrix));
	}
}
