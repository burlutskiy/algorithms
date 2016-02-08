package sort;

/**
 * 
 * @author alexey
 *
 */
public class SelectionSort extends AbstractSort {
	public SelectionSort(int[] a) {
		super(a);
	}

	public void sort() {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j=increase(j)) {
				if (less(j, minIndex, a)) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(i, minIndex, a);
			}
		}
	}

}