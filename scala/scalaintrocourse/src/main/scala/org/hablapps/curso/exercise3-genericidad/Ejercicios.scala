package org.hablapps.scalaintro.genericidad

object Ejercicios {

  case class Bicicleta(marcha: Int, cadencia: Int, velocidad: Int)

  val bicicletas: List[Bicicleta] = List(
    Bicicleta(1,  0,  5),
    Bicicleta(2, 10,  8),
    Bicicleta(4, 25, 30),
    Bicicleta(6,  1, 45))

  // Consulta la API de `List` para acceder a la documentación de los métodos
  // que usaremos en los siguientes ejercicios:
  // http://www.scala-lang.org/api/current/#scala.collection.immutable.List

  object Ejercicio1 {
    // Filtra todas aquellas bicicletas que se encuentren en una marcha impar. A
    // tener en cuenta:
    // - El operador "módulo" se representa mediante `%`, por ejemplo `x % y`
    val res: List[Bicicleta] = bicicletas.filter(???)
  }

  object Ejercicio2 {
    // Busca la bicicleta que circule a mayor velocidad. Pista: utiliza el
    // método `reduce` para llevar a cabo esta implementación. A tener en cuenta:
    // - La estructura de control de flujo "if" se despliega con esta sintáxis:
    // `if (b) expr1 else expr2`
    val res: Bicicleta = ???
  }

  object Ejercicio3 {
    // Suma las cadencias de todas las bicicletas. ¿A qué estructura de control
    // de flujo te recuerda `foldLeft`?
    val res: Int = bicicletas.foldLeft(???)(???)
  }
}
