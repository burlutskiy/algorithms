package math;

import org.junit.Assert;
import org.junit.Test;

/*
 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
public class CountPrimes {

	public static int countPrimes(int n) {
		int count = 0;
		for (int i = 1; i < n; i++)
			if (isPrime(i)) {
				count++;
				System.out.println(i);
			}
		return count;
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n > 3 && (n % 2 == 0 || n % 3 == 0))
			return false;

		int i = n;
		while (i > 2)
			if (n % --i == 0)
				return false;
		return true;
	}

	@Test
	public void testIsPrime() {
		Assert.assertFalse(isPrime(1));
		Assert.assertTrue(isPrime(2));
		Assert.assertTrue(isPrime(3));
		Assert.assertTrue(isPrime(5));
		Assert.assertTrue(isPrime(7));
		Assert.assertTrue(isPrime(10007));
	}

	@Test
	public void testCountPrimes() {
		Assert.assertEquals(1, countPrimes(3));
		Assert.assertEquals(4, countPrimes(10));
	}
}
