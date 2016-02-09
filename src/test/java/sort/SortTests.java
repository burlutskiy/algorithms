package sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://en.wikipedia.org/wiki/Comparison_sort
 * 
 * @author burlutal
 *
 */
public class SortTests {
	@Test
	public void testRadixSort() {
		test(RadixSort.class);
	}

	@Test
	public void testCountingSort() {
//		test(LSDSort.class);
	}

	@Test
	public void testQuickSort() {
		test(QuickSort.class);
	}

	@Test
	public void testHeapSort() {
		test(HeapSort.class);
	}

	@Test
	public void testBucketSort() {
		test(BucketSort.class);
	}

	@Test
	public void testIntroSort() {
		test(IntroSort.class);
	}

	@Test
	public void testOddEvenSort() {
		test(OddEvenSort.class);
	}

	@Test
	public void testSmoothsSort() {
		test(SmoothsSort.class);
	}

	@Test
	public void testTimSort() {
		test(TimSort.class);
	}

	@Test
	public void testShellSort() {
		test(ShellSort.class);
	}

	@Test
	public void testBubbleSort() {
		test(BubbleSort.class);
	}

	@Test
	public void testCombSort() {
		test(CombSort.class);
	}

	@Test
	public void testInsertionSort() {
		test(InsertionSort.class);
	}

	@Test
	public void testCoctalSort() {
		test(CoctalSort.class);
	}

	@Test
	public void testSelectionSort() {
		test(SelectionSort.class);
	}

	@Test
	public void testBottomUpMergeSort() {
		test(BottomUpMergeSort.class);
	}

	@Test
	public void testMergeSort() {
		test(MergeSort.class);
	}

	private void test(Class<? extends AbstractSort> clazz) {
		SortTestUtil.test(clazz);
	}
}
