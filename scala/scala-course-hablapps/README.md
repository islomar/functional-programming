#Hablapps course
Javier Fuentes Sánchez

**Wifi info:**
eduroam
hablapps
Dici@18.

https://github.com/hablapps/funcourseinscala



##¿Qué es la programación funcional?
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
* Es parecido a un reduce, es más limitado: sólo puedes sacar como resultado el mismo tipo que la lista que "entre"
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


##Week 2: 



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
* http://www.scala-lang.org/old/node/123
* http://docs.scala-lang.org/tutorials/tour/case-classes.html
* http://chris-taylor.github.io/blog/2013/02/10/the-algebra-of-algebraic-data-types/


##Glossary
* Tuple: https://en.wikipedia.org/wiki/Tuple
* Parametric polymorphism:   https://en.wikipedia.org/wiki/Parametric_polymorphism
* Predicate:    https://en.wikipedia.org/wiki/Predicate_(mathematical_logic)