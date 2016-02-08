<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1454513820566" ID="ID_1159202562" LINK="Interview%20Areas.mm" MODIFIED="1454514108109" STYLE="bubble" TEXT="Design Patterns">
<node CREATED="1329206975557" HGAP="83" ID="ID_3452391" MODIFIED="1454523590640" POSITION="right" VSHIFT="10">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      Behaviour<br />Patterns
    </p>
  </body>
</html>
</richcontent>
<node CREATED="1329206990619" ID="ID_1350297685" MODIFIED="1454513842443" TEXT="Interpreter"/>
<node CREATED="1329206997244" ID="ID_1780277148" MODIFIED="1454513842443" TEXT="Iterator \ Cursor"/>
<node CREATED="1329207002244" ID="ID_121301661" MODIFIED="1454513842443" TEXT="Command \ Action \ Transaction"/>
<node CREATED="1329207132354" ID="ID_1409038606" MODIFIED="1454513842443" TEXT="Observer"/>
<node CREATED="1329207149963" ID="ID_328599478" MODIFIED="1454513842444" TEXT="Publish - Subscribe"/>
<node CREATED="1329207162323" ID="ID_952415931" MODIFIED="1454513842444" TEXT="Delegation Event Model"/>
<node CREATED="1329207179244" ID="ID_1302355595" MODIFIED="1454513842444" TEXT="Visitor"/>
<node CREATED="1329207182073" ID="ID_1293778698" MODIFIED="1454513842444" TEXT="Mediator">
<node CREATED="1400636566462" ID="ID_641629600" MODIFIED="1454513842445" TEXT="Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently. Design an intermediary to decouple many peers. Promote the many-to-many relationships between interacting peers to &quot;full object status&quot;."/>
</node>
<node CREATED="1329207184916" ID="ID_1686931544" MODIFIED="1454513842446" TEXT="State"/>
<node CREATED="1329207187573" ID="ID_1416928834" MODIFIED="1454513842446" TEXT="Strategy">
<node CREATED="1400637323962" ID="ID_1058045353" MODIFIED="1454513842446" TEXT="Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it."/>
<node CREATED="1400637334993" ID="ID_1309637289" MODIFIED="1454513842446" TEXT="Client---&gt;Abstraction(+doSomething())&lt;=====ConcreteAbstraction">
<font NAME="Dialog" SIZE="12"/>
</node>
</node>
<node CREATED="1329207191119" ID="ID_113259266" MODIFIED="1454513842447" TEXT="Memento">
<node CREATED="1400636706345" ID="ID_249275755" MODIFIED="1454513842447" TEXT="Without violating encapsulation, capture and externalize an object&apos;s internal state so that the object can be returned to this state later."/>
</node>
<node CREATED="1329207204276" ID="ID_646172058" MODIFIED="1454513842447" TEXT="Chain of Responsibility">
<node CREATED="1400636810277" ID="ID_724064507" MODIFIED="1454513842447" TEXT="Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it. Launch-and-leave requests with a single processing pipeline that contains many possible handlers. An object-oriented linked list with recursive traversal."/>
<node COLOR="#999999" CREATED="1400636834652" ID="ID_35711244" MODIFIED="1454513842448" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400636839388" ID="ID_1138470431" MODIFIED="1454513842449">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      if( I can handle it){
    </p>
    <p>
      handleIt();
    </p>
    <p>
      }else{
    </p>
    <p>
      next.handle();
    </p>
    <p>
      }
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1329207223619" ID="ID_32633190" MODIFIED="1454513842450" TEXT="Template Method">
<node CREATED="1400637122018" ID="ID_926608433" MODIFIED="1454513842450" TEXT="Basically it is a classical abstract class with abstract methods. Usually if some abstract method is used in an implementation method in this abstract class then this method is called the template method.&#xa;"/>
</node>
</node>
<node CREATED="1329207269369" ID="ID_433305086" MODIFIED="1454523599296" POSITION="right" VSHIFT="6">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      Creational<br />Patterns
    </p>
  </body>
</html>
</richcontent>
<node CREATED="1329207288838" ID="ID_1300911340" MODIFIED="1454513842451" TEXT="Abstract Factory"/>
<node CREATED="1329207307807" ID="ID_586524955" MODIFIED="1454513842451" TEXT="Kit"/>
<node CREATED="1329207310635" ID="ID_372479069" MODIFIED="1454513842451" TEXT="Singleton"/>
<node CREATED="1329207315807" ID="ID_1741143407" MODIFIED="1454513842452" TEXT="Prototype"/>
<node CREATED="1329207319057" ID="ID_768308821" MODIFIED="1454513842452" TEXT="Creator"/>
<node CREATED="1329207323588" ID="ID_628748589" MODIFIED="1454513842452" TEXT="Builder"/>
<node CREATED="1329207328901" ID="ID_1270303290" MODIFIED="1454513842452" TEXT="Factory Method \ Virtual Constructor"/>
</node>
<node CREATED="1329206952057" HGAP="16" ID="ID_1496395657" MODIFIED="1454523593113" POSITION="left" VSHIFT="-1">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Structure<br />Patterns
    </p>
  </body>
