package sort;

import java.util.Arrays;

public class Merge {

	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			c[k++] = a[i] < b[j] ? a[i++] : b[j++];
		}
		while (i < a.length) {
			c[k++] = a[i++];
		}
		while (j < b.length) {
			c[k++] = b[j++];
		}
		return c;
	}

	public static void mergeInPlace(int[] a, int[] b) {

	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 6, 8 };
		int[] b = { 3, 5, 7, 9, 11 };
		System.out.println(Arrays.toString(merge(a, b)));
	}
}
