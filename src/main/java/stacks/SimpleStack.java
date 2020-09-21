package stacks;


/**
 * A simple thread safe first in first out data structure.
 *
 * @param <T> concrete element type
 */
public class SimpleStack<T> {
	
	private Node<T> top;
	
	class Node<T> {
		Node<T> prev;
		T value;

		public Node(Node<T> prev, T value) {
			this.prev = prev;
			this.value = value;
		}

		public String toString() {
			return String.valueOf(value);
		}

		public Node<T> getPrev() {
			return prev;
		}

		public T getValue() {
			return value;
		}
	}


    /**
     * Push an item into the stack and return the stack
     *
     * @param item item to push into the stack, can *not* be null
     * @return {@code this}
     * @throws NullPointerException if item is {@code null}
     */
    public synchronized SimpleStack<T> push(T item) throws NullPointerException {
    	if(item == null)
    		throw new NullPointerException();
		final Node<T> v = top;
		top = new Node<>(v, item);
        return this;
    }

    /**
     * Remove the last item placed into the stack from the stack and return it.  If stack is empty, should return
     * {@code null}
     *
     * @return last item placed into the stack or {@code null}
     */
    public synchronized T pop() {
		if (top == null)
			return null;
		Node<T> node = top;
		top = top.getPrev();
		return node.getValue();
    }

    /**
     * Return the last item placed into the stack but do not remove it from the stack.  If stack is empty, should
     * return
     * {@code null}
     *
     * @return last item placed into the stack or {@code null}
     */
    public T peek() {
		if (top == null)
			return null;
		return top.getValue();
    }

    /**
     * Return stack size
     *
     * @return stack size
     */
    public synchronized int size() {
    	Node<T> cur = top;
    	int count = 0;
        while(cur != null) {
        	cur = cur.prev;
        	count++;
        }
        return count;
    }

    /**
     * Clear the stack
     */
    public void clear() {
        top = null;
    }
}
