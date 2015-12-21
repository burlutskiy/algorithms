package graphs;

import org.junit.Before;
import org.junit.Test;

/**
 * @author alexey
 *
 */
public class IndexedGraphTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() throws Exception {
		IndexedGraph graph = GraphTestUtil.readGraphFromFile("src/test/java/graphs/vertices1.txt");
		System.out.println(graph);
	}

	@Test
	public void testDFSPaths() throws Exception {
		IndexedGraph graph = GraphTestUtil.readGraphFromFile("src/test/java/graphs/vertices1.txt");
		Paths<Integer> pathsFrom = graph.pathsFrom(0);
		System.out.println(pathsFrom);
	}

}
