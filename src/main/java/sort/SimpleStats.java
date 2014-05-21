package sort;

public class SimpleStats implements Stats {
	int passes;
	int comparisons;
	int swaps;
	
	@Override
	public void increaseComparisons() {
		comparisons++;
	}

	@Override
	public void increaseComparisons(int times) {
		comparisons+=times;
	}

	@Override
	public void increasePasses() {
		passes++;
	}

	@Override
	public void increaseSwaps() {
		
	}

	@Override
	public int getComparisons() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPasses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSwaps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void increaseSwaps(int times) {
		// TODO Auto-generated method stub

	}

	@Override
	public void increasePasses(int times) {
		// TODO Auto-generated method stub

	}

}
