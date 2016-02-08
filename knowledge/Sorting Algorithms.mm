<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node COLOR="#ff0000" CREATED="1383141908886" HGAP="30" ID="ID_841643229" LINK="algorithms.mm" MODIFIED="1454514416348" STYLE="bubble" TEXT="Sorting Algorithms" VSHIFT="14">
<node COLOR="#ff0000" CREATED="1383141978529" ID="ID_1564714775" MODIFIED="1454514416349" POSITION="right" TEXT="Quick">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383141981042" MODIFIED="1454514416349" POSITION="right" TEXT="Radix">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1452700381919" ID="ID_689136246" MODIFIED="1454514416350" TEXT="Key-Indexed Counting"/>
<node CREATED="1452700392736" MODIFIED="1454514416350" TEXT="LSD Sort"/>
<node CREATED="1452700397279" MODIFIED="1454514416350" TEXT="MSD Sort"/>
<node CREATED="1452700400647" MODIFIED="1454514416350" TEXT="3-way Radix Quick Sort"/>
</node>
<node COLOR="#ff0000" CREATED="1383141983304" MODIFIED="1454514416350" POSITION="right" TEXT="Bucket">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383141998753" MODIFIED="1454514416350" POSITION="right" TEXT="Merge">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1449761032188" MODIFIED="1454514416350" TEXT="Bottom Up"/>
</node>
<node COLOR="#ff0000" CREATED="1383142001421" MODIFIED="1454514416350" POSITION="right" TEXT="Heap">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142003575" MODIFIED="1454514416350" POSITION="right" TEXT="Intro">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142007101" MODIFIED="1454514416350" POSITION="right" TEXT="Odd-even">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142012719" MODIFIED="1454514416351" POSITION="right" TEXT="Cycle">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142015965" MODIFIED="1454514416351" POSITION="right" TEXT="Smoothsort">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#ff0000" CREATED="1383142022472" MODIFIED="1454514416351" POSITION="right" TEXT="Timsort">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#338800" CREATED="1383141925426" ID="ID_752388606" MODIFIED="1454514416351" POSITION="left" TEXT="Bubble"/>
<node COLOR="#338800" CREATED="1383141931107" ID="ID_1303706530" MODIFIED="1454514416351" POSITION="left" TEXT="Comb"/>
<node COLOR="#338800" CREATED="1383141945307" ID="ID_1903593955" MODIFIED="1454514416351" POSITION="left" TEXT="Insertion">
<node CREATED="1454623461718" ID="ID_288995958" MODIFIED="1454623487817" TEXT="In Iteration i, swap a[i] with each larger entry to its left."/>
<node CREATED="1454623949276" ID="ID_522027166" MODIFIED="1454624031495" TEXT="It has O(n) for partially sorted arrays, where partialy sorted array has number of inversions &lt;= cN"/>
</node>
<node COLOR="#338800" CREATED="1383141948272" ID="ID_1471186986" MODIFIED="1454514416351" POSITION="left" TEXT="Coctail"/>
<node COLOR="#338800" CREATED="1383141975362" ID="ID_1864298248" MODIFIED="1454514416351" POSITION="left" TEXT="Selection">
<node CREATED="1454623001656" ID="ID_985165847" MODIFIED="1454623026292" TEXT="In iteration i, find index min of smallest remaining entry"/>
<node CREATED="1454623026943" ID="ID_45870288" MODIFIED="1454623045308" TEXT="swap a[i] and a[min]"/>
<node CREATED="1454623380659" ID="ID_626561665" MODIFIED="1454623390103" TEXT="N^2 / 2"/>
</node>
<node COLOR="#338800" CREATED="1383142087715" ID="ID_1158187149" MODIFIED="1454706697831" POSITION="left" TEXT="Shellsort">
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
</html>
</richcontent>
</node>
<node CREATED="1454701227600" ID="ID_1567007134" MODIFIED="1454706696752" TEXT="h-sorting">
<node CREATED="1454701231247" HGAP="15" ID="ID_1600013244" MODIFIED="1454706696752" TEXT="Knuth 3x+1" VSHIFT="2">
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
</node>
</node>
<node CREATED="1454706648082" ID="ID_512183384" MODIFIED="1454706696752" TEXT="Asymptotic growth rate?"/>
<node CREATED="1454706665609" ID="ID_252395082" MODIFIED="1454706696752" TEXT="Best sequence of increments?"/>
<node CREATED="1454706678464" ID="ID_440143848" MODIFIED="1454706696752" TEXT="Average-case performance?"/>
</node>
</node>
</map>
