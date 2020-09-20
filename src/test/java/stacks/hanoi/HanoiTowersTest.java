package stacks.hanoi;

import org.junit.Assert;
import org.junit.Test;

import stacks.hanoi.HanoiTowers;
import stacks.hanoi.HanoiTowersNotOriginalSolution1;
import stacks.hanoi.HanoiTowersNotOriginalSolution2;
import stacks.hanoi.HanoiTowersOriginal;

public class HanoiTowersTest {
	private final static int N = 15;
	@Test
	public void testHanoiTowersNotOriginalSolution1() {
		HanoiTowers hanoi = new HanoiTowersNotOriginalSolution1(N);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
		Assert.assertEquals((long)Math.pow(3, N) - 1, hanoi.getMoves());
	}

	@Test
	public void testHanoiTowersNotOriginalSolution2() {
		HanoiTowers hanoi = new HanoiTowersNotOriginalSolution2(N);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
		Assert.assertEquals((long)Math.pow(3, N) - 1, hanoi.getMoves());
	}

	@Test
	public void testOriginal() {
		HanoiTowers hanoi = new HanoiTowersOriginal(N);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
		Assert.assertEquals((long)Math.pow(2, N) - 1, hanoi.getMoves());
	}
}
