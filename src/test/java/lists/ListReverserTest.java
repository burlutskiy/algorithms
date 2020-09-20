package lists;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Tests for {@link ListReverser}
 */
public class ListReverserTest {

    @Test(expected = NullPointerException.class)
    public void testReversingNullList() {
        ListReverser.reverse(null);
    }

    @Test
    public void testReversingEmptyList() {
        assertEquals(0, ListReverser.reverse(emptyList()).size());
    }

    @Test
    public void testReversingStringList() {
        assertEquals(asList("three", "two", "one", "testing"), ListReverser.reverse(asList("testing", "one", "two", "three")));
    }

    @Test
    public void testReversingBigList() {
        List<Integer> bigList = IntStream.range(0, 10_000).mapToObj(i -> i).collect(Collectors.toList());
        List<Integer> reversed = ListReverser.reverse(bigList);
        IntStream.range(0, 10_000).forEach(i -> assertEquals(9_999 - i, reversed.get(i), 0));
    }
}
