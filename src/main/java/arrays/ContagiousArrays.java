package arrays;

import java.util.ArrayList;
import java.util.List;

public class ContagiousArrays {

	// find a number of subarrays for index of max
	int countSubarrays(int[] arr, int imax) {
		
		final int max = arr[imax];
		final int n = arr.length;

		int result = 1;
		int i = imax;
		while (++i < n)
			if (arr[i] < max)
				result++;
			else
				break;

		i = imax;
		while (--i >= 0)
			if (arr[i] < max)
				result++;
			else
				break;

		return result;
	}

	int[] countSubarrays(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++)
			list.add(countSubarrays(arr, i));
		return list.stream().mapToInt(i -> i).toArray();
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

	public void run() {
		int[] test_1 = { 3, 4, 1, 6, 2 };
		int[] expected_1 = { 1, 3, 1, 5, 1 };
		int[] output_1 = countSubarrays(test_1);
		check(expected_1, output_1);

		int[] test_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { 1, 2, 6, 1, 3, 1 };
		int[] output_2 = countSubarrays(test_2);
		check(expected_2, output_2);

		// Add your own test cases here
		check(new int[] { 1 }, countSubarrays(new int[] { 3 }));
		check(new int[] { 1, 2 }, countSubarrays(new int[] { 3, 4 }));

	}

	public static void main(String[] args) {
		new ContagiousArrays().run();
	}
}
