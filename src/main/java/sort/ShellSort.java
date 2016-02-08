package sort;

/**
 * 
 * @author alexey
 *
 */
public class ShellSort extends AbstractSort {

	public ShellSort(int[] a) {
		super(a);
	}

	public void sort() {
		final int n = a.length;
		int h = 1;
		// 3x+1: 1, 4, 13, 40
		while (h < n / 3)
			h = h * 3 + 1;
		for (; h > 0; h /= 3)
			for (int i = h; i < n; i++)
				for (int j = i; j >= h; j = decrease(j,h))
					if (less(j, j - h, a))
						swap(j, j - h, a);
	}

}
