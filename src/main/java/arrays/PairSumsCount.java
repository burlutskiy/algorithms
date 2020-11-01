package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * You will be given an array of integers and a target value. Determine the
 * number of pairs of array elements that adds up to a target
 * value.
 * 
 */
public class PairSumsCount {

	int numberOfWays(int[] arr, int k) {
		Map<Integer, Integer> auxMap = buildDublicatesMap(arr);
		int dpairCount = countDublicatePairs(auxMap);
		arr = removeDuplicates(auxMap);
		
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int idx = Arrays.binarySearch(arr, i, arr.length, k - arr[i]);
			if (idx < 0 || idx == i)
				continue;
			count++;
		}
		return count + dpairCount;
	}
	
	Map<Integer, Integer> buildDublicatesMap(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
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

    @Test 
    public void test0() {
    	Assert.assertEquals(2, numberOfWays(new int[] { 1, 2, 3, 4, 3 }, 6));
    }
    
    @Test 
    public void test1() {
    	Assert.assertEquals(4, numberOfWays(new int[] { 1, 5, 3, 3, 3 }, 6));
    }
    
    @Test 
    public void test2() {
    	Assert.assertEquals(1, numberOfWays(new int[] { 1, 5, 3, 4, 7 }, 6));
    }
    
    @Test 
    public void test3() {
    	Assert.assertEquals(1, numberOfWays(new int[] { 6, 6 }, 12));
    }
    
}
