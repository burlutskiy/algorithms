package strings.permutation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Find sum of all combinations like below for any int N:
 *
 *                                              |123
 *                         1+|23               12+|3            123+|
 *                     1+2|3   1+23|           12+3|
 *                  1+2+3|
 *
  */
public class SumEvalPermutations {
    private static long sum(String prefix, String suffix) {
        if(suffix.isEmpty())
            return eval(prefix);
        var res = 0;
        for (int i = 0; i < suffix.length(); i++) {
            var newElements = suffix.substring(i + 1);
            var newPrefix = prefix + suffix.substring(0, i + 1);
            if(!newElements.isEmpty())
                newPrefix += "+";
            res += sum(newPrefix, newElements);
        }
        return res;
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(168, sum("", "123"));
    }
    @Test
    public void test2() throws Exception {
        Assert.assertEquals(1736, sum("", "1234"));
    }

    @Test
    public void test3() throws Exception {
        Assert.assertEquals(17520, sum("", "12345"));
    }

    @Test
    public void test4() throws Exception {
        Assert.assertEquals(1757802240, sum("", "1234567890"));
    }

    private static long eval(String t) {
        return Arrays.stream(t.split("\\+"))
                .mapToLong(value -> Long.valueOf(value))
                .sum();
    }



}
