package org.hablapps.scalaintro.genericidad
package code

// 0. Partimos de una versión reducida de la lista generada en el módulo
// anterior.
// sealed trait Lista
// case class Cons(cabeza: Int, resto: Lista = Nada()) extends Lista
// case class Nada() extends Lista

// 1. Generalizamos sobre `Int` añadiendo parámetro tipo `A`
// sealed trait Lista[A]
// case class Cons[A](cabeza: A, resto: Lista[A] = Nada[A]()) extends Lista[A]
// case class Nada[A]() extends Lista[A]

// 2. Hacemos polimórfico el método `apply` de creación de listas.
object Lista {
  def apply[A](elems: A*): Lista[A] =
    if (elems.isEmpty)
      Nada[A]()
    else
      Cons[A](elems.head, Lista[A](elems.tail: _*))
}

// 3. Probamos que nuestra lista es invariante y posteriormente la convertimos
// en covariante.
// sealed trait Lista[+A]
// case class Cons[A](cabeza: A, resto: Lista[A] = Nada[A]()) extends Lista[A]
// case class Nada[A]() extends Lista[A]

// 4. Problema al implementar método contains. Solucionado con type bound.
sealed trait Lista[+A] {

  def existe(f: A => Boolean): Boolean = this match {
    case Cons(cabeza, _) if f(cabeza) => true
    case Cons(_, resto) => resto.existe(f)
    case Nada() => false
  }

  def contiene[A1 >: A](i: A1): Boolean = {
    existe(j => i == j)
  }
}
case class Cons[A](cabeza: A, resto: Lista[A] = Nada[A]()) extends Lista[A]
case class Nada[A]() extends Lista[A]
