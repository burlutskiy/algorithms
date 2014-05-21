package sort;

/**
 * http://en.wikipedia.org/wiki/Cocktail_sort#Differences_from_bubble_sort
 * 
 * @author burlutal
 * 
 */
public class CoctalSort extends AbstractSort {
	public void sort(int[] a) {
		int r = 0, t = a.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = r + 1; i < t; i++) {
				if (a[i - 1] > a[i]) {
					int dummy = a[i];
					a[i] = a[i - 1];
					a[i - 1] = dummy;
					stats.increaseSwaps();
					swapped = true;
				}
				stats.increasePasses();
				stats.increaseComparisons();
			}
			t--;
			
			stats.increaseComparisons();
			if (!swapped)
				break;
			
			for (int i = t; i > 0; i--) {
				if (a[i - 1] > a[i]) {
					int dummy = a[i];
					a[i] = a[i - 1];
					a[i - 1] = dummy;
					swapped = true;
					stats.increaseSwaps();
				}
				stats.increaseComparisons();
				stats.increasePasses();
			}
			r++;
		}
		while (swapped);
	}
}