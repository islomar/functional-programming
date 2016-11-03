#Hablapps course
Javier Fuentes Sánchez

**Wifi info:**
eduroam
hablapps
Dici@18.

https://github.com/hablapps/funcourseinscala

https://www.reddit.com/r/scalaEs/


##Semana 1: ¿Qué es la programación funcional?
* Scala es de 2004.
* La programación funcional es programar con funciones puras.

`@scala.annotation.tailrec` >> falla si detecta que la función no es tail recursive.

###Tipos
* Las funciones transforman valores en valores (dominio >> codominio).
* Un tipo es un conjunto de valores.
* Los tipos forman un Álgebra: ADT (Algebraic Data Type)
* Tipos:
  * Tipos primitivos
  * Tipos suma (coproductos)  >> ponen co- para indicar "lo opuesto"
  * Tipos producto
* Número de valores (cardinalidad) según el tipo:
|Boolean| = 2
|Int| = 2^32
|Unit| = 1          >> representado como ()
|Nothing| = 0
* ADT: combinamos tipos para conseguir tipos más complejos (tipos derivados). Realizamos estas combinaciones mediante operaciones algebraicas (+, x)

####Producto
* **type alias**: definirme un tipo a partir de la particularidad de otro
Existe producto de tipos algebraicos en:
1. Tuplas
2. Clases

```
type T1 = Tuple2[Int, Boolean]
val t1: T1 = (5, true)

type T2 = (Int, Boolean) >> es lo mismo que definirlo como en T1

case class T3(s: String, i: Int)
val t1: T3 = T3("hola", 17)
```

####Suma
Existe suma de tipos algebraicos en:
1. Either
2. Herencia
```
type T1 = Either[Int, Boolean]     >> como el Either de Guava
val t1: T1 = Left(25)
val t2: T2 = Right(true)
```

Ejemplo de Option
```
sealed trait Option[A]  // |A| + 1
case class Some[A](a: A) extends Option[A]
case class None[A]() extends Option[A]
```


Ejemplo de List
```
sealed trait List[A]  // |Cons| + |Nil| = |A| x |List[A]| + 1
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]
```

Conocer la cardinalidad te permite saber si dos tipos son isomórficos, y por tanto podemos ir de uno a otro sin perder información.
**Tipos isomórficos**: cuando tienen la misma cardinalidad >> si es así, sabes que son el mismo tipo

**Case classes**
http://docs.scala-lang.org/tutorials/tour/case-classes.html

**Covariance**
http://julien.richard-foy.fr/blog/2013/02/21/be-friend-with-covariance-and-contravariance/
http://blogs.atlassian.com/2013/01/covariance-and-contravariance-in-scala/

**sealed**
http://www.scala-lang.org/old/node/123
A sealed class may not be directly inherited, except if the inheriting template is defined in the same source file as the inherited class. However, subclasses of a sealed class can inherited anywhere.
Sealed classes are defined using the sealed modifier.


###Escalera de modularidad
Si una función solo tiene una expresión, no son necesarias las llaves.

* **Polimorfismo paramétrico**
https://en.wikipedia.org/wiki/Parametric_polymorphism
Son los Generics

###HOF
####Composición
Función que recibe o devuelve una función (puede recibir algo más aparte de una función).

**eta expansion**: mecnaismo para convertir métodos a objetos
Todo esto es azúcar sintáctico.
**Functions as objects**: al final todo se traduce a una Function con un apply.

Scala es orientada a objetos con facilidad para programar de manera funcional.

* **Variables de tipo**: se definen entre corchetes al principio de la función, para poder ser utilizados luego en la función.
* **Variables de valor**: entre paréntesis

####Fold: catamorfismo
* Es una forma de interpretar/consumir/plegar un ADT: F[A] --> fold --> B
  * El B no tiene por qué ser una estructura más pequeña que la inicial
* Es parecido a un reduce, aunque un reduce es más limitado: sólo puedes sacar como resultado el mismo tipo que la lista que "entre"
  * http://blog.plasmaconduit.com/reduve-vs-fold-in-scala/
* **Ejemplo suma**: `fold(Int, (Int, Int) => Int`, con `nil=0` y `cons = (i1: Int, i2: Int) => i1 + i2`
Un catamorfismo consiste en sustituir los constructores por los argumentos.
`List(1, 2, 3, 4, 5).foldRight(0)(_+_)`
El catamorfismo existe para cualquier ADT, no solo para Listas.

