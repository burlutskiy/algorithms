/**
 * 
 */
package stacks;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Write a program to sort a stack in ascending order (with biggest items on
 * top). You may use at most one additional stack to hold items, but you may not
 * copy the elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, and isEmpty.
 * 
 * @author burlutal
 *
 */
public class SortAStack {
	
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tmp = new Stack<>();
		while (!stack.isEmpty()) {
			tmp.push(stack.pop());
			if (!stack.isEmpty() && stack.peek() > tmp.peek()) {
				Integer n = stack.pop();
				while (!tmp.isEmpty() && n > tmp.peek()) {
					stack.push(tmp.pop());
				}
				stack.push(n);
				pushBack(stack, tmp);
			} 
		}
		pushBack(stack, tmp);
		return;
	}

	private static void pushBack(Stack<Integer> stack, Stack<Integer> tmp) {
		while (!tmp.isEmpty()) {
			stack.push(tmp.pop());
		}
	}

	 @Test
	public void test() {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		sortStack(stack);
		Assert.assertEquals(stack.peek().intValue(), 8);
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
		sortStack(stack);
		Assert.assertEquals(stack.peek().intValue(), 9);
	}
}
