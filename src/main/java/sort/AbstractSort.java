package sort;

abstract class AbstractSort implements Sort {
	Stats stats;

	public AbstractSort(Stats stats) {
		this.stats = stats;
	}
	
	public AbstractSort() {
		this(new VoidStats());
	}

	void printStats(int size, int passes, int swaps) {
		float fP = passes;
		float fS = swaps;
		int i = 1, j = 1;
		if (size != 0) {
			while ((fP /= size) > 1)
				i++;
			while ((fS /= size) > 1)
				j++;
		}
		System.out.println(String.format(
			"%s: size=%d, passes=%d(n^%d), swaps=%d(n^%d)",
			getClass().getSimpleName(),
			size,
			passes,
			i,
			swaps,
			j));
	}

}
