/**
  * Created by pabloren on 31/01/2017.
  */

import scala.reflect.runtime.{universe=>ru}

object ScalaReflec {

  def main(args: Array[String]): Unit = {

    var a = args(0)

    //Using scala library
    val m = ru.runtimeMirror(getClass.getClassLoader)
    val classPerson = ru.typeOf[Person].typeSymbol.asClass
    val cm = m.reflectClass(classPerson)
    val ctor = ru.typeOf[Person].declaration(ru.nme.CONSTRUCTOR).asMethod
    val ctorm = cm.reflectConstructor(ctor)

    val p = ctorm("Mike")

    println(p.toString)


    //Using java library

    var b = Class.forName(a)

    val c = b.getInterfaces

    println(b.toString)
    for (Class cls : c) {

    }

  }
}


case class Person(name:String)