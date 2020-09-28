package arrays;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromArray {

	Map<Integer, Integer> buildDublicatesMap(int[] arr) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < arr.length; i++)
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		return map;
	}
	
	int countDublicatePairs(Map<Integer, Integer> map) {
		return map.values().stream().filter(n -> n > 1).mapToInt(n -> new Integer(n*(n-1)/2)).sum();
	}

	int[] removeDuplicates(Map<Integer, Integer> map) {
		return map.keySet().stream().mapToInt(i->i).toArray();
	}

	
	public int[] removeDuplicates(int[] array) {
		return removeDuplicates(buildDublicatesMap(array));
	}
	
	@Test
	public void test() {
		RemoveDuplicatesFromArray sol = new RemoveDuplicatesFromArray();
		Assert.assertArrayEquals(new int[]{ 1, 5, 3 }, sol.removeDuplicates(new int[]{ 1, 5, 3, 3, 3 }));
		Assert.assertArrayEquals(new int[]{ 1, 2, 3, 4 }, sol.removeDuplicates(new int[]{ 1, 2, 3, 4, 3 }));
	}
}
