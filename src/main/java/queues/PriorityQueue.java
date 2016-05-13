package queues;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author alexey
 *
 */
public class PriorityQueue<T extends Comparable<T>> implements Iterable<T> {
	private final static int Initial_Capacity = 8;
	private T[] array;
	private int capacity;
	private int size;

	public PriorityQueue() {
		capacity = Initial_Capacity;
		array = newArray();
	}

	public void insert(T value) {
		array[size] = value;
		swim(size++);
		increaseCapacity();
	}

	public T remove() {
		T result = array[0];
		swap(0, --size);
		array[size] = null;
		sink(0);
		descreaseCapacity();
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	/**
	 * childs 2 * k + 1, 2 * k + 2
	 * @param k
	 */
	void sink(int k) {
		while (2 * k + 2 <= size) {
			int inx = 2 * k;
			int child = inx + 2 < size ? succsessor(inx + 1, inx + 2) : inx + 1;
			if (less(k, child))
				swap(k, child);
			k = child; 
		}
	}

	int succsessor(int i, int j) {
		return less(j, i) ? i : j;
	}

	/**
	 * parent (k - 1) / 2
	 * @param k
	 */
	void swim(int k) {
		int parent; 
		while ((parent = (k - 1) / 2) >= 0 && less(parent, k)) {
			swap(parent, k);
			k = parent;
		}
	}

	private void swap(int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private boolean less(int x, int y) {
		return array[x].compareTo(array[y]) < 0;
	}

	void increaseCapacity() {
		if (size >= capacity) {
			capacity <<= 1;
			T[] tmp = newArray();
			System.arraycopy(array, 0, tmp, 0, size);
			array = tmp;
		}
	}

	void descreaseCapacity() {
		if (size * 4 < capacity && capacity > Initial_Capacity) {
			capacity >>= 1;
			T[] tmp = newArray();
			System.arraycopy(array, 0, tmp, 0, size);
			array = tmp;
		}
	}

	private T[] newArray() {
		return (T[]) new Comparable[capacity];
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			T t = iterator.next();
			s.append(t);
			if (iterator.hasNext())
				s.append(' ');
		}
		s.append("]");
		return s.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			final int s = size;

			public boolean hasNext() {
				if (s != size)
					throw new ConcurrentModificationException();
				return i < s;
			}

			@Override
			public T next() {
				if (s != size)
					throw new ConcurrentModificationException();
				if (i >= size)
					throw new NoSuchElementException();
				return array[i++];
			}
		};
	}
}
