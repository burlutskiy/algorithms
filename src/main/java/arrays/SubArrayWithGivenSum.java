package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. 
 * Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, 
 * where N is the size of array and S is the sum. 
 * The second line of each test case contains N space separated integers denoting the array elements.
 * 
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of first 
 * such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:

Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10

Output:
2 4
1 5
*/
public class SubArrayWithGivenSum {

	public static void main(String[] strings) {
		try (final Scanner scanner = new Scanner(System.in)) {
			int n = Integer.valueOf(scanner.nextLine());
			for (int i = 0; i < n; i++) {
				int sum = Integer.valueOf(scanner.nextLine().split(" ")[1]);
				String[] str = scanner.nextLine().split(" ");
				int[] array = new int[str.length];
				for (int j = 0; j < array.length; j++)
					array[j] = Integer.valueOf(str[j]);
				subArrayWithSum(array, sum);
			}
		}
	}

	/*
	 * O(n), space O(n)
	 */
	private static void subArrayWithSum(int[] n, int sum) {
		if (n.length == 0) {
			System.out.println(-1);
			return;
		}
		Map<Integer, Integer> csum = new HashMap<>();
		int lsum = 0;
		csum.put(0, -1);
		for (int i = 0; i < n.length; i++) {
			lsum += n[i];
			csum.put(lsum, i);
			if (csum.containsKey(lsum - sum) ) {
				System.out.println(String.format("%d %d", csum.get(lsum - sum) + 2, i + 1));
				return;
			}
		}
		System.out.println(-1);
	}

	/*
	 * O(n), space O(1)
	 */
	private static void __subArrayWithSum(int[] n, int sum) {
		if (n.length == 0) {
			System.out.println(-1);
			return;
		}
		int i = 0, j = 0;
		int lsum = n[i];
		while (i < n.length && j < n.length) {
			if (lsum == sum) {
				System.out.println(String.format("%d %d", i + 1, j + 1));
				return;
			}
			if (lsum < sum) {
				if (j + 1 < n.length)
					lsum += n[++j];
			} else {
				lsum -= n[i++];
			}
		}
		System.out.println(-1);
	}

	/**
	 * 
	 * Too slow O(n^2)
	 */
	@Deprecated
	private static void _subArrayWithSum(int[] n, int sum) {
		if (n.length == 0) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < n.length; i++) {
			int lsum = 0;
			for (int j = i; j < n.length; j++) {
				lsum += n[j];
				if (lsum == sum) {
					System.out.println(String.format("%d %d", i + 1, j + 1));
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
