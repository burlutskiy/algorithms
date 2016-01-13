package sort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class KeyIndexedCountingTest {
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	@Test
	public void test() {
		int[] a = new int[] { 2, 6, 3, 4, 1, 3, 8, 7, 9, 4, 0, 3, 0, 3 };
		KeyIndexedCounting.sort(a, 10);
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				Assert.fail(Arrays.toString(a) + " wasn't sorted");
			}
		}
	}

	@Test
	public void test2() {
		int[] a = new int[MAX_ARRAY_SIZE];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(MAX_ARRAY_SIZE);
		}
		KeyIndexedCounting.sort(a, MAX_ARRAY_SIZE);
	}
}
