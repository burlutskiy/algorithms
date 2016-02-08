package sort;

/**
 * http://en.wikipedia.org/wiki/Cocktail_sort#Differences_from_bubble_sort
 * 
 * @author burlutal
 * 
 */
public class CoctalSort extends AbstractSort {

	public CoctalSort(int[] a) {
		super(a);
	}

	public void sort() {
		int r = 0, t = a.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = r + 1; i < t; i=increase(i)) {
				if (less(i, i - 1, a)) {
					swap(i, i - 1, a);
					swapped = true;
				}
			}
			t--;
			if (!swapped)
				break;
			for (int i = t; i > r; i=decrease(i)) {
				if (less(i, i - 1, a)) {
					swap(i, i - 1, a);
				}
			}
			r++;
		} while (swapped);
	}
}