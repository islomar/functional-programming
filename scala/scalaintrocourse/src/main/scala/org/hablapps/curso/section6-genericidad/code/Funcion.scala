package org.hablapps.scalaintro.genericidad
package code

trait Funcion[A, B] {
  def apply(a: A): B
}

object VarianzaFuncion {


  /* Funciones para trastear */

  val fAnyAny: Funcion[Any, Any] = new Funcion[Any, Any] {
    def apply(a: Any) = a
  }

  val fAnyInt: Funcion[Any, Int] = new Funcion[Any, Int] {
    def apply(a: Any) = 1
  }

  val fIntAny: Funcion[Int, Any] = new Funcion[Int, Any] {
    def apply(i: Int) = "whatever"
  }


  /* ¿Qué tipo de varianza debe tener B? */

  // val f1: Function[Any, Int] = fAnyAny

  // val f2: Funcion[Any, Any] = fAnyInt


  /* ¿Qué tipo de varianza debe tener A? */

  // val f3: Funcion[Any, Any] = fIntAny

  // val f4: Funcion[Int, Any] = fAnyAny
}
