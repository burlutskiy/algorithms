package math;

import java.util.LinkedList;

import org.junit.Test;

public class CombinationSum {

	public int combinationSum3(int k, int n) {
		return combination(1, new LinkedList<Integer>(), 1, k, n);

	}

	int combination(int sum, LinkedList<Integer> queue, int level, int k, int n) {
		if(level > k)
			return 0;
		System.out.println(String.format("%d %d %d %d", sum, level, k, n));
		if (level == k && sum == n) {
			queue.add(sum);
			System.out.println(queue);
			queue.poll();
			return 1;
		}
		else if (level == k && sum != n)
			return 0;
		else {
			int count = 0;
			queue.add(sum);
			for (int i = level; i < 10; i++) {
				count += combination(sum + i + 1, queue, level + 1, k, n);
			}
			queue.poll();
			return count;
		}
	}

	@Test
	public void test() {
		System.out.println(combinationSum3(3, 15));
	}
}
