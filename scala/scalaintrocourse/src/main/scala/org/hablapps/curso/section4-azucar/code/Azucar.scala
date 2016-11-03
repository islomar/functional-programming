package org.hablapps.scalaintro.azucar
package code

class Azucar {

  def f1(a: Int): Int = a

  def f2(a: Boolean, b: String, c: String): String = {
    if (a) b else c
  }

  def f3(a: Boolean, b: String = "then", c: String = "else"): String = {
    if (a) b else c
  }

  def f4(a: Int*): Int = a.reduce { (a1, a2) =>
    a1 + a2
  }

  def f5(f: Int => String): Unit = ()

  def apply(a: Int): Int = a
}
