package strings;

import org.junit.Assert;
import org.junit.Test;

public class MatchingPairs {

	void swap(char[] arr, int i1, int i2) {
		char tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}

	int matches(char[] arr1, char[] arr2) {
		int res = 0;
		for (int i = 0; i < arr1.length; i++)
			if (arr1[i] == arr2[i])
				res++;
		return res;
	}

	int matchingPairs(String s, String t) {
		final char[] sarr = s.toCharArray();
		final char[] tarr = t.toCharArray();
		final int n = sarr.length;
		int max = 0;
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++) {
				if (i == j)
					continue;
				swap(sarr, i, j);
				max = Math.max(max, matches(sarr, tarr));
				swap(sarr, i, j);
			}
		return max;
	}

	int matches(char[] arr1, char[] arr2, int i1, int i2) {
		int res = 0;
		if (arr1[i1] == arr2[i1])
			res++;
		if (arr1[i2] == arr2[i2])
			res++;
		return res;
	}

	// 1 2 3 4
	// 1 3 2 4

	int matchingPairsNxN(String s, String t) {
		final char[] sarr = s.toCharArray();
		final char[] tarr = t.toCharArray();
		final int n = sarr.length;
		int matches = matches(sarr, tarr);
		if(matches == n)
			return matches - 2;
		
		int max = matches;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				int m1 = matches(sarr, tarr, i, j);
				swap(sarr, i, j);
				int m2 = matches(sarr, tarr, i, j);
				swap(sarr, i, j);
				if (m2 > m1)
					max = Math.max(max, matches + (m2 - m1));
			}
		return max;
	}

	int matchingPairsON(String s, String t) {
		return 0; // coundn't find
	}

	@Test
	public void test1() {
		Assert.assertEquals(5, matchingPairs("abcde", "adcbe"));
		Assert.assertEquals(5, matchingPairsNxN("abcde", "adcbe"));
		Assert.assertEquals(2, matchingPairs("aab", "aaa"));
		Assert.assertEquals(2, matchingPairsNxN("aab", "aaa"));
	}
	@Test
	public void test1_1() {
		Assert.assertEquals(2, matchingPairsNxN("aab", "aaa"));
	}
	@Test
	public void test2() {
		Assert.assertEquals(2, matchingPairs("abcd", "abcd"));
		Assert.assertEquals(2, matchingPairsNxN("abcd", "abcd"));
	}
	@Test
	public void test3() {
		Assert.assertEquals(2, matchingPairsNxN("zyxwvutsrqponmlkjihgfedcba", "abcdefghijklmnopqrstuvwxyz"));
	}
	@Test
	public void test4() {
		Assert.assertEquals(24, matchingPairsNxN("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
	}
}
