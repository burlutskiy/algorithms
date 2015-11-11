package stacks;

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

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StackWithConstantLookUpForMin<Integer> stack = new StackWithConstantLookUpForMin<>();
		stack.push(-1);
		stack.push(4);
		stack.push(3);
		stack.push(-2);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}

}
