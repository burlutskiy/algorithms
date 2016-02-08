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
	public CombSort(int[] a) {
		super(a);
	}

	public void sort() {
		int n = a.length;
		int gap = n;
		boolean swapped = false;
		while (gap > 1 || swapped) {
			if (gap > 1)
				gap /= 1.5f;
			int i = 0;
			swapped = false;
			while (i + gap < n) {
				if (less(i + gap, i, a)) {
					swap(i + gap, i, a);
					swapped = true;
				}
				i = increase(i);
			}
		}
	}
}
