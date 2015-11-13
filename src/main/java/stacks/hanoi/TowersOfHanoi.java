package stacks.hanoi;

import org.junit.Assert;
import org.junit.Test;

public class TowersOfHanoi {

	@Test
	public void testNotOriginal() {
		HanoiTowers hanoi = new HanoiTowers(4);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
	}

	@Test
	public void testCount() {
		for (int i = 2; i < 10; i++) {
			HanoiTowers hanoi = new HanoiTowers(i);
			hanoi.solve();
			System.out.println(hanoi.getMoves());
		}
	}

	@Test
	public void testOriginal() {
		HanoiTowers hanoi = new HanoiTowersOriginal(4);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
		Assert.assertEquals((long)Math.pow(2, 4) - 1, hanoi.getMoves());
	}
}
