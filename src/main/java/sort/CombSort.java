package sort;

/**
 * http://en.wikipedia.org/wiki/Comb_sort
 * 
 * @author burlutal 
 * 	Worst case performance \Omega(n^2)[1] 
 * 	Best case performance O(n) 
 * 	Average case performance \Omega(n^2/2^p), where p is the number of increments Worst case space complexity
 */
public class CombSort extends AbstractSort {
	public void sort(int[] a) {
		int n = a.length;
		int gap = n;
		boolean swapped = false;
		while (gap > 1 || swapped) {
			if (gap > 1)
				gap /= 1.5f;
			stats.increaseComparisons();
			int i = 0;
			swapped = false;
			while (i + gap < n) {
				if (a[i] > a[i + gap]) {
					swap(i + gap, i, a);
					stats.increaseSwaps();
					swapped = true;
				}
				i++;
				stats.increaseComparisons();
				stats.increasePasses();
			}
		}
	}
}
