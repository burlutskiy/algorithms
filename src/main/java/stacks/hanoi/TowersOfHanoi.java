package stacks.hanoi;

import org.junit.Assert;
import org.junit.Test;

public class TowersOfHanoi {
	private final static int N = 15;
	@Test
	public void testNotOriginal() {
		HanoiTowers hanoi = new HanoiTowers(N);
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
