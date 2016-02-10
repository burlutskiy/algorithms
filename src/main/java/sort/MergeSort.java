package sort;

/**
 * 
 * @author alexey
 *
 */
public class MergeSort extends AbstractSort {
	private static final int CUTOFF = 7;

	public MergeSort(int[] a) {
		super(a);
	}

	void sort() {
		int[] aux = new int[a.length];
		System.arraycopy(a, 0, aux, 0, a.length);
		sort(aux, a, 0, a.length - 1);
	}
	
	private void sort(int[] a, int[] aux, int lo, int hi){
		if(hi <= lo + CUTOFF - 1){
			InsertionSort.sort(aux, lo, hi);
			return;
		}
		if(hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public void merge(int[] a, int[] aux, int lo, int mid, int hi){
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
