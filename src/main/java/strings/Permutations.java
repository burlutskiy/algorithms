package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given a string S. The task is to print all permutations of a given string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Constraints:
1 ≤ T ≤ 10
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA 
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
 */

public class Permutations {

	class Node {
		char c;
		Node[] nodes;

		Node(char c, Node[] nodes) {
			this.c = c;
			this.nodes = nodes;
		}
	}

	public List<String> permutate(String str) {
		Node root = buildNodes((char) 0, str.toCharArray());
		Stack<Character> stack = new Stack<>();
		final List<String> permutations = new LinkedList<>();
		traverse(root, stack, c -> permutations.add(c));
		Collections.sort(permutations);
		return permutations;
	}

	private String stackToString(Stack<Character> stack) {
		return stack.stream().map(c -> c.toString()).collect(Collectors.joining());
	}

	private void traverse(Node node, Stack<Character> stack, Consumer<String> consumer) {
		if (node == null || node.nodes == null) {
			consumer.accept(stackToString(stack));
			return;
		}
		for (Node n : node.nodes) {
			stack.push(n.c);
			traverse(n, stack, consumer);
			stack.pop();
		}
	}

	private Node buildNodes(char lchar, char[] arr) {
		if (arr.length == 0)
			return new Node(lchar, null);

		Node[] nodes = new Node[arr.length];
		Node node = new Node(lchar, nodes);
		for (int i = 0; i < arr.length; i++) {
			char nc = arr[i];
			swap(arr, 0, i);
			char[] cut = cut(arr);
			nodes[i] = buildNodes(nc, cut);
			swap(arr, 0, i);
		}
		return node;
	}

	private static char[] cut(char[] array) {
		char[] r = new char[array.length - 1];
		for (int i = 0; i < array.length - 1; i++)
			r[i] = array[i + 1];
		return r;
	}

	private static void swap(char[] arr, int idx1, int idx2) {
		char tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

	@Test
	public void test() {
		Permutations perm = new Permutations();
		Assert.assertEquals(Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA"), perm.permutate("ABC"));
		Assert.assertEquals(Arrays.asList("ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS",
				"GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"), perm.permutate("ABSG"));
	}
}
