package graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author alexey
 *
 */
public class PrimsMSTTest {


	@Test
	public void test() throws Exception {
		testEWG("tinyEWG.txt");
	}
	@Test
	public void test1000EWG() throws Exception {
		testEWG("1000EWG.txt");
	}
	
	@Test
	public void test10000EWG() throws Exception {
		testEWG("10000EWG.txt");
	}
	
	@Test
	public void testLargeEWG() throws Exception {
		testEWG("largeEWG.txt");
	}

	private void testEWG(String graphFile) throws Exception {
		IndexedWeightedGraph g = GraphTestUtil.readWeightedGraphFromFile("src/test/java/graphs/"+ graphFile);
		LazyPrimMST<Integer> mst = new LazyPrimMST<>(g);
		System.out.println(mst.edges().size());
		Assert.assertEquals(g.vertices - 1, mst.edges().size());
	}
	
}
