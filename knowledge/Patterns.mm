<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1329206750276" ID="ID_432205224" MODIFIED="1329207412323" STYLE="bubble" TEXT="Patterns">
<node CREATED="1329206920401" ID="ID_332886420" MODIFIED="1329207919338" POSITION="right" TEXT="Design Patterns">
<node CREATED="1329206952057" HGAP="78" ID="ID_1496395657" MODIFIED="1329207928166" TEXT="Structure Patterns" VSHIFT="24">
<node CREATED="1329206787448" ID="ID_1738709343" MODIFIED="1332158059453" TEXT="Adapter \ Wrapper">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_738177902" MODIFIED="1332158746319" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1332158777866" ID="ID_1126113304" MODIFIED="1332158823240" TEXT="Introduced to organise object functions usage from specified interface."/>
<node CREATED="1332158904177" ID="ID_575004819" MODIFIED="1332158909161" TEXT="Translates one interface for a class into a compatible interface."/>
<node CREATED="1400633120005" ID="ID_714303472" MODIFIED="1400633157710" TEXT="Convert the interface of a class into another interface clients expect. "/>
<node CREATED="1400633140955" ID="ID_1716999487" MODIFIED="1400633151886" TEXT="Adapter lets classes work together that couldn&apos;t otherwise because of incompatible interfaces. "/>
<node CREATED="1400633151887" ID="ID_1910217374" MODIFIED="1400633151888" TEXT="&#xa;Wrap an existing class with a new interface. Impedance match an old component to a new system"/>
</node>
<node COLOR="#999999" CREATED="1332158740351" ID="ID_1669305068" MODIFIED="1332158746319" TEXT="Motivation">
<font NAME="SansSerif" SIZE="10"/>
</node>
<node COLOR="#999999" CREATED="1332158660523" ID="ID_74527019" MODIFIED="1332158746319" TEXT="Solve">
<font NAME="SansSerif" SIZE="10"/>
</node>
<node COLOR="#999999" CREATED="1332158702289" ID="ID_920408120" MODIFIED="1332158977691" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400635751164" ID="ID_463146664" MODIFIED="1400635995800">
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
</html>
</richcontent>
</node>
</node>
</node>
<node CREATED="1329206790338" ID="ID_1258750525" MODIFIED="1332158062875" TEXT="Decorator">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_18894441" MODIFIED="1332158746319" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400633428874" ID="ID_1713980562" MODIFIED="1400633485994" TEXT="Add new behaviour to the existing class without extending it"/>
</node>
</node>
<node CREATED="1329206843682" ID="ID_1474689256" MODIFIED="1329206857401" TEXT="Proxy \ Surrogate">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_1879155220" MODIFIED="1332158746319" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400633530694" ID="ID_1274745065" MODIFIED="1400633532400" TEXT="Provide a surrogate or placeholder for another object to control access to it. Use an extra level of indirection to support distributed, controlled, or intelligent access."/>
</node>
</node>
<node CREATED="1329206858041" ID="ID_319244367" MODIFIED="1329206868744" TEXT="Information Expert">
<node COLOR="#999999" CREATED="1332158653914" ID="ID_241890711" MODIFIED="1332158746319" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
</node>
</node>
<node CREATED="1329206869198" FOLDED="true" ID="ID_625052204" MODIFIED="1400635087506" TEXT="Composite">
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
</html>
</richcontent>
</node>
</node>
</node>
<node CREATED="1329206880776" ID="ID_615137909" MODIFIED="1400635094167" TEXT="Bridge">
<node CREATED="1400634248203" ID="ID_273869746" MODIFIED="1400634249247" TEXT="Decouple an abstraction from its implementation so that the two can vary independently. Publish interface in an inheritance hierarchy, and bury implementation in its own inheritance hierarchy. Beyond encapsulation, to insulation"/>
<node COLOR="#999999" CREATED="1400634817711" ID="ID_1334350267" MODIFIED="1400634822209" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400634826134" ID="ID_1768002647" MODIFIED="1400635213951">
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
</html>
</richcontent>
</node>
</node>
</node>
<node CREATED="1329206892010" ID="ID_590060588" MODIFIED="1329206905307" TEXT="Flyweight">
<node COLOR="#999999" CREATED="1400635264614" ID="ID_1006401352" MODIFIED="1400635268336" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400635269510" ID="ID_1322419392" MODIFIED="1400635270681" TEXT="Use sharing to support large numbers of fine-grained objects efficiently"/>
</node>
<node COLOR="#999999" CREATED="1400635272398" ID="ID_896549023" MODIFIED="1400635276512" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400635276902" ID="ID_651650855" MODIFIED="1400635276902" TEXT=""/>
</node>
</node>
<node CREATED="1329206905713" ID="ID_975214571" MODIFIED="1329206916744" TEXT="Facade">
<node COLOR="#999999" CREATED="1400635677983" ID="ID_951218146" MODIFIED="1400635683024" TEXT="Goal">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400635683910" ID="ID_1050033930" MODIFIED="1400635687153" TEXT="Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use. Wrap a complicated subsystem with a simpler interface"/>
</node>
</node>
<node CREATED="1400633064039" ID="ID_464563078" MODIFIED="1400633066418" TEXT="http://sourcemaking.com/design_patterns/structural_patterns"/>
</node>
<node CREATED="1329206975557" HGAP="83" ID="ID_3452391" MODIFIED="1331911921536" TEXT="Behaviour Patterns" VSHIFT="10">
<node CREATED="1329206990619" ID="ID_1350297685" MODIFIED="1329206996776" TEXT="Interpreter"/>
<node CREATED="1329206997244" ID="ID_1780277148" MODIFIED="1329207097666" TEXT="Iterator \ Cursor"/>
<node CREATED="1329207002244" ID="ID_121301661" MODIFIED="1329207014151" TEXT="Command \ Action \ Transaction"/>
<node CREATED="1329207132354" ID="ID_1409038606" MODIFIED="1329207149604" TEXT="Observer"/>
<node CREATED="1329207149963" ID="ID_328599478" MODIFIED="1329207161901" TEXT="Publish - Subscribe"/>
<node CREATED="1329207162323" ID="ID_952415931" MODIFIED="1329207173448" TEXT="Delegation Event Model"/>
<node CREATED="1329207179244" ID="ID_1302355595" MODIFIED="1329207181463" TEXT="Visitor"/>
<node CREATED="1329207182073" ID="ID_1293778698" MODIFIED="1329207184479" TEXT="Mediator">
<node CREATED="1400636566462" ID="ID_641629600" MODIFIED="1400636567656" TEXT="Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently. Design an intermediary to decouple many peers. Promote the many-to-many relationships between interacting peers to &quot;full object status&quot;."/>
</node>
<node CREATED="1329207184916" ID="ID_1686931544" MODIFIED="1329207187307" TEXT="State"/>
<node CREATED="1329207187573" ID="ID_1416928834" MODIFIED="1329207190619" TEXT="Strategy">
<node CREATED="1400637323962" ID="ID_1058045353" MODIFIED="1400637333508" TEXT="Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it."/>
<node CREATED="1400637334993" ID="ID_1309637289" MODIFIED="1400637493932" TEXT="Client---&gt;Abstraction(+doSomething())&lt;=====ConcreteAbstraction">
<font NAME="Geneva" SIZE="12"/>
</node>
</node>
<node CREATED="1329207191119" ID="ID_113259266" MODIFIED="1329207203760" TEXT="Memento">
<node CREATED="1400636706345" ID="ID_249275755" MODIFIED="1400636707652" TEXT="Without violating encapsulation, capture and externalize an object&apos;s internal state so that the object can be returned to this state later."/>
</node>
<node CREATED="1329207204276" ID="ID_646172058" MODIFIED="1329207213823" TEXT="Chain of Responsibility">
<node CREATED="1400636810277" ID="ID_724064507" MODIFIED="1400636811304" TEXT="Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it. Launch-and-leave requests with a single processing pipeline that contains many possible handlers. An object-oriented linked list with recursive traversal."/>
<node COLOR="#999999" CREATED="1400636834652" ID="ID_35711244" MODIFIED="1400636839158" TEXT="Example">
<font NAME="SansSerif" SIZE="10"/>
<node CREATED="1400636839388" ID="ID_1138470431" MODIFIED="1400636964492">
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
</html>
</richcontent>
</node>
</node>
</node>
<node CREATED="1329207223619" ID="ID_32633190" MODIFIED="1329207227541" TEXT="Template Method">
<node CREATED="1400637122018" ID="ID_926608433" MODIFIED="1400637285243" TEXT="Basically it is a classical abstract class with abstract methods. Usually if some abstract method is used in an implementation method in this abstract class then this method is called the template method.&#xa;"/>
</node>
</node>
<node CREATED="1329207269369" ID="ID_433305086" MODIFIED="1331911924223" TEXT="Creational Patterns" VSHIFT="6">
<node CREATED="1329207288838" ID="ID_1300911340" MODIFIED="1329207299994" TEXT="Abstract Factory"/>
<node CREATED="1329207307807" ID="ID_586524955" MODIFIED="1329207310385" TEXT="Kit"/>
<node CREATED="1329207310635" ID="ID_372479069" MODIFIED="1329207315573" TEXT="Singleton"/>
<node CREATED="1329207315807" ID="ID_1741143407" MODIFIED="1329207318838" TEXT="Prototype"/>
<node CREATED="1329207319057" ID="ID_768308821" MODIFIED="1329207323338" TEXT="Creator"/>
<node CREATED="1329207323588" ID="ID_628748589" MODIFIED="1329207328494" TEXT="Builder"/>
<node CREATED="1329207328901" ID="ID_1270303290" MODIFIED="1329207358260" TEXT="Factory Method \ Virtual Constructor"/>
</node>
<node COLOR="#338800" CREATED="1329209291901" ID="ID_215352219" MODIFIED="1329209301010" TEXT="Questions">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
<node CREATED="1329207390260" HGAP="28" ID="ID_376590417" MODIFIED="1332397159524" POSITION="left" TEXT="Arhitectural Patterns">
<node CREATED="1329207979213" HGAP="28" ID="ID_380832359" MODIFIED="1329209273682" TEXT="Unstructored" VSHIFT="42">
<node CREATED="1329208071510" ID="ID_259642574" MODIFIED="1329208077057" TEXT="Peer to Peer"/>
<node CREATED="1329208092010" ID="ID_869172172" MODIFIED="1329208123213" STYLE="bubble" TEXT="Naked Objects"/>
<node CREATED="1329208157666" ID="ID_1066746508" MODIFIED="1329208172651" TEXT="Event-driven"/>
<node CREATED="1329207628229" ID="ID_1154636956" MODIFIED="1329207631932" TEXT="Callback"/>
<node CREATED="1329207477463" ID="ID_1865526868" MODIFIED="1329208062229" TEXT="Pipe and Filter"/>
<node CREATED="1329207452885" ID="ID_1449077052" MODIFIED="1329207459026" TEXT="Client - Server"/>
</node>
<node CREATED="1329208219760" HGAP="147" ID="ID_499991783" MODIFIED="1332157896424" TEXT="http://martinfowler.com/eaaCatalog/" VSHIFT="26"/>
<node CREATED="1329208553432" HGAP="151" ID="ID_1659380379" MODIFIED="1332157894205" TEXT="http://design-pattern.ru/patterns" VSHIFT="26"/>
<node CREATED="1329208812354" HGAP="158" ID="ID_1018340595" MODIFIED="1332157892768" TEXT="Data Source Architectural Patterns" VSHIFT="10">
<node CREATED="1329207900604" ID="ID_1713079971" MODIFIED="1329207913510" TEXT="Table Data Gateway"/>
<node CREATED="1329208977463" ID="ID_1819688957" MODIFIED="1329208982510" TEXT="Row Data Geteway"/>
<node CREATED="1329207732432" ID="ID_1351256440" MODIFIED="1329207737776" TEXT="Active Record"/>
<node CREATED="1329207468244" ID="ID_253682310" MODIFIED="1329207473276" TEXT="Data Mapper"/>
</node>
<node CREATED="1329208815041" HGAP="123" ID="ID_1264442487" MODIFIED="1332157891049" TEXT="Domain Logic Patterns" VSHIFT="16">
<node CREATED="1329207473510" ID="ID_343130515" MODIFIED="1329208929604" TEXT="Service Layers"/>
<node CREATED="1329207459291" ID="ID_588875252" MODIFIED="1329207467994" TEXT="Domain Model"/>
<node CREATED="1329208945635" ID="ID_1017391954" MODIFIED="1329208949510" TEXT="Table Model"/>
<node CREATED="1329208949916" ID="ID_372850054" MODIFIED="1329208954916" TEXT="Transaction Script"/>
<node CREATED="1352881477046" ID="ID_528428139" MODIFIED="1352881482171" TEXT="Anemic Domain Model"/>
</node>
<node CREATED="1329208826182" HGAP="274" ID="ID_1935984520" MODIFIED="1332157349790" TEXT="Object-Relational Behavioral Patterns" VSHIFT="-3">
<node CREATED="1329207738213" ID="ID_1235377252" MODIFIED="1329207744229" TEXT="Unit of Work"/>
<node CREATED="1329207744494" ID="ID_1473485120" MODIFIED="1329207748729" TEXT="Lazy Load"/>
<node CREATED="1329207748948" ID="ID_867794978" MODIFIED="1329207755682" TEXT="Identity Map"/>
</node>
<node CREATED="1329208832041" HGAP="274" ID="ID_482244644" MODIFIED="1332157351665" TEXT="Object-Relational Structural Patterns" VSHIFT="9">
<node CREATED="1329207763026" ID="ID_4064173" MODIFIED="1329207770541" TEXT="Single Table Inheritance"/>
<node CREATED="1329207770791" ID="ID_1560133872" MODIFIED="1329207779182" TEXT="Class Table Inheritance"/>
<node CREATED="1329207879948" ID="ID_878406077" MODIFIED="1329207884244" TEXT="Identity Field"/>
<node CREATED="1329207849510" ID="ID_1087047446" MODIFIED="1329209066182" TEXT="Association Table Model\Mapping"/>
</node>
<node CREATED="1329208839682" HGAP="242" ID="ID_279026889" MODIFIED="1332157353509" TEXT="Object-Relational Metadata Mapping Patterns" VSHIFT="6">
<node CREATED="1329207447526" ID="ID_612005171" MODIFIED="1329207452416" TEXT="Repository"/>
</node>
<node CREATED="1329208845573" HGAP="172" ID="ID_632046599" MODIFIED="1332157355025" TEXT="Web Presentation Patterns" VSHIFT="18">
<node CREATED="1329207989198" ID="ID_366180501" MODIFIED="1329207997088" TEXT="Model View Controller"/>
<node CREATED="1329207997494" ID="ID_160141598" MODIFIED="1329208020401" TEXT="Presentation Abstraction Control"/>
<node CREATED="1329208020854" ID="ID_1163548373" MODIFIED="1329208026885" TEXT="Model View Presenteer"/>
<node CREATED="1329208027135" ID="ID_938024226" MODIFIED="1329208036057" TEXT="Model View ViewModel"/>
</node>
<node CREATED="1329208853463" HGAP="165" ID="ID_1842539956" MODIFIED="1332157886643" TEXT="Distribution Patterns" VSHIFT="34">
<node CREATED="1329209111354" ID="ID_1191938297" MODIFIED="1329209115291" TEXT="Remote Facade"/>
<node CREATED="1329209115698" ID="ID_1919100787" MODIFIED="1329209125213" TEXT="Data Transfer Object"/>
</node>
<node CREATED="1329208430901" HGAP="143" ID="ID_1794791899" MODIFIED="1332157885487" TEXT="Offline Concurrency Patterns" VSHIFT="41">
<node CREATED="1329207839213" ID="ID_1352860583" MODIFIED="1329207849073" TEXT="Optimistic Offline Lock">
<node CREATED="1400637828192" ID="ID_546718067" MODIFIED="1400637829634" TEXT="Prevents conflicts between concurrent business transactions by detecting a conflict and rolling back the transaction."/>
</node>
<node CREATED="1329207861901" ID="ID_1949477643" MODIFIED="1329208346963" TEXT="Pessimistic Offline Lock"/>
<node CREATED="1329208355276" ID="ID_1414434205" MODIFIED="1329208363713" TEXT="Coarse Grained Lock"/>
<node CREATED="1329208364213" ID="ID_1930664881" MODIFIED="1329208371307" TEXT="Implicit Lock"/>
</node>
<node CREATED="1329208872682" HGAP="110" ID="ID_38133799" MODIFIED="1332157882940" TEXT="Session State Patterns" VSHIFT="43">
<node CREATED="1329209162135" ID="ID_1604880812" MODIFIED="1329209165994" TEXT="Client Session State"/>
<node CREATED="1329209168588" ID="ID_1005732580" MODIFIED="1329209173323" TEXT="Server Session State"/>
<node CREATED="1329209173963" ID="ID_589409665" MODIFIED="1329209181588" TEXT="Database Session State"/>
</node>
<node CREATED="1329208888573" HGAP="79" ID="ID_1389542787" MODIFIED="1332157368587" TEXT="Base Patterns" VSHIFT="29">
<node CREATED="1329209189698" ID="ID_1783930108" MODIFIED="1329209192432" TEXT="Gateway"/>
<node CREATED="1329209192666" ID="ID_563098174" MODIFIED="1329209195041" TEXT="Mapper"/>
<node CREATED="1329209195276" ID="ID_1099055605" MODIFIED="1329209203651" TEXT="Layer Supertype"/>
<node CREATED="1329209206135" ID="ID_1366900491" MODIFIED="1329209210010" TEXT="Separated Interface"/>
<node CREATED="1329209210229" ID="ID_1406290960" MODIFIED="1329209214901" TEXT="Registry"/>
<node CREATED="1329209215494" ID="ID_1867631755" MODIFIED="1329209222510" TEXT="Value Object"/>
<node CREATED="1329209222994" ID="ID_1764641443" MODIFIED="1329209225588" TEXT="Money"/>
<node CREATED="1329209226119" ID="ID_1724900928" MODIFIED="1329209229979" TEXT="Special Case"/>
<node CREATED="1329209230385" ID="ID_1405967186" MODIFIED="1329209238979" TEXT="Service Stub"/>
<node CREATED="1329209239479" ID="ID_1808703767" MODIFIED="1329210140604" TEXT="Record Set">
<node CREATED="1329210066541" FOLDED="true" ID="ID_1532998060" MODIFIED="1329210184510" TEXT="Scheme">
<node CREATED="1329210078588" HGAP="18" ID="ID_506479201" MODIFIED="1329210182994">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <img src="recordSetSketch.gif"/>
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
</node>
<node COLOR="#338800" CREATED="1329209291901" ID="ID_550448140" MODIFIED="1329209301010" TEXT="Questions">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
</node>
</node>
</node>
</map>