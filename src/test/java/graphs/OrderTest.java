package graphs;

import org.junit.Test;

public class OrderTest {
	@Test
	public void testPreOrderTest() throws Exception {
		IndexedGraph graph = GraphTestUtil.readGraphFromFile("src/test/java/graphs/vertices1.txt");
		GraphVisitor<Integer> visitor = new GraphVisitor<Integer>(){
			@Override
			public void visitNode(Integer object) {
				System.out.print(object+" ");
			}
		};
		new Order<>(graph, visitor, GraphVisitor.Direction.PRE);
		System.out.println();
	}

	@Test
	public void testPostOrderTest() throws Exception {
		IndexedGraph graph = GraphTestUtil.readGraphFromFile("src/test/java/graphs/vertices1.txt");
		GraphVisitor<Integer> visitor = new GraphVisitor<Integer>(){
			@Override
			public void visitNode(Integer object) {
				System.out.print(object+" ");
			}
		};
		new Order<>(graph, visitor, GraphVisitor.Direction.POST);
		System.out.println();
	}

	@Test
	public void testPostOrderDAGTest() throws Exception {
		IndexedDigraph graph = GraphTestUtil.readDigraphFromFile("src/test/java/graphs/tinyDAG.txt");
		GraphVisitor<Integer> visitor = new GraphVisitor<Integer>(){
			@Override
			public void visitNode(Integer object) {
				System.out.print(object+" ");
			}
		};
		new Order<>(graph, visitor, GraphVisitor.Direction.POST);
		System.out.println();
	}

}
