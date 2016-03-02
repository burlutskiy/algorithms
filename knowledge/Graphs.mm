<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node COLOR="#990000" CREATED="1366207582853" HGAP="123" ID="ID_429857744" LINK="algorithms.mm" MODIFIED="1454514249557" STYLE="bubble" TEXT="Graphs" VSHIFT="20">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1451942989317" HGAP="16" ID="ID_691211503" MODIFIED="1454514269671" POSITION="left" VSHIFT="36">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      Weighted<br />Graphs
    </p>
  </body>
</html></richcontent>
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1451942999772" MODIFIED="1454514249587" TEXT="Shortest Paths">
<node COLOR="#ff0000" CREATED="1450149165362" ID="ID_1310461840" MODIFIED="1454514249587" TEXT="A* Search Algorithm">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1450149237847" ID="ID_757212372" MODIFIED="1454514249587" TEXT="Floyd&#x2013;Warshall Algorithm ">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1450149258232" ID="ID_265954261" MODIFIED="1454514249587" TEXT="Johnson&apos;s Algorithm ">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1450149278173" ID="ID_443653580" MODIFIED="1456179314254" TEXT="Viterbi Algorithm ">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1451944024561" MODIFIED="1454514249587">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      General Shortes-Paths Algorithm
    </p>
    <p style="text-align: center">
      (to compute SPT from s)
    </p>
  </body>
</html></richcontent>
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1451943009819" MODIFIED="1454514249589" TEXT="Idea is to relax any edge"/>
<node CREATED="1450149112439" ID="ID_1019210105" MODIFIED="1454514249589">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Dijkstra's Algorithm
    </p>
    <p>
      (nonnegative weights)
    </p>
  </body>
</html></richcontent>
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
<node COLOR="#338800" CREATED="1450149355933" ID="ID_596691636" MODIFIED="1454514249590" TEXT="O(V^2) 1959"/>
<node CREATED="1450149553569" ID="ID_48922720" MODIFIED="1454514249590" TEXT="Dijkstra&apos;s algorithm with Fibonacci heap">
<node CREATED="1450149565932" MODIFIED="1454514249590">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(E + V log V)&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Fredman &amp; Tarjan 1984, Fredman &amp; Tarjan 1987<br />which is not good as far as V &gt;&gt; E
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node COLOR="#ff0000" CREATED="1452019257769" ID="ID_803134291" MODIFIED="1454514249594" TEXT="Based On Binary Heap">
<node CREATED="1452019271929" MODIFIED="1454514249594" TEXT="O(ElogV)"/>
</node>
<node CREATED="1451944162362" ID="ID_127037109" MODIFIED="1454514249594">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      Topological Sort Algorithm
    </p>
    <p style="text-align: center">
      (no directed cycles)
    </p>
  </body>
</html></richcontent>
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1452021811544" MODIFIED="1454514249595">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      Dijkstra's Algorithm<br />for DAG
    </p>
  </body>
</html></richcontent>
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1452021636345" HGAP="19" MODIFIED="1454514249596" TEXT="Single-Source Shortest Paths DAG Algorithm" VSHIFT="15">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
</node>
</node>
<node CREATED="1451943020123" MODIFIED="1454514249597" TEXT="Shortest Path Tree( SPT)">
<node CREATED="1452023267931" ID="ID_339052047" MODIFIED="1454514249597" TEXT="Proposition: A SPT exists iff no negative cycles"/>
</node>
<node CREATED="1450149139666" MODIFIED="1454514249597">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Bellman-Ford Algorithm
    </p>
    <p>
      (no negative cycles)
    </p>
  </body>
