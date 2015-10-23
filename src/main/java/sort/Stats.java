package sort;

interface Stats {
	void increaseComparisons();
	
	void increaseComparisons(int times);

	void increasePasses();

	void increaseSwaps();

	void increaseSwaps(int times);
	
	void increasePasses(int times);

	int getComparisons();

	int getPasses();

	int getSwaps();

}
