package sort.simple;

import org.junit.Assert;
import org.junit.Test;

/**
 * Simplified version to quickly grasp the idea of the algorithm
 * 
 * @author alexey
 *
 */
public class InsertionSort {


	int[] sort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++)
			sink(arr, i);
		return arr;
	}

	void sink(int[] arr, int index) {
		for (int j = index; j > 0 && arr[j] < arr[j - 1]; j--)
			swap(arr, j - 1, j);		
	}
	
	void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] {1,2,3,4,5}, sort(new int[] {3,5,1,2,4}));
	}
}
