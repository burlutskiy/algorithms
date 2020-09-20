package stacks;

import org.junit.Assert;
import org.junit.Test;

public class StackWithConstantLookUpForMinTest {

	private StackWithConstantLookUpForMin<Integer> stack = new StackWithConstantLookUpForMin<>();
	
	@Test
	public void test(){
		stack.push(-1);
		stack.push(4);
		stack.push(3);
		stack.push(-2);
		Assert.assertSame(-2, stack.min());
		stack.pop();
		Assert.assertSame(-1, stack.min());
	}

}
