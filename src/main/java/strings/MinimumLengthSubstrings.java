package strings;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
 * Minimum Length Substrings
 * 
 * You are given two strings s and t. 
 * You can select any substring of string s and rearrange the characters of the selected substring. 
 * Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
 * 
 * Signature
 * int minLengthSubstring(String s, String t)
 * 
 * Input
 * s and t are non-empty strings that contain less than 1,000,000 characters each
 * 
 * Output
 * Return the minimum length of the substring of s. If it is not possible, return -1
 * 
 * Example
 * s = "dcbefebce"
 * t = "fd"'
 * output = 5
 * 
 * Explanation:
 * Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. 
 * String t is a substring of "cfdeb". Thus, the minimum length required is 5.
*/
public class MinimumLengthSubstrings {

	int minLengthSubstring(String s, String t) {
		final int n = s.length();
		final int m = t.length();
		int minLength = m;
		while (minLength <= n) {
			if (loopAndFind(t, s, minLength++))
				return minLength - 1;
		}
		return -1;
	}

	boolean loopAndFind(String t, String s, int minLength) {
		final int n = s.length();
		for (int i = 0; i + minLength <= n; i++) {
			String sub = s.substring(i, i + minLength);
			if (isRearangedSubString(sub, t)) {
				System.out.println(sub);
				return true;
			}
		}
		return false;
	}

	boolean isRearangedSubString(String sub, String t) {
		final Map<Character, Long> subMap = countMapFromString(sub);
		final Map<Character, Long> tMap = countMapFromString(t);

		for (Entry<Character, Long> entry : tMap.entrySet()) {
			Long count = subMap.get(entry.getKey());
			if (count == null || count < entry.getValue())
				return false;
		}
		return true;
	}

	Map<Character, Long> countMapFromString(String sub) {
		Map<Character, Long> collect = sub.chars()
				.mapToObj(v -> (char)v)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return collect;
	}

	@Test
	public void test1() {
		String s = "dcbefebce";
		String t = "fd";
		int expected = 5;
		Assert.assertEquals(expected, minLengthSubstring(s, t));

	}

	@Test
	public void test2() {
		String s = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
		String t = "cbccfafebccdccebdd";
		int expected = -1;
		Assert.assertEquals(expected, minLengthSubstring(s, t));
	}

	@Test
	public void test3() {
		String s = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
		String t = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
		int expected = t.length();
		Assert.assertEquals(expected, minLengthSubstring(s, t));
	}
	@Test
	public void test4() {
		String s = "bfbeadbcbcbfeaaeevfcddcccbbbfaaafdbebedddf";
		String t = "abcdefv";
		int expected = 11;
		Assert.assertEquals(expected, minLengthSubstring(s, t));
	}

}
