package graphs;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graphs.ObjectGraph;
import graphs.Paths;

public class GraphTest {
	private static final String LAS_VEGAS = "LasVegas";
	private static final String SAN_FRANCISCO = "SanFrancisco";
	private static final String STAMFORD = "Stamford";
	private static final String NEW_YORK = "NewYork";
	private static final String KAZAN = "Kazan";
	private static final String AMSTERDAM = "Amsterdam";
	private static final String PARIS = "Paris";
	private static final String LONDON = "London";
	private static final String MOSCOW = "Moscow";
	private static final String PHILADELPHIA = "Philadelphia";
	private static final String[] cities = new String[] { MOSCOW, LONDON, PARIS, AMSTERDAM, KAZAN, NEW_YORK, STAMFORD, SAN_FRANCISCO, LAS_VEGAS,
			PHILADELPHIA };
	ObjectGraph<String> graph = new ObjectGraph<>(Arrays.asList(cities));

	@Before
	public void setUp() throws Exception {
		graph.addEdge(LAS_VEGAS, NEW_YORK);
		graph.addEdge(MOSCOW, KAZAN);
		graph.addEdge(MOSCOW, NEW_YORK);
		graph.addEdge(SAN_FRANCISCO, NEW_YORK);
		graph.addEdge(PARIS, PHILADELPHIA);
		graph.addEdge(PARIS, LONDON);
		graph.addEdge(LAS_VEGAS, LONDON);
	}

	
	@Test
	public void test() {
		System.out.println(graph);
	}
	
	@Test
	public void testDFSPaths() throws Exception {
		Paths<String> pathsFrom = graph.pathsFrom(MOSCOW);
		Iterable<String> pathTo = pathsFrom.pathTo(PHILADELPHIA);
		Iterable<String> asList = Arrays.asList(new String[]{MOSCOW, NEW_YORK, LAS_VEGAS, LONDON, PARIS, PHILADELPHIA});
		AssertGraph.assertEquals(pathTo, asList);
		System.out.println(pathsFrom);
	}

}
