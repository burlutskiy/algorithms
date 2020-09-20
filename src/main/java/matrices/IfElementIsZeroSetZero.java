package matrices;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 * 
 * @author Alexey Burlutskiy
 *
 */
public class IfElementIsZeroSetZero {

	public static void main(String[] args) {
		MatrixUtils.M55[0][0] = -1;
		MatrixUtils.M55[0][1] = 0;
		MatrixUtils.M55[4][4] = 0;
		MatrixUtils.M55[0][4] = 0;
		process(MatrixUtils.M55);
		MatrixUtils.print(MatrixUtils.M55);
	}

	/**
	 * @param matrix
	 */
	public static void process(int[][] matrix) {
		BitSet rows = new BitSet(matrix.length);
		BitSet columns = new BitSet(matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {
					rows.set(i);
					columns.set(j);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (rows.get(i))
				setZeroToRow(matrix, i);
		}
		for (int j = 0; j < matrix.length; j++) {
			if (columns.get(j))
				setZeroToColumn(matrix, j);
		}
	}

	private static void setZeroToRow(int[][] matrix, int index) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[index][i] = 0;
		}
	}

	private static void setZeroToColumn(int[][] matrix, int index) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][index] = 0;
		}
	}

}
