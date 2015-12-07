package sort;

public class MergeSort extends AbstractSort {
	@Override
	public void sort(int[] a) {
		int n = a.length;
		int[] b = new int[n];
		bottomUpSort(n, a, b);
	}

	void bottomUpSort(int n, int a[], int b[]) {
		for (int width = 1; width < n; width = 2 * width) {
			for (int i = 0; i < n; i = i + 2 * width) {
				bottomUpMerge(a, i, Math.min(i + width, n), Math.min(i + 2 * width, n), b);
			}
//			System.arraycopy(b, 0, a, 0, b.length);
			stats.increaseSwaps(b.length);
			stats.increasePasses(b.length);
		}
	}

	void bottomUpMerge(int a[], int iLeft, int iRight, int iEnd, int b[]) {
		int i0 = iLeft;
		int i1 = iRight;
		for (int j = iLeft; j < iEnd; j++) {
			if (i0 < iRight && (i1 >= iEnd || a[i0] <= a[i1])) {
				b[j] = a[i0++];
			} else { 
				b[j] = a[i1++];
			}
			stats.increaseComparisons(3);
			stats.increasePasses();
		}
	}
}