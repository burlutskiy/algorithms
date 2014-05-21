package sort;

interface Stats {
	void increaseComparisons();
	
	void increaseComparisons(int times);

	void increasePasses();

	void increaseSwaps();

	int getComparisons();

	int getPasses();

	int getSwaps();

	void increaseSwaps(int times);

	void increasePasses(int times);
}
