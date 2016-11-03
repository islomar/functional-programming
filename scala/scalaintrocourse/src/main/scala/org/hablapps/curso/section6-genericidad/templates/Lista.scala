package org.hablapps.scalaintro.genericidad

package object templates {

  // 0. Partimos de una versión reducida de la lista generada en el módulo
  // anterior.

  // sealed trait Lista
  //
  // case class Cons(cabeza: Int, resto: Lista = Nada()) extends Lista
  //
  // case class Nada() extends Lista

  // 1. Generalizamos sobre `Int` añadiendo parámetro tipo `A`

  // 2. Hacemos polimórfico el método `apply` de creación de listas.

  // 3. Probamos que nuestra lista es invariante y posteriormente la convertimos
  // en covariante.

  // 4. Problema al implementar método contains. Solucionado con type bound.

}
