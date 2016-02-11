package sort;

/**
 * 
 * @author alexey
 *
 */
public class BottomUpMergeSort extends MergeSort {

	public BottomUpMergeSort(int[] a) {
		super(a);
	}

	public void sort() {
		int n = a.length;
		int[] aux = new int[n];
		sort(n, a, aux);
	}

	void sort(int n, int a[], int aux[]) {
		for (int w = 1; w < n; w = 2 * w) {
			for (int i = 0; i < n - w; i += 2 * w)
				merge(a, aux, i, i + w - 1, Math.min(i + 2 * w - 1, n - 1));
			System.arraycopy(aux, 0, a, 0, a.length);
		}
	}
	
}