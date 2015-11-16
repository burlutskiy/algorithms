package stacks.hanoi;

import org.junit.Assert;
import org.junit.Test;

public class TowersOfHanoi {
	private final static int N = 15;
	@Test
	public void testNotOriginal() {
		HanoiTowersNotOriginalSolution1 hanoi = new HanoiTowersNotOriginalSolution1(N);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
		Assert.assertEquals((long)Math.pow(3, N) - 1, hanoi.getMoves());
	}

	@Test
	public void testNotOriginal2() {
		HanoiTowersNotOriginalSolution1 hanoi = new HanoiTowersNotOriginalSolution2(N);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
		Assert.assertEquals((long)Math.pow(3, N) - 1, hanoi.getMoves());
	}

	@Test
	public void testOriginal() {
		HanoiTowersNotOriginalSolution1 hanoi = new HanoiTowersOriginal(N);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
		Assert.assertEquals((long)Math.pow(2, N) - 1, hanoi.getMoves());
	}
}
