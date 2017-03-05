
----------------------------------------SCALA PATTERNS----------------------------------------------------

 -------------------
|Creational Patterns|
 -------------------

--------------------------------------
//

1)	Abstract Factory

	Provide an interface for creating families of related or dependent objects without
	specifying the concrete classes.


*	Listing 5.1: Abstract Factory trait

	trait WindowFactory {
		type aWindow <: Window
		type aScrollbar <: Scrollbar

		def createWindow(s:aScrollbar) 

		def createScrollbar()

		abstract class Window(s: aScrollbar)
		
		abstract class Scrollbar
	}

*	Listing 5.2: Abstract Factory example usage


	object VistaFactory extends WindowFactory {
		
		type aWindow = VistaWindow
		type aScrollbar = VistaScrollbar
		
		def createWindow(s:aScrollbar) = new VistaWindow(s) 
		def createScrollbar () = new VistaScrollbar
		
		val window:aWindow = new VistaWindow(scrollbar) 
		val scrollbar: aScrollbar = new VistaScrollbar
		
		protected class VistaWindow(s:aScrollbar) extends Window(s)
		protected class VistaScrollbar extends Scrollbar 
	}



	trait VistaWidgets {
		// the self type annotation
		self:WindowFactory =>

		protected class VistaWindow(s:aScrollbar) extends Window(s)
		protected class VistaScrollbar extends Scrollbar
	}


Summarising on the qualities not present in the original GOF solution:

	• Product-interdependence: Impossible to mix products from different factories. 
	• Singleton factories are trivial to implement.
	• Nested product classes: Implementation classes are easily hidden from clients.

2)	Builder

	“Separate the construction of a complex object from its representation so that
	the same construction process can create different representations.”

	We can simulate multiple dispatch with pattern matching.

	t match {
		case c @ Character() => convert(c)
		case f @ Font() => convert(f)
	}
	def convert(t:Font) = println("Converting font")
	def convert(t:Character) = println("Converting character")


3)	Factory Method

	“Define an interface for creating an object, but let subclasses decide which class to instantiate. 
	Factory Method lets a class defer instantiation to sub- classes.”

	trait Document { 
		def open
		def close
	}

	trait Application { 
		type D <: Document
		var docs = List[D]()
		def newDocument = {
			val doc = new D //Illegal! Cannot instantiate types 
			docs = doc::docs
			doc.open
		}
	}

*	Listing 5.3: Factory Method solution

	
	trait Document { 
		def open
		def close
	}

	trait Application { 
		type D <: Document 
		var docs = List[D]()
		def newDocument = {
			val doc = createDocument 
			docs = doc::docs
			doc . open
		}
		//Factory method
		def createDocument:D
	
	}


4)	Prototype

	“Specify the kinds of objects to create using a prototypical instance,
	and create new objects by copying this prototype.”

*	Listing 5.4: Adding a clone method

	class CloneA(a:A) {
		def copy = new A(a.state)
	}

	implicit def cloneA(a:A): CloneA = new CloneA(a)

	class A(var state:Int)
	
	def main(args:Array[String]) = { 
		def a = new A(2)
		println(a.state)
		def aCopy = a.copy
		println(a. state)
	}


5)	Singleton

	“Ensure a class only has one instance, and provide a global point of access to it.”

*	Listing 5.5: Singleton in Scala

	/ / companion object
	object Singleton {
		private val instance : Single = new Single 
		def getInstance ( ) = instance
	}

	class Singleton private() // private constructor 

	val s = Singleton . getInstance ()




 -------------------
|Structural Patterns|
 -------------------

--------------------------------------
//

1)	Adapter

	“Convert the interface of a class into another interface clients expect. 
	 Adapter lets classes work together that could not otherwise because of incompatible interfaces.” 

*	Listing 6.1: Adapter in Scala

	trait Target {
		def f
	}

	class Adaptee {
		def g = println("g")
	}

	trait Adapter {
		self : Target with Adaptee => 
		def f = g
	}

	def main(args:Array[String]) = {
		val adapter = new Adaptee with Adapter with Target 
		adapter . f
		adapter . g
		()
	}


2)	Bridge

	“Decouple an abstraction from its implementation so that the two can vary.”

