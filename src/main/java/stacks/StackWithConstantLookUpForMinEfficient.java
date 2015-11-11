package stacks;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in O(1) time.
 * 
 * @author burlutal
 */
public class StackWithConstantLookUpForMinEfficient<T extends Comparable<T>> extends Stack<T> {
	Stack<T> mins = new Stack<>();

	@Override
	public void push(T newValue) {
		super.push(newValue);
		if(mins.isEmpty() || mins.top.getValue().compareTo(newValue) > 0){
			mins.push(newValue);
		}
	}

	@Override
	public T pop() {
		T value = super.pop();
		if(value == mins.top.getValue())
			mins.pop();
		return value;
	}
	
	public T min() {
		return mins.top.getValue();
	}

	@Test
	public void test(){
		StackWithConstantLookUpForMinEfficient<Integer> stack = new StackWithConstantLookUpForMinEfficient<>();
		stack.push(-1);
		stack.push(4);
		stack.push(3);
		stack.push(-2);
		Assert.assertSame(-2, stack.min());
		stack.pop();
		Assert.assertSame(-1, stack.min());
	}

}
