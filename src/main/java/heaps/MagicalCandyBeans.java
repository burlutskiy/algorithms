package heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/*
 * Magical Candy Bags
You have N bags of candy. The ith bag contains arr[i] pieces of candy, and each of the bags is magical!
It takes you 1 minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of candy are inside), and as soon as you finish, the bag mysteriously refills. If there were x pieces of candy in the bag at the beginning of the minute, then after you've finished you'll find that floor(x/2) pieces are now inside.
You have k minutes to eat as much candy as possible. How many pieces of candy can you eat?
Signature
int maxCandies(int[] arr, int K)
Input
1 ≤ N ≤ 10,000
1 ≤ k ≤ 10,000
1 ≤ arr[i] ≤ 1,000,000,000
Output
A single integer, the maximum number of candies you can eat in k minutes.
Example 1
N = 5 
k = 3
arr = [2, 1, 7, 4, 2]
output = 14
In the first minute you can eat 7 pieces of candy. That bag will refill with floor(7/2) = 3 pieces.
In the second minute you can eat 4 pieces of candy from another bag. That bag will refill with floor(4/2) = 2 pieces.
In the third minute you can eat the 3 pieces of candy that have appeared in the first bag that you ate.
In total you can eat 7 + 4 + 3 = 14 pieces of candy.
 */
public class MagicalCandyBeans {

	  int maxCandies(int[] arr, int k) {
		    if(arr.length == 0)
		      return 0;
		    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		    Arrays.stream(arr).forEach(e -> queue.add(e));
		    int candies = 0;
		    while(k-- != 0) {
		      int x = queue.poll();
		      candies+=x;
		      queue.add(x/2);
		    }
		    return candies;
		  }
	  
	  @Test
	  public void test() {
		  MagicalCandyBeans mcb = new MagicalCandyBeans();
		  Assert.assertEquals(228, mcb.maxCandies(new int[]{19, 78, 76, 72, 48, 8, 24, 74, 29}, 3));
	  }
	  

}