*	Listing 6.2: Bridge in Scala

	trait Window {
		self : WindowImp =>
		def drawRect(x1:Int ,x2:Int ,x3:Int ,x4:Int) = { 
			drawline(x1,x2)
			drawLine(x1,x3)
			drawLine(x2,x4)
 			drawLine(x3,x4)
 		}
	}
	//
	trait TransientWindow {
		self: Window =>
		def drawCloseBox = drawRect(4,3,2,1)
	}
	
	trait IconWindow {
		self: Window => 
		def drawBorder = drawRect(1,2,3,4)
	}

	// common interface for all implementors
	trait WindowImp {
		def drawLine(x:Int,y:Int)
	}

	// implementors
	trait WindowOSX extends WindowImp {
		def drawLine(x:Int,y:Int) = println("drawing line in OSX")
	}
	
	trait WindowVista extends WindowImp {
		def drawLine(x:Int,y:Int) = println("drawing line in Vista")
	}

	def main(args:Array[String]) = {
		val windowOSX:Window = new Window with WindowOSX
		windowOSX.drawRect(1,2,3,4)
	}



3)	Composite

	
“Compose objects into tree structures to represent part-whole hierarchies.
 Composite lets clients treat individual objects and compositions of objects uniformly.”

 [A domain where the composite pattern can be applied naturally is in the context of a text editor. 
  Documents consists of pages which consists of columns, which in turn consists of lines of text and images,
  and so forth.]	 


*	Listing 6.3: Composite implementation in Scala

	sealed abstract class Component { 
		def display
	}
	
	case class Text(var text:String) extends Component {
 		def display = println(text)
	}


	class Picture (var picture : String ) extends Component { 
		def display = println(picture)
	}

	case class Composite(var children : List [Component]) extends Component = 
		def display = children.foreach(x => x.display)
	}

	def main(args:Array[String]) = {
		val tree =
		Composite(List(Composite(List(Text("t1") ,Picture("p1"))) ,Text("t2"))) 
		tree.display
		tree.children(1).display
	}

	(this gives us a type-safe way of traversing and altering the structure via pattern matching.)




4)	Decorator

	“Attach additional responsibilities to an object dynamically. Decorators provide
	a flexible alternative to subclassing for extending functionality.”


	trait Component {
		def draw
	}

	class EncapsulateTextView (c:TextView) extends Component { 
		def draw = c.draw
	}

	class TextView (var s:String) extends Component { 
		def draw = println("Drawing.." + s)
	}

	trait BorderDecorator extends Component {
		abstract override def draw = { super.draw ; drawBorder } 
		def drawBorder = println("Drawing border")
	}

	trait ScrollDecorator extends Component {
		abstract override def draw = { scrollTo ; super.draw }
		def scrollTo = println("Scrolling..")
	}

	def main(args: Array[String]) = {
		val tw = new TextView("foo")
		val etw1 = new EncapsulateTextView(tw) with BorderDecorator with ScrollDecorator 
		etw1.draw
		tw.s = "bar"
		val etw2 = new EncapsulateTextView(tw) with ScrollDecorator with BorderDecorator
		etw2.draw
		()
	}


5)	Facade
	
	“Provide a unified interface to a set of interfaces in a subsystem. 
	 Facade defines a higher-level interface that makes the subsystem easier to use.”

*	Listing 6.4: Facade in Scala

	trait Facade {
		type A <: SubSystemA
		type B <: SubSystemB
		
		protected val subA:A
		protected val subB:B

		def foo = subB.foo(subA)

		protected class SubSystemA
		protected class SubSystemB {
			def foo(sub:SubSystemA) = println("Calling foo") 
		}
	}

	object FacadeA extends Facade {
		type A = SubSystemA
		type B = SubSystemB
		val subA:A = new SubSystemA
		val subB:B = new SubSystemB
	}


	Summarising on the qualities of our solution compared to the original:
		• Subsystemclassesarehiddenfromclients.
		• Moreoppurtiniesforreuseandrefinementsoffacades,becauseofabstracttypes.


6)	Flyweight

	“Use sharing to support large numbers of fine-grained objects efficiently.”


*	Listing 6.5: Flyweight Factory Component
	
	trait FlyWeightFactory[T1,T2] extends Function[T1,T2]{ 
		
		private var pool = Map[T1,T2]()
		
		def createFlyWeight( intrinsic :T1) :T2
		
		def apply(index:T1):T2 = { pool.get(index) match {
			case Some(f) => f
			case None => {
				pool += (index −> createFlyWeight(index))
				pool ( index ) }
			}
		}
		
		def update(index:T1, elem:T2) { pool(index) = elem }
	}


*	Listing 6.6: Example usage of reusable flyweight factory
		
		trait DrawingContext { def queryExtrinsicState }

		class Character(val char:Char) {
			def draw(context:DrawingContext) = println("drawing character")
		}

		object CharacterFactory extends FlyWeightFactory[Char,Character] {
			def createFlyWeight(c:Char) = new Character(c)
		}
		
		val f1 = CharacterFactory(’a’)
		val f2 = CharacterFactory(’b’)
		val f3 = CharacterFactory(’a’)


