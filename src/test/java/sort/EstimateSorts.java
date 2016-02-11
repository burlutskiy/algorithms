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
		estimateSortAlgorithm(TopDownMergeSort.class);
	}

	@Test
	public void estimateQuickSort() {
		estimateSortAlgorithm(QuickSort.class);
	}

	@Test
	public void estimateInsertionSort() {
		estimateSortAlgorithm(InsertionSort.class, 16);
	}

	private void estimateSortAlgorithm(Class<? extends AbstractSort> clazz) {
		estimateSortAlgorithm(clazz, MAX_POW);
	}
	
	private void estimateSortAlgorithm(Class<? extends AbstractSort> clazz, int max) {
		SortTestUtil.estimate(clazz, MIN_POW, max, new RandomIntArrayGenerator());
		SortTestUtil.estimate(clazz, MIN_POW, max, new ReverseIntArrayGenerator());
		SortTestUtil.estimate(clazz, MIN_POW, max, new SortedIntArrayGenerator());
	}

}
