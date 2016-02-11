package sort;

/**
 * 
 * @author alexey
 *
 */
public class TopDownMergeSort extends MergeSort {
	private static final int CUTOFF = 7;

	public TopDownMergeSort(int[] a) {
		super(a);
	}

	void sort() {
		int[] aux = new int[a.length];
		System.arraycopy(a, 0, aux, 0, a.length);
		sort(aux, a, 0, a.length - 1);
	}
	
	private void sort(int[] a, int[] aux, int lo, int hi){
//		if(hi <= lo + CUTOFF - 1){
//			InsertionSort.sort(aux, lo, hi);
//			return;
//		}
		if(hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static void main(String[] args) {
		TopDownMergeSort sort = new TopDownMergeSort(new int[]{14, 29, 12, 32, 99, 97, 92, 79, 65, 74, 55, 96});
	}
}
