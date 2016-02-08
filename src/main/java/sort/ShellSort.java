package sort;

import java.util.Arrays;

public class ShellSort implements SortAlgorithm {

	@Override
	public void sort(int[] a) {
		final int n = a.length;
		int h = 1;
		// 3x+1: 1, 4, 13, 40
		while (h < n / 3)
			h = h * 3 + 1;
		for (; h > 0; h /= 3)
			for (int i = h; i < n; i++)
				for (int j = i; j >= h; j -= h)
					if (less(j, j - h, a))
						swap(j, j - h, a);
	}

	public static void main(String[] args) {
		ShellSort sort = new ShellSort();
		int[] a = new int[] { 1, 2, 7, 6, 5, 4, 3, 9, 8, 0 };
		sort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
