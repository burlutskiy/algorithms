package matrices;

/**
 * 
 * @author burlutal Given an image represented by an NxN matrix, where each
 *         pixel in the image is 4 bytes, write a method to rotate the image by
 *         90 degrees. Can you do this in place?
 *
 */
public class RotateAMatrix {
	private static class Tuple {
		public int i, j;

		public Tuple(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public Tuple clone() {
			return new Tuple(i, j);
		}

		public void copyFrom(Tuple from) {
			this.i = from.i;
			this.j = from.j;
		}
	}

	public static void main(String[] args) {
		int[][] m = new int[][] { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 7, 8, 9, 10 }, {11, 12, 13, 14} };
		print(m);
		rotate(m, 0, m.length - 1, m.length);
		print(m);
		m = new int[][] { { 0, 1, 2, 3, 4 }, { 5, 6, 7, 8, 9 }, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20}, {21, 22, 23, 24, 25} };
		print(m);
		rotate(m, 0, m.length - 1, m.length);
		print(m);
	}

	private static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
		    for (int j = 0; j < m.length; j++) {
		        System.out.print(m[i][j] + "\t");
		    }
		    System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void rotate(int[][] matrix, int k1, int k2, int n) {
		if(k2 - k1 > 2){
			rotate(matrix, k1 + 1, k2 - 1, n);
		}
		for (int j = k1; j < k2; j++) {
			Tuple to = new Tuple(k1, j);
			Tuple from = to.clone();
			rotateCCW(from, k1, k2, n);
			int nextV = matrix[to.i][to.j];
			for (int k = 1; k <= 3; k++) {
				matrix[to.i][to.j] = matrix[from.i][from.j];
				to.copyFrom(from);
				rotateCCW(from, k1, k2, n);
			}
			matrix[to.i][to.j] = nextV;
		}
	}

	/**
	 * 
	 * @param index - index tuple
	 * @param k1 - matrix bounds rows
	 * @param k2 - matrix bounds columns
	 */
	private static void rotateCCW(Tuple index, int k1, int k2, int n) {
		if (index.i == k1) { // top
			index.i = n - index.j - 1;
			index.j = k1;
		} else if (index.i == k2) {// bottom
			index.i = n - index.j - 1;
			index.j = k2;
		} else if (index.j == k2) {// right
			index.j = index.i;
			index.i = k1;
		} else if (index.j == k1) {// left
			index.j = index.i;
			index.i = k2;
		}
	}
}
