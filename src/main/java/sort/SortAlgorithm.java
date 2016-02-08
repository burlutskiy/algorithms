package sort;

interface SortAlgorithm {
	void sort(int[] a);
	
	default void swap(int i, int j, int[] a){
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}
	
	default boolean less(int i, int j, int[] a){
		return a[i] < a[j];
	}
	
}