7)	Proxy

	“Provide a surrogate or placeholder for another object to control access to it.”

	class VirtualProxy {
		lazy val expensiveOperation = List(1 to 1000000000)
	}

 -------------------
|Behavioral Patterns|
 -------------------

--------------------------------------
//

1)	Chain of Responsibility

	
	“Avoid coupling the sender of a request to its receiver by giving more than one object
	a chance to handle the request. Chain the receiving objects and pass the request along the chain
	until an object handles it.”


*	Listing 7.1: Reusable generic handler
		
		trait Handler[T] {
			var successor:Handler[T] = null
			def handleRequest(r:T):Unit =
				if (handlingCriteria(r)) doThis(r)
				else if (successor != null) 
					successor.handleRequest(r)
				
			def doThis(v:T):Unit = ()
			def handlingCriteria(request :T): Boolean = false
		}

*	Listing 7.2: Example usage of handler trait

		class Sensor extends Handler[Int] {
			var value = 0
			def changeValue(v:Int) {
				value = v
				handleRequest(value)
			}
		}

		class Display1 extends Handler[Int] {
			def show(v:Int) = println(v)
			override def doThis(v:Int) = show(v)
			override def handlingCriteria(v:Int):Boolean = v < 4
		}

		class Display2 {
			def show(v:Int) = println(v)
		}

		// another solution, pattern specific code is kept in separate trait
		trait Display2Handler extends Display2 with Handler[ Int ] {
			override def doThis(v:Int) = show(v)
			override def handlingCriteria(v:Int):Boolean = v >= 4
		}

		def main(args: Array[String]) = {
			val sensor = new Sensor
			val display1 = new Display1
			val display2 = new Display2 with Display2Handler
			sensor.successor = display1
			display1.successor = display2 sensor.changeValue(2) sensor.changeValue(4)
		}


	Summarising:
	• Patterniscomponentized,resulting in improved reusability
	• Improved traceability.
	• Pattern specific code can be completely localised, which makes it non-intrusive.


2)	Command

	“Encapsulate a request as an object, thereby letting you parameterize clients 
	with different requests, queue or log requests, and support undoable operations.”


	trait Undoable { def undo }

	class CallBack extends ( ( ) => Unit ) with Undoable { 
		def apply():Unit = println("callback!")
		def undo = println("undoing!")
	}

	object History {
		var commands: List [(() => Unit) with Undoable] = 
			List () val undoAll = commands.foreach(_.undo)
	}


3)	Interpreter

	“Given a language, define a representation for its grammar along with
	an interpreter that uses the representation to interpret sentences in the language.”


4)	Iterator

	“Provide a way to access the elements of an aggregate object sequentially
	without exposing its underlying representation.” 


	The iterator pattern is integrated in the Scala language itself.
	If a collection defines the higher-order functions map, flatMap, filter
	and foreach it can be used with for-comprehensions.

*	Listing 7.3: Iterator in Scala

	object MyCollection {
		private var items = List (1 ,2 ,3)
		def foreach(f: Int => Unit) =
			for( i <− 0 to items.length−1)
				f(items(i))
	}

	for(i <− MyCollection) 
		println(i)

	Qualities of our solution:
	• Deep integration with the Scala language.
	• Concise: The integration allows us to use succinct syntactic sugar.

5)	Mediator

	“Define an object that encapsulates how a set of objects interact.
	Mediator promotes loose coupling by keeping objects from referring to each other
	explicitly, and it lets you vary their interaction independently.”


*	Listing 7.4: Mediator in Scala

	// Widgets
	class ListBox {
		def getSelection: String = "selected"
		def click = ()
	}

	class EntryField {
		def setText(s: String) = println(s)
	}

	class DialogDirector {
		//Colleagues
		val listBox : ListBox = new ListBox with ListBoxDir
		val entryField : EntryField = new EntryField

		// Directing methods
		def showDialog = ()
		// called when listbox is clicked via advice
		def listBoxChanged = entryField.setText(listBox.getSelection)

		protected trait ListBoxDir extends ListBox { 
			abstract override def click = {
			super. click
			listBoxChanged 
			}
		}
	}

	val dialog = new DialogDirector
	val listBox = dialog.listBox
	val entryField = dialog.entryField
	listBox . click


6)	Memento

	“Without violating encapsulation, capture and externalize an objects internal
	 state so that the object can be restored to this state later.”


*	Listing 7.5: Memento in Scala

   	trait Originator {
	   	def createMemento:Memento
		def setMemento(m:Memento)
		trait Memento {
			def getState [Originator]
			def setState [Originator]
		}
	}

