package heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

/*
 * Median Stream
 * You're given a list of n integers arr[0..(n-1)]. 
 * You must compute a list output[0..(n-1)] such that, 
 * for each index i (between 0 and n-1, inclusive), 
 * output[i] is equal to the median of the elements arr[0..i] (rounded down to the nearest integer).
 * The median of a list of integers is defined as follows. 
 * 
 * If the integers were to be sorted, then:
 * If there are an odd number of integers, 
 * then the median is equal to the middle integer in the sorted order.
 * Otherwise, if there are an even number of integers, 
 * then the median is equal to the average of the two middle-most integers in the sorted order.
 * 
 * Signature
 * int[] findMedian(int[] arr)
 * 
 * Input
 * n is in the range [1, 1,000,000].
 * Each value arr[i] is in the range [1, 1,000,000].
 * Output
 * Return a list of n integers output[0..(n-1)], as described above.
 * 
 * Example 1
 * n = 4
 * arr = [5, 15, 1, 3]
 * output = [5, 10, 5, 4]
 * 
 * The median of [5] is 5, the median of [5, 15] is (5 + 15) / 2 = 10, the median of [5, 15, 1] is 5, and the median of [5, 15, 1, 3] is (3 + 5) / 2 = 4.
 * Example 2
 * n = 2
 * arr = [1, 2]
 * output = [1, 1]
 * 
 * The median of [1] is 1, the median of [1, 2] is (1 + 2) / 2 = 1.5 (which should be rounded down to 1).
 */
public class MedianStream {

	class MedianQueue {
		final Queue<Integer> below = new PriorityQueue<>(Comparator.reverseOrder());
		final Queue<Integer> above = new PriorityQueue<>();
		
		Integer median = null;
		public MedianQueue add(int value) {
			if(isEmpty()) {
				below.add(value);
				return this;
			}
			if(value > median())
				above.add(value);
			else if(value <= median())
				below.add(value);
			balance();
			return this;
		}
		
		public boolean isEmpty() {
			return below.isEmpty() && above.isEmpty();
		}
		
		private void balance() {
			if(below.size() - above.size() > 1)
				swim();
			else if(above.size() - below.size() > 1)
				sink();	
		}
		
		private void swim() {
			above.add(below.poll());
		}

		private void sink() {
			below.add(above.poll());
		}
		
		public int median() {
			if(below.size() > above.size())
				return below.peek();
			else if(below.size() < above.size())
				return above.peek();
			else
				return (int) (below.peek() + above.peek()) / 2 ;
		}
	}
	
	// 5 15 1 4 3
	//
	// 5 -> (5)() -> 5
	// 15 -> (5)(15) -> 10
	// 1 -> (1,5)(15) -> 5
	// 4 ->  (1,4,5)(15) -> (1,4),(5, 15) -> 4
	// 3 -> (1,3,4)(5,15) -> 4
	/*
	 * Idea is to keep two arrays below the median and above, so that we can get a median in O(1)
	 */
	int[] findMedianNlogN(int[] arr) {
		final int n = arr.length;
		final int[] result = new int[n];
		final MedianQueue queue = new MedianQueue();
		for (int i = 0; i < n; i++)
			result[i] = queue.add(arr[i]).median();
		return result;
	}

	/*
	 * slow O(n^2)
	 */
	int[] findMedian_ONxN(int[] arr) {
		final int n = arr.length;
		final int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			sink(arr, i);
			result[i] = median(arr, i);
		}
		return result;
	}

	int median(int[] sorted, int end) {
		if (end % 2 != 0)
			return (int) (sorted[end / 2] + sorted[(end / 2) + 1]) / 2;
		else
			return sorted[end / 2];
	}

	void sink(int[] arr, int index) {
		while (index > 0) {
			if (arr[index] < arr[index - 1])
				swap(arr, index, index - 1);
			index--;
		}
	}

	void swap(int[] arr, int i1, int i2) {
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}

	@Test
	public void testNlogN() {
		Assert.assertArrayEquals(new int[] { 5, 10, 5, 4 }, findMedianNlogN(new int[] { 5, 15, 1, 3 }));
		Assert.assertArrayEquals(new int[] { 5, 10, 5, 4, 4 }, findMedianNlogN(new int[] { 5, 15, 1, 4, 3 }));
	}

	@Test
	public void testNxN() {
		Assert.assertArrayEquals(new int[] { 5, 10, 5, 4 }, findMedian_ONxN(new int[] { 5, 15, 1, 3 }));
		Assert.assertArrayEquals(new int[] { 5, 10, 5, 4, 4 }, findMedian_ONxN(new int[] { 5, 15, 1, 4, 3 }));
	}

	@Test
	public void testB() {
		Assert.assertEquals(1, Math.abs(Arrays.binarySearch(new int[] { 1, 3, 5, 7, 9 }, 2)) - 1);
		Assert.assertEquals(2, Math.abs(Arrays.binarySearch(new int[] { 1, 3, 5, 7, 9 }, 4)) - 1);
		Assert.assertEquals(3, Math.abs(Arrays.binarySearch(new int[] { 1, 3, 5, 7, 9 }, 6)) - 1);
		Assert.assertEquals(4, Math.abs(Arrays.binarySearch(new int[] { 1, 3, 5, 7, 9 }, 8)) - 1);
		Assert.assertEquals(5, Math.abs(Arrays.binarySearch(new int[] { 1, 3, 5, 7, 9 }, 10)) - 1);
	}

}
