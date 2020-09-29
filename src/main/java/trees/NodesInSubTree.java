package trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * Nodes in a Subtree
 * 
 * You are given a tree that contains N nodes, each containing an integer u which corresponds to a lowercase 
 * character c in the string s using 1-based indexing.
 * You are required to answer Q queries of type [u, c], where u is an integer and c is a lowercase letter. 
 * The query result is the number of nodes in the subtree of node u containing c.
 * 
 * Signature
 * int[] countOfNodes(Node root, ArrayList<Query> queries, String s)
 * 
 * Input
 * A pointer to the root node, an array list containing Q queries of type [u, c], and a string s
 * 
 * Constraints
 * N and Q are the integers between 1 and 1,000,000
 * u is a unique integer between 1 and N
 * s is of the length of N, containing only lowercase letters
 * c is a lowercase letter contained in string s
 * Node 1 is the root of the tree
 * 
 * Output
 * An integer array containing the response to each query
 * 
 * Example
        1(a)
        /   \
      2(b)  3(a)
 * s = "aba"
 * RootNode = 1
 * query = [[1, 'a']]
 * Note: Node 1 corresponds to first letter 'a', Node 2 corresponds to second letter of the string 'b', Node 3 corresponds to third letter of the string 'a'.
 * output = [2]
 * Both Node 1 and Node 3 contain 'a', so the number of nodes within the subtree of Node 1 containing 'a' is 2.
 */
public class NodesInSubTree {
	// Tree Node
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
			val = 0;
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	class Query {
		int u;
		char c;

		Query(int u, char c) {
			this.u = u;
			this.c = c;
		}
	}

	int traverse(Node root, char c, Map<Integer, Character> ucMap) {
		if (root == null)
			return 0;
		int count = ucMap.get(root.val) == c ? 1 : 0;
		if (root.children == null || root.children.isEmpty())
			return count;
		return count + root.children.stream().mapToInt(node -> traverse(node, c, ucMap)).sum();
	}

	Node findNode(Node root, int u) {
		if (root == null || root.children == null || root.children.isEmpty())
			return null;
		if (root.val == u)
			return root;
		for (Node node : root.children) {
			Node tmp = findNode(node, u);
			if (tmp != null)
				return tmp;
		}
		return null;
	}

	Map<Integer, Character> convert(String s) {
		Map<Integer, Character> map = new HashMap<>();
		char[] carr = s.toCharArray();
		for (int i = 0; i < carr.length; i++)
			map.put(i + 1, carr[i]);
		return map;
	}

	int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
		final Map<Integer, Character> ucMap = convert(s);
		final int[] result = new int[queries.size()];
		int i = 0;
		for (Query query : queries) {
			Node node = findNode(root, query.u);
			if (node != null)
				result[i++] = traverse(node, query.c, ucMap);
			else
				result[i++] = 0;
		}
		return result;
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	public void run() throws IOException {
		Scanner sc = new Scanner(System.in);

		// Testcase 1
		int n_1 = 3, q_1 = 1;
		String s_1 = "aba";
		Node root_1 = new Node(1);
		root_1.children.add(new Node(2));
		root_1.children.add(new Node(3));
		ArrayList<Query> queries_1 = new ArrayList<>();
		queries_1.add(new Query(1, 'a'));
		int[] output_1 = countOfNodes(root_1, queries_1, s_1);
		int[] expected_1 = { 2 };
		check(expected_1, output_1);

		// Testcase 2
		int n_2 = 7, q_2 = 3;
		String s_2 = "abaacab";
		Node root_2 = new Node(1);
		root_2.children.add(new Node(2));
		root_2.children.add(new Node(3));
		root_2.children.add(new Node(7));
		root_2.children.get(0).children.add(new Node(4));
		root_2.children.get(0).children.add(new Node(5));
		root_2.children.get(1).children.add(new Node(6));
		ArrayList<Query> queries_2 = new ArrayList<>();
		queries_2.add(new Query(1, 'a'));
		queries_2.add(new Query(2, 'b'));
		queries_2.add(new Query(3, 'a'));
		int[] output_2 = countOfNodes(root_2, queries_2, s_2);
		int[] expected_2 = { 4, 1, 2 };
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) throws IOException {
		new NodesInSubTree().run();
	}
}