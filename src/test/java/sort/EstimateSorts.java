package sort;

import org.junit.Test;

public class EstimateSorts {
	private static final int MAX_POW = 17;
	private static final int MIN_POW = 11;

	@Test
	public void estimateSelectionSort() {
		estimateSortAlgorithm(SelectionSort.class);
	}

	@Test
	public void estimateInsertionSort() {
		estimateSortAlgorithm(InsertionSort.class);
	}

	private void estimateSortAlgorithm(Class<? extends AbstractSort> clazz) {
		SortTestUtil.estimate(clazz, MIN_POW, MAX_POW, new RandomIntArrayGenerator());
		SortTestUtil.estimate(clazz, MIN_POW, MAX_POW, new ReverseIntArrayGenerator());
		SortTestUtil.estimate(clazz, MIN_POW, MAX_POW, new SortedIntArrayGenerator());
	}

}
