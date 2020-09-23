package math;

import java.util.BitSet;

import org.junit.Assert;
import org.junit.Test;

/*
 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
public class CountPrimesEratosthenes {
    public static int countPrimes(int n) {
    	int count = 0;
    	BitSet bits = new BitSet(n);
    	
    	for(int i = 2; i <= n; i++) {
    		if (i > 3 && (i % 2 == 0 || i % 3 == 0))
    			continue;
    		if(!bits.get(i))
    			count++;
    		int sum = i;
    		while(sum <= n)
    			bits.set(sum+=i);
    	}
    	return count;
    }
    
    @Test
    public void testCountPrimes() {
    	Assert.assertEquals(4, countPrimes(10));
    }


}
