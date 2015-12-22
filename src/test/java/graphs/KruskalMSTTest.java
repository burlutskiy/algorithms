package graphs;

import org.junit.Test;

/**
 * 
 * @author alexey
 *
 */
public class KruskalMSTTest {

	@Test
	public void test() throws Exception {
		IndexedWeightedGraph g = GraphTestUtil.readWeightedGraphFromFile("src/test/java/graphs/tinyEWG.txt");
		KruskalMST<Integer> mst = new KruskalMST<>(g);
		System.out.println(mst.edges().size());
	}
	
	@Test
	public void test10000EWG() throws Exception {
		IndexedWeightedGraph g = GraphTestUtil.readWeightedGraphFromFile("src/test/java/graphs/10000EWG.txt");
		KruskalMST<Integer> mst = new KruskalMST<>(g);
		System.out.println(mst.edges().size());
	}

	@Test
	public void testLargeEWG() throws Exception {
		IndexedWeightedGraph g = GraphTestUtil.readWeightedGraphFromFile("src/test/java/graphs/largeEWG.txt");
		KruskalMST<Integer> mst = new KruskalMST<>(g);
		System.out.println(mst.edges().size());
	}
	
}
