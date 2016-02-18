package queues;

/**
 * @author alexey
 *
 */
public class PriorityQueue<T extends Comparable<T>> {
	private final static int Initial_Capacity = 8;
	private T[] array;
	private int capacity;
	private int size;

	public PriorityQueue() {
		capacity = Initial_Capacity;
		array = (T[]) new Object[capacity];
	}

	public void insert(T value){
		array[size] = value;
		swim(size++);
		increaseCapacity();
	}
	
	public T remove() {
		T result = array[0];
		swap(0,size);
		array[size--] = null;
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

	void sink(int index){
		
	}

	void swim(int index) {
		while (index / 2 > 0 && less(index / 2, index)) {
			swap(index, index / 2);
			index /= 2;
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

	void increaseCapacity(){
		if (size >= capacity) {
			capacity <<= 1;
			T[] tmp = (T[]) new Object[capacity];
			System.arraycopy(array, 0, tmp, 0, size);
			array = tmp;
		}
	}
	
	void descreaseCapacity(){
		if (size * 4 < capacity && capacity > Initial_Capacity) {
			capacity >>= 1;
			T[] tmp = (T[]) new Object[capacity];
			System.arraycopy(array, 0, tmp, 0, size);
			array = tmp;
		}
	}
}
