<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node COLOR="#ff0000" CREATED="1383141908886" HGAP="30" ID="ID_841643229" LINK="algorithms.mm" MODIFIED="1454969672691" STYLE="bubble" TEXT="Sorting Algorithms" VSHIFT="14">
<node COLOR="#338800" CREATED="1383141978529" ID="ID_1564714775" MODIFIED="1456927161151" POSITION="right" TEXT="QuickSort">
<font NAME="SansSerif" SIZE="12"/>
<node COLOR="#338800" CREATED="1455652157314" ID="ID_160524231" MODIFIED="1455652179738" TEXT="2-way Randomized QuickSort">
<node CREATED="1454862301909" ID="ID_1711380197" MODIFIED="1454862602187" TEXT="1.39NlnN compares and 1/3NlnN exchanges"/>
<node CREATED="1455202232929" ID="ID_1583465517" MODIFIED="1455202238261" TEXT="Basic plan">
<node CREATED="1455202239049" ID="ID_324275114" MODIFIED="1455202241949" TEXT="Shuffle"/>
<node CREATED="1455202242384" ID="ID_582827045" MODIFIED="1455202244421" TEXT="Partition">
<node CREATED="1455202326572" ID="ID_11535907" MODIFIED="1455202577810">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Phase I
    </p>
  </body>
</html></richcontent>
<node CREATED="1455290165924" ID="ID_160826033" MODIFIED="1455290204828" TEXT="pick an element lo = pivot"/>
<node CREATED="1455202585333" ID="ID_1436462834" MODIFIED="1455202598070" TEXT="repeat until i crosses j "/>
<node CREATED="1455202598070" ID="ID_201393815" MODIFIED="1455202854322" TEXT="scan i from left to right so long as a[i] &lt; a[lo] "/>
<node CREATED="1455202603670" ID="ID_490813238" MODIFIED="1455202617801">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      scan j from right to left so long as a[j] &gt; a[lo]
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1455202617802" ID="ID_993583734" MODIFIED="1455202617806">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      exchage a[i] with a[j]
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1455202577815" ID="ID_100078503" MODIFIED="1455202577819">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Phase II
    </p>
  </body>
</html></richcontent>
<node CREATED="1455202628098" HGAP="19" ID="ID_1261721131" MODIFIED="1455202640732" TEXT="exchange a[lo] with a[j]" VSHIFT="5"/>
</node>
</node>
<node CREATED="1455202245872" ID="ID_608803591" MODIFIED="1455202247133" TEXT="Sort"/>
</node>
<node CREATED="1454706400576" HGAP="21" ID="ID_322402936" MODIFIED="1454706696752" TEXT="" VSHIFT="2">
<icon BUILTIN="hourglass"/>
<node CREATED="1449240504883" HGAP="15" ID="ID_808415201" MODIFIED="1455286209208" VSHIFT="2">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <table class="infobox" style="font-size: 12.32px; border-spacing: 3px; color: black; margin-top: 0; margin-right: 0px; margin-bottom: 0; margin-left: 0; padding-top: 0; padding-right: 0; padding-bottom: 0; padding-left: 0; clear: right; line-height: 1.5em; font-family: sans-serif; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; word-spacing: 0px; background-color: rgb(249, 249, 249)">
      <tr>
        <td style="vertical-align: top; text-align: left">
          
        </td>
        <td style="vertical-align: top; text-align: left">
          <font size="2">Average </font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font size="2">Worst case </font>
        </td>
      </tr>
      <tr>
        <th style="vertical-align: top; text-align: left">
          <font size="2">Space </font>
        </th>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(1)</font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(1)</font>
        </td>
      </tr>
      <tr>
        <th style="vertical-align: top; text-align: left">
          <font size="2">Sort </font>
        </th>
        <td style="vertical-align: top; text-align: left">
          <font size="2">O(NlgN) </font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(NlgN)</font>
        </td>
      </tr>
    </table>
  </body>
