package org.hablapps.scalaintro.azucar
package code

// 0. Partimos de la lista del módulo 3, incluyendo los ejercicios en notación
// infija.

// 1. Aplicación de parámetros por defecto en el constructor de `Cons`.

// 2. Método variadico `crear` para creación de listas.

// 3. Renombramiento de `crear` por `apply`

sealed trait Lista {

  def insertar(elemento: Int): Lista = {
    new Cons(elemento, this)
  }

  def ::(elemento: Int) = insertar(elemento)

  def suma: Int = this match {
    case Cons(cabeza, resto) => cabeza + resto.suma
    case Nada() => 0
  }

  def map(f: Int => Int): Lista = this match {
    case Cons(cabeza, resto) => Cons(f(cabeza), resto.map(f))
    case Nada() => Nada()
  }

  def concatenar(l: Lista): Lista = this match {
    case Cons(cabeza, resto) => Cons(cabeza, resto.++(l))
    case Nada() => l
  }

  def ++(l: Lista): Lista = concatenar(l)

  def existe(f: Int => Boolean): Boolean = this match {
    case Cons(cabeza, _) if f(cabeza) => true
    case Cons(_, resto) => resto.existe(f)
    case Nada() => false
  }

  def contiene(i: Int): Boolean = {
    existe(j => i == j)
  }

  def tirarMientras(f: Int => Boolean): Lista = this match {
    case Cons(cabeza, resto) if f(cabeza) => resto.tirarMientras(f)
    case _ => this
  }
}
case class Cons(cabeza: Int, resto: Lista = Nada()) extends Lista
case class Nada() extends Lista

object Lista {
  def apply(elems: Int*): Lista =
    if (elems.isEmpty)
      Nada()
    else
      Cons(elems.head, Lista(elems.tail: _*))
}
