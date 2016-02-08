<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1454861916854" ID="ID_1932822469" MODIFIED="1454861941089" STYLE="bubble" TEXT="Sorts">
<node CREATED="1454861925239" ID="ID_983274735" MODIFIED="1454861941090" POSITION="right" STYLE="bubble" TEXT="Selection">
<node CREATED="1454861986909" ID="ID_872276382" MODIFIED="1454862004859" TEXT="N(N-1)/2 compares"/>
</node>
<node CREATED="1454861952848" ID="ID_1680505836" MODIFIED="1454861955896" POSITION="right" TEXT="QuickSort">
<node CREATED="1454862301909" ID="ID_1711380197" MODIFIED="1454862602187" TEXT="1.39NlnN compares and 1/3NlnN exchanges"/>
</node>
<node CREATED="1454861942010" ID="ID_410005118" MODIFIED="1454861946584" POSITION="left" TEXT="Insertion">
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
</node>
<node CREATED="1454861962293" ID="ID_75458489" MODIFIED="1454861965197" POSITION="left" TEXT="ShellSort">
<node CREATED="1454862140192" ID="ID_993365261" MODIFIED="1454862143585" TEXT="3x+1">
<node CREATED="1454862144937" ID="ID_983814256" MODIFIED="1454862151474" TEXT="sorted">
<node CREATED="1454862154347" ID="ID_987271068" MODIFIED="1454862161218" TEXT="Nlog3N compares"/>
</node>
<node CREATED="1454862165707" ID="ID_1816140661" MODIFIED="1454862168418" TEXT="revers">
<node CREATED="1454862171352" ID="ID_1720191651" MODIFIED="1454862179769" TEXT="N^(3/2)"/>
</node>
</node>
</node>
<node CREATED="1454861947789" ID="ID_834591398" MODIFIED="1454861950296" POSITION="left" TEXT="MergeSort">
<node CREATED="1454862189873" ID="ID_1136494626" MODIFIED="1454862198490" TEXT="NlogN compares"/>
<node CREATED="1454862199049" ID="ID_1993930090" MODIFIED="1454862208546" TEXT="6NlogN array access"/>
<node CREATED="1454862212407" ID="ID_1184616565" MODIFIED="1454862221516" TEXT="inplace ? - not discovered"/>
<node CREATED="1454862244280" ID="ID_662736012" MODIFIED="1454862246425" TEXT="best case">
<node CREATED="1454862247194" ID="ID_1414471506" MODIFIED="1454862258090" TEXT="1/2NlogN"/>
</node>
</node>
<node CREATED="1454862268694" ID="ID_822957419" MODIFIED="1454862279130" POSITION="left" TEXT="BottomUp MergeSort">
<node CREATED="1454862280015" ID="ID_1741409750" MODIFIED="1454862286000" TEXT="logN passes"/>
</node>
</node>
</map>