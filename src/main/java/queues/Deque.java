package queues;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * http://coursera.cs.princeton.edu/algs4/assignments/queues.html
 * 
 * @author alexey
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
	private class Node {
		private Node next, prev;
		private Item value;

		public Node(Item value) {
			this(null, null, value);
		}

		public Node(Node next, Node prev, Item value) {
			this.next = next;
			this.prev = prev;
			this.value = value;
		}

		public String toString() {
			return String.valueOf(value);
		}
	}
	
	private Node first, last;
	private int size;

	public boolean isEmpty() {
		return first == null && last == null;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item value) {
		if (value == null)
			throw new NullPointerException();
		size++;
		if (first == null) {
			first = last = new Node(value);
		} else {
			Node node = new Node(first, null, value);
			first.prev = node;
			first = node;
		}
	}

	public void addLast(Item value) {
		if (value == null)
			throw new NullPointerException();
		size++;
		if (last == null) {
			first = last = new Node(value);
		} else {
			Node node = new Node(null, last, value);
			last.next = node;
			last = node;
		}
	}

	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		size--;
		Node node = first;
		if (first != null) {
			first = first.next;
			if (first != null) {
				first.prev = null;
			}
			if(first == null)
				last = null;
			return node.value;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public Item removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		size--;
		Node node = last;
		if (last != null) {
			last = last.prev;
			if (last != null) {
				last.next = null;
			}
			if(last == null)
				first = null;
			return node.value;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public java.util.Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node cur = first;

			@Override
			public boolean hasNext() {
				return cur != null;
			}

			@Override
			public Item next() {
				if (cur == null)
					throw new NoSuchElementException();
				Item value = cur.value;
				cur = cur.next;
				return value;
			}
		};
	}

	public static void main(String[] args) {
		Deque<Integer> deck = new Deque<>();
		System.out.println(deck.isEmpty());
		deck.addFirst(0);
		System.out.println(deck.isEmpty());
		System.out.println(deck.removeLast());
		System.out.println(deck.isEmpty());
	}
}