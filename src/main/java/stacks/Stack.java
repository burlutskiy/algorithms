package stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author burlutal
 *
 * @param <T>
 */
public class Stack<T> implements Iterable<T> {
	INode<T> top;

	interface INode<T> {
		public INode<T> getPrev();

		public T getValue();
	}

	class Node implements INode<T> {
		INode<T> prev;
		T value;

		public Node(INode<T> prev, T value) {
			this.prev = prev;
			this.value = value;
		}

		public String toString() {
			return String.valueOf(value);
		}

		public INode<T> getPrev() {
			return prev;
		}

		public T getValue() {
			return value;
		}
	}

	public T peek() {
		if (top == null)
			return null;
		return top.getValue();
	}

	public T pop() {
		if (top == null)
			return null;
		INode<T> node = top;
		top = top.getPrev();
		return node.getValue();
	}

	public void push(T newValue) {
		INode<T> v = top;
		top = new Node(v, newValue);
	}

	@Override
	public String toString() {
		if (top == null)
			return "";
		INode<T> node = top;
		StringBuffer sb = new StringBuffer();
		do {
			sb.append(node.getValue());
			node = node.getPrev();
			if (node != null)
				sb.append(",");
		} while (node != null);
		return sb.toString();
	}

	public boolean isEmpty() {
		return top == null;
	}
   
	public Iterator<T> iterator() {
        return new ListIterator(top);
    }

    private class ListIterator implements Iterator<T> {
        private INode<T> current;

        public ListIterator(INode<T> first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T T = current.getValue();
            current = current.getPrev(); 
            return T;
        }
    }

}