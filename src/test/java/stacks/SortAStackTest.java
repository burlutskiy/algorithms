package stacks;

import org.junit.Assert;
import org.junit.Test;

public class SortAStackTest {
	private SortAStack sortStack = new SortAStack();
	 @Test
	public void test() {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		sortStack.sortStack(stack);
		Assert.assertEquals(5, stack.peek().intValue());
	}

	@Test
	public void test2() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(9);
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(4);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		sortStack.sortStack(stack);
		Assert.assertEquals(stack.peek().intValue(), 9);
	}
}
