package strings.permutation;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Find all possible permutations repeatedly doing the reverse operation of some subportion of the inital string.
 * 
 * Example
 *  If S = (312), we can do the following operations:
 *  Select (31) and reverse it -> 132
 *  Select (132) and reverse it -> 231
 *  etc... 
 * @author alexey
 *
 */
public class PermutationsWithReverseOperations {

	String[] reversePermutations(String s) {
		Queue<String> queue = new LinkedList<String>();
		for(int i = 2; i <= s.length(); i++) {
			queue.addAll(permutations(s, i));
		}
		return queue.stream().toArray(String[]::new);
	}
	
	Queue<String> permutations(String s, int count) {
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i + count <= s.length(); i++) {
			StringBuilder permutation = new StringBuilder();
			if(i > 0)
				permutation.append(s.substring(0, i));
			permutation.append(new StringBuilder(s.substring(i, i + count)).reverse());
			if(i + count < s.length())
				permutation.append(s.substring(i+count));
			queue.add(permutation.toString());
		}
		return queue;
	}

	@Test
	public void test1() {
		PermutationsWithReverseOperations sol = new PermutationsWithReverseOperations();
		Assert.assertArrayEquals(new String[] {"132", "321", "213"}, sol.reversePermutations("312"));
		Assert.assertArrayEquals(new String[] {"1432", "4312", "4123", "3142", "4231","2314"}, sol.reversePermutations("4132"));
	}
}
