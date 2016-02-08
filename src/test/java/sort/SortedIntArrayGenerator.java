package sort;

class SortedIntArrayGenerator implements IntArrayGenerator {
	public int[] getArray(int pow) {
		int n = 2 << pow - 1;
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		return a;
	}

	@Override
	public String getDescription() {
		return "Sorted array";
	}
}