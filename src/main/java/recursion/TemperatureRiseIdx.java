package recursion;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 */
public class TemperatureRiseIdx {
    public static int[] temperatureIdx(int[] array) {
        var result = new int[array.length];
        process(array, result, 0, Integer.MAX_VALUE);
        return result;
    }

    // returns the end index of sub array
    private static int process(int[] temp, int[] days, int curr, int max) {
        var n = temp.length;
        if(curr == n - 1)
            return curr;
        if(temp[curr + 1] > max) {
            days[curr] = 1;
            return curr;
        }

        var i = curr;
        while (i + 1 < n && temp[i + 1] <= max) {
            if(temp[i + 1] > temp[i])
                days[i++] = 1;
            else {
                var idx = process(temp, days, i + 1, temp[i]);
                if(idx + 1 < n && temp[idx + 1] > temp[i]) {
                    days[i] = idx - i + 1;
                    i = idx;
                }
                else
                    break;
            }
        }
        return i;
    }

    //non recursive
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            // Popping all indices with a lower or equal temperature than the current index
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            // If the stack still has elements, then the next warmer temperature exists!
            if(!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }

            // Inserting current index in the stack: monotonicity is maintained!
            st.push(i);
        }

        return ans;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{ 0,0,0,0 }, temperatureIdx(new int[]{72,72,72,72}));
    }
    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{ 1,1,1,0 }, temperatureIdx(new int[]{72,74,76,78}));
    }
    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{ 2,1,0,0 }, temperatureIdx(new int[]{71,70,72,71}));
    }
    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[]{ 0,1,1,0 }, temperatureIdx(new int[] { 71,69,70,71 } ));
    }
    @Test
    public void test5() {
        Assert.assertArrayEquals(new int[]{ 1,1,4,2,1,1,0,0 }, temperatureIdx(new int[]{73,74,75,71,69,72,76,73}));
    }
    @Test
    public void test6() {
        Assert.assertArrayEquals(new int[]{ 1,1,4,2,1,1,0,0 }, dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }

}
