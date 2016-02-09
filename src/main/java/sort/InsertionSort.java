package sort;

/**
 * http://en.wikipedia.org/wiki/Insertion_sort
 * 
 * @author burlutal
 * 
 */
public class InsertionSort extends AbstractSort {
	public InsertionSort(int[] a) {
		super(a);
	}

	void sort() {
		int n = a.length;
	}
	
	public static void sort(int a[], int lo, int hi){
		for (int i = lo; i < hi - lo + 1; i++)
			for (int j = i; j > 0 && a[j] < a[j - 1]; j--){
				static_swap(j - 1, j, a);
			}
	}
}