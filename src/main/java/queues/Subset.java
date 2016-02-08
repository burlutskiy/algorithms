package queues;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author alexey
 *
 */
public class Subset {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		String[] readStrings = StdIn.readAllStrings();
		StdRandom.shuffle(readStrings);
		final Deque<String> deque = new Deque<>();
		for (int i = 0; i < k; i++){
			deque.addLast(readStrings[i]);
		}
		Iterator<String> iterator = deque.iterator();
		while(iterator.hasNext()){
			StdOut.println(iterator.next());
		}
	}
}
