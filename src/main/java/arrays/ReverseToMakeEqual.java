package arrays;

import java.util.Arrays;
import java.util.BitSet;

import org.junit.Assert;
import org.junit.Test;

/*
 * Reverse to Make Equal
 * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
 * Signature
 * bool areTheyEqual(int[] arr_a, int[] arr_b)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if B can be made equal to A, return false otherwise.
 * Example
 * A = [1, 2, 3, 4]
 * B = [1, 4, 3, 2]
 * output = true
 * After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 */
public class ReverseToMakeEqual {

	/*
	 * comes down to checking if one is permutation of the another
	 */
	boolean areTheyEqual(int[] array_a, int[] array_b) {
		if (array_a.length != array_b.length || array_b.length == 0)
			return false;
		final int n = array_a.length;
		final BitSet set_a = new BitSet(n);
		final BitSet set_b = new BitSet(n);
		Arrays.stream(array_a).forEach(i -> set_a.flip(i));
		Arrays.stream(array_b).forEach(i -> set_b.flip(i));
		set_a.xor(set_b);
		return set_a.cardinality() == 0;
	}
	
	@Test
	public void test() {
	    Assert.assertFalse(areTheyEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 3})); 
	    Assert.assertTrue(areTheyEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 2})); 
	    Assert.assertFalse(areTheyEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 2})); 
	    Assert.assertFalse(areTheyEqual(new int[]{}, new int[]{})); 
	    Assert.assertFalse(areTheyEqual(new int[]{1}, new int[]{1, 1})); 
	    Assert.assertTrue(areTheyEqual(new int[]{1,1,1,1}, new int[]{1,1,1,1})); 

	}
}
