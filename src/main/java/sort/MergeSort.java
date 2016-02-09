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
		sort(a, aux, 0, a.length - 1);
	}
	
	private void sort(int[] a, int[] aux, int lo, int hi){
		if(hi <= lo + CUTOFF - 1){
			InsertionSort.sort(a, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public void merge(int[] a, int[] aux, int lo, int mid, int hi){
		int n1 = mid - lo + 1; 
		int n2 = hi - mid;
		System.arraycopy(a, lo, aux, lo, n1 + n2);
		int i = lo, j = mid + 1, k = lo;
		while (i <= mid && j <= hi) {
			if(less(i, j, aux))
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
			k = increase(k);
		}
		if(i <= mid)
			System.arraycopy(aux, i, a, k, mid - i + 1);
		if(j <= hi)
			System.arraycopy(aux, j, a, k, hi - j + 1);
	}

}
