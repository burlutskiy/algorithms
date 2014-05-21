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
			int j = i;
			while (j > 0 && a[j] < a[j - 1]) {
				int dumb = a[j - 1];
				a[j - 1] = a[j];
				a[j--] = dumb;
				stats.increaseSwaps();
				stats.increasePasses();
				stats.increaseComparisons();
			}
			stats.increaseComparisons();
		}
	}
}