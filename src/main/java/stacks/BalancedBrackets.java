package stacks;

public class BalancedBrackets {
	// Add any helper functions you may need here
	boolean isCloseBracket(char c) {
		return c == ']' || c == '}' || c == ')';
	}

	boolean isOpenBracket(char c) {
		return c == '[' || c == '{' || c == '(';
	}

	boolean isBracket(char c) {
		return isOpenBracket(c) || isCloseBracket(c);
	}

	boolean areSameBracketGroup(char c1, char c2) {
		String[] bgroups = new String[] { "{}", "[]", "()" };
		for (String bs : bgroups)
			if (bs.indexOf(c1) > 0 && bs.indexOf(c2) < 0 || bs.indexOf(c1) < 0 && bs.indexOf(c2) > 0)
				return false;
		return true;
	}

	boolean isBalanced(String s) {
		// Write your code here
		// {{]{()}}
		if (s == null)
			throw new IllegalArgumentException("s is null");
		final int n = s.length();
		final Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (!isBracket(c))
				throw new IllegalArgumentException("not a bracket");
			if (isOpenBracket(c))
				stack.push(c);
			else {
				char charFromStack = stack.pop();
				if (!isOpenBracket(charFromStack))
					return false;
				if (!areSameBracketGroup(c, charFromStack))
					return false;
			}
		}
		return stack.isEmpty();
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(boolean expected, boolean output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			System.out.print(expected);
			System.out.print(" Your output: ");
			System.out.print(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printString(String str) {
		System.out.print("[" + str + "]");
	}

	public void run() {
		String s_1 = "{[(])}";
		boolean expected_1 = false;
		boolean output_1 = isBalanced(s_1);
		check(expected_1, output_1);

		String s_2 = "{{[[(())]]}}";
		boolean expected_2 = true;
		boolean output_2 = isBalanced(s_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new BalancedBrackets().run();
	}
}
