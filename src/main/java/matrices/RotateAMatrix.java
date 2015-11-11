package matrices;

/**
 * 
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 * 
 * @author burlutal
 */
public class RotateAMatrix {
	public static void main(String[] args) {
		MatrixUtils.print(MatrixUtils.m44);
		rotate(MatrixUtils.m44, 0, MatrixUtils.m44.length);
		MatrixUtils.print(MatrixUtils.m44);
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
