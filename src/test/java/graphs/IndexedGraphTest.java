package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
		IndexedGraph graph = readFromFile("src/test/java/graphs/vertices1.txt");
		System.out.println(graph);
	}

	@Test
	public void testDFSPaths() throws Exception {
		IndexedGraph graph = readFromFile("src/test/java/graphs/vertices1.txt");
		Paths<Integer> pathsFrom = graph.pathsFrom(0);
		System.out.println(pathsFrom);
	}

	
	public static IndexedGraph readFromFile(String filename) throws Exception{
		FileReader fr = new FileReader(new File(filename));
		BufferedReader br = new BufferedReader(fr);
		String line;
		int vertices = Integer.parseInt(br.readLine());
		IndexedGraph graph = new IndexedGraph(vertices);
		while ((line = br.readLine()) != null) {
			String[] split = line.split(" ");
			graph.addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
	    }
		br.close();
		return graph;
	}

}
