package sort;

class ReverseIntArrayGenerator implements IntArrayGenerator {
	public int[] getArray(int pow) {
		int n = 2 << pow - 1;
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = n - i - 1;
		}
		return a;
	}

	@Override
	public String getDescription() {
		return "Reverse Array";
	}
}