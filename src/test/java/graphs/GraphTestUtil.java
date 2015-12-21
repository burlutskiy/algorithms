/**
 * 
 */
package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author alexey
 *
 */
public class GraphTestUtil {

	public static IndexedGraph readGraphFromFile(String filename) throws Exception{
		FileReader fr = new FileReader(new File(filename));
		BufferedReader br = new BufferedReader(fr);
		String line;
		int vertices = Integer.parseInt(br.readLine());
		IndexedGraph graph = new IndexedGraph(vertices);
		while ((line = br.readLine()) != null) {
			line = line.trim();
			String[] split = line.split(" ");
			graph.addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
	    }
		br.close();
		return graph;
	}

	public static IndexedDigraph readDigraphFromFile(String filename) throws Exception{
		FileReader fr = new FileReader(new File(filename));
		BufferedReader br = new BufferedReader(fr);
		String line;
		int vertices = Integer.parseInt(br.readLine());
		IndexedDigraph graph = new IndexedDigraph(vertices);
		while ((line = br.readLine()) != null) {
			line = line.trim();
			String[] split = line.split(" ");
			graph.addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		}
		br.close();
		return graph;
	}

}
