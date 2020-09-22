package arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysSumEqualsK {

	public static void main(String[] args) {

	}

	/*
	 * O(n)
	 * Using the cumulative sum  
	 */
	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	/*
	 * O(n^2)
	 */
	public int _subarraySum(int[] nums, int sum) {
		if (nums.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int lsum = 0;
			for (int j = i; j < nums.length; j++) {
				lsum += nums[j];
				if (lsum == sum) {
					count++;
					continue;
				}

			}
		}
		return count;
	}

}
