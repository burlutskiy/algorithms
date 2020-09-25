package greedy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * Seating Arrangements
 * 
There are n guests attending a dinner party, numbered from 1 to n. 
The ith guest has a height of arr[i] inches.
The guests will sit down at a circular table which has n seats, 
numbered from 1 to n in clockwise order around the table. 
As the host, you will choose how to arrange the guests, one per seat. 
Note that there are n! possible permutations of seat assignments.
Once the guests have sat down, the awkwardness between a pair of guests sitting 
in adjacent seats is defined as the absolute difference between their two heights. 
Note that, because the table is circular, seats 1 and n are considered to be adjacent 
to one another, and that there are therefore n pairs of adjacent guests.

The overall awkwardness of the seating arrangement is then defined as the maximum 
awkwardness of any pair of adjacent guests. Determine the minimum possible overall 
awkwardness of any seating arrangement.

Input
n is in the range [3, 1000].
Each height arr[i] is in the range [1, 1000].

Output
Return the minimum achievable overall awkwardness of any seating arrangement.

Example
n = 4
arr = [5, 10, 6, 8]
output = 4
If the guests sit down in the permutation [3, 1, 4, 2] in clockwise order around the table (having heights [6, 5, 8, 10], in that order), then the four awkwardnesses between pairs of adjacent guests will be |6-5| = 1, |5-8| = 3, |8-10| = 2, and |10-6| = 4, yielding an overall awkwardness of 4. It's impossible to achieve a smaller overall awkwardness.
 */
public class SeatingsArrangements {
	// Add any helper functions you may need here

	// 1 2 3 4 -> 1 2 4 3 -> 2
	// 1 2 3 4 5 6 -> 1 2 4 6 5 3 -> 2

	// 1 2 3 4 5 6 7 -> 1 3 5 7 6 4 2 -> 2

	// 2 4 6 8 10 15 21 -> 10 21 15 -> 11
	// 3 6 9 12 15 18 21 -> 3 9 15 21 18 12 6 -> 6

	// i-1 (i i+1) i+2 -> i-1 (i+1 i) i+2

	int minOverallAwkwardness(int[] arr) {
		final int n = arr.length;
		if(n < 3)
			throw new IllegalArgumentException("length is less than 3");
		Arrays.sort(arr);
		int lm, hm;
		int awk = 0;
		int i = 0;

		if (n % 2 != 0) {
			lm = hm = arr[n - 1];
			i = n - 2;
		} else {
			hm = arr[n - 1];
			lm = arr[n - 2];
			i = n - 3;
		}

		while (i > 0) {
			int m1 = arr[i];
			int m2 = arr[i - 1];
			awk = Math.max(awk, Math.max(lm - m2, hm - m1));
			lm = m2;
			hm = m1;
			i -= 2;
		}
		return awk;
	}


	@Test
	public void test() {
	    SeatingsArrangements testee = new SeatingsArrangements();
		Assert.assertEquals(2, testee.minOverallAwkwardness(new int[] { 1, 2, 3, 4 }));
		Assert.assertEquals(11, testee.minOverallAwkwardness(new int[] { 2, 4, 6, 8, 10, 15, 21 }));
		Assert.assertEquals(4, testee.minOverallAwkwardness(new int[] { 5, 10, 6, 8 }));
		Assert.assertEquals(4, testee.minOverallAwkwardness(new int[] { 1, 2, 5, 3, 7 }));
		Assert.assertEquals(2, testee.minOverallAwkwardness(new int[] { 1, 2, 3 }));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEx() {
	    SeatingsArrangements testee = new SeatingsArrangements();
		Assert.assertEquals(1, testee.minOverallAwkwardness(new int[] { 1, 2 }));
	}
}