**Ejemplo de suma de altura de un árbol**
```
leaf = 0
node = (left: Int, a: A, right: Int) => max(1, r) + 1
```

###Conclusiones
* Los ADTs no son clases orientadas a objetos
 * No son extensibles
 * No encapsulan comportamiento


##Semana 2: Más allá de las HOFs (type classes)
Las Type classes son el patrón de diseño más importante de la programación funcional.

**Type class**: funcionalidad asociada a un tipo genérico. Es un diccionario de funciones y valores indexado por tipos de datos.
 * Las type classes son interfaces genéricas que definen una funcionalidad que proporciona el tipo que parametrizan (métodos, valores).
 * Capturan funcionalidad altamente reutilizable de una manera extensible, facilitando la corrección 

**Monoides**: 
 * polimorfismo ad-hoc
 * Su función es recoger N y devolver 1.
 * Un monoide es un tipo de datos para el que podemos dar un zero y una operación binaria de composición (suma). Estas operaciones deben satisfacer determinadas leyes: 1) elemento neutro y 2) asociatividad.
 * Un monoide define una clase de tipos (type class): aquellos para los que hay un zero y una operación binaria con esas propiedades.

Con las type classes tienes la capacidad de sobrecargar de manera similar a la herencia en OO.

Dos características deseables de las type classes:
* **Generalidad**: poder clasificar muchos tipos (e.g. hay muchísimas instancias de monoides).
* **Expresividad**: número de operaciones derivadas que podré definir a partir de las operaciones primitivas.

###Implícitos (aberración absoluta, kk)
Me permite ahorrarme parámetros, dejar que el compilador busque por mí.
http://docs.scala-lang.org/tutorials/tour/implicit-parameters.html
http://www.cakesolutions.net/teamblogs/demystifying-implicits-and-typeclasses-in-scala

* **Argumentos/parámetros implícitos**
 * Los implícitos siempre son el último grupo de argumentos. Se buscan en el scope, de abajo a arriba, y no por el nombre, sino por el tipo (e.g. búscame algún implícito de tipo String).

* **Conversiones implícitas**
 * Ejemplo de conversión implícita de Double a Int.

Se puede crear una jerarquía de implícitos.

###Context Bounds
`implicitly`: puedes quitarlo como parámetro y declararlo dentro.
Aún mejor, con azúcar sintáctico: `implicit class`

**Una type class tiene cinco partes**:
* **Interfaz abstracta**∫: la de Order es 'compare'
* **Interfaz Concreta**: las que puedes definir en función de la abstracta; de Order son 'gt', 'lt', etc.
* **Instances**
 * Hay una especial, el `apply`, que se suele llamar 'summoner' (=invocador) >> para buscar una evidencia implícita de un tipo
  * Puedes crear una jerarquía de instancias (heredando), por ejemplo para la suma y el producto (ver ejemplo).
* **Syntax**
 * e.g. OrderSyntax, poder usar cosas como `>`, `<`
 * acceso directo a la type class, pero no tener que poner el implicit en el context. bound.
* **Laws**
 * Condiciones que debe cumplir la type class: antisimétrica, transitiva, etc.
 * **ScalaCheck**: para property-based testing. Suite de tests que trabaja sobre generadores: dado un generador de As, generaría N millones, y miraría si la propiedad se cumple para todos los casos.

:::     >> concatenar listas
::      >> unir elemento y lista


**ScalaZ** es una librería de type classes.

`apply` te da una instancia


###Otros patrones OO
* Herencia
* Adapter vs Type classes


###Higher-kinds generics
* Tipos concretos ( * ): String, Int, Potato
* Constructores de tipos ( * -> * ): List[_], Option[_]  >> sólo necesita un tipo para completarse
* Either[_, _] ( * -> * -> * )  >> necesita dos tipos para completarse

Convención para constructores de tipo: F, G, H
Convención para tipos: A, B, C

Un **Functor** es una type class que contiene la función `map`, no parametrizada sobre un tipo concreto, sino sobre un constructor de tipo genérico (usa F en lugar de List u Option).


###Representación de datos
Tipos de datos como type classes, similar a las factorías abstractas.

