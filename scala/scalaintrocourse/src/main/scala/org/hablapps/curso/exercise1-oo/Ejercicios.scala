package org.hablapps.scalaintro.oo

object Ejercicios extends App {

  object Ejercicio1 {
    // Extiende el trait Fruta, añadiendo un método 'precio' sin implementación
    // asociada, que no recibe ningún argumento y que devuelve un Double como
    // salida. Toma el método `color` como referencia.
    trait Fruta {
      def color: String
      ???
    }
  }

  import Ejercicio1._

  object Ejercicio2 {
    // A continuación aparece el Companion Object para el trait `Fruta` que
    // creamos en el primer ejercicio. Implementa el método `crear`, que crea
    // una `Fruta`, valiéndose del `_color` recibido como argumento y fijando el
    // precio a 3.0. Recuerda que un trait no tiene constructores, por lo que
    // tendrás que utilizar la sintaxis de clases anónimas para poder crear una
    // instancia. `new Fruta { ... }`
    object Fruta {
      def crear(_color: String): Fruta = ???
    }
  }

  import Ejercicio2._

  object Ejercicio3 {
    // Extiende la clase `Platano`, para que herede de `Fruta`, fijando el
    // método `color` a "amarillo" y recibiendo el precio en el constructor.
    class Platano {
      def color: String = ???
    }
  }

  import Ejercicio3._

  object Ejercicio4 {
    // Crea una fruta de cualquier color (utilizando `Fruta.crear`) y un plátano
    // de cualquier precio (utilizando el constructor de la clase `Platano`).
    val fruta: Fruta = ???
    val platano: Platano = ???
  }

  import Ejercicio4._

  // Ejecuta `org.hablapps.scalaintro.oo.Ejercicios` y asegúrate de que el precio de
  // la `fruta` (3.0) y el color del `platano` ("amarillo") sean correctos.
  println("El precio de la fruta es: " + ???)
  println("El color del plátano es: "  + ???)
}
