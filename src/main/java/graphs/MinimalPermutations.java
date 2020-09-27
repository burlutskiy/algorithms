package graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MinimalPermutations {
	
	class PermutationGraph {
	    final Map<String, Integer> vertexMap = new HashMap<>();
	    final Map<Integer, Integer> edgeTo = new HashMap<>();
	    final AtomicInteger vertexCount = new AtomicInteger();
	    final String solution;
	    
	    PermutationGraph(int[] arr) {
	    	arr = arr.clone();
	    	Arrays.sort(arr);
	    	solution = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining());
	    }

	    boolean isItSolution(String permutation) {
	    	return permutation.equals(solution);
	    }
	    
	    boolean containsPermutation(String permutation) {
	    	return vertexMap.containsKey(permutation);
	    }

	    void addPermutation(String permutation, Integer vertexFrom) {
	    	int newVertex = vertexCount.getAndIncrement();
	    	vertexMap.put(permutation, newVertex);
	    	edgeTo.put(newVertex, vertexFrom);
	    }
	    
	    Integer getVertexFrom(String permutation) {
	    	return vertexMap.get(permutation);
	    }
	    
	    Queue<Integer> getPath(String permutation) {
	    	Queue<Integer> path = new LinkedList<Integer>();
		    int vertex = vertexMap.get(permutation);
		    path.add(vertex);
		    while(edgeTo.get(vertex) != null) {
		      vertex = edgeTo.get(vertex);
		      path.add(vertex);
		    }
		    return path;
	    }
	}

	String[] reversePermutations(String s) {
		Queue<String> queue = new LinkedList<String>();
		for(int i = 2; i <= s.length(); i++) {
			queue.addAll(permutations(s, i));
		}
		return queue.stream().toArray(String[]::new);
	}
	
	Queue<String> permutations(String s, int count) {
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i + count <= s.length(); i++) {
			StringBuilder permutation = new StringBuilder();
			if(i > 0)
				permutation.append(s.substring(0, i));
			permutation.append(new StringBuilder(s.substring(i, i + count)).reverse());
			if(i + count < s.length())
				permutation.append(s.substring(i+count));
			queue.add(permutation.toString());
		}
		return queue;
	}

	

	int minOperations(int[] arr) {
		final PermutationGraph graph = new PermutationGraph(arr);
		final Queue<String> permutations = new LinkedList<>();
	    String permutation = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining());
	    graph.addPermutation(permutation, null);
	    permutations.add(permutation);
	    while(!permutations.isEmpty()) {
	      permutation = permutations.remove();
	      if(graph.isItSolution(permutation))
	        break;
	      int vertexFrom =  graph.getVertexFrom(permutation);
	      Arrays.stream(reversePermutations(permutation))
	                                    .filter(p -> !graph.containsPermutation(p))
	                                    .forEach(p -> {
	                                    	graph.addPermutation(p, vertexFrom);
	                                    	permutations.add(p);
	                                     });
	    }
	    return graph.getPath(permutation).size() - 1;
	  }

	
	
	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() {

		int[] arr_1 = { 1, 2, 5, 4, 3 };
		int expected_1 = 1;
		int output_1 = minOperations(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = { 3, 1, 2 };
		int expected_2 = 2;
		int output_2 = minOperations(arr_2);
		check(expected_2, output_2);

	}

	public static void main(String[] args) {
		new MinimalPermutations().run();
	}
}
