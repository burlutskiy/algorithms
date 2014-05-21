package sort;

final class VoidStats implements Stats {
	@Override
	public void increaseSwaps() {
	}

	@Override
	public void increasePasses() {
	}

	@Override
	public void increaseComparisons() {
	}

	@Override
	public int getSwaps() {
		return 0;
	}

	@Override
	public int getPasses() {
		return 0;
	}

	@Override
	public int getComparisons() {
		return 0;
	}

	@Override
	public void increaseComparisons(int times) {
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