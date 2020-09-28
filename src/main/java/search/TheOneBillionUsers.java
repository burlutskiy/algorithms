package search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TheOneBillionUsers {

	double numberOfUsers(double rate, double day) {
		return Math.pow(rate, day);
	}

	double getUsers(double day, double[] rates) {
		return Arrays.stream(rates).map(rate -> numberOfUsers(rate, day)).sum();
	}

	double estimate(double[] rates) {
		double days = 1;
		while (getUsers(days *= 2, rates) < 1e9)
			;
		return days;
	}

	double[] converToDoubleArray(float[] arr) {
		return IntStream.range(0, arr.length).mapToDouble(i -> arr[i]).toArray();
	}

	/*
	 * O(log(n))
	 */
	int getBillionUsersDay(float[] growthRates) {
		double[] rates = converToDoubleArray(growthRates);
		int upper = (int) estimate(rates);
		int lower = (upper / 2) + 1;
		int mid = (upper + lower) / 2;

		while (upper > lower) {
			double users = getUsers(mid, rates);
			if (users > 1e9) {
				upper = mid - 1;
				mid = (upper + lower) / 2;
			} else if (users < 1e9) {
				lower = mid + 1;
				mid = (upper + lower) / 2;
			} else
				return mid;
		}
		return mid;
	}

	/**
	 * 
	 * O(n)
	 */
	@Deprecated
	int _getBillionUsersDay(float[] growthRates) {
		double[] rates = new double[growthRates.length];
		for (int i = 0; i < rates.length; i++)
			rates[i] = growthRates[i];
		int billion = (int) 1e9;
		int day = 2;
		double users = getUsers(day, rates);
		while (users < billion) {
			users = getUsers(++day, rates);
		}
		return day;
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
		float[] test_1 = { 1.1f, 1.2f, 1.3f };
		int expected_1 = 79;
		int output_1 = getBillionUsersDay(test_1);
		check(expected_1, output_1);

		float[] test_2 = { 1.01f, 1.02f };
		int expected_2 = 1047;
		int output_2 = getBillionUsersDay(test_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new TheOneBillionUsers().run();
	}
}
