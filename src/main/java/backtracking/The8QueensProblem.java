package backtracking;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class The8QueensProblem {

	static boolean isSameRow(int[] queens, int col, int row) {
		return queens[col] == row;
	}

	static boolean isSameRightDiagonal(int[] queens, int i, int col, int row) {
		return queens[i] - i == row - col;
	}

	static boolean isSameLeftDiagonal(int[] queens, int i, int col, int row) {
		return queens[i] + i == row + col;
	}

	static boolean canPlaceQueen(int[] queens, int queen, int row) {
		int n = queens.length;
		for (int i = 0; i < n; i++) {
			if (queens[i] >= 0 && i == queen)
				return false;
			if (queens[i] >= 0 && (isSameRow(queens, i, row) || isSameRightDiagonal(queens, i, queen, row) || isSameLeftDiagonal(queens, i, queen, row)))
				return false;
		}
		return true;
	}

	static boolean allPlaced(int[] queens) {
		for (int i = 0; i < queens.length; i++)
			if (queens[i] < 0)
				return false;
		return true;
	}

	int[] findSolution(int n) {
		int[] queens = new int[n];
		Arrays.fill(queens, -1);
		findSolution(queens, 0);
		printQueens(queens);
		return queens;
	}

	static boolean findSolution(int[] queens, int col) {
		if (col >= queens.length)
			return false;
		boolean result = false;
		for (int i = 0; i < queens.length; i++) {
			if (canPlaceQueen(queens, col, i)) {
				queens[col] = i;
				if (result = allPlaced(queens)) 
					break;
				if (!(result = findSolution(queens, col + 1)))
					queens[col] = -1;
				else
					break;
			}
		}
		return result;
	}

	public static void printQueens(int[] q) {
		int n = q.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (q[i] == j)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}

	@Test
	public void testFindSolution() {
		The8QueensProblem sol = new The8QueensProblem();
		int[] solution = sol.findSolution(8);
		System.out.println(Arrays.toString(solution));
		Assert.assertArrayEquals(new int[] {0, 4, 7, 5, 2, 6, 1, 3}, solution);
	}

	@Test
	public void testRightDiogonal() {
		The8QueensProblem sol = new The8QueensProblem();
		// * * * *
		// * * * *
		// Q * * *
		// * ? * *
		Assert.assertTrue(sol.isSameRightDiagonal(new int[] { 2, -1, -1, -1 }, 0, 1, 3));
		// * Q * *
		// * * * *
		// * * * *
		// * * * ?
		Assert.assertFalse(sol.isSameRightDiagonal(new int[] { -1, 0, -1, -1 }, 1, 3, 3));
		// * Q * *
		// * * * *
		// * * * ?
		// * * * *
		Assert.assertTrue(sol.isSameRightDiagonal(new int[] { -1, 0, -1, -1 }, 1, 3, 2));
	}

	@Test
	public void testLeftDiogonal() {
		The8QueensProblem sol = new The8QueensProblem();
		// * * * *
		// * ? * *
		// Q * * *
		// * * * *
		Assert.assertTrue(sol.isSameLeftDiagonal(new int[] { 2, -1, -1, -1 }, 0, 1, 1));
		// * Q * *
		// * * * *
		// * * * *
		// ? * * *
		Assert.assertFalse(sol.isSameLeftDiagonal(new int[] { -1, 0, -1, -1 }, 1, 0, 3));
		// * Q * *
		// ? * * *
		// * * * *
		// * * * *
		Assert.assertTrue(sol.isSameLeftDiagonal(new int[] { -1, 0, -1, -1 }, 1, 0, 1));
	}

	@Test
	public void testCanPlaceQueen() {
		The8QueensProblem sol = new The8QueensProblem();
		Assert.assertTrue(sol.canPlaceQueen(new int[] { -1, -1, -1, -1 }, 0, 0));
		Assert.assertFalse(sol.canPlaceQueen(new int[] { 0, -1, -1, -1 }, 0, 0));
		Assert.assertFalse(sol.canPlaceQueen(new int[] { 0, -1, -1, -1 }, 3, 3));
		Assert.assertFalse(sol.canPlaceQueen(new int[] { 0, -1, -1, -1 }, 0, 3));
	}

}
