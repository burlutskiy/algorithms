/**
 * 
 */
package stacks;

import java.util.HashMap;
import java.util.Map;

/**
 * Describe how you could use a single array to implement three stacks.
 * @author burlutal
 *
 */
public class ThreeStacksBasedOnOneArray {

	static enum StackIndex {
		FIRST, SECOND, THIRD
	}

	static class StackData {
		int begin, end, curr;

		StackData(int begin, int end) {
			this.begin = begin;
			this.end = end;
			this.curr = begin;
		}
	}

	static class ThreeStack {
		int[] array;
		final Map<StackIndex, StackData> stacks = new HashMap<>();
		int size = 0;

		public ThreeStack(int capacity) {
			size = 3 * capacity;
			array = new int[size];
			createStackData(size);
		}

		public void push(StackIndex stackIndex, int value) {
			StackData stack = stacks.get(stackIndex);
			array[stack.curr] = value;
			if (++stack.curr > stack.end)
				resize();
		}

		private void resize() {
			StackData second = stacks.get(StackIndex.SECOND);
			StackData third = stacks.get(StackIndex.THIRD);
			int newsize = size * 2;
			int[] newarray = new int[newsize];
			System.arraycopy(array, 0, newarray, 0, stacks.get(StackIndex.FIRST).end + 1);
			System.arraycopy(array, second.begin, newarray, newsize / 3, second.end - second.begin + 1);
			System.arraycopy(array, third.begin, newarray, 2 * size / 3, third.end - third.begin + 1);
			createStackData(newsize);
			array = newarray;
			size = newsize;
		}

		private void createStackData(int size) {
			stacks.put(StackIndex.FIRST, new StackData(0, size / 3 - 1));
			stacks.put(StackIndex.SECOND, new StackData(size / 3, 2 * size / 3 - 1));
			stacks.put(StackIndex.THIRD, new StackData(2 * size / 3, size - 1));
		}

		public int pop(StackIndex stackIndex) {
			StackData stack = stacks.get(stackIndex);
			return array[stack.curr-- - 1];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeStack stack = new ThreeStack(4);
		stack.push(StackIndex.FIRST, 1);
		stack.push(StackIndex.FIRST, 1);
		stack.push(StackIndex.FIRST, 1);
		stack.push(StackIndex.FIRST, 1);
		stack.push(StackIndex.SECOND, 2);
		stack.push(StackIndex.SECOND, 2);
		stack.push(StackIndex.SECOND, 2);
		stack.push(StackIndex.SECOND, 2);
		stack.push(StackIndex.THIRD, 3);
		stack.push(StackIndex.THIRD, 3);
		stack.push(StackIndex.THIRD, 3);
		stack.push(StackIndex.THIRD, 3);
		System.out.println();
	}

}
