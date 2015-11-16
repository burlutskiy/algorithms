package queues;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * 
 * @author burlutal
 *
 */
public class QueueBasedOnTwoStacks {

	class MyQueue {
		final Stack<Integer> stack1, stack2;

		public MyQueue() {
			super();
			this.stack1 = new Stack<>();
			this.stack2 = new Stack<>();
		}

		public void add(Integer value) {
			stack1.push(value);
		}

		public Integer peek() {
			shift();
			return stack2.peek();
		}

		public Integer remove() {
			shift();
			return stack2.pop();
		}

		private void shift() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
		}
	}

	@Test
	public void test() {
		MyQueue queue = new MyQueue();
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
