package backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class KnightDialer {
    public static final int max = 1000000007;
    public int knightDialer(int n) {
        var moves = new int[][] {
                new int[]{4, 6}, // 0
                new int[]{6, 8}, // 1
                new int[]{7, 9}, // 2
                new int[]{4, 8}, // 3
                new int[]{3, 9, 0}, // 4
                new int[]{}, // 5
                new int[]{7, 1, 0}, // 6
                new int[]{2, 6}, // 7
                new int[]{1, 3}, // 8
                new int[]{4, 2} // 9
        };
        var count = 0L;
        var memo = new long[11][n+1];
        for (long[] row: memo)
            Arrays.fill(row, -1);
        for (int i = 0; i < 10; i++)
            count = (count+ solve(i, moves, n, memo)) % max;
        return (int) count;
    }

   static long solve(int digit, int[][] moves, int k, long[][] memo) {
        if(k == 1)
            return 1;
        long count = Arrays.stream(moves[digit]).mapToObj(d -> {
            if(memo[d][k-1] != -1)
                return memo[d][k-1];
            return solve(d, moves, k - 1, memo) ;
        }).reduce(0L, (a, b) -> (a + b) % max);
       memo[digit][k] = count;
       return count;
    }

    @Test
    public void test1() throws IOException {
        KnightDialer sol = new KnightDialer();
        Assert.assertEquals(10, sol.knightDialer(1));
    }
    @Test
    public void test2() throws IOException {
        KnightDialer sol = new KnightDialer();
        Assert.assertEquals(20, sol.knightDialer(2));
    }
    @Test
    public void test3() throws IOException {
        KnightDialer sol = new KnightDialer();
        Assert.assertEquals(46, sol.knightDialer(3));
    }
    @Test
    public void test10() throws IOException {
        KnightDialer sol = new KnightDialer();
        Assert.assertEquals(14912, sol.knightDialer(10));
    }
    @Test
    public void test3131() throws IOException {
        KnightDialer sol = new KnightDialer();
        Assert.assertEquals(136006598, sol.knightDialer(3131));
    }
    @Test
    public void test31() throws IOException {
        KnightDialer sol = new KnightDialer();
        Assert.assertEquals(352313197, sol.knightDialer(31));
    }
    @Test
    public void test3086() throws IOException {
        KnightDialer sol = new KnightDialer();
        Assert.assertEquals(450829411, sol.knightDialer(3086));
    }
    @Test
    public void test4902() throws IOException {
        KnightDialer sol = new KnightDialer();
        Assert.assertEquals(473031725, sol.knightDialer(4902));
    }

}