</html></richcontent>
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1452019158191" ID="ID_1462946293" MODIFIED="1454514249598" TEXT="Initialize distTo[s] to 0 and all other distTo[] values to infinity. &#xa;Then, considering the digraph&apos;s edges in any order, and relax all edges. &#xa;Make V such passes.for (int pass = 0; pass &lt; G.V(); pass++)&#xa;   for (int v = 0; v &lt; G.V(); v++)&#xa;      for (DirectedEdge e : G.adj(v))&#xa;          relax(e);"/>
<node CREATED="1452019372796" HGAP="23" MODIFIED="1454514249600" TEXT="Queue-based Bellman-Ford Algorithm" VSHIFT="14">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
</node>
</node>
<node CREATED="1366207616804" HGAP="60" MODIFIED="1454514249600" TEXT="Find Minimum Spanning Tree (MST)" VSHIFT="47">
<node CREATED="1449637202283" MODIFIED="1454514249600" TEXT="What is the best way to connect all of the vertices?"/>
<node CREATED="1450728783159" MODIFIED="1454514249600" TEXT="A spanning tree of G is a subgraph T that is both a tree (connected and acyclic) and spanning (includesall of the vertices)" VSHIFT="23"/>
<node CREATED="1450728874049" MODIFIED="1454514249601" TEXT="Algorithms" VSHIFT="5">
<node CREATED="1450728878432" MODIFIED="1454514249601" TEXT="Brute Forse"/>
</node>
<node CREATED="1450729774045" HGAP="21" MODIFIED="1454514249601" TEXT="Greedy MST Algorithms" VSHIFT="12">
<node COLOR="#338800" CREATED="1450729843610" MODIFIED="1454514249602" TEXT="Kruskal&apos;s Algorithm">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1451918357872" MODIFIED="1454514249602" TEXT="Kruskal&apos;s algorithm processes the edges in order of their weight values (smallest to largest,  taking for the MST (coloring black) each edge that does not form a cycle with edges previously added, stopping after adding V-1 edges. The black edges form a forest of trees that evolves gradually into a single tree, the MST."/>
</node>
<node CREATED="1450729855033" HGAP="21" MODIFIED="1454514249603" TEXT="Prim&apos;s Algorithm" VSHIFT="7">
<node CREATED="1451918761009" MODIFIED="1454514249603" TEXT="Jarnik 1930, Dijkstra 1957, Prim 1959"/>
<node COLOR="#338800" CREATED="1451940088979" HGAP="24" MODIFIED="1454514249603" TEXT="Lazy" VSHIFT="2"/>
<node COLOR="#ff0000" CREATED="1451940092466" HGAP="22" MODIFIED="1454514249603" TEXT="Eager" VSHIFT="3">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1451941162349" MODIFIED="1454514249603" TEXT="return to this algorithm after studying heaps"/>
</node>
</node>
<node COLOR="#ff0000" CREATED="1450729868529" HGAP="16" MODIFIED="1454514249603" TEXT="Bruvkas&apos;s Algorithm" VSHIFT="2"/>
</node>
</node>
<node COLOR="#ff0000" CREATED="1451940428975" HGAP="68" MODIFIED="1454514249604" TEXT="Euclidean MST" VSHIFT="-47"/>
<node COLOR="#ff0000" CREATED="1451940537849" HGAP="63" MODIFIED="1454514249604" TEXT="Clustering" VSHIFT="-49">
<node CREATED="1451940547089" MODIFIED="1454514249604" TEXT="k-clustering"/>
<node CREATED="1451940582422" MODIFIED="1454514249604" TEXT="single link clustering"/>
</node>
<node COLOR="#ff0000" CREATED="1452715775849" HGAP="44" MODIFIED="1454514249604" TEXT="Max Flow, Min Cut">
<node CREATED="1452715999516" MODIFIED="1454514249604" TEXT="Minimum Cut">
<node CREATED="1452716004412" MODIFIED="1454514249604" TEXT="Stoer-Wagner Algorithm">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
<node CREATED="1452716020706" MODIFIED="1454514249604" TEXT="Maximum Flow">
<node CREATED="1452715800194" MODIFIED="1454514249604" TEXT="Ford Folkerson Algorithm" VSHIFT="4">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1452716190091" MODIFIED="1454514249604" TEXT="Edmonds-Karp Algorithm">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1452716203665" MODIFIED="1454514249605" TEXT="A specialization of Ford&#x2013;Fulkerson, finding augmenting paths with breadth-first search."/>
</node>
</node>
</node>
</node>
<node CREATED="1449693256662" HGAP="27" MODIFIED="1454514249605" POSITION="left" TEXT="Internal Representation" VSHIFT="24">
<node CREATED="1449693268293" MODIFIED="1454514249605" TEXT="Set-Of-Edges graph">
<node CREATED="1449693301923" MODIFIED="1454514249605" TEXT="A list of the edges usually linked list or array."/>
</node>
<node CREATED="1449693329682" MODIFIED="1454514249605" TEXT="Adjacency-matrix graph">
<node CREATED="1449693337064" MODIFIED="1454514249605" TEXT="for each edge v&#x2013;w in graph: adj[v][w] = adj[w][v] = true."/>
</node>
<node CREATED="1449693347439" MODIFIED="1454514249605" TEXT="Adjacency-list graph"/>
</node>
<node CREATED="1449700078094" HGAP="10" ID="ID_1637671453" MODIFIED="1454514260122" POSITION="right">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Directed Graphs
    </p>
    <p>
      &#160;(Unweighted)
    </p>
  </body>
</html></richcontent>
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<node COLOR="#338800" CREATED="1366207628975" HGAP="34" MODIFIED="1454514249561" TEXT="Topological Sort" VSHIFT="2">
<node CREATED="1449762932812" HGAP="32" MODIFIED="1454514249561" TEXT="Precedence Scheduling" VSHIFT="-12">
<node CREATED="1449762950397" MODIFIED="1454514249562" TEXT="Goal. Given a set of the tasks to be completed with precedence constraints, in which order should we schedule the stasks?"/>
</node>
<node COLOR="#338800" CREATED="1449763113868" HGAP="24" MODIFIED="1454514249568" TEXT="Directed Acyclic Graph (DAG)" VSHIFT="3">
<node CREATED="1449763159776" MODIFIED="1454514249568" TEXT="Redraw DAG so all edges point upwards"/>
</node>
<node COLOR="#338800" CREATED="1449764712905" HGAP="25" MODIFIED="1454514249568" TEXT="Proposition: A digraph has a topological order iff no directed cycle" VSHIFT="11"/>
</node>
<node COLOR="#ff0000" CREATED="1449700488358" HGAP="36" MODIFIED="1454514249568" TEXT="Strong Connected Components" VSHIFT="9">
<node CREATED="1449764899881" HGAP="23" MODIFIED="1454514249569" VSHIFT="-8">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Def. Vertices <i>v</i>&#160;and <i>w</i>&#160;are <font color="#fb0808">strongly connected</font>&#160;if there is a directed path from v to w and a directed path from <i>w</i>&#160;to <i>v</i>.
    </p>
  </body>
</html></richcontent>
</node>
<node COLOR="#338800" CREATED="1449765563998" HGAP="34" MODIFIED="1454514249574" TEXT="Two-Pass Kosaraju&#x2013;Sharir Algorithm" VSHIFT="-5">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1449765690476" HGAP="27" MODIFIED="1454514249575" TEXT="One-Pass Cheriyan-Melhorn Algorithm" VSHIFT="-3">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1449766391241" HGAP="31" MODIFIED="1454514249575" TEXT="Tarjan DFS Algorithm" VSHIFT="4">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
<node COLOR="#ff0000" CREATED="1449700505590" HGAP="49" MODIFIED="1454514249575" TEXT="Transitive Closure" VSHIFT="14"/>
<node COLOR="#ff0000" CREATED="1449700532644" HGAP="48" MODIFIED="1454514249575" TEXT="PageRank" VSHIFT="19"/>
<node CREATED="1449693229727" HGAP="52" MODIFIED="1454514249575" VSHIFT="28">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Undirected Graphs
    </p>
    <p>
      (Unweighted)
    </p>
  </body>
</html></richcontent>
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<node COLOR="#338800" CREATED="1366207586962" HGAP="28" MODIFIED="1454514249579" TEXT="Breadth-first search (BFS)" VSHIFT="-11">
<node COLOR="#338800" CREATED="1449637086163" HGAP="39" MODIFIED="1454514249580" TEXT="Path." VSHIFT="-28">
<node CREATED="1449637285900" MODIFIED="1454514249580" TEXT="Is there a path between s and t ?"/>
</node>
<node COLOR="#338800" CREATED="1449637094610" HGAP="41" MODIFIED="1454514249580" TEXT="Shortest path" VSHIFT="7">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1449637274576" MODIFIED="1454514249580" TEXT="What is the shortest path between s and t ?"/>
<node COLOR="#338800" CREATED="1450149188999" MODIFIED="1454514249580" TEXT="Simple BFS">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
</node>
<node COLOR="#338800" CREATED="1366207602242" HGAP="30" MODIFIED="1454514249580" TEXT="Depth-first search (DFS)" VSHIFT="-7">
<node COLOR="#338800" CREATED="1449696839540" MODIFIED="1454514249580" TEXT="Connected Components">
<node COLOR="#338800" CREATED="1449637119808" HGAP="32" MODIFIED="1454514249580" TEXT="Connectivity" VSHIFT="-18">
<font NAME="SansSerif" SIZE="12"/>
<node COLOR="#338800" CREATED="1449637215701" MODIFIED="1454514249580" TEXT="Is there a way to connect all of the vertices?"/>
</node>
</node>
<node COLOR="#338800" CREATED="1449698897170" MODIFIED="1454514249581" TEXT="Bipartite Check">
<node CREATED="1449860433562" HGAP="31" MODIFIED="1454514249581" TEXT="A bipartite graph contains no odd cycles." VSHIFT="9"/>
<node CREATED="1449860602308" MODIFIED="1454514249581">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#160;(Sum of Degrees) E v&#8712;V (G) deg(v) = 2e.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1449860518098" HGAP="23" MODIFIED="1454514249582" VSHIFT="17">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      Bipartite Graphs and Problem Solving
    </p>
    <p style="text-align: center">
      Jimmy Salvatore
    </p>
    <p style="text-align: center">
      University of Chicago
    </p>
    <p style="text-align: center">
      August 8, 2007
    </p>
  </body>
</html></richcontent>
<node CREATED="1449860442868" MODIFIED="1454514249584" TEXT="http://www.math.uchicago.edu/~may/VIGRE/VIGRE2007/REUPapers/FINALAPP/Salvatore.pdf"/>
</node>
</node>
<node COLOR="#338800" CREATED="1449637102771" HGAP="26" MODIFIED="1454514249584" TEXT="Find Cycles">
<node CREATED="1449637253972" HGAP="22" MODIFIED="1454514249584" TEXT="Is there a cycle in the graph?" VSHIFT="5"/>
</node>
<node CREATED="1449637132414" HGAP="31" MODIFIED="1454514249584" TEXT="Planarity" VSHIFT="-4">
<node CREATED="1449637172443" HGAP="23" MODIFIED="1454514249584" TEXT="Can you draw the graph in the plane with no crossing edges?" VSHIFT="7"/>
<node COLOR="#990000" CREATED="1449699918399" MODIFIED="1454514249584" TEXT="Tarjan Planarity Algorithm">
<node CREATED="1449699941342" MODIFIED="1454514249585" TEXT="log(n)"/>
<node CREATED="1449699954085" MODIFIED="1454514249585" TEXT="Discovered in 1970s"/>
<node CREATED="1449760338167" MODIFIED="1454514249585" TEXT="http://192.35.222.224/newweb/~gilbert/cs240a/old/cs240aSpr2011/slides/TarjanDFS.pdf"/>
</node>
</node>
<node CREATED="1449760212249" HGAP="23" MODIFIED="1454514249585" TEXT="DFS Mark-and-Sweep Algorithm" VSHIFT="-9">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1449760248323" MODIFIED="1454514249585" TEXT="McCarthy, 1960"/>
</node>
</node>
<node CREATED="1449637108021" HGAP="43" MODIFIED="1454514249585" TEXT="Euler tour" VSHIFT="46">
<node CREATED="1449637230373" MODIFIED="1454514249585" TEXT="Is there a cycle that uses each edge exactly once?">
<node CREATED="1449699227132" MODIFIED="1454514249585" TEXT="Yes, if all vertices have even degree."/>
</node>
</node>
<node CREATED="1449637114094" HGAP="31" MODIFIED="1454514249585" TEXT="Hamilton tour" VSHIFT="2">
<node CREATED="1449637223989" MODIFIED="1454514249585" TEXT="Is there a cycle that uses each vertex exactly once?"/>
<node CREATED="1449699423044" MODIFIED="1454514249586" TEXT="Usually known as a Traveling sales person problem"/>
<node COLOR="#990000" CREATED="1449699481832" MODIFIED="1454514249586" TEXT="NP-complete">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
<node COLOR="#ff0000" CREATED="1449637126749" HGAP="32" MODIFIED="1454514249586" TEXT="Biconnectivity" VSHIFT="7">
<node CREATED="1449637182884" MODIFIED="1454514249586" TEXT="Is there a vertex whose removal disconnects the graph?"/>
</node>
<node COLOR="#ff0000" CREATED="1449637150966" HGAP="36" MODIFIED="1454514249586" TEXT="Graph isomorphism" VSHIFT="8">
<node CREATED="1449637158045" MODIFIED="1454514249586" TEXT="Do two adjacency lists represent the same graph?"/>
<node CREATED="1449699615768" MODIFIED="1454514249586" TEXT="Are two graphs identical except for vertex names?"/>
<node COLOR="#990000" CREATED="1449699698995" MODIFIED="1454514249586" TEXT="Unclassified">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
<node COLOR="#ff0000" CREATED="1449639067665" HGAP="35" ID="ID_693552109" MODIFIED="1456496455652" TEXT="Maze Exploration" VSHIFT="3">
<node CREATED="1449639081785" MODIFIED="1454514249587" TEXT="Tremaux maze exploration algorithm">
<font ITALIC="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
<node COLOR="#006699" CREATED="1449760855205" HGAP="33" MODIFIED="1454514249587" TEXT="Multi-Source Shortes Paths" VSHIFT="19"/>
</node>
<node CREATED="1449870403550" MODIFIED="1454514249587" TEXT="http://www.personal.kent.edu/~rmuhamma/GraphTheory/MyGraphTheory/defEx.htm" VSHIFT="17"/>
</node>
</node>
</map>
