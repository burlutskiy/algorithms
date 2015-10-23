package strings;

import java.util.BitSet;

/**
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 * 
 * @author burlutal
 *
 */
public class DoesStringHasAllUniqueCharacters {

	public static void main(String[] args) {
		System.out.println(method3("ABC"));
		System.out.println(method3("AZCPBG"));
		System.out.println(method3("AZCPBGP"));
	}
	
	/**
	 * Assuming it is ASCII
	 * @return
	 */
	static boolean method1(String string){
		if(string.length() > 256 || string.length() == 0)
			return false;
		if(string.length() == 1)
			return true;
		boolean array[] = new boolean[256];
		for (int i = 0; i < string.length(); i++) {
			char charAt = string.charAt(i);
			if(!(array[charAt] = !array[charAt]))
				return false;
		}
		return true;
	}

	/**
	 * Assuming it is ASCII
	 * @return
	 */
	static boolean method2(String string){
		if(string.length() > 256 || string.length() == 0)
			return false;
		if(string.length() == 1)
			return true;
		BitSet bitset = new BitSet(256); 
		for (int i = 0; i < string.length(); i++) {
			char charAt = string.charAt(i);
			bitset.flip(charAt);
			if(!bitset.get(charAt))
				return false;
		}
		return true;
	}
	
	/**
	 * Assuming it is ASCII and from range A-Z
	 * @return
	 */
	static boolean method3(String string){
		if(string.length() > 256 || string.length() == 0)
			return false;
		if(string.length() == 1)
			return true;
		int bitset = 0; // 32 bits 
		for (int i = 0; i < string.length(); i++) {
			int pos = string.charAt(i) - 'A';
			if((bitset & 1 << pos) > 0 )
				return false;
			bitset|=1 << pos;
		}
		return true;
	}
}
