package sort;

public class KeyIndexedCounting {

	public static void sort(int[] a, int radix){
		int N = a.length;
		int[] aux = new int[N];
		int[] count = new int[radix + 1];

		for (int i = 0; i < N; i++)
		   count[a[i] + 1]++;
		
		// Transform counts to indices.
		for (int r = 0; r < radix; r++)
		   count[r+1] += count[r];
		
		// Distribute the records.
		for (int i = 0; i < N; i++)
		   aux[count[a[i]]++] = a[i];
		
		// Copy back.
		for (int i = 0; i < N; i++)
		   a[i] = aux[i];
	}
}