7)	Observer

	“Define a one-to-many dependency between objects so that when one object changes state,
	all its dependents are notified and updated automatically.”

	trait Subject [T] {
		self: T =>
		private var observers: List[T => Unit] = Nil
		def subscribe(obs: T => Unit) = observers = obs :: observers 
		def unsubscribe ( obs : T => Unit ) = observers = observers − obs 
		protected def publish = for (obs <− observers) 
		obs(this)
	}

	class Sensor(val label:String) { 
		var value:Double = _
		def changeValue(v: Double) = {
			value = v 
		}
	}

	// Pattern specific code
	trait SensorSubject extends Sensor with Subject[Sensor] {
		override def changeValue(v: Double) = {
			super.changeValue(v)
			publish
		}
	}

	class Display (label:String) {
		def notify(s: Sensor) =
			println(label + " " + s.label + " " + s.value)
	}

	def main(args: Array[String]) = {
		val s1 = new Sensor("s1") with SensorSubject
		val d1 = new Display("d1")
		val d2 = new Display("d2")
		s1.subscribe(d1.notify)
		s1.subscribe(d2.notify)
		s1.changeValue(10)
	}

8)	State

	“Allow an object to alter its behaviour when its internal state changes.
	 The object will appear to change its class.”

*	Listing 7.8: State pattern in Scala

	class Context {
		private var currentState : State = State1
		
		def operation = currentState.operation
		
		trait State {
			def operation
		}
		
		private object State1 extends State {
			def operation = {
				println("State1"); 
				currentState = State2
			}
		}
		private object State2 extends State {
			def operation = { 
				println("State2");
				currentState = State1 
			}
		}
	}
	def main(args:Array[String]) = {
		val c = new Context
		c.operation
		c.operation
		c.operation
		()
	}

9)	Strategy

	“Define a family of algorithms, encapsulate each one,
	and make them interchangeable. Strategy lets the algorithm
	vary independently from clients that use it.”

*	Listing 7.10: Strategy pattern in Scala

	object FileMatcher {
		private val filesHere = (new java.io.File(".")).listFiles
		// matcher is a strategy
		private def filesMatching(matcher: String => Boolean) = 
			for (file <− filesHere; if matcher(file.getName))
				yield file
		// Strategy selection
		def filesContaining(query: String) =
			filesMatching { x => x.contains(query) } 
		// inline strategy

		def filesRegex(query: String) = filesMatching(matchRegex(query)) // using a method
		def filesEnding(query: String)=
			filesMatching(new FilesEnding(query).matchEnding) // lifting a method
		//Strategies
		private def matchRegex(query:String) = { 
			s:String => s.matches(query)
		}
	
		private class FilesEnding(query:String) {
			def matchEnding(s:String) = s.endsWith(query)
		}
	}
	def main(args: Array[String]) {
		val query = args(0);
		var matchingFiles = FileMatcher.filesEnding(query)
		matchingFiles = FileMatcher.filesContaining(query)
		matchingFiles = FileMatcher.filesRegex(query) 
		matchingFiles = FileMatcher.filesEnding(query)
	}

	Summary Scala gives us much flexibility in implementing the pattern. 
	Compared to the original GOF solution our solution is:
	• Succinct: We can in line strategies or use an existing method.
	• Flexible: A concrete strategy ranges from function literals to classes.
	• Localised: The solution shown localises all pattern code.


10)	Template Method

	“Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
	Template Method lets subclasses redefine certain steps of an algorithm without changing
	the algorithm’s structure.”


*	Listing 7.11: Template Method pattern in Scala

	trait Template extends (() => Int) {
		def subStepA
		def subStepB:Int
		def apply : Int = {
			subStepA
			subStepB
		}
	}

11)	Visitor

	
	“Represent an operation to be performed on the elements of an object structure.
	Visitor lets you define a new operation without changing the classes of the elements
	on which it operates.”

*	Listing 7.12: Visitor in Scala

	sealed abstract class Expr
	case class Num(n: Int ) extends Expr
	case class Sum(l: Expr, r: Expr) extends Expr

	def prettyPrint(e:Expr):Unit = e match {
		case Num(n) => print(n)
		case Sum(l ,r) => prettyPrint(l); print(" + "); prettyPrint(r)
	}

	def eval(e:Expr):Int = e match {
		case Num(n) => n
		case Sum(l ,r) => eval(l) + eval(r)
	}
	def main(args:Array[String]) = {
		val e1 = Sum(Sum(Num(1),Num(2)),Num(3))
		prettyPrint(e1)
		print("\n" + eval(e1))
		()
	}





