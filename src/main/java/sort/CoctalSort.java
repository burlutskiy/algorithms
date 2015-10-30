package sort;

/**
 * http://en.wikipedia.org/wiki/Cocktail_sort#Differences_from_bubble_sort
 * 
 * @author burlutal
 * 
 */
public class CoctalSort extends AbstractSort {

	private void swapWithBottom(int[] a, int i) {
		a[i] = a[i] ^ a[i - 1];
		a[i - 1] = a[i] ^ a[i - 1];
		a[i] = a[i] ^ a[i - 1];
		stats.increasePasses();
	}

	private boolean less(int x, int y, int[] a) {
		stats.increaseComparisons();
		return a[x] < a[y];
	}

	public void sort(int[] a) {
		int r = 0, t = a.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = r + 1; i < t; i++) {
				if (less(i, i - 1, a)) {
					swapWithBottom(a, i);
					swapped = true;
				}
				stats.increasePasses();
			}
			t--;
			stats.increaseComparisons();
			if (!swapped)
				break;
			for (int i = t; i > r; i--) {
				if (less(i, i - 1, a)) {
					swapWithBottom(a, i);
				}
				stats.increasePasses();
			}
			r++;
		} while (swapped);
	}
}