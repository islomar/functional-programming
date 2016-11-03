package org.hablapps.scalaintro
package test

import org.scalatest._
import genericidad.Ejercicios._

// Run this test with `test-tema0-gen`
class GenericidadSpec extends FlatSpec with Matchers {

  "Ejercicio1" should "contener las bicicletas con marcha impar únicamente" in {
    Ejercicio1.res shouldBe Bicicleta(1, 0, 5) :: Nil
  }

  "Ejercicio2" should "devolver la bicicleta con mayor velocidad" in {
    Ejercicio2.res shouldBe Bicicleta(6,  1, 45)
  }

  "Ejercicio3" should "devolver la suma de todas las cadencias" in {
    Ejercicio3.res shouldBe 36
  }

}
