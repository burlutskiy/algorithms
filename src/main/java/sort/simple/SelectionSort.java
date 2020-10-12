package sort.simple;

import org.junit.Assert;
import org.junit.Test;

/**
 * Simplified version to quickly grasp the idea of the algorithm
 * 
 * @author alexey
 *
 */
public class SelectionSort {

	int[] sort(int[] arr) {
		final int n = arr.length;
		for(int i = 0; i < n; i++) {
			int imin = min(arr, i);
			swap(arr, i, imin);
		}
		return arr;
	}

	void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	int min(int[] arr, int index) {
		int imin = index;
		for(int i = index + 1; i < arr.length; i++)
			if(arr[i] < arr[imin])
				imin = i;
		return imin;
	}

	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] {1,2,3,4,5}, sort(new int[] {3,5,1,2,4}));
	}
}
