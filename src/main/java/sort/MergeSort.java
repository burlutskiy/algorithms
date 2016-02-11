package sort;

public abstract class MergeSort extends AbstractSort {

	public MergeSort(int[] a) {
		super(a);
	}

	protected void merge(int a[], int aux[], int lo, int mid, int hi) {
		int i = lo, j = mid + 1, k = lo;
		while (i <= mid && j <= hi) {
			if(less(i, j, a))
				aux[k] = a[i++];
			else
				aux[k] = a[j++];
			k = increase(k);
		}
		if(i <= mid)
			System.arraycopy(a, i, aux, k, mid - i + 1);
		if(j <= hi)
			System.arraycopy(a, j, aux, k, hi - j + 1);
	}

}