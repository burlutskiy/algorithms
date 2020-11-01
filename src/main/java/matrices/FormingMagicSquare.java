package matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We define a magic square to be an matrix of distinct positive integers from
 * to where the sum of any row, column, or diagonal of length is always equal to
 * the same number: the magic constant.
 * 
 * You will be given a matrix of integers in the inclusive range . We can
 * convert any digit to any other digit in the range at cost of . Given ,
 * convert it into a magic square at minimal cost. Print this cost on a new
 * line.
 * 
 * Note: The resulting magic square must contain distinct integers in the
 * inclusive range .
 * 
 * Example
 * 
 * $s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]
 * 
 * The matrix looks like this:
 * 
 * 5 3 4 1 5 8 6 4 2 We can convert it to the following magic square:
 * 
 * 8 3 4 1 5 9 6 7 2 This took three replacements at a cost of .
 * 
 */
public class FormingMagicSquare {

	class Snapshot {
		final int[][] arr;
		final int distance;
		Snapshot(int[][]arr, int distance) {
			this.arr = arr;
			this.distance = distance;
		}
	}
	
	int sum(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length; j++)
				sum += arr[i][j];
		return sum;
	}

	int[][] convertLine(int[] arr) {
		final int n = arr.length;
		final int sum = Arrays.stream(arr).sum();
		final int magicSum = magicSum(n);
		if (sum == magicSum)
			return new int[][] {};
		int[][] result = new int[n][n];
		for (int i = 0; i < arr.length; i++) 
			for (int j = 0; i < n; i++) 
				result[i][j] = arr[j] + magicSum - sum;
		return result;
	}

	int formingMagicSquare(int[][] s) {
		final int n = s.length;
		Comparator<Snapshot> c = (s1, s2) -> Integer.compare(s1.distance, s2.distance);
		PriorityQueue<Snapshot> queue = new PriorityQueue<Snapshot>(c);
		queue.add(new Snapshot(s, 0));
		for(;;) {
			Snapshot snap = queue.poll();
			if(sum(snap.arr) == n * magicSum(n))
				return snap.distance;
			queue.addAll(spawnSnapshots(snap));
		}
	}

	List<Snapshot> spawnSnapshots(Snapshot snap) {
		return null;
	}

	List<Snapshot> spawnRowSnapshot(Snapshot snap, int indx) {
		final List<Snapshot> result = new ArrayList<>();
		final int sum = Arrays.stream(snap.arr[indx]).sum();
		final int magicSum = magicSum(snap.arr.length);
		final int n = snap.arr.length;
		if (sum != magicSum) {
			for (int i = 0; i < n; i++) {
				int[][] tmp = snap.arr.clone();
				tmp[indx][i] += magicSum - sum;
				result.add(new Snapshot(tmp, snap.distance + Math.abs(magicSum - sum)));
			}
		}
		return result;
	}

	List<Snapshot> spawnColumSnapshot(Snapshot snap, int indx) {
		final int n = snap.arr.length;
		final List<Snapshot> result = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < n; i++) 
			sum+=snap.arr[i][indx];
		
		final int magicSum = magicSum(n);
		if (sum != magicSum) {
			for (int i = 0; i < n; i++) {
				int[][] tmp = snap.arr.clone();
				tmp[i][indx] += magicSum - sum;
				result.add(new Snapshot(tmp, snap.distance + Math.abs(magicSum - sum)));
			}
		}
		return result;
	}

	int magicSum(int n) {
		return n * (n * n + 1) / 2;
	}

}
