package misc;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RotationalChiper {

	// Add any helper functions you may need here
	static String Alphabet = "abcdefghijklmnopqrstuvwxyz";
	static String AlphabetCap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String Numbers = "0123456789";

	int rotationIndex(String source, char c, int rotationFactor) {
		int idx = source.indexOf(c);
		return (idx + rotationFactor) % source.length();
	}


	private String getAlphabet(char c) {
		for(String a : Arrays.asList(Alphabet, AlphabetCap, Numbers))
			if (c >= a.charAt(0) && c <= a.charAt(a.length()-1))
				return a ;
		return null;
	}
	
	String rotationalCipher(String input, int rotationFactor) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			final char c = input.charAt(i);
			String alphabet = getAlphabet(c);
			if(alphabet != null)
				sb.append(alphabet.charAt(rotationIndex(alphabet, c, rotationFactor)));
			else
				sb.append(c);
		}
		return sb.toString();
	}

	@Test
	public void test() {
		RotationalChiper rc = new RotationalChiper();
		Assert.assertEquals("Epp-gsrzsCw-3-fi:Epivx5.", rc.rotationalCipher("All-convoYs-9-be:Alert1.", 4));
		Assert.assertEquals("stuvRPQrpq-999.@", rc.rotationalCipher("abcdZXYzxy-999.@", 200));
	}

}
