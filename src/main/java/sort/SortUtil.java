package sort;

public class SortUtil {
	private long comparisonCount;
	private long exchangesCount;
	private long passesCount;
	
	public boolean less(int i, int j, int[] a){
		comparisonCount++;
		return a[i] < a[j];
	}
	
	public void swap(int i, int j, int[] a){
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
		exchangesCount++;
	}
	
	public int increase(int i){
		passesCount++;
		return i++;
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
	
}
