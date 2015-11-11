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
public class StackWithConstantLookUpForMin<T extends Comparable<T>> extends Stack<T> {

	class NodeWithMin extends Node {
		final T min;

		public NodeWithMin(NodeWithMin prev, T value) {
			super(prev, value);
			if (prev == null || prev.min.compareTo(value) > 0)
				this.min = value;
			else {
				this.min = prev.min;
			}
		}
	}

	NodeWithMin getTop() {
		return (NodeWithMin) top;
	}

	@Override
	public void push(T newValue) {
		this.top = new NodeWithMin(getTop(), newValue);
	}

	public T min() {
		if (getTop() != null) {
			return getTop().min;
		}
		return null;
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
