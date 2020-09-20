/**
 * 
 */
package strings;

/**
 * @author Alexey Burlutskiy
 *
 *         Implement a method to perform basic string compression using the
 *         counts of repeated characters. For example, the string aabcccccaaa
 *         would become a2blc5a3. If the "compressed" string would not become
 *         smaller than the original string, your method should return the
 *         original string.
 * 
 */
public class CompressAString {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
	}

	public static void processStringWithStrategy(String string, FoundDoublicateStrategy strategy) {
		char curr = string.charAt(0);
		int count = 1;
		for (int i = 1; i < string.length(); i++) {
			if (curr != string.charAt(i)) {
				strategy.performOperation(curr, count);
				curr = string.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		if (count > 0) {
			strategy.performOperation(curr, count);
		}
	}

	public static String compress(String string) {
		GetNewLengthStrategy strategy = new GetNewLengthStrategy();
		processStringWithStrategy(string, strategy);
		int newlength = strategy.getNewlength();
		if (newlength < string.length()) {
			CompressStrategy cstrategy = new CompressStrategy(newlength);
			processStringWithStrategy(string, cstrategy);
			return cstrategy.getCompressedString();
		}
		return string;
	}

	private static interface FoundDoublicateStrategy {
		void performOperation(char curr, int count);
	}

	private static class GetNewLengthStrategy implements FoundDoublicateStrategy {
		private int newlength = 0;

		@Override
		public void performOperation(char curr, int count) {
			newlength++;
			newlength += lettersInNumber(count);
		}

		public int getNewlength() {
			return newlength;
		}

		private static int lettersInNumber(int count) {
			int result = 1;
			while ((count /= 10) > 0)
				result++;
			return result;
		}
	}

	private static class CompressStrategy implements FoundDoublicateStrategy {
		private final StringBuffer sb;

		public CompressStrategy(int newlenght) {
			super();
			this.sb = new StringBuffer(newlenght);
		}

		@Override
		public void performOperation(char curr, int count) {
			add(sb, curr, count);
		}

		private static void add(StringBuffer sb, char curr, int count) {
			sb.append(curr);
			sb.append(count);
		}

		public String getCompressedString() {
			return sb.toString();
		}
	}

}
