package sort;

import java.util.Arrays;

public class QuickSort extends AbstractSort {

	public QuickSort(int[] a) {
		super(a);
	}

	public void sort() {
		shuffle(a);
		sort(0, a.length - 1);
	}

	private void sort(int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = partition(lo, hi);
		sort(lo, mid - 1);
		sort(mid + 1, hi);
	}

	int partition(int lo, int hi) {
		int i = lo, j = hi + 1;
		while (true) {
			i = scan_i(lo, hi, i);
			j = scan_j(lo, j);
			if (j < i)
				break;
			swap(i, j, a);
		}
		swap(lo, j, a);
		return j;
	}

	private int scan_j(int lo, int j) {
		while (--j >= lo && less(lo, j, a))
			;
		return j;
	}

	private int scan_i(int lo, int hi, int i) {
		while (++i <= hi && less(i, lo, a))
			;
		return i;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 1, 7, 3, 2, 4, 0 };
		QuickSort sort = new QuickSort(a);
		System.out.println(Arrays.toString(sort.sortedArray()));
	}

}
