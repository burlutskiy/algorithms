package sort;

public class SelectionSort extends AbstractSort {
	@Override
	public void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
				stats.increasePasses();
				stats.increaseComparisons();
			}
			if (minIndex != i) {
				int dummy = a[i];
				a[i] = a[minIndex];
				a[minIndex] = dummy;
				stats.increaseSwaps();
			}
			stats.increaseComparisons();
		}
	}

}