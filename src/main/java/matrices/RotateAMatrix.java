package matrices;

/**
 * 
 * @author burlutal Given an image represented by an NxN matrix, where each
 *         pixel in the image is 4 bytes, write a method to rotate the image by
 *         90 degrees. Can you do this in place?
 *
 */
public class RotateAMatrix {
	public static void main(String[] args) {
		int[][] m = new int[][] { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, {8, 9, 10, 11 }, { 12, 13, 14, 15} };
		print(m);
		rotate(m, 0, m.length);
		print(m);
		m = new int[][] { { 0, 1, 2, 3, 4 }, { 5, 6, 7, 8, 9 }, { 10, 11, 12, 13, 14 }, { 15, 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		print(m);
		rotate(m, 0, m.length);
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

	public static void rotate(int[][] matrix, int first, int n) {
		if (n > 3) {
			rotate(matrix, first + 1, n - 2);
		}
		int last = first + n - 1;
		for (int k = first; k < last; k++) {
			int offset = k - first;
			int top = matrix[first][k];
			matrix[first][k] = matrix[last - offset][first];
			matrix[last - offset][first] = matrix[last][last - offset];
			matrix[last][last - offset] = matrix[k][last];
			matrix[k][last] = top;
		}
	}

}
