package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Two sum exacly one solution
 * 
 * @author alexey
 *
 */
public class TwoSum {

	/*
	 * O(N)
	 */
	public int[] twoSum(int nums[], int target) {
		final Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(target - nums[i])) {
        		return new int[] {map.get(target - nums[i]), i};
        	}
        	map.put(nums[i], i);
        }		
        throw new RuntimeException("no exacly one solution foud");
	}
	
	/*
	 * O(NlogN)
	 */
    public int[] _twoSum(int[] nums, int target) {
    	int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for(int i = 0; i < nums.length; i++) {
        	int idx = Arrays.binarySearch(sorted, target - sorted[i]);
        	if(idx >= 0) {
        		int x = 0;
        		int[] result = new int[2];
        		for(int j = 0; j < nums.length; j++) {
        			if(nums[j] == sorted[i])
        				result[x++] = j;
        			else if(nums[j] == sorted[idx])
        				result[x++] = j;
        			if(x >  1)
        				break;
        		}
        		return result;
        	}
        }
        throw new RuntimeException("no exacly one solution foud");
    }
    
    @Test 
    public void test() {
    	Assert.assertArrayEquals(new int[] {1,2}, twoSum(new int[] {3,2,4}, 6));
    	
    }
    
    @Test 
    public void test1() {
    	Assert.assertArrayEquals(new int[] {0, 1}, twoSum(new int[] {3,3}, 6));
    }
}
