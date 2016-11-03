package org.hablapps.scalaintro
package test

import org.scalatest._
import funcional._, code._, Ejercicios._

// Run this test with `test-tema0-fun`
class FuncionalSpec extends FlatSpec with Matchers {

  val emptyL = Fin()
  val l1 = Fin().insertar(3).insertar(2).insertar(1)
  val l2 = Fin().insertar(6).insertar(5).insertar(4)

  "Concatenar" should "concatenar 2 listas no vacías" in {
    Ejercicio1.concatenar(l1, l2) shouldBe
      Fin().insertar(6).insertar(5).insertar(4).insertar(3).insertar(2).insertar(1)
  }

  it should "devolver la primera lista si la segunda está vacía" in {
    Ejercicio1.concatenar(l1, emptyL) shouldBe l1
  }

  it should "devolver la segunda lista si la primera está vacía" in {
    Ejercicio1.concatenar(emptyL, l2) shouldBe l2
  }

  "Existe" should "devolver true si algún elemento cumple con la condición" in {
    Ejercicio2.existe(l1, _ < 3) shouldBe true
  }

  it should "devolver false si ningún elemento cumple con la condición" in {
    Ejercicio2.existe(l2, _ < 3) shouldBe false
  }

  it should "devolver false si la lista está vacía" in {
    Ejercicio2.existe(emptyL, _ => true) shouldBe false
  }

  "Contiene" should "devolver true la lista contiene el elemento" in {
    Ejercicio3.contiene(l1, 3) shouldBe true
  }

  it should "devolver false si la lista NO contiene el elemento" in {
    Ejercicio3.contiene(l2, 3) shouldBe false
  }

  it should "devolver false si la lista está vacía" in {
    Ejercicio3.contiene(emptyL, 3) shouldBe false
  }

  "Tirar mientras" should "descartar elementos mientras se cumpla la condicion" in {
    Ejercicio4.tirarMientras(l1, _ % 2 != 0) shouldBe Fin().insertar(3).insertar(2)
  }

  it should "devolver la lista inicial si la condición es siempre false" in {
    Ejercicio4.tirarMientras(l1, _ => false) shouldBe l1
  }

  it should "devolver lista vacía si la lista está vacía" in {
    Ejercicio4.tirarMientras(emptyL, _ => true) shouldBe Fin()
  }
}
