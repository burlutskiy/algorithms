package sort;

import org.junit.Test;

public class EstimateSorts {
	private static final int MAX_POW = 20;
	private static final int MIN_POW = 11;

	@Test
	public void estimateSelectionSort() {
		estimateSortAlgorithm(SelectionSort.class, 16);
	}

	@Test
	public void estimateBubbleSort() {
		estimateSortAlgorithm(BubbleSort.class, 16);
	}

	@Test
	public void estimateMergeSort() {
		estimateSortAlgorithm(TopDownMergeSort.class, 23, 26);
	}

	@Test
	public void estimateQuickSort() {
		estimateSortAlgorithm(QuickSort.class, 23, 26);
	}

	@Test
	public void estimateInsertionSort() {
		estimateSortAlgorithm(InsertionSort.class, MIN_POW, 16);
	}

	private void estimateSortAlgorithm(Class<? extends AbstractSort> clazz) {
		estimateSortAlgorithm(clazz, MIN_POW, MAX_POW);
	}

	private void estimateSortAlgorithm(Class<? extends AbstractSort> clazz, int max) {
		estimateSortAlgorithm(clazz, MIN_POW, max);
	}
	
	private void estimateSortAlgorithm(Class<? extends AbstractSort> clazz, int min, int max) {
		SortTestUtil.estimate(clazz, min, max, new RandomIntArrayGenerator());
		SortTestUtil.estimate(clazz, min, max, new ReverseIntArrayGenerator());
		SortTestUtil.estimate(clazz, min, max, new SortedIntArrayGenerator());
	}

}