</html></richcontent>
</node>
<node CREATED="1455286214023" ID="ID_859490319" MODIFIED="1455286220171" TEXT="Worst Case">
<node CREATED="1455286224375" ID="ID_383655063" MODIFIED="1455286231387" TEXT="Number of compares is quadratic"/>
<node CREATED="1455286234214" ID="ID_1265993683" MODIFIED="1455286247474" TEXT="Cn ~ 1/2N^2"/>
</node>
<node CREATED="1455286257573" ID="ID_466327179" MODIFIED="1455286260387" TEXT="Average Case">
<node CREATED="1455286264508" ID="ID_1985958050" MODIFIED="1455286271625" TEXT="Cn ~ 1.39NlgN"/>
<node CREATED="1455286274044" ID="ID_971678765" MODIFIED="1455286287184" TEXT="39% more compares then merge sort"/>
<node CREATED="1455286291571" ID="ID_726383930" MODIFIED="1455286309782" TEXT="But faster then MergeSort in practice because of less data movement"/>
</node>
<node CREATED="1455651050515" ID="ID_1203390239" MODIFIED="1455651054672" TEXT="Best Case">
<node CREATED="1455651055378" ID="ID_671004467" MODIFIED="1455651087479" TEXT="In the best case, the number of compares to 3-way quicksort an array of N keys (not necessarily distinct) is ~ N"/>
<node CREATED="1455656544767" ID="ID_127316960" MODIFIED="1455656545460" TEXT="In the best case, the number of compares to quicksort an array of N distinct keys is ~ N lg N."/>
<node CREATED="1455659162923" ID="ID_417745982" MODIFIED="1455659163718" TEXT="The number of compares to 3-way quicksort an array of N equal keys is ~ N."/>
<node CREATED="1455659183296" ID="ID_1016673659" MODIFIED="1455659183869" TEXT="The number of partitioning steps to 3-way quicksort an array of N items is no more than the number of distinct keys."/>
</node>
<node CREATED="1455661360301" ID="ID_1471328993" MODIFIED="1455661363657" TEXT="Other facts">
<node CREATED="1455661364556" ID="ID_483838278" MODIFIED="1455661365313" TEXT="The number of compares is ~ N lg N. The 2-way partitioning algorithm stops the scan on equal keys, so each passioning step divides the array in half."/>
</node>
</node>
</node>
<node CREATED="1455652180770" ID="ID_928335345" MODIFIED="1455652193285" TEXT="3-way QuickSort">
<node CREATED="1455652463040" ID="ID_947763944" MODIFIED="1455652482436" TEXT="Let v = a[lo]"/>
<node CREATED="1455652361630" ID="ID_94603230" MODIFIED="1455652425327" TEXT="Scan i from left to right">
<node CREATED="1455652370487" ID="ID_777858926" MODIFIED="1455652383298" TEXT="a[i] &lt; v ">
<node CREATED="1455652384022" ID="ID_1537699433" MODIFIED="1455652402001" TEXT="exchange a[lt] with a[i]"/>
<node CREATED="1455652402853" ID="ID_131384050" MODIFIED="1455652410688" TEXT="increment both lt and i"/>
</node>
<node CREATED="1455652412731" ID="ID_255360953" MODIFIED="1455652525488" TEXT="a[i] &gt; v">
<node CREATED="1455652426915" ID="ID_1241554043" MODIFIED="1455652447646" TEXT="exchange a[gt] with a[i]"/>
<node CREATED="1455652448201" ID="ID_1554877852" MODIFIED="1455652786995" TEXT="decrement gt"/>
</node>
<node CREATED="1455652526837" ID="ID_436994701" MODIFIED="1455652530609" TEXT="a[i] == v">
<node CREATED="1455652532086" HGAP="21" ID="ID_224500829" MODIFIED="1455652537919" TEXT="increment i" VSHIFT="3"/>
</node>
</node>
<node CREATED="1455652351769" ID="ID_1087327921" MODIFIED="1455652502034" TEXT="Maintain Invariant">
<node CREATED="1455652503342" ID="ID_1986838573" MODIFIED="1455652517586" TEXT=" &lt; v ; =v ; &gt; v"/>
</node>
<node CREATED="1455661331479" ID="ID_1431651183" MODIFIED="1455661385638" TEXT="Facts">
<node CREATED="1455661385627" ID="ID_1831006874" MODIFIED="1455661387415" TEXT="3-way quicksort makes a linear number of compares in cases where the standard version of quicksort makes a linearithmic number of compares ,e.g., N equal keys."/>
</node>
</node>
<node CREATED="1455822094704" ID="ID_121464316" MODIFIED="1455822101917" TEXT="UNSTABLE"/>
</node>
<node COLOR="#ff0000" CREATED="1383141981042" ID="ID_794687715" MODIFIED="1454969831979" POSITION="right" TEXT="Radix" VSHIFT="14">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1452700381919" ID="ID_689136246" MODIFIED="1454514416350" TEXT="Key-Indexed Counting"/>
<node CREATED="1452700392736" MODIFIED="1454514416350" TEXT="LSD Sort"/>
<node CREATED="1452700397279" MODIFIED="1454514416350" TEXT="MSD Sort"/>
<node CREATED="1452700400647" MODIFIED="1454514416350" TEXT="3-way Radix Quick Sort"/>
</node>
<node COLOR="#ff0000" CREATED="1383141983304" MODIFIED="1454514416350" POSITION="right" TEXT="Bucket">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142001421" HGAP="22" ID="ID_682904616" MODIFIED="1455822264329" POSITION="right" TEXT="HeapSort" VSHIFT="6">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1455821650825" ID="ID_131459045" MODIFIED="1455822264329" TEXT="Heap construction uses &#x2264; 2 N compares and exchanges.  "/>
<node CREATED="1455821693922" ID="ID_753824084" MODIFIED="1455822264329" TEXT="Heapsort uses &#x2264; 2 N lg N compares and exchanges."/>
<node CREATED="1455821817690" ID="ID_1123115631" MODIFIED="1455822264329" TEXT="Significance">
<node CREATED="1455821826692" ID="ID_1594210798" MODIFIED="1455822264329" TEXT=" In-place sorting algorithm with N log N worst-case. "/>
<node CREATED="1455821834964" ID="ID_756209873" MODIFIED="1455822264329">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Mergesort: no, linear extra space.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1455821862268" ID="ID_884255899" MODIFIED="1455822264330">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Quicksort: no, quadratic time in worst case.
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1455821935378" ID="ID_1767795429" MODIFIED="1455822264330" TEXT="Bottom Line">
<node CREATED="1455821899644" ID="ID_1837103752" MODIFIED="1455822264330" TEXT="Heapsort is optimal for both time and space, but: Inner loop longer than quicksort&#x2019;s. "/>
<node CREATED="1455821911142" ID="ID_1673242132" MODIFIED="1455822264330" TEXT="Makes poor use of cache memory. "/>
<node CREATED="1455821907785" ID="ID_1689590958" MODIFIED="1455822264330" TEXT="Not stable."/>
</node>
<node CREATED="1455822082065" ID="ID_416883519" MODIFIED="1455822264330" TEXT="UNSTABLE"/>
</node>
<node COLOR="#ff0000" CREATED="1383142003575" HGAP="23" ID="ID_398273523" MODIFIED="1455821084707" POSITION="right" TEXT="Intro" VSHIFT="7">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142007101" HGAP="22" ID="ID_1088219627" MODIFIED="1455824546198" POSITION="right" TEXT="Odd-even" VSHIFT="6">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142012719" HGAP="21" ID="ID_1330112177" MODIFIED="1455824545649" POSITION="right" TEXT="Cycle" VSHIFT="4">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142015965" HGAP="22" ID="ID_344271449" MODIFIED="1455824544998" POSITION="right" TEXT="Smoothsort" VSHIFT="6">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142022472" HGAP="23" ID="ID_1533322279" MODIFIED="1455824542670" POSITION="right" TEXT="Timsort" VSHIFT="9">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#338800" CREATED="1383141925426" ID="ID_752388606" MODIFIED="1454514416351" POSITION="left" TEXT="Bubble"/>
<node COLOR="#338800" CREATED="1383141931107" ID="ID_1303706530" MODIFIED="1454514416351" POSITION="left" TEXT="Comb"/>
<node COLOR="#338800" CREATED="1383141945307" ID="ID_1903593955" MODIFIED="1454514416351" POSITION="left" TEXT="Insertion">
<node CREATED="1454623461718" ID="ID_288995958" MODIFIED="1454623487817" TEXT="In Iteration i, swap a[i] with each larger entry to its left."/>
<node CREATED="1454623949276" ID="ID_522027166" MODIFIED="1454624031495" TEXT="It has O(n) for partially sorted arrays, where partialy sorted array has number of inversions &lt;= cN"/>
<node CREATED="1454862009900" ID="ID_46675934" MODIFIED="1454862016562" TEXT="random array">
<node CREATED="1454862026803" ID="ID_645117996" MODIFIED="1454862047250" TEXT="1/4N^2 exchanges and compares"/>
</node>
<node CREATED="1454862016851" ID="ID_1939689957" MODIFIED="1454862021162" TEXT="reverse array">
<node CREATED="1454862051248" ID="ID_953217971" MODIFIED="1454862061298" TEXT="1/2N^2 exchanges and compares"/>
</node>
<node CREATED="1454862022051" ID="ID_1989754261" MODIFIED="1454862024666" TEXT="sorted array">
<node CREATED="1454862066845" ID="ID_735769848" MODIFIED="1454862069195" TEXT="N compares"/>
</node>
<node CREATED="1454862080531" ID="ID_645197312" MODIFIED="1454862097207" TEXT="Number of exchanges = number of inversions"/>
<node CREATED="1454862101943" ID="ID_914770773" MODIFIED="1454862121075" TEXT="Number of compares = Number of inversions + N - 1"/>
<node CREATED="1455132118281" ID="ID_1997697343" MODIFIED="1455132125570">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      for (int i = lo; i &lt; hi - lo + 1; i++)
    </p>
    <p>
      for (int j = i; j &gt; 0 &amp;&amp; a[j] &lt; a[j - 1]; j--)
    </p>
    <p>
      static_swap(j - 1, j, a);
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node COLOR="#338800" CREATED="1383141948272" ID="ID_1471186986" MODIFIED="1454514416351" POSITION="left" TEXT="Coctail"/>
<node COLOR="#338800" CREATED="1383141975362" ID="ID_1864298248" MODIFIED="1454514416351" POSITION="left" TEXT="Selection">
<node CREATED="1454623001656" ID="ID_985165847" MODIFIED="1454623026292" TEXT="In iteration i, find index min of smallest remaining entry"/>
<node CREATED="1454623026943" ID="ID_45870288" MODIFIED="1454623045308" TEXT="swap a[i] and a[min]"/>
<node CREATED="1454969631363" ID="ID_1084023030" MODIFIED="1454969633483" TEXT="N(N-1)/2 compares "/>
</node>
<node COLOR="#338800" CREATED="1383142087715" ID="ID_1158187149" MODIFIED="1455824460537" POSITION="left" TEXT="Shellsort">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1454700723933" ID="ID_1002169000" MODIFIED="1454706696751">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Move entries more then one position at a time by h-sorting the array,<br />an h-sorted array is h interleaved sorted subsequences.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1454701227600" HGAP="21" ID="ID_1567007134" MODIFIED="1454969517197" TEXT="h-sorting" VSHIFT="8">
<node CREATED="1454701231247" HGAP="15" ID="ID_1600013244" MODIFIED="1454706696752" TEXT="Knuth 3x+1" VSHIFT="2">
<node CREATED="1454862144937" ID="ID_983814256" MODIFIED="1454862151474" TEXT="sorted">
<node CREATED="1454862154347" ID="ID_987271068" MODIFIED="1454862161218" TEXT="Nlog3N compares"/>
</node>
<node CREATED="1454862165707" ID="ID_1816140661" MODIFIED="1454862168418" TEXT="revers">
<node CREATED="1454862171352" ID="ID_1720191651" MODIFIED="1454862179769" TEXT="N^(3/2)"/>
</node>
<node CREATED="1454706400576" HGAP="21" ID="ID_1037717617" MODIFIED="1454706696752" TEXT="" VSHIFT="2">
<icon BUILTIN="hourglass"/>
<node CREATED="1449240504883" HGAP="15" ID="ID_147837760" MODIFIED="1454706696752" VSHIFT="2">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <table class="infobox" style="font-size: 12.32px; border-spacing: 3px; color: black; margin-top: 0; margin-right: 0px; margin-bottom: 0; margin-left: 0; padding-top: 0; padding-right: 0; padding-bottom: 0; padding-left: 0; clear: right; line-height: 1.5em; font-family: sans-serif; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; word-spacing: 0px; background-color: rgb(249, 249, 249)">
      <tr>
        <td style="vertical-align: top; text-align: left">
          
        </td>
        <td style="vertical-align: top; text-align: left">
          <font size="2">Average </font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font size="2">Worst case </font>
        </td>
      </tr>
      <tr>
        <th style="vertical-align: top; text-align: left">
          <font size="2">Space </font>
        </th>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(1)</font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(1)</font>
        </td>
      </tr>
      <tr>
        <th style="vertical-align: top; text-align: left">
          <font size="2">Sort </font>
        </th>
        <td style="vertical-align: top; text-align: left">
          <font size="2">??? </font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(N^3/2)</font>
        </td>
      </tr>
    </table>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1455132041135" HGAP="21" ID="ID_177382510" MODIFIED="1455201938332" VSHIFT="4">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: left">
      while (h &lt; n / 3)
    </p>
    <p style="text-align: left">
      h = h * 3 + 1;
    </p>
    <p style="text-align: left">
      for (; h &gt; 0; h /= 3)
    </p>
    <p style="text-align: left">
      for (int i = h; i &lt; n; i++)
    </p>
    <p style="text-align: left">
      for (int j = i; j &gt;= h; j = decrease(j,h))
    </p>
    <p style="text-align: left">
      if (less(j, j - h, a))
    </p>
    <p style="text-align: left">
      swap(j, j - h, a);
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1454706648082" ID="ID_512183384" MODIFIED="1454706696752" TEXT="Asymptotic growth rate?"/>
<node CREATED="1454706665609" ID="ID_252395082" MODIFIED="1454706696752" TEXT="Best sequence of increments?"/>
<node CREATED="1454706678464" ID="ID_440143848" MODIFIED="1454706696752" TEXT="Average-case performance?"/>
</node>
<node COLOR="#338800" CREATED="1454861947789" HGAP="22" ID="ID_834591398" MODIFIED="1455822254930" POSITION="right" TEXT="MergeSort" VSHIFT="21">
<node COLOR="#338800" CREATED="1454862268694" HGAP="17" ID="ID_822957419" MODIFIED="1455202025421" TEXT="BottomUp" VSHIFT="14"/>
<node COLOR="#338800" CREATED="1455201948513" HGAP="25" ID="ID_511033344" MODIFIED="1455824686054" TEXT="TopDown" VSHIFT="11">
<node CREATED="1455202048819" ID="ID_1376389779" MODIFIED="1455202093701">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      There is a cutoff for short subarrays<br />
    </p>
    <p>
      if(hi &lt;= lo + CUTOFF - 1) {InsertionSort.sort(aux, lo, hi); return;}
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1454706400576" HGAP="28" ID="ID_649337676" MODIFIED="1455824684966" TEXT="" VSHIFT="12">
<icon BUILTIN="hourglass"/>
<node CREATED="1449240504883" HGAP="15" ID="ID_787055199" MODIFIED="1455201995826" VSHIFT="2">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <table class="infobox" style="font-size: 12.32px; border-spacing: 3px; color: black; margin-top: 0; margin-right: 0px; margin-bottom: 0; margin-left: 0; padding-top: 0; padding-right: 0; padding-bottom: 0; padding-left: 0; clear: right; line-height: 1.5em; font-family: sans-serif; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; word-spacing: 0px; background-color: rgb(249, 249, 249)">
      <tr>
        <td style="vertical-align: top; text-align: left">
          
        </td>
        <td style="vertical-align: top; text-align: left">
          <font size="2">Average </font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font size="2">Worst case </font>
        </td>
      </tr>
      <tr>
        <th style="vertical-align: top; text-align: left">
          <font size="2">Space </font>
        </th>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(N)</font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(N)</font>
        </td>
      </tr>
      <tr>
        <th style="vertical-align: top; text-align: left">
          <font size="2">Sort </font>
        </th>
        <td style="vertical-align: top; text-align: left">
          <font size="2">O(NlogN) </font>
        </td>
        <td style="vertical-align: top; text-align: left">
          <font face="Nimbus Roman No9 L, Times New Roman, Times, serif" size="2">O(NlogN)</font>
        </td>
      </tr>
    </table>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1455202003790" ID="ID_349356241" MODIFIED="1455202139620" TEXT="Common Properties">
