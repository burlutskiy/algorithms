package strings.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;

public class PermutationR {

	public List<String> permutate(String str) {
		final List<String> result = new ArrayList<>();
		permutate("", str, c -> result.add(c));
		return result;
	}

	private void permutate(String prefix, String elems, Consumer<String> consumer) {
		if (elems == null || elems.isEmpty()) {
			consumer.accept(prefix);
			return;
		}
		for (int i = 0; i < elems.length(); i++)
			permutate(prefix + elems.charAt(i), elems.substring(0, i) + elems.substring(i + 1, elems.length()), consumer);
	}

	@Test
	public void test() {
		Permutations perm = new Permutations();
		Assert.assertEquals(Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA"), perm.permutate("ABC"));
		Assert.assertEquals(Arrays.asList("ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS",
				"GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"), perm.permutate("ABSG"));
		Assert.assertEquals(40320/* n! */, perm.permutate("12345678").size());
	}
}
