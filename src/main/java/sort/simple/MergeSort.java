package sort.simple;

import org.junit.Assert;
import org.junit.Test;

public class MergeSort {

	int[] sort(int[] arr) {
		final int n = arr.length;
		final int[] aux = new int[n];
		sort(arr, aux, 0, n - 1);
		return arr;
	}

	void sort(int[] arr, int[] aux, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid + 1, hi);
		merge(arr, aux, lo, mid, hi);
	}

	/*
	 * merge arr[lo..mid] with arr[mid+1..hi]
	 */
	void merge(int arr[], int aux[], int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		System.arraycopy(arr, lo, aux, lo, hi - lo + 1);
		for (int k = lo; k <= hi; k++) {
			if (i > mid) // right half not exhausted yet -> copy leftovers
				arr[k] = aux[j++];
			else if (j > hi) // left half not exhausted yet -> copy leftovers
				arr[k] = aux[i++];
			else if (aux[i] < aux[j])
				arr[k] = aux[i++];
			else
				arr[k] = aux[j++];
		}
	}

	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, sort(new int[] { 3, 5, 1, 2, 4 }));
	}
}
