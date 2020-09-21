package stacks;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests for {@link SimpleStack}
 */
public class SimpleStackTest {

    @Test
    public void testEmptySize() {
        SimpleStack<String> stack = new SimpleStack<>();
        assertEquals(0, stack.size());
    }

    @Test
    public void testEmptyPopReturnsNull() {
        SimpleStack<String> stack = new SimpleStack<>();
        assertNull(stack.pop());
    }

    @Test
    public void testEmptyPeekReturnsNull() {
        SimpleStack<String> stack = new SimpleStack<>();
        assertNull(stack.peek());
    }

    @Test
    public void testSimpleStackLikeBehavior() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push("a").push("b");
        assertEquals("b", stack.pop());
        stack.push("c");
        assertEquals("c", stack.pop());
        assertEquals("a", stack.pop());
        assertNull(stack.pop());
    }

    @Test(expected = NullPointerException.class)
    public void testNullPushThrowsNPE() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push(null);
    }

    @Test
    public void testPushPeekPopSizeClear() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push("one").push("two").push("three");
        assertEquals(stack.size(), 3);
        assertEquals(stack.peek(), "three");
        assertEquals(stack.pop(), "three");
        assertEquals(stack.pop(), "two");
        assertEquals(stack.pop(), "one");
        assertEquals(stack.size(), 0);
        stack.push("one");
        assertEquals(1, stack.size());
        stack.clear();
        assertEquals(0, stack.size());
    }

    @Test
    public void testConcurrentPush() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        /* push 1000 elements into stack in parallel */
        IntStream.range(0, 1000).parallel().forEach(i -> stack.push(i));
        /* verify size */
        assertEquals(1000, stack.size());
        /* pop 500 elements */
        IntStream.range(0, 500).parallel().forEach(i -> stack.pop());
        assertEquals(500, stack.size());
    }

}
