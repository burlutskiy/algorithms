package strings;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FirstNonRepeatingCharacter {

	Character solve(String str) {
		final Map<Character, Integer> map = new LinkedHashMap<>();
		str.chars().mapToObj(i -> (char)i).forEach(c -> map.put(c, map.getOrDefault(c,  0) + 1));
		return map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
	}
	
	@Test
	public void test() {
		Assert.assertEquals(Character.valueOf('1'), solve("123"));
		Assert.assertEquals(Character.valueOf('2'), solve("12313"));
		Assert.assertEquals(Character.valueOf('b'), solve("aaabcccdeeef"));
		Assert.assertEquals(Character.valueOf('c'), solve("abcbad"));
	}
}
