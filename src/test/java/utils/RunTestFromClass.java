package utils;

import org.junit.*;
import org.junit.runner.JUnitCore;

public class RunTestFromClass {	
	
	public static void main(String... args) {
		JUnitCore.main("utils.RunTestFromClass");
	}
	
	public boolean func(boolean b) {
		return b;
	}
	
	@Test
	public void test() {
		System.out.println("Test");
		Assert.assertTrue(func(true));
	}

	@Test
	public void test2() {
		System.out.println("Test");
		Assert.assertFalse(func(false));
	}
	
}
