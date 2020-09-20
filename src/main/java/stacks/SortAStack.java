/**
 * 
 */
package stacks;

/**
 * 
 * Write a program to sort a stack in ascending order (with biggest items on
 * top). You may use at most one additional stack to hold items, but you may not
 * copy the elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, and isEmpty.
 * 
 * @author Alexey Burlutskiy
 *
 */
public class SortAStack {
	
	public void sortStack(Stack<Integer> stack) {
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

	private void pushBack(Stack<Integer> stack, Stack<Integer> tmp) {
		while (!tmp.isEmpty()) {
			stack.push(tmp.pop());
		}
	}

}
