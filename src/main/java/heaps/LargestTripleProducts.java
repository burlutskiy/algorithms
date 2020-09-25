package heaps;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class LargestTripleProducts {

	int[] findMaxProduct(int[] arr) {
		int min = arr[0];
		int[] result = new int[arr.length];
		int[] triplet = new int[] {min, min, min};
		for(int i = 0; i < arr.length; i++) {
			int m = updateMaxTriplet(triplet, arr[i]);
			if(i < 2)
				result[i] = -1;
			else
				result[i] = m;
		}
		return result;
	}
	
	int updateMaxTriplet(int[] triplet, int value) {
		if(triplet[0] < value)
			triplet[0] = value;
		Arrays.sort(triplet);
		return Arrays.stream(triplet).reduce(1, (a, b) -> a * b);
	}
	
	@Test
	public void test() {
		LargestTripleProducts ltp = new LargestTripleProducts();
		Assert.assertArrayEquals(new int[]{-1, -1, 6, 24, 60}, ltp.findMaxProduct(new int[] {1,2,3,4,5}));
	}
}
