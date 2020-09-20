/**
 * 
 */
package matrices;

/**
 * @author Alexey Burlutskiy
 *
 */
public class MatrixUtils {
	public static int[][] m44 = new int[][] { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, {8, 9, 10, 11 }, { 12, 13, 14, 15} };
	public static int[][] M55 = new int[][] { { 0, 1, 2, 3, 4 }, { 5, 6, 7, 8, 9 }, { 10, 11, 12, 13, 14 }, { 15, 16, 17, 18, 19, 20 },
		{ 21, 22, 23, 24, 25 } };
	
	public static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

}
