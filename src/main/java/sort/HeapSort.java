package sort;

/**
 * 
 * @author alexey
 */
public class HeapSort extends AbstractSort {
	public HeapSort(int[] a) {
		super(a);
	}

	public void sort() {
		heapConstruction();
		sortDown();
	}

	/**
	 * takes NlgN
	 */
	private void heapConstruction(){
		final int n = a.length;
		for (int i = (n - 1)/2; i >= 0 ; i--)
			sink(i, n);
	}
	
	/**
	 * takes N
	 */
	private void sortDown() {
		int i = a.length;
        while (i > 1) {
            swap(0, --i);
            sink(0, i);
        }
	}
	
	/**
	 * childs 2 * k + 1, 2 * k + 2
	 * @param k
	 */
	void sink(int k, int n) {
		while (2 * k + 2 <= n) {
			int inx = 2 * k;
			int child = inx + 2 < n ? succsessor(inx + 1, inx + 2) : inx + 1;
			if (less(k, child))
				swap(k, child);
			k = child; 
		}
	}
	
	int succsessor(int i, int j) {
		return less(j, i) ? i : j;
	}

}
