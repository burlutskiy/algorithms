package arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindFirstNotIncludedPositiveNumber {
	public int solution(int... A) {
		Arrays.sort(A);
		int zeroPos = Arrays.binarySearch(A, 0);
		if (zeroPos < 0)
			zeroPos = -1 * zeroPos - 1;

		for (int i = 1; true ; i++) {
			int idx = Arrays.binarySearch(A, zeroPos, A.length, i);
			if (idx < 0)
				return i;
		}
	}

	@Test
	public void test() {
		Assert.assertEquals(4, solution(1,2,3));
	}
	
	/**
	 * Example test:   [1, 3, 6, 4, 1, 2]
OK

Example test:   [1, 2, 3]
OK

Example test:   [-1, -3]
	 */
}
