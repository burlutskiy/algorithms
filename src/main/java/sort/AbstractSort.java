package sort;

abstract class AbstractSort implements SortAlgorithm {
	private long comparisonCount;
	private long exchangesCount;
	private long passesCount;
	private final long time;
	protected final int a[];

	public AbstractSort(int[] a) {
		this.a = a;
		long l = System.currentTimeMillis();
		sort();
		this.time = System.currentTimeMillis() - l;
	}

	abstract void sort();

	public int[] sortedArray() {
		return a;
	}

	void printStats() {
		System.out.println(String.format("%s: size=% ,8d, comparisons=% ,16d, exchanges=% ,16d, passes=% ,15d, time=% ,6d", getClass().getSimpleName(), a.length,
				comparisonCount, exchangesCount, passesCount, time));
	}

	boolean less(int i, int j, int[] a) {
		comparisonCount++;
		return a[i] < a[j];
	}

	void swap(int i, int j, int[] a) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
		exchangesCount++;
	}

	int increase(int i) {
		passesCount++;
		return ++i;
	}

	int decrease(int i) {
		passesCount++;
		return --i;
	}

	int decrease(int i, int step) {
		passesCount++;
		return i-step;
	}

	public long getComparisonCount() {
		return comparisonCount;
	}

	public long getExchangesCount() {
		return exchangesCount;
	}

	public long getPassesCount() {
		return passesCount;
	}

	public long getTime() {
		return time;
	}
}
