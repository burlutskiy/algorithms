package utils;

import org.junit.*;
import org.junit.runner.JUnitCore;

public class RunTestFromClass {	
	
	public static void main(String... args) {
		JUnitCore.main("utils.RunTestFromClass");
	}
	
	@Test
	public void test() {
		System.out.println("Test");
		Assert.assertTrue(true);
	}

	@Test
	public void test2() {
		System.out.println("Test");
		Assert.assertTrue(false);
	}
	
}
