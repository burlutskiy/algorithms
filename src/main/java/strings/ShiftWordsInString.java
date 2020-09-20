/**
 * 
 */
package strings;

/**
 * Write a method to replace all spaces in a string with'%20'. You may assume
 * that the string has sufficient space at the end of the string to hold the
 * additional characters, and that you are given the "true" length of the
 * string. (Note: if implementing in Java, please use a character array so that
 * you can perform this operation in place.) EXAMPLE Input:
 * "Mr John Smith Output: "Mr%20Dohn%20Smith"
 * 
 * @author Alexey Burlutskiy
 */
public class ShiftWordsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "I am Mr John Smith";
		// str = " I am Mr John Smith ";
		// str = " ";
		// str = " ";
		char[] input = new char[100];
		System.arraycopy(str.toCharArray(), 0, input, 0, str.length());
		replace2(input, str.length());
		for (char c : input) {
			System.out.print(c);
		}
	}

	public static void replace2(char[] string, int originalLength) {
		char[] webspace = new char[] { '%', '2', '0' };
		boolean lookingWhereWordStarts = false;
		// 1. go through and check how many spaces
		int spaces = 0;
		for (int t = string.length - 1; t >= 0; t--) {
			if (string[t] == ' ')
				spaces++;
		}
		// 2. shift
		lookingWhereWordStarts = false;
		int wordEndIndex = -1;
		for (int t = originalLength - 1; t >= 0; t--) {
			if (string[t] != ' ') {
				if (!lookingWhereWordStarts) {
					lookingWhereWordStarts = true;
					wordEndIndex = t;
				}
			} else {
				lookingWhereWordStarts = false;
				if (wordEndIndex != -1)
					System.arraycopy(string, t + 1, string, t + spaces * 2 + 1, wordEndIndex - t);
				System.arraycopy(webspace, 0, string, t + spaces * 2 - 2, 3);
				spaces--;
			}
		}
	}

}
