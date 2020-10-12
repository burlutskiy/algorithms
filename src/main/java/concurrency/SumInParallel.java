package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;

public class SumInParallel {

	/*
	 * Complete the 'computeFactorialSum' function below.
	 * 
	 * Your function should utilize the computeFactorial() function below to
	 * calculate the factorial for each number in inputs, sum the results, and
	 * return the sum. Though this can be done without parallelization, we ask that
	 * you perform computeFactorial() in parallel using your preferred method.
	 *
	 * Note that Java 8+ concurrency constructs are supported.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * LONG_INTEGER_ARRAY inputs as parameter.
	 */

	public static long computeFactorialSum(List<Long> inputs) {
		return inputs.parallelStream().mapToLong(input -> computeFactorial(input)).sum();
	}

	public static long computeFactorialSum2(List<Long> inputs) {
		return inputs.stream().map(input -> CompletableFuture.supplyAsync(() -> {
			return computeFactorial(input);
		})).mapToLong(cf -> getOrWait(cf)).sum();
	}
	
	static Long getOrWait(CompletableFuture<Long> cf) {
		try {
			return cf.get();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(e);
		}
		catch(ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	public static Long computeFactorial(Long num) {
		Long factorial = 1l;
		for (int i = 1; i <= Math.abs(num); i++) {
			factorial *= i;
		}

		return factorial;
	}

	@Test
	public void test1() {
		List<Long> list = Arrays.asList(2l, 3l, 4l, 5l, 3l, 1l, 2l, 4l, 6l, 5l, 4l, 7l, 8l, 9l);
		Assert.assertEquals(409289, computeFactorialSum(list));
	}

	@Test
	public void test2() {
		List<Long> list = Arrays.asList(2l, 3l, 4l, 5l, 3l, 1l, 2l, 4l, 6l, 5l, 4l, 7l, 8l, 9l);
		Assert.assertEquals(409289, computeFactorialSum2(list));
	}
}
