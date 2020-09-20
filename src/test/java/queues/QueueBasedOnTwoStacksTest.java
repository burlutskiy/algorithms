
package queues;

import org.junit.Assert;
import org.junit.Test;

public class QueueBasedOnTwoStacksTest {

	private QueueBasedOnTwoStacks queue = new QueueBasedOnTwoStacks();
	@Test
	public void test() {
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.remove();
		queue.add(4);
		queue.add(5);
		queue.peek();
		Assert.assertEquals(new Integer(2), queue.remove());
	}

}
