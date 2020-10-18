package search;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given the structure based on arrays. All elements are sorted. The only method
 * is
 * 
 * get(int index) throws ArrayOutOfBoundException
 * 
 * Find the index for specified value or return -1 if it is not in the
 * structure.
 * 
 * Amazon: 2020 interview
 * 
 * @author alexey
 *
 */
public class FindIndexInUndefinedArrayStructure {

	static class SomeArrayStructure {
		final int[] arr;

		SomeArrayStructure(int[] arr) {
			Arrays.sort(arr);
			this.arr = arr;
		}

		int get(int index) {
			return arr[index];
		}

		@Override
		public String toString() {
			return "[" + Arrays.toString(arr) + "]";
		}
		
	}

	int find(SomeArrayStructure uas, int from, int value) {
		int end = findEnd(uas, from, value);
		return search(uas, end / 2, end, value);
	}

	int findEnd(SomeArrayStructure uas, int from, int value) {
		from++;
		while (true) {
			from *= 2;
			if (less(uas, from, value))
				break;
		}
		return from - 1;
	}

	boolean less(SomeArrayStructure uas, int index, int value) {
		try {
			if (value >= uas.get(index))
				return false;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return true;
	}

	boolean higher(SomeArrayStructure uas, int index, int value) {
		try {
			if (value > uas.get(index))
				return true;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return false;
	}

	boolean equal(SomeArrayStructure uas, int index, int value) {
		return !less(uas, index, value) && !higher(uas, index, value);
	}

	int equalOrDefault(SomeArrayStructure uas, int index, int value) {
		if (equal(uas, index, value))
			return index;
		else
			return -1;
	}

	int search(SomeArrayStructure uas, int lo, int hi, int value) {
		int vhi = equalOrDefault(uas, hi, value);
		int vlo = equalOrDefault(uas, lo, value);
		if (hi == lo || hi - lo == 1)
			if (vhi >= 0)
				return vhi;
			else if (vlo >= 0)
				return vlo;
			else
				return -1;

		int mid = (hi + lo) / 2;
		if (less(uas, mid, value))
			return search(uas, lo, mid, value);
		else if (higher(uas, mid, value))
			return search(uas, mid, hi, value);
		else
			return equalOrDefault(uas, mid, value);
	}

	@Test
	public void test() {
		Assert.assertEquals(2, find(build(1, 2, 3, 4), 0, 3));
	}

	@Test
	public void test2() {
		Assert.assertEquals(2, find(build(1, 2, 3, 4), 1, 3));
	}

	@Test
	public void test3() {
		Assert.assertEquals(0, find(build(1, 2, 3, 4), 0, 1));
	}

	@Test
	public void test4() {
		Assert.assertEquals(-1, find(build(1, 2, 4, 5, 6), 1, 3));
	}

	@Test
	public void test5() {
		Assert.assertEquals(13, find(build(2, 3, 4, 5, 6, 7, 8, 13, 23, 23, 34, 35, 45, 61, 63, 77, 83, 94), 1, 61));
	}

	@Test
	public void test6() {
		Assert.assertEquals(0, find(build(1), 0, 1));
	}

	@Test
	public void test7() {
		Assert.assertEquals(-1, find(build(15, 20), 1, 15));
	}

	@Test
	public void test8() {
		Assert.assertEquals(-1, find(build(2, 3, 4, 5, 6, 7, 8, 13, 23, 23, 34, 35, 45, 61, 63, 77, 83, 94), 15, 105));
	}

	@Test
	public void test9() {
		Assert.assertEquals(17, find(build(2, 3, 4, 5, 6, 7, 8, 13, 23, 23, 34, 35, 45, 61, 63, 77, 83, 94), 15, 94));
	}

	@Test
	public void test10() {
		Assert.assertEquals(-1, find(new SomeArrayStructure(new int[] {}), 0, 1));
	}

	@Test
	public void test11() {
		Assert.assertEquals(-1, find(build(15, 20), 0, -11));
	}

	@Test
	public void test12() {
		Assert.assertEquals(0, find(build(-115, -20), 0, -115));
	}

	@Test
	public void test13() {
		Assert.assertEquals(1, find(build(-115, -20), 0, -20));
	}

	@Test
	public void testEven1() {
		Assert.assertEquals(1, find(build(5, 10, 12, 17), 0, 10));
	}

	@Test
	public void testEven2() {
		Assert.assertEquals(2, find(build(5, 10, 12, 17), 0, 12));
	}

	@Test
	public void testOdd() {
		Assert.assertEquals(2, find(build(5, 10, 12, 17, 20), 0, 12));
	}

	static SomeArrayStructure build(int... arr) {
		return new SomeArrayStructure(arr);
	}
}
