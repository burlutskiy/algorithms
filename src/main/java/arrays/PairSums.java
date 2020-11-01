package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.Test;

/**
 * You will be given an array of integers and a target value. Determine the
 * number of pairs of array elements that adds up to a target value.
 * 
 */
public class PairSums {

	void find(int[] arr, int k, BiConsumer<Integer, Integer> consumer) {
		Map<Integer, List<Integer>> map = arrToIndexMap(arr);
		map.keySet().stream().
			filter(x -> map.containsKey(k - x)).
			forEach(x -> map.get(k - x).stream().
					forEach(indx -> consumer.accept(x, arr[indx])));
	}

	Map<Integer, List<Integer>> arrToIndexMap(int[] arr) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> indices = map.getOrDefault(arr[i], new ArrayList<>());
			indices.add(i);
			map.putIfAbsent(arr[i], indices);
		}
		return map;
	}

	int[][] find(int[] arr, int k) {
		final Set<List<Integer>> set = new LinkedHashSet<>();
		BiConsumer<Integer, Integer> consumer = (a, b) -> {
			List<Integer> list = Arrays.asList(a, b);
			list.sort(Comparator.naturalOrder());
			set.add(list);
		};
		find(arr, k, consumer);
		int[][] result = new int[set.size()][2];
		int i = 0;
		for (List<Integer> pair : set) {
			result[i][0] = pair.get(0);
			result[i][1] = pair.get(1);
			i++;
		}
		return result;
	}

	@Test
	public void test0() {
		Assert.assertArrayEquals(new int[][] { { 2, 4 }, { 3, 3 } }, find(new int[] { 1, 2, 3, 4, 3 }, 6));
	}

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[][] { { 6, 6 } }, find(new int[] { 6, 6 }, 12));
	}

}