###Lecturas recomendadas para la semana 2
* http://danielwestheide.com/blog/2013/02/06/the-neophytes-guide-to-scala-part-12-type-classes.html
* http://danielwestheide.com/scala/neophytes.html
* Ejercicios para el libro rojo: http://blog.higher-order.com/assets/fpiscompanion.pdf


###Dudas semana 2
* En la definición de una type class, ¿qué significa la parte de "indexado por tipos de datos"? ¿Que debe ser genérica?



##Semana 3: funciones puras y lenguajes
Para acceso a DB: Slick (http://slick.lightbend.com/)
Functional architecture: Pure functions -- programs (languages) -- interpreters (side-effectful)
La pureza de una función se evalúa presumiendo pureza en los parámetros que recibe.

Posibles efectos secundarios:
* Logging
* Estados mutables
* Errores

Ejemplo en meetap_v2.0
doAndThen == flatMap

**For comprehension**
```
for {
    variableALaQueAsignar: A <- LaFdA: F[A]
} yield LoQueQuieroDevolver
```
* Necesitamos un flatMap y un map
* El `for` no es un bucle. Se aplica/busca un flatMap que pase de F[A] a A (fallará si no encuentra un flatMap).
 * Todo lo que hay dentro del for es un flatMap, excepto lo último, que es un map.
* El `yield` empaqueta y envuelve.




##Your data structures are made of maths!
Algebraic types:
* Product
`(A, B)`  >> A*B
* Sum
* Exponent:
A -> B = B^A
`def getTurtles: () -> NinjaTurtles` >>    1 -> 4 = 4^1
Functions “with no arguments” are tacitly from a singleton type such as Unit. **Singleton** types carry no information.
`trait State[S, A] { def run(state: S): (A, S) }`
S -> (A, S)  >> (S*A)^S

`tupled[A, B, C](a: A, b: B): C`    >> (A*B) -> C = C^(AB)
`def curried[A, B, C]: A => (B => C)`  >> A -> (C^B) = C^BA

 **isomorphism**: One-to-one mapping between two objects so you can go back-and-forth without losing information



###Category Theory
A -> B
A -(f)-> B              Categories generalise functions over sets.
A -(f)-> B -(g)-> C     Arrows compose like functions.
A -(g ∘ f)-> C
Every object has an identity arrow, just as an identity function.

**Opposite categories**
C -> Cop
Cop -> C
Just flip the arrows and reverse composition!
A product in C is a sum in Cop.
A sum in C is a product in Cop.

* Sums are isomorphic to Products!
* Terminology dual An object and its equivalent in the opposite category are to each other.
* Often we call something’s dual a Co-(thing)
* Sums are also called Coproducts

**Injections (A, B)**
* A function is injective if it maps 1-to-1 onto a subset of the codomain B
* All the information in A is preserved
* But everything else in B is lost.

**Surjections**
* A function is surjective if it maps onto the whole of the codomain
* All the information in B is preserved.
* But everything else in A is lost.

**Bijections**
A function is bijective if it maps 1-to-1 onto the whole codomain

### Motivation 
So much software is just mapping between things!
* Bugs proliferate where data is lost!
* Injections and surjections tell us what is preserved and what is lost
* Bijections are especially valuable

###Conclusion
* Data structures are made out of maths!
* How we map between them is maths too.
* Understanding the underlying shape of data and functions is enormously helpful for more robust, error-free software
* Isomorphism is more interesting than equality! 
  * Isomorphic types can be rewritten, optimised without error. 
  * Isomorphic mappings allow us to preserve information




##A leer/revisar/buscar/investigar:
* http://www.slideshare.net/kenbot/your-data-structures-are-made-of-maths
* http://julien.richard-foy.fr/blog/2013/02/21/be-friend-with-covariance-and-contravariance/
* Companion objects (visto en curso de Scala)
* http://www.scala-lang.org/old/node/123
* http://docs.scala-lang.org/tutorials/tour/case-classes.html
* http://chris-taylor.github.io/blog/2013/02/10/the-algebra-of-algebraic-data-types/


##Glossary
* Tuple: https://en.wikipedia.org/wiki/Tuple
* Parametric polymorphism:   https://en.wikipedia.org/wiki/Parametric_polymorphism
* Predicate:    https://en.wikipedia.org/wiki/Predicate_(mathematical_logic)


* Implícitos
* Singletons, herencia...