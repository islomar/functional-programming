package org.hablapps.scalaintro.implicitos
package code

/**
 * El primer uso que tienen los implicitos, es el paso de argumentos,
 * esto nos permite que el compilador busque por nosotros los argumentos
 * adecuados que pasarle a una función.
 */
object ArgumentosImplicitos extends App {

  // 1. Empezamos con una función normal y corriente
  def post(data: Array[Byte], uri: String, port: Int): String =
    s"Posting to $uri on port $port"

  // 2. Podemos marcar los argumentos que queramos como implícitos,
  // estos argumentos tienen que ir en un grupo a parte, y además
  // este grupo tiene que ser el último siempre.

  // 3. Podemos utilizar este método pasando argumentos con total
  // normalidad

  // 4. Pero además, en este caso, podemos marcar valores como implícitos
  // para que sean "usados" automáticamente por el método

  // 5. También podemos elegir qué argumentos queremos que el compilador
  // "consiga" implícitamente, haciendo uso del método `implicitly`.
}

/**
 * El otro caso de uso que nos proporcionan los implícitos son las
 * conversiones, el compilador será capaz de transformarnos un valor
 * en otro cualquiera de manera automática. Ahora veremos para qué
 * puede ser útil este comportamiento.
 */
object ConversionesImplicitas {
  import scala.language.implicitConversions

  // 6. Partimos de una funcion de conversión ordinaria
  def doubleToInt(i: Double): Int = i.toInt
  val myNumber: Int = doubleToInt(243.53)

  // 7. Podemos ahorrarnos esta conversión manual, marcando al
  // método conversor como `implicit`

  // Esta práctica, sin embargo, es bastante peligrosa, puesto que
  // puede ocultar bugs en nuestro código, y en general, no es un
  // caso de uso recomendado.

  // 8. Un caso de uso más común (y más correcto) para conversiones
  // implícitas, es el aumento de funcionalidad para un tipo, por
  // ejemplo vamos a extender la funcionalidad de Int para poder
  // hacer factoriales y potencias. La solución más común es crearnos
  // un wrapper y añadir esa funcionalidad
  class RichInt(i: Int) {
    def factorial: Int =
      if (i > 1)
        i * new RichInt(i-1).factorial
      else
        i
    def squared: Int = math.pow(i, 2).toInt
    def exp(e: Int): Int = math.pow(i, e).toInt
  }

  // 9. Sin embargo, las conversiones implícitas nos permiten
  // abstraernos del wrapper y utilizar los métodos directamente

  // 10. Este patrón es tan común que para eso existen otro tipo de
  // implícitos, las `implicit clases`, cuyo caso de uso es concretamente
  // ese, extender la funcionalidad de los tipos.

}
