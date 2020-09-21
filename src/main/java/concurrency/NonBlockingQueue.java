package concurrency;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class NonBlockingQueue<T> implements Iterable<T> {

	class Node<T> {
		T value;
		Node<T> next;

		Node(T value) {
			this.value = value;
		}
	}

	AtomicReference<Node<T>> head = new AtomicReference<>();
	AtomicReference<Node<T>> tail = new AtomicReference<>();

	public void enqueue(T value) {
		Node<T> newNode = new Node<>(value);
		Node<T> node;
		do {
			node = tail.get();
		} while (!tail.compareAndSet(node, newNode));
		if (node != null)
			node.next = newNode;
		else
			head.compareAndSet(null, newNode);
	}

	public T dequeue() {
		Node<T> node;
		do {
			node = head.get();
			if (node == null)
				return null;
		} while (!head.compareAndSet(node, node.next));
		if(node.next == null)
			tail.compareAndSet(node, null);
		return node.value;
	}

	public static void main(String[] args) throws InterruptedException {
		final NonBlockingQueue<Integer> queue = new NonBlockingQueue<>();
		Runnable p1 = () -> IntStream.range(0, 10).forEach(i -> queue.enqueue(i));
		Runnable p2 = () -> IntStream.range(10, 20).forEach(i -> queue.enqueue(i));
		Runnable p3 = () -> IntStream.range(0, 10).forEach(i -> queue.dequeue());
		List<Thread> list = Arrays.asList(new Thread(p1), new Thread(p2), new Thread(p3));
		list.stream().forEach(th -> th.start());
		for(Thread th : list) th.join();

		queue.forEach(v -> System.out.println(v));
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> cur = head.get();

			public boolean hasNext() {
				return cur.next != null;
			}

			public T next() {
				T result = cur.next.value;
				cur = cur.next;
				return result;
			}
		};
	}
}
