package queues;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue Removals
You're given a list of n integers arr, which represent elements in a queue (in order from front to back). You're also given an integer x, and must perform x iterations of the following 3-step process:
Pop x elements from the front of queue (or, if it contains fewer than x elements, pop all of them)
Of the elements that were popped, find the one with the largest value (if there are multiple such elements,
take the one which had been popped the earliest), and remove it
For each one of the remaining elements that were popped (in the order they had been popped), 
decrement its value by 1 if it's positive (otherwise, if its value is 0, then it's left unchanged), 
and then push it back onto the queue

Compute a list of x integers output, the ith of which is the 1-based index in the original array of the element which had been removed in step 2 during the ith iteration.

Signature
int[] findPositions(int[] arr, int x)
Input
x is in the range [1, 316].
n is in the range [x, x*x].
Each value arr[i] is in the range [1, x].
Output

Return a list of x integers output, as described above.

Example
n = 6
arr = [1, 2, 2, 3, 4, 5]
x = 5
output = [5, 6, 4, 1, 2]

The initial queue is [1, 2, 2, 3, 4, 5] (from front to back).

In the first iteration, the first 5 elements are popped off the queue, leaving just [5]. Of the popped elements, the largest one is the 4, which was at index 5 in the original array. The remaining elements are then decremented and pushed back onto the queue, whose contents are then [5, 0, 1, 1, 2].
In the second iteration, all 5 elements are popped off the queue. The largest one is the 5, which was at index 6 in the original array. The remaining elements are then decremented (aside from the 0) and pushed back onto the queue, whose contents are then [0, 0, 0, 1].
In the third iteration, all 4 elements are popped off the queue. The largest one is the 1, which had the initial value of 3 at index 4 in the original array. The remaining elements are pushed back onto the queue, whose contents are then [0, 0, 0].
In the fourth iteration, all 3 elements are popped off the queue. Since they all have an equal value, we remove the one that was popped first, which had the initial value of 1 at index 1 in the original array. The remaining elements are pushed backed onto the queue, whose contents are then [0, 0].
In the final iteration, both elements are popped off the queue. We remove the one that was popped first, which had the initial value of 2 at index 2 in the original array.
 */
public class QueueRemovals {

	class ValPos {
		final int position;
		int value;

		ValPos(int value, int position) {
			this.position = position;
			this.value = value;
		}

		ValPos decrement() {
			value--;
			return this;
		}

		int get() {
			return value;
		}

		int position() {
			return position;
		}
	}

	Queue<ValPos> step1(Queue<ValPos> queue, int x) {
		Queue<ValPos> tmp = new LinkedList<>();
		while (x-- > 0 && !queue.isEmpty())
			tmp.add(queue.remove());
		return tmp;
	}

	ValPos step2(Queue<ValPos> queue) {
		ValPos max = queue.stream().max(Comparator.comparing(ValPos::get)).get();
		queue.remove(max);
		return max;
	}

	void step3(Queue<ValPos> queue, Queue<ValPos> tmp) {
		for (ValPos vp : tmp)
			queue.add(vp.get() > 0 ? vp.decrement() : vp);
	}

	int indexOf(int[] arr, int max, int x) {
		for (int i = 0; i < x; i++)
			if (arr[i] == max)
				return i;
		return 0;
	}

	void initQueue(int arr[], Queue<ValPos> queue) {
		for (int i = 0; i < arr.length; i++)
			queue.add(new ValPos(arr[i], i + 1));
	}

	int[] findPositions(int[] arr, int x) {
		int[] result = new int[x];
		Queue<ValPos> queue = new LinkedList<>();
		initQueue(arr, queue);
		for (int i = 0; i < x; i++) {
			Queue<ValPos> tmp = step1(queue, x);
			ValPos max = step2(tmp);
			step3(queue, tmp);
			result[i] = max.position();
		}
		return result;
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	public void run() {
		int n_1 = 6;
		int x_1 = 5;
		int[] arr_1 = { 1, 2, 2, 3, 4, 5 };
		int[] expected_1 = { 5, 6, 4, 1, 2 };
		int[] output_1 = findPositions(arr_1, x_1);
		check(expected_1, output_1);

		int n_2 = 13;
		int x_2 = 4;
		int[] arr_2 = { 2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4 };
		int[] expected_2 = { 2, 5, 10, 13 };
		int[] output_2 = findPositions(arr_2, x_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new QueueRemovals().run();
	}
}
