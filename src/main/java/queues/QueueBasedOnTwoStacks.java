package queues;

import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * 
 * @author Alexey Burlutskiy
 *
 */
public class QueueBasedOnTwoStacks {

	final Stack<Integer> stack1, stack2;

	public QueueBasedOnTwoStacks() {
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
