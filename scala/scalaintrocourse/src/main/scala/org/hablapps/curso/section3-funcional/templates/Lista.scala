package org.hablapps.scalaintro.funcional

package object templates {

  // 1. Crear estructura propia para poder trabajar con listas.

  sealed trait Lista

  // 2. Añadimos un método para insertar un nuevo elemento en la lista (por la
  // cabeza)

  // 3. Convertimos nuestras clases en "case" y añadimos el método `suma`, que
  // suma todos los elementos de la lista, o devuelve 0 en caso de que la lista
  // sea vacía.

  // 4. Añadimos el método `map` que recibe una lambda (Int => Int) para mapear
  // todos los elementos de esta lista.

}
