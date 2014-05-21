package sort;

/**
 * http://en.wikipedia.org/wiki/Bubble_sort
 * 
 * @author burlutal
 * 
 */
public class BubbleSort extends AbstractSort {
	public void sort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if (a[j - 1] > a[j]) {
					int dumb = a[j - 1];
					a[j - 1] = a[j];
					a[j] = dumb;
					stats.increaseSwaps();
				}
				stats.increasePasses();
				stats.increaseComparisons();
			}
		}
	}
}
