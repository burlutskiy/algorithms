package sort;

/**
 * http://en.wikipedia.org/wiki/Bubble_sort
 * 
 * @author burlutal
 * 
 */
public class BubbleSort extends AbstractSort {
	public BubbleSort(int[] a) {
		super(a);
	}

	public void sort() {
		int n = a.length;
		for (int i = 0; i < n; i++)
			for (int j = 1; j < n - i; j=increase(j)) 
				if (less(j, j - 1, a)) 
					swap(j-1,j,a);
	}
}