</html>
</richcontent>
<node CREATED="1329206787448" ID="ID_1738709343" MODIFIED="1454513842423" TEXT="Adapter \ Wrapper">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_738177902" MODIFIED="1454513842423" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1332158777866" ID="ID_1126113304" MODIFIED="1454513842423" TEXT="Introduced to organise object functions usage from specified interface."/>
<node CREATED="1332158904177" ID="ID_575004819" MODIFIED="1454513842423" TEXT="Translates one interface for a class into a compatible interface."/>
<node CREATED="1400633120005" ID="ID_714303472" MODIFIED="1454513842423" TEXT="Convert the interface of a class into another interface clients expect. "/>
<node CREATED="1400633140955" ID="ID_1716999487" MODIFIED="1454513842424" TEXT="Adapter lets classes work together that couldn&apos;t otherwise because of incompatible interfaces. "/>
<node CREATED="1400633151887" ID="ID_1910217374" MODIFIED="1454513842424" TEXT="&#xa;Wrap an existing class with a new interface. Impedance match an old component to a new system"/>
</node>
<node COLOR="#999999" CREATED="1332158740351" ID="ID_1669305068" MODIFIED="1454513842426" TEXT="Motivation">
<font NAME="SansSerif" SIZE="10"/>
</node>
<node COLOR="#999999" CREATED="1332158660523" ID="ID_74527019" MODIFIED="1454513842426" TEXT="Solve">
<font NAME="SansSerif" SIZE="10"/>
</node>
<node COLOR="#999999" CREATED="1332158702289" ID="ID_920408120" MODIFIED="1454513842427" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400635751164" ID="ID_463146664" MODIFIED="1454513842427">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Client---&gt;Adaptor===&gt;Adaptee1(+do1())&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;|========&gt;Adaptee2(+do2())
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1329206790338" ID="ID_1258750525" MODIFIED="1454513842430" TEXT="Decorator">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_18894441" MODIFIED="1454513842431" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400633428874" ID="ID_1713980562" MODIFIED="1454513842432" TEXT="Add new behaviour to the existing class without extending it"/>
</node>
</node>
<node CREATED="1329206843682" ID="ID_1474689256" MODIFIED="1454513842432" TEXT="Proxy \ Surrogate">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_1879155220" MODIFIED="1454513842432" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400633530694" ID="ID_1274745065" MODIFIED="1454513842433" TEXT="Provide a surrogate or placeholder for another object to control access to it. Use an extra level of indirection to support distributed, controlled, or intelligent access."/>
</node>
</node>
<node CREATED="1329206858041" ID="ID_319244367" MODIFIED="1454513842434" TEXT="Information Expert">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_241890711" MODIFIED="1454513842435" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
</node>
</node>
<node CREATED="1329206869198" FOLDED="true" ID="ID_625052204" MODIFIED="1454513842435" TEXT="Composite">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_1875547492" MODIFIED="1332158746319" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400634138672" ID="ID_529334466" MODIFIED="1400634140251" TEXT="Compose objects into tree structures to represent whole-part hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly. Recursive composition &quot;Directories contain entries, each of which could be a directory.&quot; 1-to-many &quot;has a&quot; up the &quot;is a&quot; hierarchy"/>
</node>
<node COLOR="#999999" CREATED="1400633996060" ID="ID_1695689178" MODIFIED="1400634016696" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400634634358" ID="ID_1523094063" MODIFIED="1400634763494">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Component&lt;------&lt;*&gt;Composite
    </p>
    <p>
      ^&#160;&#160;&#160;^_____________________|
    </p>
    <p>
      |
    </p>
    <p>
      |
    </p>
    <p>
      Leaf
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1329206880776" ID="ID_615137909" MODIFIED="1454513842435" TEXT="Bridge">
<node CREATED="1400634248203" ID="ID_273869746" MODIFIED="1454513842435" TEXT="Decouple an abstraction from its implementation so that the two can vary independently. Publish interface in an inheritance hierarchy, and bury implementation in its own inheritance hierarchy. Beyond encapsulation, to insulation"/>
<node COLOR="#999999" CREATED="1400634817711" ID="ID_1334350267" MODIFIED="1454513842437" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400634826134" ID="ID_1768002647" MODIFIED="1454513842437">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      _&gt;&#160;&#160;Abstraction&lt;&gt;------IImplementor(+do())&lt;===ConcreteImplementor
    </p>
    <p>
      |&#160;&#160;- impl:Implementor
    </p>
    <p>
      |
    </p>
    <p>
      |_ AbstractionImpl
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1329206892010" ID="ID_590060588" MODIFIED="1454513842439" TEXT="Flyweight">
<node COLOR="#999999" CREATED="1400635264614" ID="ID_1006401352" MODIFIED="1454513842440" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400635269510" ID="ID_1322419392" MODIFIED="1454513842440" TEXT="Use sharing to support large numbers of fine-grained objects efficiently"/>
</node>
<node COLOR="#999999" CREATED="1400635272398" ID="ID_896549023" MODIFIED="1454513842440" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400635276902" ID="ID_651650855" MODIFIED="1454513842440" TEXT=""/>
</node>
</node>
<node CREATED="1329206905713" ID="ID_975214571" MODIFIED="1454513842440" TEXT="Facade">
<node COLOR="#999999" CREATED="1400635677983" ID="ID_951218146" MODIFIED="1454513842441" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400635683910" ID="ID_1050033930" MODIFIED="1454513842441" TEXT="Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use. Wrap a complicated subsystem with a simpler interface"/>
</node>
</node>
<node CREATED="1400633064039" ID="ID_464563078" MODIFIED="1454513842442" TEXT="http://sourcemaking.com/design_patterns/structural_patterns"/>
</node>
</node>
</map>