<node CREATED="1455822070802" ID="ID_911533782" MODIFIED="1455822075645" TEXT="STABLE"/>
<node CREATED="1454862189873" ID="ID_1136494626" MODIFIED="1455057971733" TEXT="NlogN compares"/>
<node CREATED="1454862199049" ID="ID_1993930090" MODIFIED="1455057971366" TEXT="6NlogN array access"/>
<node CREATED="1454862212407" ID="ID_1184616565" MODIFIED="1454862221516" TEXT="inplace ? - not discovered"/>
<node CREATED="1454862244280" ID="ID_662736012" MODIFIED="1454862246425" TEXT="best case">
<node CREATED="1454862247194" ID="ID_1414471506" MODIFIED="1454862258090" TEXT="1/2NlogN"/>
</node>
<node CREATED="1454862280015" ID="ID_1741409750" MODIFIED="1454862286000" TEXT="logN passes"/>
<node CREATED="1455202111616" ID="ID_487251991" MODIFIED="1455202122291" TEXT="common merge method impl">
<node CREATED="1455202122975" ID="ID_1155433083" MODIFIED="1455202132077" TEXT="&#x9;protected void merge(int a[], int aux[], int lo, int mid, int hi) {&#xa;&#x9;&#x9;int i = lo, j = mid + 1, k = lo;&#xa;&#x9;&#x9;while (i &lt;= mid &amp;&amp; j &lt;= hi) {&#xa;&#x9;&#x9;&#x9;if(less(i, j, a))&#xa;&#x9;&#x9;&#x9;&#x9;aux[k] = a[i++];&#xa;&#x9;&#x9;&#x9;else&#xa;&#x9;&#x9;&#x9;&#x9;aux[k] = a[j++];&#xa;&#x9;&#x9;&#x9;k = increase(k);&#xa;&#x9;&#x9;}&#xa;&#x9;&#x9;if(i &lt;= mid)&#xa;&#x9;&#x9;&#x9;System.arraycopy(a, i, aux, k, mid - i + 1);&#xa;&#x9;&#x9;if(j &lt;= hi)&#xa;&#x9;&#x9;&#x9;System.arraycopy(a, j, aux, k, hi - j + 1);&#xa;&#x9;}&#xa;"/>
</node>
</node>
</node>
<node CREATED="1455822150215" ID="ID_1666135818" MODIFIED="1455822209961" POSITION="left" TEXT="Reference">
<node CREATED="1455822206787" MODIFIED="1455822206787">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="Sorting Algorithms_6648747486860319506.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
</node>
</map>
