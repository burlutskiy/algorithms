package queues;

import org.junit.Test;

import junit.framework.Assert;

public class PriorityQueueTest {

	@Test
	public void test() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		Assert.assertEquals(4, queue.remove().intValue());
		Assert.assertEquals(3, queue.remove().intValue());
		Assert.assertEquals(2, queue.remove().intValue());
		Assert.assertEquals(1, queue.remove().intValue());
		Assert.assertTrue(queue.isEmpty());
		
		queue.insert(4);
		Assert.assertEquals(4, queue.remove().intValue());
		Assert.assertTrue(queue.isEmpty());
	}
	@Test
	public void testInsert() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		String s = "98 92 97 82 76 10 86 12 50 49 23 11 27";
		String[] split = s.split(" ");
		for (String string : split) {
			queue.insert(Integer.parseInt(string));
		}
		Assert.assertEquals("[98 92 97 82 76 27 86 12 50 49 23 10 11]", queue.toString());
	}

	@Test
	public void testDelete() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		String s = "85 79 78 71 76 11 18 19 68 54";
		String[] split = s.split(" ");
		for (String string : split) {
			queue.insert(Integer.parseInt(string));
		}
		for (int i = 0; i < 3; i++) {
			queue.remove();
		}
		Assert.assertEquals("[76 71 68 19 54 11 18]", queue.toString());
	}
	
}
