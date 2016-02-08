<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1352972477138" ID="ID_773597506" MODIFIED="1352975255874" STYLE="bubble" TEXT="The Art of MP">
<node CREATED="1352972697499" ID="ID_224943882" MODIFIED="1352972708749" POSITION="right" TEXT="a fable">
<node CREATED="1352972712530" ID="ID_650192461" MODIFIED="1352972724983" TEXT="Bob has a dog"/>
<node CREATED="1352972726046" ID="ID_709708173" MODIFIED="1352972733358" TEXT="Alice has a cat"/>
<node CREATED="1352972752468" ID="ID_346422935" MODIFIED="1352972783108" TEXT="The yard is located between them"/>
<node CREATED="1352976590852" ID="ID_99137963" MODIFIED="1454512973535" TEXT="Code">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      
    </p>
    <p>
      public class Fabule {
    </p>
    <p>
      static int bobFlag, aliceFlag;
    </p>
    <p>
      
    </p>
    <p>
      static void unleashCat(){
    </p>
    <p>
      aliceFlag = 1;
    </p>
    <p>
      if(bobFlag != 1){
    </p>
    <p>
      System.out.println(&quot;cat is on yard&quot;);
    </p>
    <p>
      aliceFlag = 0;
    </p>
    <p>
      }
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      static void unleashDog(){
    </p>
    <p>
      bobFlag = 1;
    </p>
    <p>
      while(aliceFlag == 1){
    </p>
    <p>
      bobFlag = 0;
    </p>
    <p>
      }
    </p>
    <p>
      bobFlag = 1;
    </p>
    <p>
      System.out.println(&quot;dog is on yard&quot;);
    </p>
    <p>
      bobFlag = 0;
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      /**
    </p>
    <p>
      * Example of weakness of one of the mutual exclusion property - starvation-freedom&#160;
    </p>
    <p>
      * @param args
    </p>
    <p>
      * @throws InterruptedException
    </p>
    <p>
      */
    </p>
    <p>
      public static void main(String[] args) throws InterruptedException {
    </p>
    <p>
      new Thread(new Runnable() {
    </p>
    <p>
      @Override
    </p>
    <p>
      public void run() {
    </p>
    <p>
      while(true)
    </p>
    <p>
      unleashCat();
    </p>
    <p>
      }
    </p>
    <p>
      }).start();
    </p>
    <p>
      new Thread(new Runnable() {
    </p>
    <p>
      @Override
    </p>
    <p>
      public void run() {
    </p>
    <p>
      while(true)
    </p>
    <p>
      unleashDog();
    </p>
    <p>
      }
    </p>
    <p>
      }).start();
    </p>
    <p>
      Thread.sleep(10000);
    </p>
    <p>
      }
    </p>
    <p>
      }
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node CREATED="1352975256968" ID="ID_1906093229" MODIFIED="1352975264312" POSITION="left" TEXT="Mutal Exclusion">
<node CREATED="1352975265546" ID="ID_1866665336" MODIFIED="1352975279156" TEXT="deadlock freedom"/>
<node CREATED="1352976008645" ID="ID_1980661222" MODIFIED="1352976017364" TEXT="starvation freedom"/>
<node CREATED="1352976124989" ID="ID_1516565559" MODIFIED="1352976125599" TEXT="waiting"/>
<node CREATED="1352976208646" ID="ID_1801338162" MODIFIED="1352976216115" TEXT="fault-tolerance"/>
</node>
<node CREATED="1352976659118" ID="ID_489641979" MODIFIED="1352976678915" POSITION="right" TEXT="The Consumer-Producer problem" VSHIFT="14">
<node CREATED="1352978237940" ID="ID_1603832597" MODIFIED="1352978254440" TEXT="Code">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      public class TheProducerConsumerProblem {
    </p>
    <p>
      static int can;
    </p>
    <p>
      
    </p>
    <p>
      static void unleashPets(){
    </p>
    <p>
      while(can == 1);
    </p>
    <p>
      System.out.println("pets are on yard");
    </p>
    <p>
      System.out.println("food consumed");
    </p>
    <p>
      can = 1;
    </p>
    <p>
      }
    </p>
    <p>
      static void placeFood(){
    </p>
    <p>
      while(can == 0);
    </p>
    <p>
      System.out.println("food is on the yard");
    </p>
    <p>
      can = 0;
    </p>
    <p>
      }
    </p>
    <p>
      public static void main(String[] args) throws InterruptedException {
    </p>
    <p>
      new Thread(new Runnable() {
    </p>
    <p>
      @Override
    </p>
    <p>
      public void run() {
    </p>
    <p>
      while(true)
    </p>
    <p>
      unleashPets();
    </p>
    <p>
      }
    </p>
    <p>
      }).start();
    </p>
    <p>
      new Thread(new Runnable() {
    </p>
    <p>
      @Override
    </p>
    <p>
      public void run() {
    </p>
    <p>
      while(true)
    </p>
    <p>
      placeFood();
    </p>
    <p>
      }
    </p>
    <p>
      }).start();
    </p>
    <p>
      Thread.sleep(10000);
    </p>
    <p>
      }
    </p>
    <p>
      }
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1352978283144" ID="ID_546445889" MODIFIED="1352978303097" TEXT="Mutual Exclusion: Bob and the pets are never in the yard together.  &#xa;&#xa;Starvation-freedom: If Bob is always willing to feed, and the pets are always famished, then the pets will eat infinitely often.  &#xa;&#xa;Producer&#x2013;Consumer: The pets will not enter the yard unless there is food, and Bob will never provide more food if there is unconsumed food."/>
</node>
<node CREATED="1352978949429" HGAP="14" ID="ID_1524350998" MODIFIED="1352978952914" POSITION="left" TEXT="The Readers&#x2013;Writers Problem" VSHIFT="22">
<node CREATED="1352978969398" ID="ID_1032960150" MODIFIED="1352979022242" TEXT="the problem">
<richcontent TYPE="NOTE">&lt;html&gt;
  &lt;head&gt;
    
    
  &lt;/head&gt;
  &lt;body&gt;
    &lt;p&gt;
      Imagine that Bob posts
    &lt;/p&gt;
    &lt;p&gt;
      the message:
    &lt;/p&gt;
    &lt;p&gt;
      sell the cat
    &lt;/p&gt;
    &lt;p&gt;
      Alice, looking through her telescope, transcribes the message
    &lt;/p&gt;
    &lt;p&gt;
      sell the
    &lt;/p&gt;
    &lt;p&gt;
      At this point Bob takes down the tiles and writes out a new message
    &lt;/p&gt;
    &lt;p&gt;
      wash the dog
    &lt;/p&gt;
    &lt;p&gt;
      Alice, continuing to scan across the billboard transcribes the message
    &lt;/p&gt;
    &lt;p&gt;
      sell the dog
    &lt;/p&gt;
    &lt;p&gt;
      You can imagine the rest.
    &lt;/p&gt;
    &lt;p&gt;
      
    &lt;/p&gt;
    &lt;p&gt;
      Alice and Bob can use the mutual exclusion protocol to make sure that
    &lt;/p&gt;
    &lt;p&gt;
      Alice reads only complete sentences. She might still miss a sentence,
    &lt;/p&gt;
    &lt;p&gt;
      however.
    &lt;/p&gt;
    &lt;p&gt;
      &amp;#2; They can use the can-and-string protocol, where Bob produces sentences 
      and
    &lt;/p&gt;
    &lt;p&gt;
      Alice consumes them.
    &lt;/p&gt;
  &lt;/body&gt;
&lt;/html&gt;</richcontent>
</node>
<node CREATED="1352978990992" ID="ID_335478271" MODIFIED="1352979004617" TEXT="there some ways to avoid waiting">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      If this problem is so easy to solve, then why do we bring it up? Both themutual
    </p>
    <p>
      exclusion and producer&#x2013;consumer protocols require waiting: if one participant is
    </p>
    <p>
      subjected to an unexpected delay, so is the other. In the context of shared multiprocessor
    </p>
    <p>
      memory, a solution to the readers&#x2013;writers problem is a way of allowing
    </p>
    <p>
      a thread to capture an instantaneous view of several memory locations. Capturing
    </p>
    <p>
      such a view without waiting, that is, without preventing other threads from modifying
    </p>
    <p>
      these locations while they are being read, is a powerful tool that can be used
    </p>
    <p>
      for backups, debugging, and in many other situations. Surprisingly, the readers&#x2013;
    </p>
    <p>
      writers problem does have solutions that do not require waiting. We examine
    </p>
    <p>
      several such solutions later on.
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1352979109555" ID="ID_1392809255" MODIFIED="1352979456339" POSITION="right" TEXT="Amdahl&#x2019;s Law">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    S = 1/(1-p+p/n) &#xa0; 

    <table cellspacing="0" style="width: 324pt" width="432" cellpadding="0" border="0" str="#DEFAULT" x="#DEFAULT">
      <tr>
        <td>
          =1/((100-$A4)/100 +$A4/(100*B$2)) <col span="6" style="width: 54pt" width="72"/>
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" style="width: 54pt; height: 15.75pt" width="72">
          P
        </td>
        <td style="width: 54pt" width="72">
          
        </td>
        <td style="width: 54pt" width="72">
          
        </td>
        <td style="width: 54pt" width="72">
          
        </td>
        <td style="width: 54pt" width="72">
          
        </td>
        <td style="width: 54pt" width="72">
          
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" style="height: 15.75pt">
          N
        </td>
        <td align="right" num="#DEFAULT" x="#DEFAULT">
          2
        </td>
        <td align="right" num="#DEFAULT" x="#DEFAULT">
          4
        </td>
        <td align="right" num="#DEFAULT" x="#DEFAULT">
          6
        </td>
        <td align="right" num="#DEFAULT" x="#DEFAULT">
          8
        </td>
        <td align="right" num="#DEFAULT" x="#DEFAULT">
          16
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" style="height: 15.75pt">
          
        </td>
        <td>
          
        </td>
        <td>
          
        </td>
        <td>
          
        </td>
        <td>
          
        </td>
        <td>
          
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          2
        </td>
        <td align="right" fmla="=1/((100-$A4)/100 + $A4/(100*B$2))" num="1.0101010101010102" x="#DEFAULT">
          1.010101
        </td>
        <td align="right" fmla="=1/((100-$A4)/100 + $A4/(100*C$2))" num="1.015228426395939" x="#DEFAULT">
          1.015228
        </td>
        <td align="right" fmla="=1/((100-$A4)/100 + $A4/(100*D$2))" num="1.0169491525423728" x="#DEFAULT">
          1.016949
        </td>
        <td align="right" fmla="=1/((100-$A4)/100 + $A4/(100*E$2))" num="1.0178117048346056" x="#DEFAULT">
          1.017812
        </td>
        <td align="right" fmla="=1/((100-$A4)/100 + $A4/(100*F$2))" num="1.0191082802547771" x="#DEFAULT">
          1.019108
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          4
        </td>
        <td align="right" fmla="=1/((100-$A5)/100 + $A5/(100*B$2))" num="1.0204081632653061" x="#DEFAULT">
          1.020408
        </td>
        <td align="right" fmla="=1/((100-$A5)/100 + $A5/(100*C$2))" num="1.0309278350515465" x="#DEFAULT">
          1.030928
        </td>
        <td align="right" fmla="=1/((100-$A5)/100 + $A5/(100*D$2))" num="1.0344827586206897" x="#DEFAULT">
          1.034483
        </td>
        <td align="right" fmla="=1/((100-$A5)/100 + $A5/(100*E$2))" num="1.0362694300518136" x="#DEFAULT">
          1.036269
        </td>
        <td align="right" fmla="=1/((100-$A5)/100 + $A5/(100*F$2))" num="1.0389610389610391" x="#DEFAULT">
          1.038961
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          6
        </td>
        <td align="right" fmla="=1/((100-$A6)/100 + $A6/(100*B$2))" num="1.0309278350515465" x="#DEFAULT">
          1.030928
        </td>
        <td align="right" fmla="=1/((100-$A6)/100 + $A6/(100*C$2))" num="1.0471204188481675" x="#DEFAULT">
          1.04712
        </td>
        <td align="right" fmla="=1/((100-$A6)/100 + $A6/(100*D$2))" num="1.0526315789473684" x="#DEFAULT">
          1.052632
        </td>
        <td align="right" fmla="=1/((100-$A6)/100 + $A6/(100*E$2))" num="1.0554089709762533" x="#DEFAULT">
          1.055409
        </td>
        <td align="right" fmla="=1/((100-$A6)/100 + $A6/(100*F$2))" num="1.0596026490066226" x="#DEFAULT">
          1.059603
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          8
        </td>
        <td align="right" fmla="=1/((100-$A7)/100 + $A7/(100*B$2))" num="1.0416666666666665" x="#DEFAULT">
          1.041667
        </td>
        <td align="right" fmla="=1/((100-$A7)/100 + $A7/(100*C$2))" num="1.0638297872340425" x="#DEFAULT">
          1.06383
        </td>
        <td align="right" fmla="=1/((100-$A7)/100 + $A7/(100*D$2))" num="1.0714285714285714" x="#DEFAULT">
          1.071429
        </td>
        <td align="right" fmla="=1/((100-$A7)/100 + $A7/(100*E$2))" num="1.075268817204301" x="#DEFAULT">
          1.075269
        </td>
        <td align="right" fmla="=1/((100-$A7)/100 + $A7/(100*F$2))" num="1.0810810810810809" x="#DEFAULT">
          1.081081
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          10
        </td>
        <td align="right" fmla="=1/((100-$A8)/100 + $A8/(100*B$2))" num="1.0526315789473684" x="#DEFAULT">
          1.052632
        </td>
        <td align="right" fmla="=1/((100-$A8)/100 + $A8/(100*C$2))" num="1.0810810810810809" x="#DEFAULT">
          1.081081
        </td>
        <td align="right" fmla="=1/((100-$A8)/100 + $A8/(100*D$2))" num="1.0909090909090908" x="#DEFAULT">
          1.090909
        </td>
        <td align="right" fmla="=1/((100-$A8)/100 + $A8/(100*E$2))" num="1.095890410958904" x="#DEFAULT">
          1.09589
        </td>
        <td align="right" fmla="=1/((100-$A8)/100 + $A8/(100*F$2))" num="1.103448275862069" x="#DEFAULT">
          1.103448
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          12
        </td>
        <td align="right" fmla="=1/((100-$A9)/100 + $A9/(100*B$2))" num="1.0638297872340425" x="#DEFAULT">
          1.06383
        </td>
        <td align="right" fmla="=1/((100-$A9)/100 + $A9/(100*C$2))" num="1.0989010989010988" x="#DEFAULT">
          1.098901
        </td>
        <td align="right" fmla="=1/((100-$A9)/100 + $A9/(100*D$2))" num="1.1111111111111112" x="#DEFAULT">
          1.111111
        </td>
        <td align="right" fmla="=1/((100-$A9)/100 + $A9/(100*E$2))" num="1.1173184357541899" x="#DEFAULT">
          1.117318
        </td>
        <td align="right" fmla="=1/((100-$A9)/100 + $A9/(100*F$2))" num="1.1267605633802817" x="#DEFAULT">
          1.126761
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          14
        </td>
        <td align="right" fmla="=1/((100-$A10)/100 + $A10/(100*B$2))" num="1.0752688172043012" x="#DEFAULT">
          1.075269
        </td>
        <td align="right" fmla="=1/((100-$A10)/100 + $A10/(100*C$2))" num="1.1173184357541899" x="#DEFAULT">
          1.117318
        </td>
        <td align="right" fmla="=1/((100-$A10)/100 + $A10/(100*D$2))" num="1.1320754716981132" x="#DEFAULT">
          1.132075
        </td>
        <td align="right" fmla="=1/((100-$A10)/100 + $A10/(100*E$2))" num="1.1396011396011396" x="#DEFAULT">
          1.139601
        </td>
        <td align="right" fmla="=1/((100-$A10)/100 + $A10/(100*F$2))" num="1.1510791366906474" x="#DEFAULT">
          1.151079
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          16
        </td>
        <td align="right" fmla="=1/((100-$A11)/100 + $A11/(100*B$2))" num="1.0869565217391306" x="#DEFAULT">
          1.086957
        </td>
        <td align="right" fmla="=1/((100-$A11)/100 + $A11/(100*C$2))" num="1.1363636363636365" x="#DEFAULT">
          1.136364
        </td>
        <td align="right" fmla="=1/((100-$A11)/100 + $A11/(100*D$2))" num="1.153846153846154" x="#DEFAULT">
          1.153846
        </td>
        <td align="right" fmla="=1/((100-$A11)/100 + $A11/(100*E$2))" num="1.1627906976744187" x="#DEFAULT">
          1.162791
        </td>
        <td align="right" fmla="=1/((100-$A11)/100 + $A11/(100*F$2))" num="1.1764705882352942" x="#DEFAULT">
          1.176471
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          18
        </td>
        <td align="right" fmla="=1/((100-$A12)/100 + $A12/(100*B$2))" num="1.098901098901099" x="#DEFAULT">
          1.098901
        </td>
        <td align="right" fmla="=1/((100-$A12)/100 + $A12/(100*C$2))" num="1.1560693641618498" x="#DEFAULT">
          1.156069
        </td>
        <td align="right" fmla="=1/((100-$A12)/100 + $A12/(100*D$2))" num="1.1764705882352942" x="#DEFAULT">
          1.176471
        </td>
        <td align="right" fmla="=1/((100-$A12)/100 + $A12/(100*E$2))" num="1.1869436201780417" x="#DEFAULT">
          1.186944
        </td>
        <td align="right" fmla="=1/((100-$A12)/100 + $A12/(100*F$2))" num="1.2030075187969926" x="#DEFAULT">
          1.203008
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          20
        </td>
        <td align="right" fmla="=1/((100-$A13)/100 + $A13/(100*B$2))" num="1.1111111111111112" x="#DEFAULT">
          1.111111
        </td>
        <td align="right" fmla="=1/((100-$A13)/100 + $A13/(100*C$2))" num="1.1764705882352939" x="#DEFAULT">
          1.176471
        </td>
        <td align="right" fmla="=1/((100-$A13)/100 + $A13/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          1.2
        </td>
        <td align="right" fmla="=1/((100-$A13)/100 + $A13/(100*E$2))" num="1.2121212121212119" x="#DEFAULT">
          1.212121
        </td>
        <td align="right" fmla="=1/((100-$A13)/100 + $A13/(100*F$2))" num="1.2307692307692308" x="#DEFAULT">
          1.230769
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          22
        </td>
        <td align="right" fmla="=1/((100-$A14)/100 + $A14/(100*B$2))" num="1.1235955056179776" x="#DEFAULT">
          1.123596
        </td>
        <td align="right" fmla="=1/((100-$A14)/100 + $A14/(100*C$2))" num="1.1976047904191616" x="#DEFAULT">
          1.197605
        </td>
        <td align="right" fmla="=1/((100-$A14)/100 + $A14/(100*D$2))" num="1.2244897959183674" x="#DEFAULT">
          1.22449
        </td>
        <td align="right" fmla="=1/((100-$A14)/100 + $A14/(100*E$2))" num="1.2383900928792571" x="#DEFAULT">
          1.23839
        </td>
        <td align="right" fmla="=1/((100-$A14)/100 + $A14/(100*F$2))" num="1.2598425196850394" x="#DEFAULT">
          1.259843
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          24
        </td>
        <td align="right" fmla="=1/((100-$A15)/100 + $A15/(100*B$2))" num="1.1363636363636365" x="#DEFAULT">
          1.136364
        </td>
        <td align="right" fmla="=1/((100-$A15)/100 + $A15/(100*C$2))" num="1.2195121951219512" x="#DEFAULT">
          1.219512
        </td>
        <td align="right" fmla="=1/((100-$A15)/100 + $A15/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          1.25
        </td>
        <td align="right" fmla="=1/((100-$A15)/100 + $A15/(100*E$2))" num="1.2658227848101264" x="#DEFAULT">
          1.265823
        </td>
        <td align="right" fmla="=1/((100-$A15)/100 + $A15/(100*F$2))" num="1.2903225806451613" x="#DEFAULT">
          1.290323
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          26
        </td>
        <td align="right" fmla="=1/((100-$A16)/100 + $A16/(100*B$2))" num="1.1494252873563218" x="#DEFAULT">
          1.149425
        </td>
        <td align="right" fmla="=1/((100-$A16)/100 + $A16/(100*C$2))" num="1.2422360248447206" x="#DEFAULT">
          1.242236
        </td>
        <td align="right" fmla="=1/((100-$A16)/100 + $A16/(100*D$2))" num="1.2765957446808511" x="#DEFAULT">
          1.276596
        </td>
        <td align="right" fmla="=1/((100-$A16)/100 + $A16/(100*E$2))" num="1.2944983818770228" x="#DEFAULT">
          1.294498
        </td>
        <td align="right" fmla="=1/((100-$A16)/100 + $A16/(100*F$2))" num="1.3223140495867769" x="#DEFAULT">
          1.322314
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          28
        </td>
        <td align="right" fmla="=1/((100-$A17)/100 + $A17/(100*B$2))" num="1.1627906976744187" x="#DEFAULT">
          1.162791
        </td>
        <td align="right" fmla="=1/((100-$A17)/100 + $A17/(100*C$2))" num="1.2658227848101264" x="#DEFAULT">
          1.265823
        </td>
        <td align="right" fmla="=1/((100-$A17)/100 + $A17/(100*D$2))" num="1.3043478260869565" x="#DEFAULT">
          1.304348
        </td>
        <td align="right" fmla="=1/((100-$A17)/100 + $A17/(100*E$2))" num="1.3245033112582782" x="#DEFAULT">
          1.324503
        </td>
        <td align="right" fmla="=1/((100-$A17)/100 + $A17/(100*F$2))" num="1.3559322033898307" x="#DEFAULT">
          1.355932
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          30
        </td>
        <td align="right" fmla="=1/((100-$A18)/100 + $A18/(100*B$2))" num="1.1764705882352942" x="#DEFAULT">
          1.176471
        </td>
        <td align="right" fmla="=1/((100-$A18)/100 + $A18/(100*C$2))" num="1.2903225806451615" x="#DEFAULT">
          1.290323
        </td>
        <td align="right" fmla="=1/((100-$A18)/100 + $A18/(100*D$2))" num="1.3333333333333333" x="#DEFAULT">
          1.333333
        </td>
        <td align="right" fmla="=1/((100-$A18)/100 + $A18/(100*E$2))" num="1.3559322033898307" x="#DEFAULT">
          1.355932
        </td>
        <td align="right" fmla="=1/((100-$A18)/100 + $A18/(100*F$2))" num="1.3913043478260869" x="#DEFAULT">
          1.391304
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          32
        </td>
        <td align="right" fmla="=1/((100-$A19)/100 + $A19/(100*B$2))" num="1.1904761904761905" x="#DEFAULT">
          1.190476
        </td>
        <td align="right" fmla="=1/((100-$A19)/100 + $A19/(100*C$2))" num="1.3157894736842106" x="#DEFAULT">
          1.315789
        </td>
        <td align="right" fmla="=1/((100-$A19)/100 + $A19/(100*D$2))" num="1.3636363636363635" x="#DEFAULT">
          1.363636
        </td>
        <td align="right" fmla="=1/((100-$A19)/100 + $A19/(100*E$2))" num="1.3888888888888886" x="#DEFAULT">
          1.388889
        </td>
        <td align="right" fmla="=1/((100-$A19)/100 + $A19/(100*F$2))" num="1.4285714285714284" x="#DEFAULT">
          1.428571
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          34
        </td>
        <td align="right" fmla="=1/((100-$A20)/100 + $A20/(100*B$2))" num="1.2048192771084336" x="#DEFAULT">
          1.204819
        </td>
        <td align="right" fmla="=1/((100-$A20)/100 + $A20/(100*C$2))" num="1.3422818791946309" x="#DEFAULT">
          1.342282
        </td>
        <td align="right" fmla="=1/((100-$A20)/100 + $A20/(100*D$2))" num="1.3953488372093024" x="#DEFAULT">
          1.395349
        </td>
        <td align="right" fmla="=1/((100-$A20)/100 + $A20/(100*E$2))" num="1.4234875444839858" x="#DEFAULT">
          1.423488
        </td>
        <td align="right" fmla="=1/((100-$A20)/100 + $A20/(100*F$2))" num="1.4678899082568806" x="#DEFAULT">
          1.46789
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          36
        </td>
        <td align="right" fmla="=1/((100-$A21)/100 + $A21/(100*B$2))" num="1.2195121951219512" x="#DEFAULT">
          1.219512
        </td>
        <td align="right" fmla="=1/((100-$A21)/100 + $A21/(100*C$2))" num="1.3698630136986301" x="#DEFAULT">
          1.369863
        </td>
        <td align="right" fmla="=1/((100-$A21)/100 + $A21/(100*D$2))" num="1.4285714285714286" x="#DEFAULT">
          1.428571
        </td>
        <td align="right" fmla="=1/((100-$A21)/100 + $A21/(100*E$2))" num="1.4598540145985401" x="#DEFAULT">
          1.459854
        </td>
        <td align="right" fmla="=1/((100-$A21)/100 + $A21/(100*F$2))" num="1.5094339622641511" x="#DEFAULT">
          1.509434
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          38
        </td>
        <td align="right" fmla="=1/((100-$A22)/100 + $A22/(100*B$2))" num="1.2345679012345678" x="#DEFAULT">
          1.234568
        </td>
        <td align="right" fmla="=1/((100-$A22)/100 + $A22/(100*C$2))" num="1.3986013986013988" x="#DEFAULT">
          1.398601
        </td>
        <td align="right" fmla="=1/((100-$A22)/100 + $A22/(100*D$2))" num="1.4634146341463414" x="#DEFAULT">
          1.463415
        </td>
        <td align="right" fmla="=1/((100-$A22)/100 + $A22/(100*E$2))" num="1.4981273408239701" x="#DEFAULT">
          1.498127
        </td>
        <td align="right" fmla="=1/((100-$A22)/100 + $A22/(100*F$2))" num="1.5533980582524272" x="#DEFAULT">
          1.553398
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          40
        </td>
        <td align="right" fmla="=1/((100-$A23)/100 + $A23/(100*B$2))" num="#DEFAULT" x="#DEFAULT">
          1.25
        </td>
        <td align="right" fmla="=1/((100-$A23)/100 + $A23/(100*C$2))" num="1.4285714285714286" x="#DEFAULT">
          1.428571
        </td>
        <td align="right" fmla="=1/((100-$A23)/100 + $A23/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          1.5
        </td>
        <td align="right" fmla="=1/((100-$A23)/100 + $A23/(100*E$2))" num="1.5384615384615383" x="#DEFAULT">
          1.538462
        </td>
        <td align="right" fmla="=1/((100-$A23)/100 + $A23/(100*F$2))" num="#DEFAULT" x="#DEFAULT">
          1.6
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          42
        </td>
        <td align="right" fmla="=1/((100-$A24)/100 + $A24/(100*B$2))" num="1.2658227848101267" x="#DEFAULT">
          1.265823
        </td>
        <td align="right" fmla="=1/((100-$A24)/100 + $A24/(100*C$2))" num="1.4598540145985404" x="#DEFAULT">
          1.459854
        </td>
        <td align="right" fmla="=1/((100-$A24)/100 + $A24/(100*D$2))" num="1.5384615384615388" x="#DEFAULT">
          1.538462
        </td>
        <td align="right" fmla="=1/((100-$A24)/100 + $A24/(100*E$2))" num="1.5810276679841899" x="#DEFAULT">
          1.581028
        </td>
        <td align="right" fmla="=1/((100-$A24)/100 + $A24/(100*F$2))" num="1.6494845360824744" x="#DEFAULT">
          1.649485
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          44
        </td>
        <td align="right" fmla="=1/((100-$A25)/100 + $A25/(100*B$2))" num="1.2820512820512819" x="#DEFAULT">
          1.282051
        </td>
        <td align="right" fmla="=1/((100-$A25)/100 + $A25/(100*C$2))" num="1.4925373134328357" x="#DEFAULT">
          1.492537
        </td>
        <td align="right" fmla="=1/((100-$A25)/100 + $A25/(100*D$2))" num="1.5789473684210524" x="#DEFAULT">
          1.578947
        </td>
        <td align="right" fmla="=1/((100-$A25)/100 + $A25/(100*E$2))" num="1.6260162601626014" x="#DEFAULT">
          1.626016
        </td>
        <td align="right" fmla="=1/((100-$A25)/100 + $A25/(100*F$2))" num="1.7021276595744681" x="#DEFAULT">
          1.702128
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          46
        </td>
        <td align="right" fmla="=1/((100-$A26)/100 + $A26/(100*B$2))" num="1.2987012987012987" x="#DEFAULT">
          1.298701
        </td>
        <td align="right" fmla="=1/((100-$A26)/100 + $A26/(100*C$2))" num="1.5267175572519083" x="#DEFAULT">
          1.526718
        </td>
        <td align="right" fmla="=1/((100-$A26)/100 + $A26/(100*D$2))" num="1.6216216216216215" x="#DEFAULT">
          1.621622
        </td>
        <td align="right" fmla="=1/((100-$A26)/100 + $A26/(100*E$2))" num="1.6736401673640167" x="#DEFAULT">
          1.67364
        </td>
        <td align="right" fmla="=1/((100-$A26)/100 + $A26/(100*F$2))" num="1.758241758241758" x="#DEFAULT">
          1.758242
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          48
        </td>
        <td align="right" fmla="=1/((100-$A27)/100 + $A27/(100*B$2))" num="1.3157894736842106" x="#DEFAULT">
          1.315789
        </td>
        <td align="right" fmla="=1/((100-$A27)/100 + $A27/(100*C$2))" num="1.5625" x="#DEFAULT">
          1.5625
        </td>
        <td align="right" fmla="=1/((100-$A27)/100 + $A27/(100*D$2))" num="1.6666666666666667" x="#DEFAULT">
          1.666667
        </td>
        <td align="right" fmla="=1/((100-$A27)/100 + $A27/(100*E$2))" num="1.7241379310344827" x="#DEFAULT">
          1.724138
        </td>
        <td align="right" fmla="=1/((100-$A27)/100 + $A27/(100*F$2))" num="1.8181818181818181" x="#DEFAULT">
          1.818182
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          50
        </td>
        <td align="right" fmla="=1/((100-$A28)/100 + $A28/(100*B$2))" num="1.3333333333333333" x="#DEFAULT">
          1.333333
        </td>
        <td align="right" fmla="=1/((100-$A28)/100 + $A28/(100*C$2))" num="#DEFAULT" x="#DEFAULT">
          1.6
        </td>
        <td align="right" fmla="=1/((100-$A28)/100 + $A28/(100*D$2))" num="1.7142857142857142" x="#DEFAULT">
          1.714286
        </td>
        <td align="right" fmla="=1/((100-$A28)/100 + $A28/(100*E$2))" num="1.7777777777777777" x="#DEFAULT">
          1.777778
        </td>
        <td align="right" fmla="=1/((100-$A28)/100 + $A28/(100*F$2))" num="1.8823529411764706" x="#DEFAULT">
          1.882353
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          52
        </td>
        <td align="right" fmla="=1/((100-$A29)/100 + $A29/(100*B$2))" num="1.3513513513513513" x="#DEFAULT">
          1.351351
        </td>
        <td align="right" fmla="=1/((100-$A29)/100 + $A29/(100*C$2))" num="1.639344262295082" x="#DEFAULT">
          1.639344
        </td>
        <td align="right" fmla="=1/((100-$A29)/100 + $A29/(100*D$2))" num="1.7647058823529411" x="#DEFAULT">
          1.764706
        </td>
        <td align="right" fmla="=1/((100-$A29)/100 + $A29/(100*E$2))" num="1.8348623853211012" x="#DEFAULT">
          1.834862
        </td>
        <td align="right" fmla="=1/((100-$A29)/100 + $A29/(100*F$2))" num="1.9512195121951221" x="#DEFAULT">
          1.95122
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          54
        </td>
        <td align="right" fmla="=1/((100-$A30)/100 + $A30/(100*B$2))" num="1.3698630136986301" x="#DEFAULT">
          1.369863
        </td>
        <td align="right" fmla="=1/((100-$A30)/100 + $A30/(100*C$2))" num="1.680672268907563" x="#DEFAULT">
          1.680672
        </td>
        <td align="right" fmla="=1/((100-$A30)/100 + $A30/(100*D$2))" num="1.8181818181818181" x="#DEFAULT">
          1.818182
        </td>
        <td align="right" fmla="=1/((100-$A30)/100 + $A30/(100*E$2))" num="1.8957345971563979" x="#DEFAULT">
          1.895735
        </td>
        <td align="right" fmla="=1/((100-$A30)/100 + $A30/(100*F$2))" num="2.0253164556962022" x="#DEFAULT">
          2.025316
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          56
        </td>
        <td align="right" fmla="=1/((100-$A31)/100 + $A31/(100*B$2))" num="1.3888888888888888" x="#DEFAULT">
          1.388889
        </td>
        <td align="right" fmla="=1/((100-$A31)/100 + $A31/(100*C$2))" num="1.7241379310344827" x="#DEFAULT">
          1.724138
        </td>
        <td align="right" fmla="=1/((100-$A31)/100 + $A31/(100*D$2))" num="1.875" x="#DEFAULT">
          1.875
        </td>
        <td align="right" fmla="=1/((100-$A31)/100 + $A31/(100*E$2))" num="1.9607843137254901" x="#DEFAULT">
          1.960784
        </td>
        <td align="right" fmla="=1/((100-$A31)/100 + $A31/(100*F$2))" num="2.1052631578947367" x="#DEFAULT">
          2.105263
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          58
        </td>
        <td align="right" fmla="=1/((100-$A32)/100 + $A32/(100*B$2))" num="1.4084507042253522" x="#DEFAULT">
          1.408451
        </td>
        <td align="right" fmla="=1/((100-$A32)/100 + $A32/(100*C$2))" num="1.7699115044247788" x="#DEFAULT">
          1.769912
        </td>
        <td align="right" fmla="=1/((100-$A32)/100 + $A32/(100*D$2))" num="1.9354838709677422" x="#DEFAULT">
          1.935484
        </td>
        <td align="right" fmla="=1/((100-$A32)/100 + $A32/(100*E$2))" num="2.030456852791878" x="#DEFAULT">
          2.030457
        </td>
        <td align="right" fmla="=1/((100-$A32)/100 + $A32/(100*F$2))" num="2.1917808219178081" x="#DEFAULT">
          2.191781
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          60
        </td>
        <td align="right" fmla="=1/((100-$A33)/100 + $A33/(100*B$2))" num="1.4285714285714286" x="#DEFAULT">
          1.428571
        </td>
        <td align="right" fmla="=1/((100-$A33)/100 + $A33/(100*C$2))" num="1.8181818181818181" x="#DEFAULT">
          1.818182
        </td>
        <td align="right" fmla="=1/((100-$A33)/100 + $A33/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          2
        </td>
        <td align="right" fmla="=1/((100-$A33)/100 + $A33/(100*E$2))" num="2.1052631578947367" x="#DEFAULT">
          2.105263
        </td>
        <td align="right" fmla="=1/((100-$A33)/100 + $A33/(100*F$2))" num="2.2857142857142856" x="#DEFAULT">
          2.285714
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          62
        </td>
        <td align="right" fmla="=1/((100-$A34)/100 + $A34/(100*B$2))" num="1.4492753623188408" x="#DEFAULT">
          1.449275
        </td>
        <td align="right" fmla="=1/((100-$A34)/100 + $A34/(100*C$2))" num="1.8691588785046729" x="#DEFAULT">
          1.869159
        </td>
        <td align="right" fmla="=1/((100-$A34)/100 + $A34/(100*D$2))" num="2.0689655172413794" x="#DEFAULT">
          2.068966
        </td>
        <td align="right" fmla="=1/((100-$A34)/100 + $A34/(100*E$2))" num="2.1857923497267757" x="#DEFAULT">
          2.185792
        </td>
        <td align="right" fmla="=1/((100-$A34)/100 + $A34/(100*F$2))" num="2.3880597014925371" x="#DEFAULT">
          2.38806
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          64
        </td>
        <td align="right" fmla="=1/((100-$A35)/100 + $A35/(100*B$2))" num="1.4705882352941178" x="#DEFAULT">
          1.470588
        </td>
        <td align="right" fmla="=1/((100-$A35)/100 + $A35/(100*C$2))" num="1.9230769230769229" x="#DEFAULT">
          1.923077
        </td>
        <td align="right" fmla="=1/((100-$A35)/100 + $A35/(100*D$2))" num="2.1428571428571428" x="#DEFAULT">
          2.142857
        </td>
        <td align="right" fmla="=1/((100-$A35)/100 + $A35/(100*E$2))" num="2.2727272727272729" x="#DEFAULT">
          2.272727
        </td>
        <td align="right" fmla="=1/((100-$A35)/100 + $A35/(100*F$2))" num="#DEFAULT" x="#DEFAULT">
          2.5
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          66
        </td>
        <td align="right" fmla="=1/((100-$A36)/100 + $A36/(100*B$2))" num="1.4925373134328357" x="#DEFAULT">
          1.492537
        </td>
        <td align="right" fmla="=1/((100-$A36)/100 + $A36/(100*C$2))" num="1.9801980198019802" x="#DEFAULT">
          1.980198
        </td>
        <td align="right" fmla="=1/((100-$A36)/100 + $A36/(100*D$2))" num="2.2222222222222223" x="#DEFAULT">
          2.222222
        </td>
        <td align="right" fmla="=1/((100-$A36)/100 + $A36/(100*E$2))" num="2.3668639053254434" x="#DEFAULT">
          2.366864
        </td>
        <td align="right" fmla="=1/((100-$A36)/100 + $A36/(100*F$2))" num="2.622950819672131" x="#DEFAULT">
          2.622951
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          68
        </td>
        <td align="right" fmla="=1/((100-$A37)/100 + $A37/(100*B$2))" num="1.5151515151515151" x="#DEFAULT">
          1.515152
        </td>
        <td align="right" fmla="=1/((100-$A37)/100 + $A37/(100*C$2))" num="2.0408163265306123" x="#DEFAULT">
          2.040816
        </td>
        <td align="right" fmla="=1/((100-$A37)/100 + $A37/(100*D$2))" num="2.3076923076923075" x="#DEFAULT">
          2.307692
        </td>
        <td align="right" fmla="=1/((100-$A37)/100 + $A37/(100*E$2))" num="2.4691358024691357" x="#DEFAULT">
          2.469136
        </td>
        <td align="right" fmla="=1/((100-$A37)/100 + $A37/(100*F$2))" num="2.7586206896551726" x="#DEFAULT">
          2.758621
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          70
        </td>
        <td align="right" fmla="=1/((100-$A38)/100 + $A38/(100*B$2))" num="1.5384615384615388" x="#DEFAULT">
          1.538462
        </td>
        <td align="right" fmla="=1/((100-$A38)/100 + $A38/(100*C$2))" num="2.1052631578947367" x="#DEFAULT">
          2.105263
        </td>
        <td align="right" fmla="=1/((100-$A38)/100 + $A38/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          2.4
        </td>
        <td align="right" fmla="=1/((100-$A38)/100 + $A38/(100*E$2))" num="2.580645161290323" x="#DEFAULT">
          2.580645
        </td>
        <td align="right" fmla="=1/((100-$A38)/100 + $A38/(100*F$2))" num="2.9090909090909092" x="#DEFAULT">
          2.909091
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          72
        </td>
        <td align="right" fmla="=1/((100-$A39)/100 + $A39/(100*B$2))" num="1.5625" x="#DEFAULT">
          1.5625
        </td>
        <td align="right" fmla="=1/((100-$A39)/100 + $A39/(100*C$2))" num="2.1739130434782608" x="#DEFAULT">
          2.173913
        </td>
        <td align="right" fmla="=1/((100-$A39)/100 + $A39/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          2.5
        </td>
        <td align="right" fmla="=1/((100-$A39)/100 + $A39/(100*E$2))" num="2.7027027027027026" x="#DEFAULT">
          2.702703
        </td>
        <td align="right" fmla="=1/((100-$A39)/100 + $A39/(100*F$2))" num="3.0769230769230766" x="#DEFAULT">
          3.076923
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          74
        </td>
        <td align="right" fmla="=1/((100-$A40)/100 + $A40/(100*B$2))" num="1.5873015873015872" x="#DEFAULT">
          1.587302
        </td>
        <td align="right" fmla="=1/((100-$A40)/100 + $A40/(100*C$2))" num="2.2471910112359552" x="#DEFAULT">
          2.247191
        </td>
        <td align="right" fmla="=1/((100-$A40)/100 + $A40/(100*D$2))" num="2.6086956521739131" x="#DEFAULT">
          2.608696
        </td>
        <td align="right" fmla="=1/((100-$A40)/100 + $A40/(100*E$2))" num="2.8368794326241131" x="#DEFAULT">
          2.836879
        </td>
        <td align="right" fmla="=1/((100-$A40)/100 + $A40/(100*F$2))" num="3.2653061224489792" x="#DEFAULT">
          3.265306
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          76
        </td>
        <td align="right" fmla="=1/((100-$A41)/100 + $A41/(100*B$2))" num="1.6129032258064517" x="#DEFAULT">
          1.612903
        </td>
        <td align="right" fmla="=1/((100-$A41)/100 + $A41/(100*C$2))" num="2.3255813953488373" x="#DEFAULT">
          2.325581
        </td>
        <td align="right" fmla="=1/((100-$A41)/100 + $A41/(100*D$2))" num="2.7272727272727271" x="#DEFAULT">
          2.727273
        </td>
        <td align="right" fmla="=1/((100-$A41)/100 + $A41/(100*E$2))" num="2.9850746268656718" x="#DEFAULT">
          2.985075
        </td>
        <td align="right" fmla="=1/((100-$A41)/100 + $A41/(100*F$2))" num="3.4782608695652177" x="#DEFAULT">
          3.478261
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          78
        </td>
        <td align="right" fmla="=1/((100-$A42)/100 + $A42/(100*B$2))" num="1.639344262295082" x="#DEFAULT">
          1.639344
        </td>
        <td align="right" fmla="=1/((100-$A42)/100 + $A42/(100*C$2))" num="2.4096385542168672" x="#DEFAULT">
          2.409639
        </td>
        <td align="right" fmla="=1/((100-$A42)/100 + $A42/(100*D$2))" num="2.8571428571428572" x="#DEFAULT">
          2.857143
        </td>
        <td align="right" fmla="=1/((100-$A42)/100 + $A42/(100*E$2))" num="3.1496062992125982" x="#DEFAULT">
          3.149606
        </td>
        <td align="right" fmla="=1/((100-$A42)/100 + $A42/(100*F$2))" num="3.7209302325581395" x="#DEFAULT">
          3.72093
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          80
        </td>
        <td align="right" fmla="=1/((100-$A43)/100 + $A43/(100*B$2))" num="1.6666666666666665" x="#DEFAULT">
          1.666667
        </td>
        <td align="right" fmla="=1/((100-$A43)/100 + $A43/(100*C$2))" num="#DEFAULT" x="#DEFAULT">
          2.5
        </td>
        <td align="right" fmla="=1/((100-$A43)/100 + $A43/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          3
        </td>
        <td align="right" fmla="=1/((100-$A43)/100 + $A43/(100*E$2))" num="3.333333333333333" x="#DEFAULT">
          3.333333
        </td>
        <td align="right" fmla="=1/((100-$A43)/100 + $A43/(100*F$2))" num="#DEFAULT" x="#DEFAULT">
          4
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          82
        </td>
        <td align="right" fmla="=1/((100-$A44)/100 + $A44/(100*B$2))" num="1.6949152542372883" x="#DEFAULT">
          1.694915
        </td>
        <td align="right" fmla="=1/((100-$A44)/100 + $A44/(100*C$2))" num="2.5974025974025974" x="#DEFAULT">
          2.597403
        </td>
        <td align="right" fmla="=1/((100-$A44)/100 + $A44/(100*D$2))" num="3.1578947368421053" x="#DEFAULT">
          3.157895
        </td>
        <td align="right" fmla="=1/((100-$A44)/100 + $A44/(100*E$2))" num="3.5398230088495577" x="#DEFAULT">
          3.539823
        </td>
        <td align="right" fmla="=1/((100-$A44)/100 + $A44/(100*F$2))" num="4.3243243243243246" x="#DEFAULT">
          4.324324
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          84
        </td>
        <td align="right" fmla="=1/((100-$A45)/100 + $A45/(100*B$2))" num="1.7241379310344829" x="#DEFAULT">
          1.724138
        </td>
        <td align="right" fmla="=1/((100-$A45)/100 + $A45/(100*C$2))" num="2.7027027027027026" x="#DEFAULT">
          2.702703
        </td>
        <td align="right" fmla="=1/((100-$A45)/100 + $A45/(100*D$2))" num="3.333333333333333" x="#DEFAULT">
          3.333333
        </td>
        <td align="right" fmla="=1/((100-$A45)/100 + $A45/(100*E$2))" num="3.773584905660377" x="#DEFAULT">
          3.773585
        </td>
        <td align="right" fmla="=1/((100-$A45)/100 + $A45/(100*F$2))" num="4.7058823529411766" x="#DEFAULT">
          4.705882
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          86
        </td>
        <td align="right" fmla="=1/((100-$A46)/100 + $A46/(100*B$2))" num="1.7543859649122806" x="#DEFAULT">
          1.754386
        </td>
        <td align="right" fmla="=1/((100-$A46)/100 + $A46/(100*C$2))" num="2.8169014084507045" x="#DEFAULT">
          2.816901
        </td>
        <td align="right" fmla="=1/((100-$A46)/100 + $A46/(100*D$2))" num="3.5294117647058822" x="#DEFAULT">
          3.529412
        </td>
        <td align="right" fmla="=1/((100-$A46)/100 + $A46/(100*E$2))" num="4.0404040404040407" x="#DEFAULT">
          4.040404
        </td>
        <td align="right" fmla="=1/((100-$A46)/100 + $A46/(100*F$2))" num="5.161290322580645" x="#DEFAULT">
          5.16129
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          88
        </td>
        <td align="right" fmla="=1/((100-$A47)/100 + $A47/(100*B$2))" num="1.7857142857142856" x="#DEFAULT">
          1.785714
        </td>
        <td align="right" fmla="=1/((100-$A47)/100 + $A47/(100*C$2))" num="2.9411764705882355" x="#DEFAULT">
          2.941176
        </td>
        <td align="right" fmla="=1/((100-$A47)/100 + $A47/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          3.75
        </td>
        <td align="right" fmla="=1/((100-$A47)/100 + $A47/(100*E$2))" num="4.3478260869565224" x="#DEFAULT">
          4.347826
        </td>
        <td align="right" fmla="=1/((100-$A47)/100 + $A47/(100*F$2))" num="5.7142857142857144" x="#DEFAULT">
          5.714286
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          90
        </td>
        <td align="right" fmla="=1/((100-$A48)/100 + $A48/(100*B$2))" num="1.8181818181818181" x="#DEFAULT">
          1.818182
        </td>
        <td align="right" fmla="=1/((100-$A48)/100 + $A48/(100*C$2))" num="3.0769230769230766" x="#DEFAULT">
          3.076923
        </td>
        <td align="right" fmla="=1/((100-$A48)/100 + $A48/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          4
        </td>
        <td align="right" fmla="=1/((100-$A48)/100 + $A48/(100*E$2))" num="4.7058823529411757" x="#DEFAULT">
          4.705882
        </td>
        <td align="right" fmla="=1/((100-$A48)/100 + $A48/(100*F$2))" num="#DEFAULT" x="#DEFAULT">
          6.4
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          92
        </td>
        <td align="right" fmla="=1/((100-$A49)/100 + $A49/(100*B$2))" num="1.8518518518518516" x="#DEFAULT">
          1.851852
        </td>
        <td align="right" fmla="=1/((100-$A49)/100 + $A49/(100*C$2))" num="3.2258064516129035" x="#DEFAULT">
          3.225806
        </td>
        <td align="right" fmla="=1/((100-$A49)/100 + $A49/(100*D$2))" num="4.2857142857142856" x="#DEFAULT">
          4.285714
        </td>
        <td align="right" fmla="=1/((100-$A49)/100 + $A49/(100*E$2))" num="5.1282051282051277" x="#DEFAULT">
          5.128205
        </td>
        <td align="right" fmla="=1/((100-$A49)/100 + $A49/(100*F$2))" num="7.2727272727272725" x="#DEFAULT">
          7.272727
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          94
        </td>
        <td align="right" fmla="=1/((100-$A50)/100 + $A50/(100*B$2))" num="1.8867924528301885" x="#DEFAULT">
          1.886792
        </td>
        <td align="right" fmla="=1/((100-$A50)/100 + $A50/(100*C$2))" num="3.3898305084745766" x="#DEFAULT">
          3.389831
        </td>
        <td align="right" fmla="=1/((100-$A50)/100 + $A50/(100*D$2))" num="4.615384615384615" x="#DEFAULT">
          4.615385
        </td>
        <td align="right" fmla="=1/((100-$A50)/100 + $A50/(100*E$2))" num="5.6338028169014089" x="#DEFAULT">
          5.633803
        </td>
        <td align="right" fmla="=1/((100-$A50)/100 + $A50/(100*F$2))" num="8.4210526315789469" x="#DEFAULT">
          8.421053
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          96
        </td>
        <td align="right" fmla="=1/((100-$A51)/100 + $A51/(100*B$2))" num="1.9230769230769229" x="#DEFAULT">
          1.923077
        </td>
        <td align="right" fmla="=1/((100-$A51)/100 + $A51/(100*C$2))" num="3.5714285714285716" x="#DEFAULT">
          3.571429
        </td>
        <td align="right" fmla="=1/((100-$A51)/100 + $A51/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          5
        </td>
        <td align="right" fmla="=1/((100-$A51)/100 + $A51/(100*E$2))" num="#DEFAULT" x="#DEFAULT">
          6.25
        </td>
        <td align="right" fmla="=1/((100-$A51)/100 + $A51/(100*F$2))" num="#DEFAULT" x="#DEFAULT">
          10
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          98
        </td>
        <td align="right" fmla="=1/((100-$A52)/100 + $A52/(100*B$2))" num="1.9607843137254901" x="#DEFAULT">
          1.960784
        </td>
        <td align="right" fmla="=1/((100-$A52)/100 + $A52/(100*C$2))" num="3.773584905660377" x="#DEFAULT">
          3.773585
        </td>
        <td align="right" fmla="=1/((100-$A52)/100 + $A52/(100*D$2))" num="5.454545454545455" x="#DEFAULT">
          5.454545
        </td>
        <td align="right" fmla="=1/((100-$A52)/100 + $A52/(100*E$2))" num="7.0175438596491233" x="#DEFAULT">
          7.017544
        </td>
        <td align="right" fmla="=1/((100-$A52)/100 + $A52/(100*F$2))" num="12.307692307692307" x="#DEFAULT">
          12.30769
        </td>
      </tr>
      <tr height="21" style="height: 15.75pt">
        <td height="21" align="right" style="height: 15.75pt" num="#DEFAULT" x="#DEFAULT">
          100
        </td>
        <td align="right" fmla="=1/((100-$A53)/100 + $A53/(100*B$2))" num="#DEFAULT" x="#DEFAULT">
          2
        </td>
        <td align="right" fmla="=1/((100-$A53)/100 + $A53/(100*C$2))" num="#DEFAULT" x="#DEFAULT">
          4
        </td>
        <td align="right" fmla="=1/((100-$A53)/100 + $A53/(100*D$2))" num="#DEFAULT" x="#DEFAULT">
          6
        </td>
        <td align="right" fmla="=1/((100-$A53)/100 + $A53/(100*E$2))" num="#DEFAULT" x="#DEFAULT">
          8
        </td>
        <td align="right" fmla="=1/((100-$A53)/100 + $A53/(100*F$2))" num="#DEFAULT" x="#DEFAULT">
          16
        </td>
      </tr>
    </table>
  </body>
</html></richcontent>
</node>
<node CREATED="1352979457167" ID="ID_340162949" MODIFIED="1352979543027" POSITION="left" TEXT="The Dining Philosophers Problem" VSHIFT="18">
<node CREATED="1352979473948" ID="ID_1179194745" MODIFIED="1352979486495" TEXT="E.W. Dijkstra"/>
<node CREATED="1352984271135" ID="ID_667394287" MODIFIED="1352986140460" TEXT="Code">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      
    </p>
    <p>
      public class TheDiningPhilosophersProblem {
    </p>
    <p>
      static Thread[] thread = new Thread[5];
    </p>
    <p>
      static boolean[] chopstick = {false, false, false, false, false};
    </p>
    <p>
      
    </p>
    <p>
      public static void main(String[] args) throws InterruptedException {
    </p>
    <p>
      for (int i = 0; i &lt; 5; i++) {
    </p>
    <p>
      final int y = i;
    </p>
    <p>
      thread[i] = new Thread(new Runnable(){
    </p>
    <p>
      @Override
    </p>
    <p>
      public void run() {
    </p>
    <p>
      while(true){
    </p>
    <p>
      if(y%2==0){
    </p>
    <p>
      pickupRight(y);
    </p>
    <p>
      pickupLeft(y);
    </p>
    <p>
      }
    </p>
    <p>
      else{
    </p>
    <p>
      pickupLeft(y);
    </p>
    <p>
      pickupRight(y);
    </p>
    <p>
      }
    </p>
    <p>
      System.out.println("Ph" + y + " consuming the food with chopsticks: "+ y + " " + mod(y-1, 5));
    </p>
    <p>
      
    </p>
    <p>
      pulldownRight(y);
    </p>
    <p>
      pulldownLeft(y);
    </p>
    <p>
      }
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      private void pulldownLeft(final int y) {
    </p>
    <p>
      chopstick[y] = false;
    </p>
    <p>
      Thread.yield();
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      private void pulldownRight(final int y) {
    </p>
    <p>
      chopstick[mod(y-1, 5)] = false;
    </p>
    <p>
      Thread.yield();
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      private void pickupLeft(final int y) {
    </p>
    <p>
      while(chopstick[y]);
    </p>
    <p>
      chopstick[y] = true;
    </p>
    <p>
      Thread.yield();
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      private void pickupRight(final int y) {
    </p>
    <p>
      while(chopstick[mod(y-1, 5)]);
    </p>
    <p>
      chopstick[mod(y-1, 5)] = true;
    </p>
    <p>
      Thread.yield();
    </p>
    <p>
      }
    </p>
    <p>
      }, "T"+i);
    </p>
    <p>
      thread[i].start();
    </p>
    <p>
      }
    </p>
    <p>
      Thread.sleep(1000);
    </p>
    <p>
      }
    </p>
    <p>
      private static int mod(int x, int y)
    </p>
    <p>
      {
    </p>
    <p>
      &#xa0;&#xa0;&#xa0;&#xa0;int result = x % y;
    </p>
    <p>
      &#xa0;&#xa0;&#xa0;&#xa0;return result &lt; 0? result + y : result;
    </p>
    <p>
      }
    </p>
    <p>
      }
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1352990634676" ID="ID_799194922" MODIFIED="1352990640067" TEXT="Questions">
<node CREATED="1352990641645" ID="ID_826291133" MODIFIED="1352990675692" TEXT="Provide deadlock-freedom solution"/>
<node CREATED="1352990676395" ID="ID_1323525016" MODIFIED="1352990686895" TEXT="Provide starvation-freedom solution"/>
</node>
</node>
<node CREATED="1353066114329" HGAP="-17" ID="ID_675371379" MODIFIED="1353066149314" POSITION="right" TEXT="Locks" VSHIFT="41">
<node CREATED="1353066152298" ID="ID_56763833" MODIFIED="1353066162721" TEXT="2-Thread Solutions">
<node CREATED="1353066117563" ID="ID_1801180038" MODIFIED="1353068524019" TEXT="The Peterson Lock">
<arrowlink DESTINATION="ID_1125124554" ENDARROW="Default" ENDINCLINATION="97;0;" ID="Arrow_ID_1213693734" STARTARROW="None" STARTINCLINATION="79;15;"/>
<node CREATED="1353066191971" HGAP="27" ID="ID_1663836454" MODIFIED="1353068520472" TEXT="Code">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      /**
    </p>
    <p>
      * 1. T1 T2
    </p>
    <p>
      * 2. i=0 i=1
    </p>
    <p>
      * 3. j=1 j=0
    </p>
    <p>
      * 4. flag[0]=true flag[1]=true
    </p>
    <p>
      * 5. victim=0; // i'm victim, i will wait ---
    </p>
    <p>
      *&#xa0;&#xa0;6. --- victim=1; //no, i'm victim, i will wait
    </p>
    <p>
      *&#xa0;&#xa0;7. out wait for flag[0] will 0
    </p>
    <p>
      */
    </p>
    <p>
      public void lock() {
    </p>
    <p>
      int i = ThreadID.get();
    </p>
    <p>
      int j = 1 - i;
    </p>
    <p>
      flag[i] = true; // I&#x2019;m interested
    </p>
    <p>
      victim = i; // you go first
    </p>
    <p>
      while (flag[j] &amp;&amp; victim == i) {}; // wait
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      public void unlock() {
    </p>
    <p>
      int i = ThreadID.get();
    </p>
    <p>
      flag[i] = false; // I&#x2019;m not interested
    </p>
    <p>
      }
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1353066122610" HGAP="35" ID="ID_22990724" MODIFIED="1353068516660" TEXT="The Filter Lock" VSHIFT="21">
<arrowlink DESTINATION="ID_1125124554" ENDARROW="Default" ENDINCLINATION="65;0;" ID="Arrow_ID_25645444" STARTARROW="None" STARTINCLINATION="65;0;"/>
</node>
</node>
<node CREATED="1353068426003" HGAP="32" ID="ID_849374036" MODIFIED="1353068505613" TEXT="2 kind-of" VSHIFT="17">
<node CREATED="1353068435003" ID="ID_1125124554" MODIFIED="1353073650489" TEXT="Spin Lock (Spinning)">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      If you keep trying, the lock is
    </p>
    <p>
      called a spin lock, and repeatedly testing the lock is called spinning
    </p>
  </body>
</html></richcontent>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1125124554" ENDARROW="Default" ENDINCLINATION="97;0;" ID="Arrow_ID_1213693734" SOURCE="ID_1801180038" STARTARROW="None" STARTINCLINATION="79;15;"/>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1125124554" ENDARROW="Default" ENDINCLINATION="65;0;" ID="Arrow_ID_25645444" SOURCE="ID_22990724" STARTARROW="None" STARTINCLINATION="65;0;"/>
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1353068538753" ID="ID_1809376675" MODIFIED="1353068539941" TEXT="Spinning is sensible when you expect the lock delay to be short."/>
<node CREATED="1353068847521" HGAP="26" ID="ID_284150638" MODIFIED="1353070747424" TEXT="Test-And-Set Locks" VSHIFT="19">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Each getAndSet() call is broadcast on the bus. Because all threads
    </p>
    <p>
      must use the bus to communicate with memory, these getAndSet() calls delay
    </p>
    <p>
      all threads, even those not waiting for the lock. Even worse, the getAndSet()
    </p>
    <p>
      call forces other processors to discard their own cached copies of the lock, so
    </p>
    <p>
      7.4 Exponential Backoff 147
    </p>
    <p>
      every spinning thread encounters a cache miss almost every time, and must use
    </p>
    <p>
      the bus to fetch the new, but unchanged value
    </p>
  </body>
</html></richcontent>
<node COLOR="#006699" CREATED="1353071699149" HGAP="19" ID="ID_1865817331" MODIFIED="1353073387566" TEXT="Problems" VSHIFT="8">
<richcontent TYPE="NOTE">&lt;html&gt;
  &lt;head&gt;
    
    
  &lt;/head&gt;
  &lt;body&gt;
    &lt;p&gt;
      Cache-coherence Traffic: All threads spin on the same shared location 
      causing
    &lt;/p&gt;
    &lt;p&gt;
      cache-coherence traffic on every successful lock access (though less 
      than with
    &lt;/p&gt;
    &lt;p&gt;
      the TASLock).
    &lt;/p&gt;
    &lt;p&gt;
      &amp;#2; Critical Section Underutilization: Threads delay longer than 
      necessary, causing
    &lt;/p&gt;
    &lt;p&gt;
      the the critical section to be underutilized.
    &lt;/p&gt;
  &lt;/body&gt;
&lt;/html&gt;</richcontent>
</node>
<node CREATED="1353070827174" ID="ID_1744918433" MODIFIED="1353070850049" TEXT="TTASLock">
<node CREATED="1353070752455" ID="ID_904118586" MODIFIED="1353070832752" TEXT="Code">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      package locks;
    </p>
    <p>
      
    </p>
    <p>
      import java.util.concurrent.TimeUnit;
    </p>
    <p>
      import java.util.concurrent.atomic.AtomicBoolean;
    </p>
    <p>
      import java.util.concurrent.locks.Condition;
    </p>
    <p>
      import java.util.concurrent.locks.Lock;
    </p>
    <p>
      
    </p>
    <p>
      public class TTASLock implements Lock {
    </p>
    <p>
      AtomicBoolean state = new AtomicBoolean(false);
    </p>
    <p>
      
    </p>
    <p>
      @Override
    </p>
    <p>
      public void lock() {
    </p>
    <p>
      while (true) {
    </p>
    <p>
      while (state.get()) {
    </p>
    <p>
      }
    </p>
    <p>
      ;
    </p>
    <p>
      if (!state.getAndSet(true))
    </p>
    <p>
      return;
    </p>
    <p>
      }
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      @Override
    </p>
    <p>
      public void unlock() {
    </p>
    <p>
      state.set(false);
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      @Override
    </p>
    <p>
      public void lockInterruptibly() throws InterruptedException {
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      @Override
    </p>
    <p>
      public boolean tryLock() {
    </p>
    <p>
      return !state.getAndSet(true);
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      @Override
    </p>
    <p>
      public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    </p>
    <p>
      return false;
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      @Override
    </p>
    <p>
      public Condition newCondition() {
    </p>
    <p>
      return null;
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      }
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1353070850049" ID="ID_1121697708" MODIFIED="1353071134270" TEXT="Behavior">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Now consider the behavior of the TTASLock algorithm while the lock is held by
    </p>
    <p>
      a thread A. The first time thread B reads the lock it takes a cache miss, forcing B
    </p>
    <p>
      to block while the value is loaded into B&#x2019;s cache. As long as A holds the lock,
    </p>
    <p>
      B repeatedly rereads the value, but hits in the cache every time. B thus produces
    </p>
    <p>
      no bus traffic, and does not slow down other threads&#x2019; memory accesses.
    </p>
    <p>
      Moreover, a thread that releases a lock is not delayed by threads spinning on
    </p>
    <p>
      that lock.
    </p>
    <p>
      
    </p>
    <p>
      The situation deteriorates, however, when the lock is released. The lock holder
    </p>
    <p>
      releases the lock by writing false to the lock variable, which immediately invalidates
    </p>
    <p>
      the spinners&#x2019; cached copies. Each one takes a cache miss, rereads the new
    </p>
    <p>
      value, and they all (more-or-less simultaneously) call getAndSet() to acquire the
    </p>
    <p>
      lock. The first to succeed invalidates the others, who must then reread the value,
    </p>
    <p>
      causing a storm of bus traffic. Eventually, the threads settle down once again to
    </p>
    <p>
      local spinning.
    </p>
    <p>
      This notion of local spinning, where threads repeatedly reread cached values
    </p>
    <p>
      instead of repeatedly using the bus, is an important principle critical to the design
    </p>
    <p>
      of efficient spin locks.
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1353071690633" HGAP="18" ID="ID_1678186636" MODIFIED="1353073385363" TEXT="BackoffLock">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      if (!state.getAndSet(true))
    </p>
    <p>
      return;
    </p>
    <p>
      else
    </p>
    <p>
      Thread.yield();
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1353073396019" ID="ID_1589724471" MODIFIED="1353073435379" TEXT="Queue Locks">
<node CREATED="1353073436035" HGAP="27" ID="ID_564033775" MODIFIED="1353073665396" TEXT="Array-Based Locks" VSHIFT="10">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      The <b>ALock</b>&#xa0;improves on BackoffLock because it reduces invalidations to a minimum,
    </p>
    <p>
      and minimizes the interval between when a lock is freed by one thread and
    </p>
    <p>
      when it is acquired by another. Unlike the TASLock and BackoffLock, this algorithm
    </p>
    <p>
      guarantees that no starvation occurs, and provides first-come-first-served
    </p>
    <p>
      fairness.
    </p>
    <p>
      Unfortunately, the ALock lock is not space-efficient. It requires a known bound
    </p>
    <p>
      n on the maximum number of concurrent threads, and it allocates an array of that
    </p>
    <p>
      size per lock. Thus, synchronizing L distinct objects requires O(Ln) space, even
    </p>
    <p>
      if a thread accesses only one lock at a time.
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1353068440284" ID="ID_643399757" MODIFIED="1353068637738" TEXT="Busy-waiting (Blocking)">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      The alternative is to suspend yourself and
    </p>
    <p>
      ask the operating system&#x2019;s scheduler to schedule another thread on your processor,
    </p>
    <p>
      which is sometimes called blocking. Because switching from one thread to
    </p>
    <p>
      another is expensive, blocking makes sense only if you expect the lock delay to
    </p>
    <p>
      be long.
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
</node>
</map>
