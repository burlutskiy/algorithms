package strings;

/**
 * Utility for detecting string rotations.
 * <p/>
 * Intended to detect strings that have been rotated. Imagine you took a string, connected the end to the beginning
 * along a wheel, spun the wheel and then split it again.
 * <p/>
 * Some examples of rotated strings:
 * <p/>
 * "ABCDEFGHIJKLMNOPQRSTUVWXYZ" and "OPQRSTUVWXYZABCDEFGHIJKLMN"
 * "12345" and "51234"
 * "12345" and "12345"
 * <p/>
 * This function should detect rotated strings, returning true if the 2 inputs are rotated versions of the
 * same string, and false if not.
 */
public class RotatedStringDetector {
    /**
     * Returns {@code true} if {@code string1} is a rotation of {@code string2}.  Examples of string rotations:
     * <p/>
     * "abcd" -> "dabc"
     * "abcd" -> "cdab"
     * "abcd" -> "bcda"
     * "abcd" -> "abcd"
     *
     * @param string1 a string or {@code null}
     * @param string2 a string or {@code null}
     * @return {@code true} if string1 is a "rotation" of string2
     */
    public static boolean isRotation(String str1, String str2) {
    	if(str1 == null || str2 ==null || str1.length() != str2.length() )
    		return false;
    	if(str1.trim().isEmpty() && str2.trim().isEmpty())
    		return true;
    	
    	final StringBuilder sb = new StringBuilder();
    	sb.append(str1);
    	sb.append(str1);
    	char[] str = sb.toString().toCharArray();
    	char[] cstr2 = str2.toCharArray();
    	for(int i = 0; i < str1.length(); i++)
    		if(compare(str, cstr2, i, str2.length()))
    			return true;
    	return false;
    }
    
    private static boolean compare(char[] c1, char[] c2, int ic1, int len) {
    	for(int i = 0; i < len; i++)
    		if(c1[ic1 + i] != c2[i])
    			return false;
    	return true;
    }

    /**
     * 
     * Too slow
     */
    @Deprecated
    public static boolean _isRotation(String str1, String str2) {
    	if(str1 == null || str2 ==null || str1.length() != str2.length() )
    		return false;
    	if(str1.trim().isEmpty() && str2.trim().isEmpty())
    		return true;
    	
    	final String str3 = str1 + str1;
    	for(int i = 0; i < str1.length(); i++) 
    		if(str3.substring(i, i + str1.length()).intern().equals(str2))
    			return true;
    	return false;
    }
}
