package trees.simple;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class FindForestDiameter {
	int longestPath = 0;

	int traverse(int k, Map<Integer, Set<Integer>> tree, Set<Integer> visited) {
		visited.add(k);
		Set<Integer> nodes = tree.get(k);
		int result = 0;
		if(nodes != null && !nodes.isEmpty()) {
			List<Integer> list = nodes.stream().filter(i -> !visited.contains(i))
			.map(n -> traverse(n, tree, visited)).collect(Collectors.toList());
			list.sort(Comparator.reverseOrder());
			longestPath = Math.max(longestPath, list.stream().limit(2).mapToInt(i -> i+1).sum());
			result = list.isEmpty() ? 0 : list.get(0) + 1;
			System.out.println();
		}
		visited.remove(k);
		return result;
	}


	int treeDiameter(int n, int[][] tree) {
        if(tree.length == 0)
            return 0;
		Map<Integer, Set<Integer>> map = new LinkedHashMap<>();
		for (int i = 0; i < tree.length; i++) {
			assert tree[i].length == 2;
			Set<Integer> set1 = map.getOrDefault(tree[i][0], new HashSet<>());
			Set<Integer> set2 = map.getOrDefault(tree[i][1], new HashSet<>());
				set1.add(tree[i][1]);
				map.put(tree[i][0], set1);
				set2.add(tree[i][0]);
				map.put(tree[i][1], set2);
		}
		Set<Integer> visited = new HashSet<>();
		traverse(tree[0][0], map, visited);
		return longestPath;
	}

	@Test
	public void test() {
		Assert.assertEquals(7, treeDiameter(10, new int[][] { { 2, 5 }, { 5, 7 }, { 5, 1 }, { 1, 9 }, { 1, 0 }, { 7, 6 }, { 6, 3 }, { 3, 8 }, { 8, 4 } }));
	}

	@Test
	public void test2() {
		Assert.assertEquals(6, treeDiameter(10, new int[][] { { 1, 3 }, { 7, 3 }, { 5, 3 }, { 8, 7 }, { 4, 1 }, { 2, 3 }, { 9, 4 }, { 0, 8 }, { 6, 8 } }));
	}

}
