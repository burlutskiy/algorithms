package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a positive integer N, the task is to find out all the combinations of
 * positive integers of size K, where 0 < Ki < K, that add upto the given
 * integer N.
 * 
 * Example: k=3,n=15
 * 
 * 15=1+5+9 15=1+6+8 15=2+4+9 15=2+5+8 15=2+6+7 15=3+4+8 15=3+5+7 15=4+5+6
 * 
 * @author alexey
 *
 */
public class CombinationsWithGivenSum {

	void findCombinations(int k, int n, Consumer<Collection<Integer>> consumer) {
		find(new Stack<Integer>(), k, n, consumer);
	}

	void find(Stack<Integer> stack, int k, int n, Consumer<Collection<Integer>> consumer) {
		int sum = stack.stream().mapToInt(i -> i).sum();
		if (sum > n)
			return;
		if (stack.size() == k) {
			if (sum == n)
				consumer.accept(stack);
			return;
		} else {
			int i = 1;
			if (!stack.isEmpty())
				i = stack.peek() + 1;
			for (; i < 10; i++) {
				stack.push(i);
				find(stack, k, n, consumer);
				stack.pop();
			}
		}
	}

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[][] { { 1, 5, 9 }, { 1, 6, 8 }, { 2, 4, 9 }, { 2, 5, 8 }, { 2, 6, 7 }, { 3, 4, 8 }, { 3, 5, 7 }, { 4, 5, 6 } },
				find(3, 15));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[][] { { 1, 2, 8, 9 }, { 1, 3, 7, 9 }, { 1, 4, 6, 9 }, { 1, 4, 7, 8 }, { 1, 5, 6, 8 }, { 2, 3, 6, 9 }, { 2, 3, 7, 8 },
				{ 2, 4, 5, 9 }, { 2, 4, 6, 8 }, { 2, 5, 6, 7 }, { 3, 4, 5, 8 }, { 3, 4, 6, 7 } }, find(4, 20));
	}

	int[][] find(int k, int n) {
		final Set<List<Integer>> set = new LinkedHashSet<>();
		Consumer<Collection<Integer>> consumer = collection -> {
			List<Integer> list = new ArrayList<>(collection);
			list.sort(Comparator.naturalOrder());
			set.add(list);
		};
		findCombinations(k, n, consumer);
		int[][] result = new int[set.size()][k];
		int i = 0;
		for (List<Integer> list : set)
			result[i++] = list.stream().mapToInt(j -> j).toArray();
		return result;
	}
}
