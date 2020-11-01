package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	void findCombinations(int k, int n, Consumer<List<Integer>> consumer) {
		int[] arr = new int[k];
		for (int i = 0; i < 10; i++) {
			arr[0] = i + 1;
			find(arr, 0, k, n, consumer);
		}
	}

	void find(int[] arr, int index, int k, int n, Consumer<List<Integer>> consumer) {
		int sum = IntStream.range(0, index  + 1).map(i -> arr[i]).sum();
		if(sum > n)
			return;
		if (index == k - 1) {
			if (sum == n)
				consumer.accept(Arrays.stream(arr).boxed().collect(Collectors.toList()));
			return;
		} else {
			for (int i = arr[index] + 1; i < 10; i++) {
				arr[index + 1] = i;
				find(arr, index + 1, k, n, consumer);
			}
		}
	}

	@Test
	public void test1() {
		findCombinations(3, 15, triplet -> System.out.println(triplet));
	}
	
	@Test
	public void test2() {
		findCombinations(4, 20, triplet -> System.out.println(triplet));
	}
}
