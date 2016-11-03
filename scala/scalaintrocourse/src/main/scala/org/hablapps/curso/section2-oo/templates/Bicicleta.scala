package org.hablapps.scalaintro.oo

package object templates {

  // 1. Creación de una bicicleta MUTABLE, con cadencia, marcha y velocidad. Los
  // campos van definidos en el bloque, utilizando los argumentos del constructor.

  // 2. Versión INMUTABLE de la bicicleta anterior. Utilizamos `val` (valor) en
  // lugar de `var` (variable). Scala fomenta la inmutabilidad, por lo que el uso
  // de `var`s está desaconsejado. Como consecuencia, desaparecen los setters.

  // 3. Los constructores y los campos se pueden unificar. Si algún argumento
  // prescinde del modificador `val` no se creará un campo para él en la clase. En
  // tal caso, será considerado como un argumento de entrada del constructor sin
  // más.

  // 4. Podemos declarar constructores adicionales mediante `def this`:

  // 5. Los métodos se añaden utilizando `def`. Podemos, por ejemplo, permitir que
  // nuestra bicicleta pueda frenar la velocidad dado un decremento.

  // 6. Es posible tener clases con una única instancia, lo que se conoce como
  // Singleton Objects. Este componente nos permite reemplazar los miembros de
  // clase propios de Java. Crearemos una `FabricaDeBicicletas` con valores
  // iniciales y un método de creación de bicicletas `crear`.

  // 7. Los Companion Objects son singleton objects (o simplemente objects) que
  // acompañan a un tipo de datos, por ejemplo a la clase bicicleta.

  // 8. Podemos aplicar herencia básica entre clases de forma muy sencilla.
  // Declararemos una bicicleta de montaña que hereda de nuestra bicicleta,
  // añadiendo un nuevo campo `alturaSillin`.

  // 9. Si una clase tiene algún miembro no definido tendrá que permanecer
  // abstracta. Se declara una bicicleta de carretera que no implementa una altura
  // para el sillín.

  // 10. Los traits son interfaces que permiten implementación parcial, con lo que
  // se permite la herencia múltiple. Por ejemplo definiremos un motor con una
  // cilindrada fija que también añade un campo revoluciones.

  // 11. De esta forma podemos definir nuestra bicicleta con motor, extendiendo la
  // clase Bicicleta y el trait Motor.

}
