package greedy;

import java.util.Arrays;

public class SlowSum {

	// Add any helper functions you may need here
	// 3 2 1
	// 0 5 11
	// 3+2 5+1

	int getTotalTime(int[] arr) {
		int n = arr.length;
		Arrays.sort(arr);
		int penalty = 0;
		if (n > 1) {
			int sum = arr[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				sum += arr[i];
				if (sum > 5 * 1000000)
					throw new IllegalArgumentException("Sum exceeds 5*10^6 : " + sum);
				penalty += sum;
			}
		}
		return penalty;
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
		int[] arr_1 = { 4, 2, 1, 3 };
		int expected_1 = 26;
		int output_1 = getTotalTime(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = { 2, 3, 9, 8, 4 };
		int expected_2 = 88;
		int output_2 = getTotalTime(arr_2);
		check(expected_2, output_2);

		// Add your own test cases here
		check(11, getTotalTime(new int[] { 1, 2, 3 }));
		check(3, getTotalTime(new int[] { 1, 2 }));
		check(0, getTotalTime(new int[] { 1 }));
		check(0, getTotalTime(new int[] {}));

		int[] arr_3 = new int[1000000];
		Arrays.fill(arr_3, 0);
		check(0, getTotalTime(arr_3));

		Arrays.fill(arr_3, 10);
		try {
			check(0, getTotalTime(arr_3));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		new SlowSum().run();
	}
}
