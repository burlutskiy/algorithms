/**
 * 
 */
package strings;

import java.util.BitSet;

/**
 * @author burlutal
 *
 * Given two strings, write a method to decide if one is a permutation of the other.
 * n-permutations = n!
 * k-permutations of n = n!/(n-k)!
 * k-combinations of n = n!/((n-k)!*k!)
 */
public class OneIsAPermutationOfTheOther {

	/**
	 * assuming str2 has unique ASCII characters and str1, str2 same length
	 */
	public static boolean permutation1(String str1, String str2) {
		int n = str2.length();
		if(str1.length() != n)
			return false;
		BitSet bitset = new BitSet(256);
		for (int i = 0; i < n; i++) {
			char c = str2.charAt(i);
			bitset.set(c);
		}
		for (int i = 0; i < n; i++) {
			char c = str1.charAt(i);
			bitset.flip(c);
			if(bitset.get(c))
				return false;
		}
		return bitset.cardinality() == 0;
	}

	/**
	 * assuming str2 has ASCII characters and str1, str2 same length and 
	 * each character can not exceed the number Integer.INT_MAX
	 */
	public static boolean permutation2(String str1, String str2) {
		int n = str2.length();
		if(str1.length() != n)
			return false;
		int[] charcount = new int[256];
		for (int i = 0; i < n; i++) {
			char c = str2.charAt(i);
			charcount[c]++;
		}
		for (int i = 0; i < n; i++) {
			char c = str1.charAt(i);
			if(--charcount[c] < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(permutation1("bac", "abc"));
		System.out.println(permutation1("abacae", "abcde"));
		System.out.println(permutation2("bac", "abc"));
		System.out.println(permutation2("abacae", "abcde"));
		
		System.out.println(permutation2("abbracaaadr", "abracadabra"));
	}
}
