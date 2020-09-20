package stacks;

/**
 * 
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in O(1) time.
 * 
 * @author Alexey Burlutskiy
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


}
