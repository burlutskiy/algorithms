<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1453979318069" ID="ID_325280934" LINK="algorithms.mm" MODIFIED="1456496745047" STYLE="bubble">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      Algorithm<br />Analysis
    </p>
  </body>
</html></richcontent>
<node CREATED="1453979338722" MODIFIED="1456496574174" POSITION="right" TEXT="Observe">
<node CREATED="1453979361667" MODIFIED="1456496574174" TEXT="some features of natural world"/>
</node>
<node CREATED="1453979341592" MODIFIED="1456496574175" POSITION="right" TEXT="Hypotisize">
<node CREATED="1453979421327" MODIFIED="1456496574175" TEXT="a model that is consistent with observations"/>
</node>
<node CREATED="1453979349067" MODIFIED="1456496574175" POSITION="right" TEXT="Predict">
<node CREATED="1453979449301" MODIFIED="1456496574175" TEXT="events using the hipothesis"/>
</node>
<node CREATED="1453979353760" MODIFIED="1456496574175" POSITION="right" TEXT="Verify">
<node CREATED="1453979491631" MODIFIED="1456496574176" TEXT="the predictions by making further observations"/>
</node>
<node CREATED="1453979357840" MODIFIED="1456496574176" POSITION="right" TEXT="Validate">
<node CREATED="1453979520468" MODIFIED="1456496574176" TEXT="by repeating until the hypothesis and observations agree"/>
</node>
<node CREATED="1387218360516" HGAP="19" ID="ID_1359430717" MODIFIED="1456496735832" POSITION="left" TEXT="Categories">
<node CREATED="1387218397249" FOLDED="true" HGAP="27" ID="ID_795698864" MODIFIED="1456496733072" TEXT="Simple recursive" VSHIFT="161">
<node CREATED="1387218614697" ID="ID_1375676122" MODIFIED="1387218628899" TEXT="A simple recursive algorithm:&#xa;Solves the base cases directly&#xa;Recurs with a simpler subproblem&#xa;Does some extra work to convert the solution to the simpler subproblem into a solution to the given problem&#xa;I call these &#x201c;simple&#x201d; because several of the other algorithm types are inherently recursive&#xa;"/>
<node CREATED="1387218638165" FOLDED="true" ID="ID_798384599" MODIFIED="1456496642541" TEXT="Examples">
<node CREATED="1387218661399" HGAP="17" ID="ID_738607870" MODIFIED="1387230179237" TEXT="To count the number of elements in a list:&#xa;If the list is empty, return zero; otherwise,&#xa;Step past the first element, and count the remaining elements in the list&#xa;Add one to the result&#xa;To test if a value occurs in a list:&#xa;If the list is empty, return false; otherwise,&#xa;If the first thing in the list is the given value, return true; otherwise&#xa;Step past the first element, and test whether the value occurs in the remainder of the list&#xa;" VSHIFT="13"/>
</node>
</node>
<node CREATED="1387218411186" FOLDED="true" HGAP="28" ID="ID_370923466" MODIFIED="1456496730448" TEXT="Backrtacking">
<node CREATED="1387295986828" ID="ID_1374968363" MODIFIED="1387295987719" TEXT="Backtracking algorithms are based on a depth-first recursive search A backtracking algorithm: Tests to see if a solution has been found, and if so, returns it; otherwise For each choice that can be made at this point, Make that choice Recur If the recursion returns a solution, return it If no choices remain, return failure "/>
<node CREATED="1387296027687" HGAP="31" ID="ID_1292819205" MODIFIED="1447952215055" TEXT="Examples" VSHIFT="9">
<node CREATED="1387296031155" ID="ID_391071252" MODIFIED="1387296042999" TEXT="To color a map with no more than four colors:&#xa;color(Country n)&#xa;If all countries have been colored (n &gt; number of countries) return success; otherwise,&#xa;For each color c of four colors,&#xa;If country n is not adjacent to a country that has been colored c&#xa;Color country n with color c&#xa;recursivly color country n+1&#xa;If successful, return success&#xa;Return failure (if loop exits)&#xa;"/>
<node COLOR="#ff0000" CREATED="1387217907965" ID="ID_1667046434" MODIFIED="1456496667440" TEXT="Solving Sudoku"/>
<node COLOR="#ff0000" CREATED="1387217914683" ID="ID_619656687" MODIFIED="1452700483419" TEXT="Alignment of Queens"/>
</node>
</node>
<node CREATED="1387218418998" FOLDED="true" HGAP="28" ID="ID_701213410" MODIFIED="1456496728127" TEXT="Divide and conquer" VSHIFT="-1">
<node CREATED="1387296087091" ID="ID_931079207" MODIFIED="1387296092013" TEXT="A divide and conquer algorithm consists of two parts:&#xa;Divide the problem into smaller subproblems of the same type, and solve these subproblems recursively&#xa;Combine the solutions to the subproblems into a solution to the original problem&#xa;Traditionally, an algorithm is only called divide and conquer if it contains two or more recursive calls&#xa;"/>
<node CREATED="1387296097091" ID="ID_1299581101" MODIFIED="1387296590438" TEXT="Examples">
<node CREATED="1387296506534" ID="ID_1097987470" MODIFIED="1452715685927" TEXT="Finding Fibonacci Numbers" VSHIFT="16">
<node CREATED="1387296520127" ID="ID_1109544055" MODIFIED="1387296579126" TEXT="To find the nth Fibonacci number:&#xa; - If n is zero or one, return one; otherwise,&#xa; - Compute fibonacci(n-1) and fibonacci(n-2)&#xa; - Return the sum of these two numbers&#xa;This is an expensive algorithm&#xa; - It requires O(fibonacci(n)) time&#xa; - This is equivalent to exponential time, that is, O(2^n)&#xa;"/>
</node>
</node>
</node>
<node CREATED="1387218425498" HGAP="29" ID="ID_71936428" MODIFIED="1456496721344" TEXT="Dynamic programming"/>
<node CREATED="1387218434389" FOLDED="true" HGAP="31" ID="ID_1220564495" MODIFIED="1463144779640" TEXT="Branch and bound" VSHIFT="2">
<node CREATED="1387297238562" ID="ID_1815456204" MODIFIED="1387297271733" TEXT="Branch and bound algorithms are generally used for optimization problems&#xa; - As the algorithm progresses, a tree of subproblems is formed&#xa; - The original problem is considered the &#x201c;root problem&#x201d;&#xa; - A method is used to construct an upper and lower bound for a given problem&#xa; - At each node, apply the bounding methods&#xa;  * If the bounds match, it is deemed a feasible solution to that particular subproblem&#xa;  * If bounds do not match, partition the problem represented by that node, and make the two subproblems into children nodes&#xa; - Continue, using the best known feasible solution to trim sections of the tree, until all nodes have been solved or trimmed"/>
</node>
<node CREATED="1387218446904" HGAP="33" ID="ID_1977393184" MODIFIED="1456496723856" TEXT="Brute force" VSHIFT="-3"/>
<node CREATED="1387218451779" HGAP="32" ID="ID_1313981552" MODIFIED="1456496709432" TEXT="Randomized" VSHIFT="-3"/>
<node CREATED="1366207682581" FOLDED="true" HGAP="31" ID="ID_816501557" MODIFIED="1463144781520" TEXT="Greedy algorithm" VSHIFT="-160">
<node CREATED="1366207698596" ID="ID_709640902" MODIFIED="1366207705752" TEXT="Kruskal"/>
<node CREATED="1366207706518" HGAP="26" ID="ID_933487602" MODIFIED="1456496683414" TEXT="Prim" VSHIFT="3"/>
<node CREATED="1366207708752" HGAP="23" ID="ID_329063163" MODIFIED="1456496685414" TEXT="EDF scheduling" VSHIFT="4"/>
<node CREATED="1387296946444" ID="ID_165711154" MODIFIED="1456496679656" TEXT="Counting money">
<node CREATED="1387296960960" ID="ID_1900069357" MODIFIED="1387297006193" TEXT="Suppose you want to count out a certain amount of money, using the fewest possible bills and coins&#xa;A greedy algorithm would do this would be:At each step, take the largest possible bill or coin that does not overshoot&#xa;- Example: To make $6.39, you can choose:&#xa; * a $5 bill&#xa; * a $1 bill, to make $6&#xa; * a 25&#xa2; coin, to make $6.25&#xa; * A 10&#xa2; coin, to make $6.35&#xa; * four 1&#xa2; coins, to make $6.39&#xa;For US money, the greedy algorithm always gives the optimum solution"/>
<node CREATED="1387297150955" ID="ID_1664164692" MODIFIED="1387297186438" TEXT="A failure of the greedy algorithm&#xa;In some (fictional) monetary system, &#x201c;krons&#x201d; come in 1 kron, 7 kron, and 10 kron coins&#xa;Using a greedy algorithm to count out 15 krons, you would get&#xa; - A 10 kron piece&#xa; - Five 1 kron pieces, for a total of 15 krons&#xa; - This requires six coins&#xa;A better solution would be to use two 7 kron pieces and one 1 kron piece&#xa; - This only requires three coins&#xa;The greedy algorithm results in a solution, but not in an optimal solution&#xa;"/>
</node>
<node CREATED="1387296848962" ID="ID_448185933" MODIFIED="1387296876993" TEXT="An optimization problem is one in which you want to find, not just a solution, but the best solution&#xa;A &#x201c;greedy algorithm&#x201d; sometimes works well for optimization problems&#xa;A greedy algorithm works in phases: At each phase:&#xa; - You take the best you can get right now, without regard for future consequences&#xa; - You hope that by choosing a local optimum at each step, you will end up at a global optimum&#xa;"/>
</node>
</node>
</node>
</map>
