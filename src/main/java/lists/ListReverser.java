package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * List reversing utility class.
 *
 * @see #reverse(List)
 */
public class ListReverser {
    /**
     * Accept a list of elements and return a reversed version of this list.  For example:
     * {@code
     * ListReverser.reverse(Arrays.asList("a","b","c"));
     * }
     * should return {@code ["c","b","a"]}
     *
     * @param list a list
     * @param <T>  concrete element type
     * @return reversed version of supplied list
     */
    public static <T> List<T> reverse(List<T> list) {
    	Stack<T> stack = new Stack<>();
    	list.forEach(e -> stack.add(e));
    	List<T> result = new ArrayList<>();
    	while(!stack.isEmpty())
    		result.add(stack.pop());
    	return result;
    }
}
