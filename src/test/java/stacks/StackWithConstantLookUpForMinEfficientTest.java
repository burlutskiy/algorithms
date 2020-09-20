package stacks;

import org.junit.Assert;
import org.junit.Test;

public class StackWithConstantLookUpForMinEfficientTest {
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
