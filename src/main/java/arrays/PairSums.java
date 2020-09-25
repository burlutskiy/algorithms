package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Add any extra import statements you may need here

public class PairSums {

	// Add any helper functions you may need here

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
		int k_1 = 6;
		int[] arr_1 = { 1, 2, 3, 4, 3 };
		int expected_1 = 2;
		int output_1 = numberOfWays(arr_1, k_1);
		check(expected_1, output_1);

		int k_2 = 6;
		int[] arr_2 = { 1, 5, 3, 3, 3 };
		int expected_2 = 4;
		int output_2 = numberOfWays(arr_2, k_2);
		check(expected_2, output_2);

		int k_3 = 6;
		int[] arr_3 = { 1, 5, 3, 4, 7 };
		int expected_3 = 1;
		int output_3 = numberOfWays(arr_3, k_3);
		check(expected_3, output_3);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new PairSums().run();
	}
}
