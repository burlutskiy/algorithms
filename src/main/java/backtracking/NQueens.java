package backtracking;

class NQueens {
	public boolean isConsistent(int[] q, int n) {
		for (int i = 0; i < n; i++) {
			if (q[i] == q[n])
				return false; // same column
			if ((q[i] - q[n]) == (n - i))
				return false; // same major diagonal
			if ((q[n] - q[i]) == (n - i))
				return false; // same minor diagonal
		}
		return true;
	}

	public void search(int N) {
		search(new int[N], 0);
	}

	public void search(int[] q, int n) {
		int N = q.length;
		if (n == N)
			The8QueensProblem.printQueens(q);
		else {
			for (int i = 0; i < N; i++) {
				q[n] = i;
				if (isConsistent(q, n))
					search(q, n + 1);
			}
		}
	}
}