package sort;

import org.junit.Test;

public class NewSortTests {

	private static final int MAX_POW = 17;
	private static final int MIN_POW = 11;

	@Test
	public void testSelectionSort() {
		testSortAlgorithm(SelectionSort.class);
	}

	@Test
	public void testInsertionSort() {
		testSortAlgorithm(InsertionSort.class);
	}

	private void testSortAlgorithm(Class<? extends AbstractSort> clazz) {
		SortTestUtil.test(clazz);
		SortTestUtil.estimate(clazz, MIN_POW, MAX_POW, new RandomIntArrayGenerator());
		SortTestUtil.estimate(clazz, MIN_POW, MAX_POW, new ReverseIntArrayGenerator());
		SortTestUtil.estimate(clazz, MIN_POW, MAX_POW, new SortedIntArrayGenerator());
	}

}
