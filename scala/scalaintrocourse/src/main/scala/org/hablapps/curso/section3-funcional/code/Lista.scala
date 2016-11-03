package org.hablapps.scalaintro.funcional
package code

// 1. Crear estructura propia para poder trabajar con listas.

// 2. Añadimos un método para insertar un nuevo elemento en la lista (por la
// cabeza)

// 3. Convertimos nuestras clases en "case" y añadimos el método `suma`, que
// suma todos los elementos de la lista, o devuelve 0 en caso de que la lista
// sea vacía.

// 4. Añadimos el método `map` que recibe una lambda (Int => Int) para mapear
// todos los elementos de esta lista.
sealed trait Lista {
  def insertar(head: Int): Lista = new Cons(head, this)
  def suma: Int = this match {
    case Cons(head, tail) => head + tail.suma
    case Fin() => 0
  }
  def map(f: Int => Int): Lista = this match {
    case Cons(head, tail) => Cons(f(head), tail.map(f))
    case Fin() => Fin()
  }
}
case class Cons(head: Int, tail: Lista) extends Lista
case class Fin() extends Lista
