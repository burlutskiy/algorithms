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
		for (int i = 1; i < n; i++) 
			for (int j = i; j > 0 && less(j, j - 1, a); j = decrease(j))
				swap(j - 1, j, a);
	}
	
	public static void sort(int a[], int lo, int hi){
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && a[j] < a[j - 1]; j--)
				static_swap(j - 1, j, a);
	}
}