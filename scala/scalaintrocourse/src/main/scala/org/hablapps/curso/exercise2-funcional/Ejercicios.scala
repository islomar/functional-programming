package org.hablapps.scalaintro.funcional

import code._

object Ejercicios extends App {

  object Ejercicio1 {
    // Implementa `concatenar`, que concatena las dos listas recibidas como
    // entrada. Utiliza la siguiente estructura.
    def concatenar(l1: Lista, l2: Lista): Lista = {
      l1 match {
        // case Nada() => ???
        // case Cons(c, r) => ???
        case _ => ???
      }
    }
  }

  object Ejercicio2 {
    // Implementa `existe`, que devuelve `true` si la lista contiene algún
    // elemento que cumple con el predicado representado por `f`. Si ningún
    // elemento lo cumple, se devolverá `false`. A tener en cuenta:
    // - El tipo Boolean contiene los valores `true` y `false`
    // - El operador lógico "or" se representa mediante `b1 || b2`.
    def existe(l: Lista, f: Int => Boolean): Boolean = ???
  }

  import Ejercicio2.existe

  object Ejercicio3 {
    // Implementa el método `contiene` que nos indica si nuestra lista contiene
    // un determinado valor de tipo `Int` que se recibe como argumento. Es
    // obligatorio que esta función reutilice `existe`. A tener en cuenta:
    // - El operador de igualdad se representa mediante `expr1 == expr2`
    def contiene(l: Lista, v: Int): Boolean = {
      existe(l, ???)
    }
  }

  object Ejercicio4 {
    // Implementa `tirarMientras` que elimina todos aquellos elementos de la
    // cabeza que cumplan con la condición, hasta que encuentre uno que no lo
    // haga, momento en el que se devolverá el resto de la lista (elemento
    // incluido). A tener en cuenta:
    // - La estructura de control de flujo "if" se despliega con esta sintáxis:
    // `if (b) expr1 else expr2`
    def tirarMientras(l: Lista, f: Int => Boolean): Lista = ???
  }
}
