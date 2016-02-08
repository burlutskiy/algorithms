package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * http://coursera.cs.princeton.edu/algs4/assignments/queues.html
 * 
 * @author alexey
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private final static int Initial_Capacity = 8;
	private final class RandomizedIterator implements Iterator<Item> {
		private int index = 0;
		private int[] sequence = new int[size];
		RandomizedIterator() {
			for (int i = 0; i < sequence.length; i++) {
				sequence[i] = i;
			}
			StdRandom.shuffle(sequence);
		}
		
		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public Item next() {
			if (index >= size)
				throw new NoSuchElementException();
			Item item = (Item) array[sequence[index++]];
			return item;
		}
	}

	private Object[] array;
	private int capacity;
	private int size;

	public RandomizedQueue() {
		capacity = Initial_Capacity;
		array = new Object[capacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(Item value) {
		if (value == null)
			throw new NullPointerException();
		if (size >= capacity) {
			capacity <<= 1;
			Object[] tmp = new Object[capacity];
			System.arraycopy(array, 0, tmp, 0, size);
			array = tmp;
		}
		array[size++] = value;
	}

	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		int index = StdRandom.uniform(size);
		Item value = (Item) array[index];
		array[index] = array[size - 1];
		array[size - 1] = null;
		size--;
		if (size * 4 < capacity && capacity > Initial_Capacity) {
			capacity >>= 1;
			Object[] tmp = new Object[capacity];
			System.arraycopy(array, 0, tmp, 0, size);
			array = tmp;
		}
		return value;
	}

	public Item sample() {
		if (isEmpty())
			throw new NoSuchElementException();
		int index = StdRandom.uniform(size);
		return (Item) array[index];
	}

	public java.util.Iterator<Item> iterator() {
		return new RandomizedIterator();
	}

	public static void main(String[] args) {
	}
}