package sort;

/**
 * http://en.wikipedia.org/wiki/Insertion_sort
 * 
 * @author burlutal
 * 
 */
public class InsertionSort extends AbstractSort {
	public void sort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && less(j, j - 1, a); j--) {
				swap(j, j-1, a);
				stats.increaseSwaps();
				stats.increasePasses();
				stats.increaseComparisons();
			}
			stats.increaseComparisons();
		}
	}
}