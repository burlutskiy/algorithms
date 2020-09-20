package stacks;

import java.util.HashMap;
import java.util.Map;

/**
 * Describe how you could use a single array to implement three stacks.
 * 
 * @author Alexey Burlutskiy
 *
 */
public class ThreeStacksBasedOnOneArray {

	public static enum StackIndex {
		FIRST, SECOND, THIRD;

		public StackIndex toTheLeft() {
			if (this == SECOND)
				return FIRST;
			else if (this == THIRD)
				return SECOND;
			else
				return null;
		}

		public StackIndex toTheRight() {
			if (this == FIRST)
				return SECOND;
			else if (this == SECOND)
				return THIRD;
			else
				return null;
		}

	}

	static class StackData {
		int begin, end, curr;

		StackData(int begin, int end, int curr) {
			this.begin = begin;
			this.end = end;
			this.curr = curr;
		}

		StackData(int begin, int end) {
			this.begin = begin;
			this.end = end;
			this.curr = begin;
		}

	}

	public static class ThreeStack {
		Integer[] array;
		final Map<StackIndex, StackData> stacks = new HashMap<>();
		int size = 0;

		public ThreeStack(int capacity) {
			size = 3 * capacity;
			array = new Integer[size];
			stacks.put(StackIndex.FIRST, new StackData(0, size / 3 - 1));
			stacks.put(StackIndex.SECOND, new StackData(size / 3, 2 * size / 3 - 1));
			stacks.put(StackIndex.THIRD, new StackData(2 * size / 3, size - 1));
		}

		public void push(StackIndex stackIndex, Integer value) {
			StackData stack = stacks.get(stackIndex);
			if (stack.curr > stack.end)
				resize();
			array[stack.curr++] = value;
		}

		private void resize() {
			StackData first = stacks.get(StackIndex.FIRST);
			StackData second = stacks.get(StackIndex.SECOND);
			StackData third = stacks.get(StackIndex.THIRD);
			int newsize = size * 2;
			Integer[] newarray = new Integer[newsize];
			System.arraycopy(array, 0, newarray, 0, first.end + 1);
			System.arraycopy(array, second.begin, newarray, newsize / 3, second.end - second.begin + 1);
			System.arraycopy(array, third.begin, newarray, 2 * size / 3, third.end - third.begin + 1);
			size = newsize;
			array = newarray;
			stacks.put(StackIndex.FIRST, new StackData(0, size / 3 - 1, first.curr));
			stacks.put(StackIndex.SECOND, new StackData(size / 3, 2 * size / 3 - 1, second.curr));
			stacks.put(StackIndex.THIRD, new StackData(2 * size / 3, size - 1, third.curr));
		}

		public Integer peek(StackIndex stackIndex) {
			StackData stack = stacks.get(stackIndex);
			return stack.begin == stack.curr ? null : array[stack.curr - 1];
		}

		public Integer pop(StackIndex stackIndex) {
			StackData stack = stacks.get(stackIndex);
			if (stack.begin == stack.curr)
				return null;
			Integer value = array[--stack.curr];
			array[stack.curr] = null;
			return value;
		}

		public boolean isEmpty(StackIndex index) {
			return stacks.get(index).begin == stacks.get(index).curr;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= size / 3; i++) {
				sb.append(array[size / 3 - i] != null && size / 3 - i < stacks.get(StackIndex.FIRST).curr
						? array[size / 3 - i] : ".")
						.append('\t')
						.append(array[2 * size / 3 - i] != null && 2 * size / 3 - i < stacks.get(StackIndex.SECOND).curr
								? array[2 * size / 3 - i] : ".")
						.append('\t').append(array[size - i] != null && size - i < stacks.get(StackIndex.THIRD).curr
								? array[size - i] : ".")
						.append("\n");
			}
			return sb.toString();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeStack stack = new ThreeStack(3);
		stack.push(StackIndex.THIRD, 1);
		stack.push(StackIndex.THIRD, 1);
		stack.push(StackIndex.THIRD, 1);
		stack.pop(StackIndex.THIRD);
		stack.pop(StackIndex.THIRD);
		stack.pop(StackIndex.THIRD);
		stack.push(StackIndex.THIRD, 1);
		System.out.println();
	}

}
