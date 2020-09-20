package strings;

import javax.print.attribute.Size2DSyntax;

/**
 * @author Alexey Burlutskiy
 *
 */
public class OneIsARotationOfTheAnother {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
		System.out.println(isRotation("waterwarm", "rwarmwate"));
		System.out.println(isRotation("waterbottle", "bottlewater"));
		System.out.println(isRotation("waterbottle", "bottleaaaaa"));
	}

	/**
	 * Assuming we don't have a method which can check if it is substring of another.
	 * But if it was then S1 = XY, S2 = YX, so then S2 must be a substring of S1S1 = XYXY = X(S2)X
	 */
	public static boolean isRotation(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		int index = 0;
		char c = s1.charAt(index);
		do {
			index = s2.indexOf(c, index);
			if(index == -1)
				return false;
			for (int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt((index + i) % s2.length()))
					continue;
			}
			return true;
		} while (true);
	}
}
