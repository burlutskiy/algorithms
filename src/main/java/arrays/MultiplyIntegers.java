package arrays;

import org.junit.Assert;
import org.junit.Test;

public class MultiplyIntegers {

	int multiply(int... arr) {
		int ncount = 0;
		for(int a : arr) {
			if(a == 0)
				return 0;
			else if(a < 0)
				ncount++;
		}
		if(ncount % 2 == 0)
			return 1;
		else
			return -1;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, multiply(1,2,3));
	}
	@Test
	public void test1() {
		Assert.assertEquals(-1, multiply(-1,2,3));
	}
	@Test
	public void test2() {
		Assert.assertEquals(0, multiply(1,2,0,1));
	}
	@Test
	public void test4() {
		Assert.assertEquals(1, multiply(-1,-2,3));
	}

}
